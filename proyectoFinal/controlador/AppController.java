package proyectoFinal.controlador;

import proyectoFinal.modelo.dominio.Fits;
import proyectoFinal.modelo.dominio.FrasesMotivacionales;
import proyectoFinal.modelo.dominio.RegistroDiario;
import proyectoFinal.modelo.dominio.Usuario;
import proyectoFinal.modelo.estrategia.PlanEjercicio;
import proyectoFinal.modelo.servicios.PlanService;
import proyectoFinal.modelo.servicios.UsuarioService;
import proyectoFinal.vista.*;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class AppController {
    private UsuarioService usuarioService;
    private Usuario usuarioAutenticado;
    private LoginGUI loginGUI;
    private DatosFitnessGUI datosFitnessGUI;
    private PlanResultadoGUI planResultadoGUI;
    private EstadisticasGUI estadisticasGUI;

    public AppController() {
        this.usuarioService = new UsuarioService();
        inicializarVistas();
    }

    private void inicializarVistas() {
        this.loginGUI = new LoginGUI(this);
        this.datosFitnessGUI = new DatosFitnessGUI(this);
        this.planResultadoGUI = new PlanResultadoGUI(this);
        this.estadisticasGUI = new EstadisticasGUI(this);

        this.loginGUI.setVisible(true);
    }
    public void registrarDia(Double nuevoPeso, boolean completado, Integer minutos, String notas) {
        if (usuarioAutenticado != null) {
            RegistroDiario nuevoRegistro = new RegistroDiario(nuevoPeso, completado, minutos, notas);

            usuarioAutenticado.agregarRegistroDiario(nuevoRegistro);
            usuarioAutenticado.getDatosFitness().setPeso(nuevoPeso);
            usuarioService.guardarUsuarios();
       if (planResultadoGUI.isVisible()) {
                PlanEjercicio plan = PlanService.generarPlan(usuarioAutenticado);
                planResultadoGUI.mostrarPlan(plan, new FrasesMotivacionales().obtenerFraseAleatoria());
            }
        }
    }
    public void mostrarEstadisticas() {
        if (usuarioAutenticado != null) {
            estadisticasGUI.cargarDatos(usuarioAutenticado.getRegistrosDiarios());
            estadisticasGUI.setVisible(true);
        }
    }

    public Usuario getUsuarioAutenticado() {
        return usuarioAutenticado;
    }
    public void autenticarUsuario(String correo, String contrasena) {
        Usuario usuario = usuarioService.iniciarSesion(correo, contrasena);
        if (usuario != null) {
            this.usuarioAutenticado = usuario;
            SwingUtilities.invokeLater(() -> loginGUI.setVisible(false));
            if (usuario.getDatosFitness() == null) {
                SwingUtilities.invokeLater(() -> datosFitnessGUI.setVisible(true));
            } else {
                mostrarResultados();
            }
        } else {
            JOptionPane.showMessageDialog(loginGUI,
                    "Correo o contraseña incorrectos.",
                    "Error de Autenticación",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void registrarNuevoUsuario(String correo, String nombre, String genero, int edad, String contrasena) {
        Usuario nuevoUsuario = new Usuario(correo, nombre, genero, edad, contrasena);
        usuarioService.agregarUsuario(nuevoUsuario);
        JOptionPane.showMessageDialog(loginGUI,
                "Registro exitoso. Inicie sesión.",
                "Éxito",
                JOptionPane.INFORMATION_MESSAGE);
    }
    public void mostrarRegistroDiario() {
        if (usuarioAutenticado != null) {
            RegistroDiarioGUI registroGUI = new RegistroDiarioGUI(this, usuarioAutenticado);
            registroGUI.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Debe iniciar sesión para registrar su día.",
                    "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    public void agregarRegistroDiario(RegistroDiario registro, Usuario usuario) {
        if (usuario != null && registro != null) {
            usuario.agregarRegistroDiario(registro);
            usuarioService.guardarUsuarios();
            JOptionPane.showMessageDialog(null,
                    "Registro diario guardado con éxito.",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void agregarRegistro(Usuario usuario, RegistroDiario registro) {
        if (usuario != null && registro != null) {
            usuario.agregarRegistroDiario(registro);
            usuarioService.guardarUsuarios();
            JOptionPane.showMessageDialog(null,
                    "Registro añadido correctamente.",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void guardarDatosFitness(Double peso, Double altura, String nivel, String objetivo) {
        if (usuarioAutenticado != null) {
            Fits datos = new Fits(peso, altura, nivel, objetivo);
            usuarioAutenticado.setDatosFitness(datos);
            usuarioService.guardarUsuarios();
            mostrarResultados();
        }
    }
    public void mostrarResultados() {
        SwingUtilities.invokeLater(() -> datosFitnessGUI.setVisible(false));
        PlanEjercicio plan = PlanService.generarPlan(usuarioAutenticado);
        planResultadoGUI.mostrarPlan(plan, new FrasesMotivacionales().obtenerFraseAleatoria());
        SwingUtilities.invokeLater(() -> planResultadoGUI.setVisible(true));
    }

    public void mostrarLogin() {
        usuarioAutenticado = null;
        SwingUtilities.invokeLater(() -> {
            if (datosFitnessGUI != null) datosFitnessGUI.setVisible(false);
            if (planResultadoGUI != null) planResultadoGUI.setVisible(false);
            if (estadisticasGUI != null) estadisticasGUI.setVisible(false);
            loginGUI.setVisible(true);
        });
    }
    public void registrarUsuario(String correo, String nombre, String genero, int edad, String pass) {
        registrarNuevoUsuario(correo, nombre, genero, edad, pass);
    }
}

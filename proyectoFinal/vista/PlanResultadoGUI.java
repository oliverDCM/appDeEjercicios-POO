package proyectoFinal.vista;

import proyectoFinal.controlador.AppController;
import proyectoFinal.modelo.dominio.Fits;
import proyectoFinal.modelo.dominio.Usuario;
import proyectoFinal.modelo.estrategia.PlanEjercicio;

import javax.swing.*;
import java.awt.*;

public class PlanResultadoGUI extends JFrame {
    private AppController controller;
    private JTextArea txtPlan = new JTextArea(25, 60);
    private JTextArea txtDatosUsuario = new JTextArea(8, 60);
    private JButton btnVolver = new JButton("Volver al Login / Cerrar Sesión");

    private JButton btnRegistrarHoy = new JButton("📝 Registrar Progreso de Hoy");
    private JButton btnVerEstadisticas = new JButton("📊 Ver Historial y Estadísticas");

    public PlanResultadoGUI(AppController controller) {
        this.controller = controller;
        setTitle("Resultado del Plan de Fitness");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        txtPlan.setEditable(false);
        txtDatosUsuario.setEditable(false);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JPanel pnlNorte = new JPanel(new BorderLayout());
        pnlNorte.add(new JLabel("=== DATOS DE PERFIL Y FITNESS ==="), BorderLayout.NORTH);
        pnlNorte.add(new JScrollPane(txtDatosUsuario), BorderLayout.CENTER);

        JPanel pnlCentro = new JPanel(new BorderLayout());
        pnlCentro.add(new JLabel("=== PLAN DE ENTRENAMIENTO PERSONALIZADO ==="), BorderLayout.NORTH);
        pnlCentro.add(new JScrollPane(txtPlan), BorderLayout.CENTER);

        JPanel pnlSur = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 5));
        pnlSur.add(btnRegistrarHoy);
        pnlSur.add(btnVerEstadisticas);
        pnlSur.add(btnVolver);

        panel.add(pnlNorte, BorderLayout.NORTH);
        panel.add(pnlCentro, BorderLayout.CENTER);
        panel.add(pnlSur, BorderLayout.SOUTH);

        add(panel);
        pack();
        setLocationRelativeTo(null);

        btnVolver.addActionListener(e -> controller.mostrarLogin());

        btnRegistrarHoy.addActionListener(e -> {
            Usuario usuario = controller.getUsuarioAutenticado();
            Double pesoInicial = usuario.getUltimoPesoRegistrado();
            new DialogoRegistroDiario(this, controller, pesoInicial).setVisible(true);
        });

        btnVerEstadisticas.addActionListener(e -> controller.mostrarEstadisticas());
    }

    public void mostrarPlan(PlanEjercicio plan, String frase) {
        Usuario usuario = controller.getUsuarioAutenticado();
        Fits datos = usuario.getDatosFitness();

        String datosTexto = String.format(
                "Nombre: %s (%d años)\nGénero: %s\n" +
                        "----------------------------------\n" +
                        "Peso Actual: %.2f kg | Altura: %.2f m\n" +
                        "Nivel: %s | Objetivo: %s\n" +
                        "IMC (Índice de Masa Corporal): %.2f",
                usuario.getNombre(), usuario.getEdad(), usuario.getGenero(),
                usuario.getUltimoPesoRegistrado(), datos.getAltura(),
                plan.getNivel(), plan.getObjetivo(),
                datos.getImc()
        );
        txtDatosUsuario.setText(datosTexto);


        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Días por semana: %d\n", plan.getDiasPorSemana()));
        sb.append(String.format("Duración por sesión: %d minutos\n\n", plan.getDuracionSesion()));
        sb.append("--- RUTINA RECOMENDADA ---\n");
        for (String ejercicio : plan.getEjercicios()) {
            sb.append(ejercicio).append("\n");
        }
        sb.append("\n\n").append("¡FRASE MOTIVACIONAL DEL DÍA!\n");
        sb.append(frase).append(" 💪\n");

        txtPlan.setText(sb.toString());
        txtPlan.setCaretPosition(0);
    }
}
package proyectoFinal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class MenuProyecto{
    private List<Usuario> usuariosRegistrados = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private Usuario usuarioAutenticado;
    private String usuarioActual;
    String nuevoCorreo;
    Integer nuevaEdad;
    boolean correoValido = false;
    boolean edadValida = false;
    public void registrarUsuario() {
        System.out.println("\n--- REGISTRO DE USUARIO ---");
        do {
            System.out.print("Correo electrónico: ");
            nuevoCorreo = scanner.nextLine().trim();
            if (!nuevoCorreo.contains("@")) {
                System.out.println("Error: El correo debe contener una @");
                correoValido = false;
            } else if (existeUsuario(nuevoCorreo)) {
                System.out.println("¡Este correo ya está registrado!");
                correoValido = false;
            } else {
                correoValido = true;
            }
        } while (!correoValido);
        System.out.print("Nombre completo: ");
        String nuevoNombre = scanner.nextLine().toLowerCase();
        System.out.print("Género (M/F): ");
        String nuevoGenero;
        boolean generoValido = false;
        do {
            nuevoGenero = scanner.nextLine().trim().toLowerCase();
            switch(nuevoGenero) {
                case "m":
                case "f":
                    generoValido = true;
                    break;
                default:
                    System.out.print("Opción inválida. Use M (Masculino), F (Femenino) u O (Otro): ");
            }
        } while (!generoValido);
        do {
            System.out.print("Edad: ");
            String entrada = scanner.nextLine().trim();
            if (!entrada.matches("\\d+")) {
                System.out.print("Error: Solo se permiten números enteros. Intente nuevamente: ");
            } else {
                nuevaEdad = Integer.parseInt(entrada);

                if (nuevaEdad < 1 || nuevaEdad > 120) {
                    System.out.print("Edad debe estar entre 1 y 120 años. Intente nuevamente: ");
                } else {
                    edadValida = true;
                }
            }
        } while (!edadValida);
        System.out.print("Contraseña: ");
        String nuevaContraseña = scanner.nextLine();
        Usuario nuevoUsuario = new Usuario(nuevoCorreo, nuevoNombre, nuevoGenero, nuevaEdad, nuevaContraseña);
        usuariosRegistrados.add(nuevoUsuario);
        System.out.println("\n¡Registro exitoso!");
    }
    public boolean iniciarSesion() {
        System.out.println("\n--- INICIO DE SESIÓN ---");
        System.out.print("Correo electrónico: ");
        String correo = scanner.nextLine().trim();
        System.out.print("Contraseña: ");
        String contraseña = scanner.nextLine();
        for (Usuario usuario : usuariosRegistrados) {
            if(usuario.getCorreo().equals(correo) && usuario.getContraseña().equals(contraseña)) {
                usuarioAutenticado = usuario;
                System.out.println("\n¡Bienvenido " + usuario.getNombre() + "!");
                mostrarMenuSecundario();
                return true;
            }}
        System.out.println("\nCredenciales incorrectas o usuario no registrado");
        return false;}
    private void mostrarMenuSecundario() {
        while(usuarioAutenticado != null) {
            System.out.println("\n*** MENÚ USUARIO ***");
            System.out.println("1. Ver mis datos");
            System.out.println("2. Modificar mis datos");
            System.out.println("3. Cerrar sesión");
            System.out.print("Seleccione opción: ");
            Byte opcion = Byte.parseByte(scanner.nextLine().trim());
            switch(opcion) {
                case 1:
                    mostrarDatosUsuario(usuarioActual);
                    break;
                case 2:
                    modificarDatosUsuario();
                    break;
                case 3:
                    cerrarSesion();
                    return;
                //AGREGAR LAS OTRAS OPCIONES
                default:
                    System.out.println("Opción inválida");
            }}}
    public void mostrarDatosUsuario(String usuarioActual) {
        System.out.println("\n--- TUS DATOS ---");
        System.out.println("Correo: " + usuarioAutenticado.getCorreo());
        System.out.println("Nombre: " + usuarioAutenticado.getNombre());
        System.out.println("Género:" + usuarioAutenticado.getGenero());
        System.out.println("Edad: " + usuarioAutenticado.getEdad());
    }
    private void modificarDatosUsuario() {
        System.out.println("\n--- MODIFICAR DATOS ---");
        System.out.print("Nuevo nombre (" + usuarioAutenticado.getNombre() + "): ");
        String nuevoNombre = scanner.nextLine().toLowerCase().trim();
        if(!nuevoNombre.isEmpty()) usuarioAutenticado.setNombre(nuevoNombre);
        System.out.print("Nuevo género (" + usuarioAutenticado.getGenero() + "): ");
        String nuevoGenero = scanner.nextLine().toUpperCase().trim();
        if(!nuevoGenero.isEmpty()) usuarioAutenticado.setGenero(nuevoGenero);
        System.out.print("Nueva edad (" + usuarioAutenticado.getEdad() + "): ");
        String nuevaEdad = scanner.nextLine().trim().replace(".","").replace(",","");
        if(!nuevaEdad.isEmpty()) usuarioAutenticado.setEdad(Integer.parseInt(nuevaEdad));
        System.out.println("Datos actualizados correctamente");
    }
    private void cerrarSesion() {
        usuarioAutenticado = null;
        System.out.println("Sesión cerrada correctamente");
    }
    private boolean existeUsuario(String correo) {
        for (Usuario usuario : usuariosRegistrados) {
            if (usuario.getCorreo().equalsIgnoreCase(correo)) {
                return true;
            }}
        return false;
    }}
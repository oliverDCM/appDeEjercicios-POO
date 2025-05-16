package proyectoFinal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class MenuProyecto{
    private List<Usuario> usuariosRegistrados = new ArrayList<>();
    private List<Fits> UsuariosDatosRegistados  = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private Double peso;
    private Double altura;
    private String NivelActividad;
    private String objetivo;
    Fits datosFitness = new Fits();
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
                    System.out.print("Opción inválida. Use M (Masculino) y F (Femenino): ");
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
            if(usuario.getCorreo().equals(correo) && usuario.getContrasena().equals(contraseña)) {
                usuarioAutenticado = usuario;
                System.out.println("\n¡Bienvenido " + usuario.getNombre() + "!");
                mostrarMenuSecundario();
                return true;
            }}
        System.out.println("\nCredenciales incorrectas o usuario no registrado");
        return false;}
    private void mostrarMenuSecundario() {
        while(usuarioAutenticado != null) {
            System.out.println("""
                *** MENÚ USUARIO ***
                1. Ver mis datos
                2. Modificar mis datos
                3. Ingrese sus datos de fitness
                4. IMC
                5.Plan de Ejercicios
                6. Cerrar sesión
                Seleccione opción:
                """);
            Byte opcion = Byte.parseByte(scanner.nextLine().trim());
            switch(opcion) {
                case 1:
                    mostrarDatosUsuario(usuarioActual);
                    break;
                case 2:
                    modificarDatosUsuario();
                    break;
                case 3:
                    datosFitness();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
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
       if (datosFitness.isDatosCompletos()){
           System.out.println("- Peso: " + datosFitness.getPeso() + " kg");
           System.out.println("- Altura: " + datosFitness.getAltura() + " m");
           System.out.println("- Nivel Actividad: " + datosFitness.getNivelActividad());
           System.out.println("- Objetivo: " + datosFitness.getObjetivo());
       }
       else {System.out.println("No se han guardado los datos de fitness");}

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
    private void datosFitness() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- DATOS FITNESS ---");
        while (true) {
            System.out.print("Peso en kg (ej: 70.5): ");
            String inputPeso = scanner.nextLine().trim();
            if (inputPeso.isEmpty()) {
                System.out.println("El peso es obligatorio!");
                continue;
            }
            try {
                peso = Double.parseDouble(inputPeso);
                if (peso <= 0 || peso > 300) {
                    System.out.println("Peso inválido. Debe ser entre 1 y 300 kg");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Formato inválido. Use números con decimales separados por punto");
            }
        }
        while (true) {
            System.out.print("Altura en metros (ej: 1.75): ");
            String inputAltura = scanner.nextLine().trim();
            if (inputAltura.isEmpty()) {
                System.out.println("La altura es obligatoria!");
                continue;
            }
            try {
                altura = Double.parseDouble(inputAltura);
                if (altura <= 0 || altura > 2.5) {
                    System.out.println("Altura inválida. Debe ser entre 0.5 y 2.5 metros");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Formato inválido. Use números con decimales separados por punto");
            }
        }
        String nivelActividad;
        while (true) {
            System.out.println("Niveles de actividad válidos:");
            System.out.println("S - Sedentario (poco o ningún ejercicio)");
            System.out.println("L - Ligero (ejercicio 1-3 días/semana)");
            System.out.println("M - Moderado (ejercicio 3-5 días/semana)");
            System.out.println("A - Activo (ejercicio 6-7 días/semana)");
            System.out.print("Seleccione nivel de actividad: ");
            nivelActividad = scanner.nextLine().trim().toUpperCase();

            if (nivelActividad.matches("S|L|M|A")) {
                break;
            }
            System.out.println("Opción inválida. Seleccione una de las opciones mostradas");
        }
        while (true) {
            System.out.println("Objetivos válidos:");
            System.out.println("DC - Déficit calórico (bajar de peso)");
            System.out.println("MP - Mantener peso actual(Tonificar)");
            System.out.println("AP - Aumentar peso/masa muscular");
            System.out.println("SP - Subir peso ");
            System.out.print("Seleccione objetivo: ");
            objetivo = scanner.nextLine().trim().toUpperCase();
            if (objetivo.matches("DC|MP|AP|SP")) {
                break;
            }
            System.out.println("Opción inválida. Seleccione una de las opciones mostradas");
        }
        Fits nuevoUsuario = new Fits(peso, altura, nivelActividad, objetivo,"",0);
        UsuariosDatosRegistados.add(nuevoUsuario);

        datosFitness.setPeso(peso);
        datosFitness.setAltura(altura);
        datosFitness.setNivelActividad(nivelActividad);
        datosFitness.setObjetivo(objetivo);

        datosFitness.setDatosCompletos(true);
        System.out.println("\nDatos fitness guardados correctamente!");
        System.out.println("Resumen:");
        System.out.println("- Peso: " + peso + " kg");
        System.out.println("- Altura: " + altura + " m");
        System.out.println("- Nivel Actividad: " + nivelActividad);
        System.out.println("- Objetivo: " + objetivo);
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
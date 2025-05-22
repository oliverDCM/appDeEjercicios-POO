package proyectoFinal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class MenuProyecto{
    private List<Usuario> usuariosRegistrados = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private Double peso;
    private Double altura;
    private String objetivo;
    Fits datosFitness = new Fits();
    private Usuario usuarioAutenticado;
    private String usuarioActual;
    String nuevoCorreo;
    Integer nuevaEdad;
    boolean correoValido = false;
    boolean edadValida = false;
    public void iniciar() {
        boolean salir = false;
        while (!salir) {
            System.out.println("""
                ╔══════════════════════════════╗
                ║       MENÚ PRINCIPAL         ║
                ╠══════════════════════════════╣
                ║  1. Registrarse              ║
                ║  2. Iniciar sesión           ║
                ║  3. Salir                    ║
                ╚══════════════════════════════╝
                """);
            System.out.print("Seleccione una opción: ");
            String opcion = scanner.nextLine();
            switch (opcion) {
                case "1":
                    registrarUsuario();
                    break;
                case "2":
                    if (iniciarSesion()) {
                        mostrarMenuSecundario();
                    }
                    break;
                case "3":
                    salir = true;
                    System.out.println("¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

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

                if (nuevaEdad <= 10 || nuevaEdad > 120) {
                    System.out.print("La edad debe ser mayor a 10 años y no exceder los 120. Intente nuevamente: ");
                } else {
                    edadValida = true;
                }
            }
        } while (!edadValida);
        System.out.print("Contraseña: ");
        String nuevaContrasena = scanner.nextLine();

        if (nuevaContrasena.isEmpty()) {
            System.out.println("Error: Debes ingresar una contraseña válida");
        }
        Usuario nuevoUsuario = new Usuario(nuevoCorreo, nuevoNombre, nuevoGenero, nuevaEdad, nuevaContrasena);
        usuariosRegistrados.add(nuevoUsuario);
        System.out.println("\n¡Registro exitoso!");
    }
    public boolean iniciarSesion() {
        System.out.println("\n--- INICIO DE SESIÓN ---");
        System.out.print("Correo electrónico: ");
        String correo = scanner.nextLine().trim();
        System.out.print("Contraseña: ");
        String contrasena = scanner.nextLine();
        for (Usuario usuario : usuariosRegistrados) {
            if(usuario.getCorreo().equals(correo) && usuario.getContrasena().equals(contrasena)) {
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
                    ╔══════════════════════════════════════════════════╗
                    ║                MENÚ DE USUARIO                   ║
                    ╠══════════════════════════════════════════════════╣
                    ║  1. Ver mis datos                                ║                          
                    ║  2. Ingresar datos de fitness                    ║
                    ║  3. Plan de ejercicios                           ║
                    ║  4. Cerrar sesión                                ║
                    ╠══════════════════════════════════════════════════╣
                      Seleccione opción: 
                    """);
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("No ingresaste ninguna opción. Intenta de nuevo.");
                continue;
            }
            byte opcion = Byte.parseByte(input);
            switch(opcion) {
                        case 1:
                            mostrarDatosUsuario(usuarioActual);
                            break;
                        case 2:
                            datosFitness();
                            break;
                        case 3:
                            mostrarPlanEjercicios();
                            break;
                        case 4:
                            cerrarSesion();
                            return;
                        default:
                            System.out.println("Opción inválida");
                    }}}

            public void mostrarDatosUsuario(String usuarioActual) {
                StringBuilder datos = new StringBuilder();
                datos.append("""
    ╔══════════════════════════════════════════════════╗
    ║                  TUS DATOS                       ║
    ╠══════════════════════════════════════════════════╣
    ║  Correo: %-37s   ║
    ║  Nombre: %-37s   ║
    ║  Género: %-37s   ║
    ║  Edad:   %-37d   ║
    """.formatted(usuarioAutenticado.getCorreo(),
                usuarioAutenticado.getNombre(),
                usuarioAutenticado.getGenero(),
                usuarioAutenticado.getEdad()
        ));
                Fits datosFitness = usuarioAutenticado.getDatosFitness();
                if (datosFitness != null && datosFitness.isDatosCompletos()) {
                    datos.append(""" 
        ╠══════════════════════════════════════════════════╣
        ║  Peso:    %-29.2f kg       ║
        ║  Altura:  %-29.2f m        ║
        ║  Imc:  %-29f             ║
        ║  Nivel Actividad: %-29s  ║
        ║  Objetivo:        %-29s  ║
        """.formatted(
                            datosFitness.getPeso(),
                            datosFitness.getAltura(),
                            datosFitness.getImc(),
                            datosFitness.getNivelActividad(),
                            datosFitness.getObjetivo()
                    ));
                } else {
                    datos.append("""
        ╠══════════════════════════════════════════════════╣
        ║  Sin datos fitness registrados                   ║
        """);
                }
                datos.append("╚══════════════════════════════════════════════════╝");
                System.out.println(datos.toString());
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
            System.out.println("""
    ╔══════════════════════════════════════════════════╗
    ║               NIVELES DE ACTIVIDAD               ║
    ╠══════════════════════════════════════════════════╣
    ║  S - Sedentario                                  ║
    ║    (poco o ningún ejercicio)                     ║
    ║  L - Ligero                                      ║
    ║    (ejercicio 1-3 días/semana)                   ║
    ║  M - Moderado                                    ║
    ║    (ejercicio 3-5 días/semana)                   ║
    ║  A - Activo                                      ║
    ║    (ejercicio 6-7 días/semana)                   ║
    ╠══════════════════════════════════════════════════╣
    ║  Seleccione nivel de actividad:                  ║
    ╚══════════════════════════════════════════════════╝
    """);
            nivelActividad = scanner.nextLine().trim().toUpperCase();

            if (nivelActividad.matches("S|L|M|A")) {
                break;
            }
            System.out.println("Opción inválida. Seleccione una de las opciones mostradas");
        }
        while (true) {
            System.out.println("""
    ╔══════════════════════════════════════════════════╗
    ║               OBJETIVOS VALIDOS                  ║
    ╠══════════════════════════════════════════════════╣
    ║  DC - Déficit calórico (bajar de peso)           ║
    ║  MP - Mantener peso actual (Tonificar)           ║
    ║  AP - Aumentar peso/masa muscular                ║
    ║  SP - Subir peso                                 ║
    ╠══════════════════════════════════════════════════╣
    ║  Seleccione objetivo:                            ║
    ╚══════════════════════════════════════════════════╝
    """);
            objetivo = scanner.nextLine().trim().toUpperCase();
            if (objetivo.matches("DC|MP|AP|SP")) {
                break;
            }
            System.out.println("Opción inválida. Seleccione una de las opciones mostradas");
        }
        Fits datos = new Fits(peso, altura, nivelActividad, objetivo);
        usuarioAutenticado.setDatosFitness(datos);
        datosFitness.setDatosCompletos(true);
        System.out.println("\nDatos fitness guardados correctamente!");
        System.out.println("Resumen:");
        System.out.println("- Peso: " + peso + " kg");
        System.out.println("- Altura: " + altura + " m");
        System.out.println("- Nivel Actividad: " + nivelActividad);
        System.out.println("- Objetivo: " + objetivo);
        System.out.printf("IMC calculado: %.2f\n", datos.getImc());
    }
    private void mostrarPlanEjercicios() {
        if (usuarioAutenticado == null || usuarioAutenticado.getDatosFitness() == null) {
            System.out.println("Complete sus datos fitness primero");
            return;
        }

        Fits datos = usuarioAutenticado.getDatosFitness();
        PlanEjercicio plan = crearPlanPersonalizado(datos.getNivelActividad(), datos.getObjetivo());

        if (plan != null) {
            plan.mostrarPlan();
        } else {
            System.out.println("No hay plan disponible para su combinación actual");
        }
    }
    private PlanEjercicio crearPlanPersonalizado(String nivel, String objetivo) {
        return switch (nivel + "|" + objetivo) {
            case "S|DC" -> new PlanDeficitSedentario();
            case "L|DC" -> new PlanDeficitLigero();
            case "M|DC" -> new PlanDeficitModerado();
            case "A|DC" -> new PlanDeficitActivo();
            case "S|MP" -> new PlanMantenerPesoSedentario();
            case "L|MP" -> new PlanMantenerPesoLigero();
            case "M|MP" -> new PlanMantenerPesoModerado();
            case "A|MP" -> new PlanMantenerPesoActivo();
            case "S|SP" -> new PlanSubirPesoSedentario();
            case "L|SP" -> new PlanSubirPesoLigero();
            case "M|SP" -> new PlanSubirPesoModerado();
            case "A|SP" -> new PlanSubirPesoActivo();
            case "S|AP" -> new PlanMasaSedentaria();
            case "L|AP" -> new PlanMasaLigero();
            case"M|AP" -> new PlanMasaModerado();
            case"A|AP" -> new PlanMasaActivo();
            default -> null;
        };
    }
    private void cerrarSesion() {
        usuarioAutenticado = null;
        System.out.println("Sesión cerrada correctamente");
    }
    private boolean existeUsuario(String correo) {
        for (Usuario usuario : usuariosRegistrados) {
            if (usuario.getCorreo().equalsIgnoreCase(correo)) {
                return true;
            }
        }
        return false;
    }
}
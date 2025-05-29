package proyectoFinal;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MenuProyecto {
    private List<Usuario> usuariosRegistrados = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private Usuario usuarioAutenticado;
    private String nuevoCorreo;
    private Integer nuevaEdad;
    private boolean correoValido = false;
    private boolean edadValida = false;
    private static final String USUARIOS_FILE = "usuarios.txt";
    // Eliminamos FITNESS_FILE, ya no es necesario.

    public void iniciar() {
        System.out.println("DEBUG: Ruta de trabajo actual: " + Paths.get("").toAbsolutePath().toString());

        cargarUsuarios(); // Ahora este método también carga los datos fitness
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
                    // Al salir, guardamos todos los usuarios (y sus datos fitness)
                    guardarTodosLosUsuarios();
                    System.out.println("¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    // `cargarDatosIniciales()` ya no es necesario, lo eliminamos.

    private void cargarUsuarios() {
        File archivo = new File(USUARIOS_FILE);
        if (!archivo.exists()) {
            System.out.println("Archivo de usuarios no encontrado. Se creará uno nuevo si registras usuarios.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Nuevo formato: correo;nombre;genero;edad;contrasena[;peso;altura;nivelActividad;objetivo;imc]
                String[] campos = linea.split(";");
                if (campos.length >= 5) { // Mínimo 5 campos para los datos del usuario
                    Usuario usuario = new Usuario(
                            campos[0], // correo
                            campos[1], // nombre
                            campos[2], // género
                            Integer.parseInt(campos[3]), // edad
                            campos[4]  // contraseña
                    );

                    // Si hay datos fitness, los cargamos
                    if (campos.length == 10) { // Si hay 10 campos, significa que los 5 de fitness están presentes
                        try {
                            Fits datos = new Fits();
                            datos.setPeso(Double.parseDouble(campos[5]));
                            datos.setAltura(Double.parseDouble(campos[6]));
                            datos.setNivelActividad(campos[7]);
                            datos.setObjetivo(campos[8]);
                            datos.setImc(Double.parseDouble(campos[9]));
                            datos.setDatosCompletos(true);
                            usuario.setDatosFitness(datos);
                            System.out.println("DEBUG: Datos fitness cargados para usuario: " + usuario.getCorreo());
                        } catch (NumberFormatException e) {
                            System.err.println("Error al parsear datos fitness para " + usuario.getCorreo() + " en " + USUARIOS_FILE + ": " + e.getMessage());
                        }
                    }
                    usuariosRegistrados.add(usuario);
                } else {
                    System.err.println("Advertencia: Línea de usuario mal formateada en " + USUARIOS_FILE + ": " + linea);
                }
            }
            System.out.println("DEBUG: Usuarios cargados. Total: " + usuariosRegistrados.size());
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error cargando usuarios desde " + USUARIOS_FILE + ": " + e.getMessage());
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
            nuevoGenero = scanner.nextLine().trim().toUpperCase();
            switch(nuevoGenero) {
                case "M":
                case "F":
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
            System.out.println("Error: Debes ingresar una contraseña válida.");
            return;
        }

        Usuario nuevoUsuario = new Usuario(nuevoCorreo, nuevoNombre, nuevoGenero, nuevaEdad, nuevaContrasena);
        usuariosRegistrados.add(nuevoUsuario); // Añadir a la lista en memoria
        // Ya no necesitamos un método aparte para guardar solo un usuario al registrar.
        // `guardarTodosLosUsuarios()` se encargará de todo al salir o cerrar sesión.
        System.out.println("\n¡Registro exitoso!");
    }

    // Este método ya no es necesario para añadir un solo usuario, lo eliminamos.
    // private void guardarUsuarioEnArchivo(Usuario usuario) { ... }

    public boolean iniciarSesion() {
        System.out.println("\n--- INICIO DE SESIÓN ---");
        System.out.print("Correo electrónico: ");
        String correo = scanner.nextLine().trim();
        System.out.print("Contraseña: ");
        String contrasena = scanner.nextLine();
        for (Usuario usuario : usuariosRegistrados) {
            if(usuario.getCorreo().equalsIgnoreCase(correo) && usuario.getContrasena().equals(contrasena)) {
                usuarioAutenticado = usuario;
                System.out.println("\n¡Bienvenido " + usuario.getNombre() + "!");
                System.out.println("DEBUG: Usuario '" + usuario.getCorreo() + "' autenticado.");
                System.out.println("DEBUG: ¿Usuario autenticado tiene Fits cargados? " + (usuarioAutenticado.getDatosFitness() != null && usuarioAutenticado.getDatosFitness().isDatosCompletos()));
                return true;
            }}
        System.out.println("\nCredenciales incorrectas o usuario no registrado");
        return false;
    }

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
            try {
                byte opcion = Byte.parseByte(input);
                switch(opcion) {
                    case 1:
                        mostrarDatosUsuario();
                        break;
                    case 2:
                        datosFitness();
                        break;
                    case 3:
                        mostrarPlanEjercicios();
                        break;
                    case 4:
                        cerrarSesion();
                        guardarTodosLosUsuarios(); // Guardamos todos los usuarios (con sus datos fitness) al cerrar sesión
                        return;
                    default:
                        System.out.println("Opción inválida");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingresa un número.");
            }
        }
    }

    public void mostrarDatosUsuario() {
        if (usuarioAutenticado == null) {
            System.out.println("No hay ningún usuario autenticado.");
            return;
        }

        StringBuilder datosStr = new StringBuilder();
        datosStr.append("""
    ╔══════════════════════════════════════════════════╗
    ║                  TUS DATOS                       ║
    ╠══════════════════════════════════════════════════╣
    ║  Correo: %-37s   ║
    ║  Nombre: %-37s   ║
    ║  Género: %-37s   ║
    ║  Edad:   %-37d   ║
    """.formatted(usuarioAutenticado.getCorreo(),
                usuarioAutenticado.getNombre(),
                usuarioAutenticado.getGenero().toUpperCase(),
                usuarioAutenticado.getEdad()
        ));

        Fits datosFitness = usuarioAutenticado.getDatosFitness();
        if (datosFitness != null && datosFitness.isDatosCompletos()) {
            datosStr.append("""
        ╠══════════════════════════════════════════════════╣
        ║  Peso:    %-29.2f kg       ║
        ║  Altura:  %-29.2f m        ║
        ║  Imc:     %-29.2f          ║
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
            datosStr.append("""
        ╠══════════════════════════════════════════════════╣
        ║  Sin datos fitness registrados. Ingréselos en la opción 2.║
        """);
        }
        datosStr.append("╚══════════════════════════════════════════════════╝");
        System.out.println(datosStr.toString());
    }

    private void datosFitness() {
        if (usuarioAutenticado == null) {
            System.out.println("Debe iniciar sesión para ingresar datos fitness.");
            return;
        }

        System.out.println("\n--- DATOS FITNESS ---");
        Double peso;
        Double altura;
        String nivelActividad;
        String objetivo;

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
    ║  SP - Subir peso (sin detalle, podría ser ganancia general)║
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
        datos.setDatosCompletos(true);
        usuarioAutenticado.setDatosFitness(datos); // Actualiza los datos fitness del usuario autenticado en memoria.

        System.out.println("DEBUG: En datosFitness(): Datos Fitness creados y asignados al usuario autenticado:");
        System.out.println("DEBUG: Usuario autenticado (correo): " + usuarioAutenticado.getCorreo());
        System.out.println("DEBUG: ¿Usuario autenticado tiene Fits? " + (usuarioAutenticado.getDatosFitness() != null));
        if (usuarioAutenticado.getDatosFitness() != null) {
            System.out.println("DEBUG: ¿Fits están completos? " + usuarioAutenticado.getDatosFitness().isDatosCompletos());
            System.out.println("DEBUG: Peso en Fits: " + usuarioAutenticado.getDatosFitness().getPeso());
            System.out.println("DEBUG: Altura en Fits: " + usuarioAutenticado.getDatosFitness().getAltura());
        }

        System.out.println("\nDatos fitness guardados correctamente en memoria!");
        System.out.println("Resumen:");
        System.out.println("- Peso: " + peso + " kg");
        System.out.println("- Altura: " + altura + " m");
        System.out.println("- Nivel Actividad: " + nivelActividad);
        System.out.println("- Objetivo: " + objetivo);
        System.out.printf("IMC calculado: %.2f\n", datos.getImc());
    }

    /**
     * Guarda TODOS los usuarios registrados (incluyendo sus datos fitness) en el archivo.
     * Este método SOBREESCRIBE el archivo `usuarios.txt` cada vez que se llama.
     */
    private void guardarTodosLosUsuarios() {
        System.out.println("DEBUG: Intentando guardar todos los usuarios en " + USUARIOS_FILE + "...");
        System.out.println("DEBUG: Número de usuarios registrados en memoria: " + usuariosRegistrados.size());

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(USUARIOS_FILE, false))) { // false para sobrescribir
            for (Usuario usuario : usuariosRegistrados) {
                StringBuilder linea = new StringBuilder();
                linea.append(String.format("%s;%s;%s;%d;%s",
                        usuario.getCorreo(),
                        usuario.getNombre(),
                        usuario.getGenero(),
                        usuario.getEdad(),
                        usuario.getContrasena()));

                Fits datos = usuario.getDatosFitness();
                if (datos != null && datos.isDatosCompletos()) {
                    linea.append(String.format(";%.2f;%.2f;%s;%s;%.2f",
                            datos.getPeso(),
                            datos.getAltura(),
                            datos.getNivelActividad(),
                            datos.getObjetivo(),
                            datos.getImc()));
                    System.out.println("DEBUG:   Línea escrita para " + usuario.getCorreo() + " (con fitness): " + linea.toString().trim());
                } else {
                    System.out.println("DEBUG:   Línea escrita para " + usuario.getCorreo() + " (sin fitness): " + linea.toString().trim());
                }
                bw.write(linea.toString());
                bw.newLine(); // Añadir un salto de línea para cada usuario
            }
            System.out.println("Todos los usuarios han sido guardados exitosamente en el archivo.");
        } catch (IOException e) {
            System.err.println("Error guardando usuarios en " + USUARIOS_FILE + ": " + e.getMessage());
        }
        System.out.println("DEBUG: Fin del intento de guardar todos los usuarios.");
    }

    private void mostrarPlanEjercicios() {
        if (usuarioAutenticado == null) {
            System.out.println("Debe iniciar sesión para ver el plan de ejercicios.");
            return;
        }
        if (usuarioAutenticado.getDatosFitness() == null || !usuarioAutenticado.getDatosFitness().isDatosCompletos()) {
            System.out.println("Primero debe ingresar sus datos fitness (Opción 2 del menú de usuario).");
            return;
        }

        Fits datosFitnessUsuario = usuarioAutenticado.getDatosFitness();
        PlanEjercicio plan = crearPlanPersonalizado(datosFitnessUsuario.getNivelActividad(), datosFitnessUsuario.getObjetivo(), usuarioAutenticado);

        if (plan != null) {
            plan.mostrarPlan();
        } else {
            System.out.println("No hay plan disponible para su combinación actual de nivel de actividad y objetivo.");
            System.out.println("Nivel: " + datosFitnessUsuario.getNivelActividad() + ", Objetivo: " + datosFitnessUsuario.getObjetivo());
        }
    }

    private PlanEjercicio crearPlanPersonalizado(String nivel, String objetivo, Usuario usuario) {
        return switch (nivel + "|" + objetivo) {
            case "S|DC" -> new PlanDeficitSedentario(usuario);
            case "L|DC" -> new PlanDeficitLigero(usuario);
            case "M|DC" -> new PlanDeficitModerado(usuario);
            case "A|DC" -> new PlanDeficitActivo(usuario);
            case "S|MP" -> new PlanMantenerPesoSedentario(usuario);
            case "L|MP" -> new PlanMantenerPesoLigero(usuario);
            case "M|MP" -> new PlanMantenerPesoModerado(usuario);
            case "A|MP" -> new PlanMantenerPesoActivo(usuario);
            case "S|SP" -> new PlanSubirPesoSedentario(usuario);
            case "L|SP" -> new PlanSubirPesoLigero(usuario);
            case "M|SP" -> new PlanSubirPesoModerado(usuario);
            case "A|SP" -> new PlanSubirPesoActivo(usuario);
            case "S|AP" -> new PlanMasaSedentaria(usuario);
            case "L|AP" -> new PlanMasaLigero(usuario);
            case "M|AP" -> new PlanMasaModerado(usuario);
            case "A|AP" -> new PlanMasaActivo(usuario);
            default -> null;
        };
    }

    private void cerrarSesion() {
        usuarioAutenticado = null;
        System.out.println("Sesión cerrada correctamente.");
        // Se guarda en `guardarTodosLosUsuarios()` al cerrar sesión en el menú secundario,
        // o al salir de la aplicación principal.
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
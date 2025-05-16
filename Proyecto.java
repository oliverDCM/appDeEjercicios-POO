package proyectoFinal;

import java.util.Scanner;
    public class Proyecto {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            MenuProyecto sistema = new MenuProyecto();
            boolean sesionIniciada = false;
            String usuarioActual = "";

            while(true) {
                try {
                    System.out.println("\n--- MENÚ PRINCIPAL ---");
                    System.out.println("1. Registro de usuario");
                    System.out.println("2. Iniciar sesión");
                    System.out.println("3. Salir");
                    System.out.print("Selección: ");

                    String input = sc.nextLine().trim();
                    if(input.isEmpty()) {
                        System.out.println("Error: Debes ingresar una opción");
                        continue;
                    }

                    // Validar que sea numérico
                    if(!input.matches("\\d+")) {
                        System.out.println("Error: Solo se permiten números");
                        continue;
                    }

                    // Convertir y validar rango
                    byte opcion = Byte.parseByte(input);

                    switch(opcion) {
                        case 1:
                            sistema.registrarUsuario();
                            break;
                        case 2:
                            sesionIniciada = sistema.iniciarSesion();
                            if(sesionIniciada) {
                                System.out.print("Ingrese su correo nuevamente: ");
                                usuarioActual = sc.nextLine();
                            }
                            break;
                        case 3:
                            System.out.println("¡Hasta luego!");
                            System.exit(0);
                        default:
                            System.out.println("Opción inválida. Intente nuevamente");
                    }

                } catch(NumberFormatException e) {
                    System.out.println("Error: La opción debe estar entre 1 y 3");
                }
            }
        }
    }



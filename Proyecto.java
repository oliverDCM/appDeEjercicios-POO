package proyectoFinal;

import java.util.Scanner;
    public class Proyecto {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            MenuProyecto sistema = new MenuProyecto();
            boolean sesionIniciada = false;
            String usuarioActual = "";
            while(true) {
                System.out.println("\n--- MENÚ PRINCIPAL ---");
                System.out.println("1. Registro de usuario");
                System.out.println("2. Iniciar sesión");
                System.out.println("3. Salir");
                System.out.print("Selección: ");
                Integer opcion = Integer.parseInt(sc.nextLine().trim());
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
                        System.out.println("Opción inválida");
                }}}}


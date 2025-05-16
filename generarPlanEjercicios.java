package proyectoFinal;

public class generarPlanEjercicios {
    MenuProyecto usuario = new MenuProyecto();
    Fits datos = new Fits();
    public void generarPlanEjercicios() {
        System.out.println("\n--- PLAN DE EJERCICIOS PERSONALIZADO ---");
        System.out.println("Basado en tus datos:");
        System.out.println("- Peso: " + datos.getPeso() + " kg");
        System.out.println("- Altura: " + datos.getAltura() + " m");
        System.out.println("- Nivel de actividad: " + datos.getNivelActividad());
        System.out.println("- Objetivo: " + datos.getObjetivo());
        //PERSONALIZAR BIEN LAS RUTINAS
        //ESTO SON RECOMENDACIONES PARA CUANDO TIENE UN NIVEL DE ACTIVIDAD SEDENTARIA
        System.out.println("\nRecomendaciones:");
        if (datos.getObjetivo().equals("DC")) {
            System.out.println("- Rutina: Cardio intensivo 5 días/semana");
            System.out.println("- Ejercicios: Correr, ciclismo, HIIT");
        } else if (datos.getObjetivo().equals("AP")) {
            System.out.println("- Rutina: Entrenamiento de fuerza 4 días/semana");
            System.out.println("- Ejercicios: Pesas, calistenia, resistencia");
        }else if (datos.getObjetivo().equals("MP")) {
            System.out.println();

        }else if (datos.getObjetivo().equals("SP")) {
            System.out.println();
        }

        double imc = datos.getPeso() / (datos.getAltura() * datos.getAltura());
        System.out.printf("\nTu IMC es: %.1f - %s\n", imc, clasificarIMC(imc));
    }

    private String clasificarIMC(double imc) {
        if (imc < 18.5) return "Bajo peso";
        else if (imc < 25) return "Peso normal";
        else if (imc < 30) return "Sobrepeso";
        else return "Obesidad";
    }
}

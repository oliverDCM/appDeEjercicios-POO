package proyectoFinal.modelo.estrategia;

import proyectoFinal.modelo.dominio.Usuario;

public class PlanDeficitLigero extends PlanEjercicio {
    public PlanDeficitLigero(Usuario usuario) {
        super("Ligero", "Deficit Calorico",usuario);
    }

    @Override
    protected void generarPlan() {
        this.setDiasPorSemana(4);
        this.setDuracionSesion(35);
        if (datos.getGenero().equals("M")) { // Para hombres
            if (datos.getEdad() >= 11 && datos.getEdad() < 18) { // Hombres adolescentes (11-17 años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria para Hombres Adolescentes (35 min - Repetir 4 días a la semana)**\n" +
                                "   - **Calentamiento (5 minutos):** 3 minutos de marcha suave en el lugar, 2 minutos de movimientos de hombros y caderas.\n" +
                                "   - **Cardio (20 minutos):** Caminata rápida a paso constante. Busca un ritmo que eleve tu respiración, pero sin que te quedes sin aliento.\n" +
                                "   - **Fuerza (10 minutos):** Realiza 3 series por ejercicio, con 30-45 segundos de descanso entre series.\n" +
                                "     1.  **Sentadillas con peso corporal:** 3 series de 15 repeticiones. Enfócate en bajar la cadera.\n" +
                                "     2.  **Flexiones (Push-ups) de rodillas o contra la pared:** 3 series de 8-10 repeticiones. Baja el pecho de forma controlada.\n" +
                                "     3.  **Elevaciones de rodillas (High Knees) en el lugar:** 3 series de 15 repeticiones por pierna. Levanta las rodillas hacia el pecho.\n" +
                                "     4.  **Plancha (Plank):** 3 series de 20-30 segundos. Mantén el cuerpo recto y el abdomen contraído.\n" +
                                "   - **Estiramiento (5 minutos):** Estiramientos suaves de piernas y espalda. Mantén cada estiramiento por 15-20 segundos."
                });
            } else { // Hombres adultos (18+ años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria para Hombres Adultos (35 min - Repetir 4 días a la semana)**\n" +
                                "   - **Calentamiento (5 minutos):** 3 minutos de trote suave en el lugar o caminata enérgica, 2 minutos de estiramientos dinámicos suaves (círculos de cadera, rotaciones de tronco).\n" +
                                "   - **Cardio (20 minutos):** Trote suave a un ritmo constante. Si sientes mucha dificultad, alterna con caminata rápida. El objetivo es mantener el movimiento continuo.\n" +
                                "   - **Fuerza (10 minutos):** Realiza 3 series por ejercicio, con 45-60 segundos de descanso entre series.\n" +
                                "     1.  **Flexiones (Push-ups) en el suelo o inclinadas:** 3 series de 10-12 repeticiones. Baja tu pecho hacia el suelo (o la superficie de apoyo).\n" +
                                "     2.  **Zancadas (Lunges) con peso corporal:** 3 series de 12 repeticiones por pierna. Da un paso largo y baja la rodilla trasera hacia el suelo.\n" +
                                "     3.  **Crunches (Abdominales básicos):** 3 series de 20 repeticiones. Levanta los hombros del suelo usando el abdomen.\n" +
                                "     4.  **Plancha (Plank):** 3 series de 30-45 segundos. Mantén una línea recta desde la cabeza hasta los talones.\n" +
                                "   - **Estiramiento (5 minutos):** Estiramientos estáticos de piernas, pecho y abdomen. Mantén cada estiramiento por 20-30 segundos."
                });
            }

        } else if (datos.getGenero().equals("F")) { // Para mujeres
            if (datos.getEdad() >= 11 && datos.getEdad() < 18) { // Mujeres adolescentes (11-17 años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria para Mujeres Adolescentes (35 min - Repetir 4 días a la semana)**\n" +
                                "   - **Calentamiento (5 minutos):** 3 minutos de saltos de tijera suaves, 2 minutos de círculos de cadera y balanceos de brazos.\n" +
                                "   - **Cardio (20 minutos):** Caminata ligera a moderada. Puedes subir una pequeña pendiente o escaleras si tienes acceso, de forma suave.\n" +
                                "   - **Fuerza (10 minutos):** Realiza 3 series por ejercicio, con 30-45 segundos de descanso entre series.\n" +
                                "     1.  **Sentadillas con peso corporal:** 3 series de 15 repeticiones. Baja como si fueras a sentarte en una silla.\n" +
                                "     2.  **Saltos de tijera (Jumping Jacks):** 3 series de 20-25 repeticiones. Mantén un ritmo cómodo.\n" +
                                "     3.  **Abdominales básicos (Crunches):** 3 series de 15 repeticiones. Contrae el abdomen al subir.\n" +
                                "     4.  **Plancha (Plank):** 3 series de 15-20 segundos. Asegúrate de mantener la espalda recta.\n" +
                                "   - **Estiramiento (5 minutos):** Estiramientos suaves de piernas, abdomen y hombros. Mantén cada estiramiento por 15-20 segundos."
                });
            } else { // Mujeres adultas (18+ años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria para Mujeres Adultas (35 min - Repetir 4 días a la semana)**\n" +
                                "   - **Calentamiento (5 minutos):** 3 minutos de elíptica suave o bicicleta estacionaria, 2 minutos de movilidad de cadera (círculos, apertura de piernas).\n" +
                                "   - **Cardio (20 minutos):** Cardio ligero y continuo (elíptica, bicicleta estática, caminata enérgica). Mantén un ritmo que te permita sostener una conversación.\n" +
                                "   - **Fuerza (10 minutos):** Realiza 3 series por ejercicio, con 45-60 segundos de descanso entre series.\n" +
                                "     1.  **Zancadas (Lunges) sin peso:** 3 series de 12 repeticiones por pierna. Enfócate en el equilibrio y la forma.\n" +
                                "     2.  **Abdominales de bicicleta (Bicycle Crunches):** 3 series de 20-25 repeticiones (total). Mueve las piernas como si pedalearas.\n" +
                                "     3.  **Mountain Climbers:** 3 series de 15-20 segundos. Lleva las rodillas al pecho alternadamente.\n" +
                                "     4.  **Plancha lateral (Side Plank):** 2 series de 20-30 segundos por lado. Mantén el cuerpo en línea recta.\n" +
                                "   - **Estiramiento (5 minutos):** Estiramientos estáticos de isquiotibiales, glúteos y abdominales. Mantén cada estiramiento por 20-30 segundos."
                });
            }
        }
    }
}

package proyectoFinal.modelo.estrategia;

import proyectoFinal.modelo.dominio.Usuario;

public class PlanDeficitModerado extends PlanEjercicio {
    public PlanDeficitModerado(Usuario usuario) {
        super("Moderado", "Déficit Calórico",usuario);
    }

    @Override
    protected void generarPlan() {
        this.setDiasPorSemana(5);
        this.setDuracionSesion(45);
        if (datos.getGenero().equals("M")) { // Para hombres
            if (datos.getEdad() >= 11 && datos.getEdad() < 18) { // Hombres adolescentes (11-17 años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria para Hombres Adolescentes (45 min - Repetir 5 días a la semana)**\n" +
                                "   - **Calentamiento (5 minutos):** 3 minutos de trote suave en el lugar, 2 minutos de estiramientos dinámicos (círculos de hombros, giros de tronco).\n" +
                                "   - **Cardio (20 minutos):** Trote continuo a un ritmo moderado. Podrías alternar con caminata rápida si es necesario para mantenerte en movimiento.\n" +
                                "   - **Fuerza (15 minutos):** Realiza 3 series por ejercicio, con 45-60 segundos de descanso entre series. Enfócate en la forma.\n" +
                                "     1.  **Flexiones (Push-ups) en el suelo o elevadas:** 3 series de 12 repeticiones. Intenta bajar el pecho controladamente.\n" +
                                "     2.  **Zancadas (Lunges) con peso corporal:** 3 series de 10 repeticiones por pierna. Mantén el equilibrio.\n" +
                                "     3.  **Abdominales bicicleta (Bicycle Crunches):** 3 series de 20 repeticiones (total). Coordinación y control.\n" +
                                "     4.  **Plancha (Plank):** 3 series de 30 segundos. Mantén el cuerpo firme como una tabla.\n" +
                                "   - **Estiramiento (5 minutos):** Estiramientos estáticos suaves para piernas, pecho y espalda. Cada estiramiento por 20-30 segundos."
                });
            } else { // Hombres adultos (18+ años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria para Hombres Adultos (45 min - Repetir 5 días a la semana)**\n" +
                                "   - **Calentamiento (5 minutos):** 3 minutos de cardio moderado (elíptica, bicicleta) y 2 minutos de movilidad dinámica (rotaciones de cadera, balanceos de pierna).\n" +
                                "   - **Cardio (20 minutos):** **Correr intervalos:** Alterna 1 minuto a ritmo intenso (casi un sprint) con 2 minutos a ritmo moderado/recuperación. Repite 6-7 veces.\n" +
                                "   - **Fuerza (15 minutos):** Realiza 3-4 series por ejercicio, con 30-45 segundos de descanso entre series. Mantén un ritmo dinámico para quemar calorías.\n" +
                                "     1.  **Flexiones explosivas (Push-ups):** 4 series de 10-12 repeticiones. Intenta levantar las manos del suelo si puedes.\n" +
                                "     2.  **Saltos al cajón (Box Jumps) en un banco o escalón bajo:** 3 series de 12 repeticiones. Aterriza suavemente.\n" +
                                "     3.  **Russian Twists con peso (mancuerna o balón medicinal):** 3 series de 20-25 repeticiones (total). Gira el tronco controladamente.\n" +
                                "     4.  **Mountain Climbers:** 3 series de 30 segundos. Lleva las rodillas al pecho rápidamente.\n" +
                                "   - **Estiramiento (5 minutos):** Estiramientos estáticos profundos de los principales grupos musculares. Cada estiramiento por 20-30 segundos."
                });
            }

        } else if (datos.getGenero().equals("F")) { // Para mujeres
            if (datos.getEdad() >= 11 && datos.getEdad() < 18) { // Mujeres adolescentes (11-17 años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria para Mujeres Adolescentes (45 min - Repetir 5 días a la semana)**\n" +
                                "   - **Calentamiento (5 minutos):** 3 minutos de caminata rápida en el lugar, 2 minutos de círculos de cadera y rotaciones de hombros.\n" +
                                "   - **Cardio (25 minutos):** Caminata rápida en pendiente (si es posible) o elíptica a ritmo moderado. Mantén una intensidad que te desafíe ligeramente.\n" +
                                "   - **Fuerza (10 minutos):** Realiza 3 series por ejercicio, con 30-45 segundos de descanso entre series.\n" +
                                "     1.  **Jumping Jacks:** 3 series de 30 repeticiones. Mantén un ritmo constante.\n" +
                                "     2.  **Sentadillas con peso corporal:** 3 series de 15 repeticiones. Concéntrate en la profundidad.\n" +
                                "     3.  **Elevaciones de piernas acostada (Leg Raises):** 3 series de 15 repeticiones. Mantén la espalda baja pegada al suelo.\n" +
                                "     4.  **Plancha (Plank):** 3 series de 25 segundos. Contrae el abdomen y los glúteos.\n" +
                                "   - **Estiramiento (5 minutos):** Estiramientos suaves de piernas, glúteos y abdominales. Mantén cada estiramiento por 20 segundos."
                });
            } else { // Mujeres adultas (18+ años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria para Mujeres Adultas (45 min - Repetir 5 días a la semana)**\n" +
                                "   - **Calentamiento (5 minutos):** 3 minutos de elíptica o trote ligero, 2 minutos de movilidad de cadera (activaciones de glúteos, balanceos de pierna).\n" +
                                "   - **Cardio (25 minutos):** **Cardio moderado continuo:** Elíptica, bicicleta estática o trote a un ritmo que te permita hablar con frases cortas. Mantén un ritmo constante.\n" +
                                "   - **Fuerza (10 minutos):** Realiza 3 series por ejercicio, con 30-45 segundos de descanso entre series. Enfócate en el movimiento y la activación muscular.\n" +
                                "     1.  **Zancadas con peso (mancuernas ligeras) o peso corporal:** 3 series de 12 repeticiones por pierna. Controla el descenso.\n" +
                                "     2.  **Mountain Climbers:** 3 series de 30-45 segundos. Rápido y controlado.\n" +
                                "     3.  **Abdominales bicicleta (Bicycle Crunches):** 3 series de 20-30 repeticiones (total). Gira el tronco hacia la rodilla opuesta.\n" +
                                "     4.  **Plancha con elevación de piernas alterna:** 3 series de 20 segundos por lado. Levanta una pierna a la vez.\n" +
                                "   - **Estiramiento (5 minutos):** Estiramientos estáticos profundos de isquiotibiales, glúteos, cuádriceps y abdomen. Cada estiramiento por 20-30 segundos."
                });
            }
        }
    }
}

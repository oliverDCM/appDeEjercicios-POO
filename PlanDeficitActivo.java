package proyectoFinal;

public class PlanDeficitActivo extends PlanEjercicio {
    public PlanDeficitActivo(Usuario usuario) {
        super("Activo", "Déficit Calórico",usuario);
    }

    @Override
    protected void generarPlan() {
        this.setDiasPorSemana(6);
        this.setDuracionSesion(50);
        if (datos.getGenero().equals("M")) { // Para hombres
            if (datos.getEdad() >= 11 && datos.getEdad() < 18) { // Hombres adolescentes (11-17 años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria para Hombres Adolescentes (50 min - Repetir 6 días a la semana)**\n" +
                                "   - **Calentamiento (5 minutos):** 3 minutos de trote suave en el lugar, 2 minutos de movimientos articulares dinámicos (círculos de brazos, rotaciones de tronco).\n" +
                                "   - **Cardio (20 minutos):** Correr a un ritmo moderado que te permita hablar, pero con cierta dificultad. Puedes variar entre correr al aire libre o en cinta.\n" +
                                "   - **Fuerza (20 minutos):** Realiza los siguientes ejercicios en circuito, con 3 series y 15-30 segundos de descanso entre ejercicios, y 60 segundos entre rondas. Enfócate en la técnica.\n" +
                                "     1.  **Sentadillas con peso corporal:** 3 series de 15 repeticiones.\n" +
                                "     2.  **Flexiones (Push-ups) de rodillas o inclinadas:** 3 series de 10 repeticiones.\n" +
                                "     3.  **Saltos con cuerda:** 3 series de 60 segundos.\n" +
                                "     4.  **Plancha (Plank):** 3 series de 30 segundos.\n" +
                                "     5.  **Zancadas:** 3 series de 10 repeticiones por pierna (alternando).\n" +
                                "   - **Estiramiento (5 minutos):** Estiramientos estáticos suaves de los principales grupos musculares: isquiotibiales, cuádriceps, pecho, espalda y hombros. Mantén cada estiramiento por 20-30 segundos."
                });
            } else { // Hombres adultos (18+ años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria para Hombres Adultos (50 min - Repetir 6 días a la semana)**\n" +
                                "   - **Calentamiento (5 minutos):** 3 minutos de cardio moderado (elíptica, bicicleta) y 2 minutos de movilidad dinámica (rotaciones de hombros y caderas, estiramientos de gato-camello).\n" +
                                "   - **Cardio (20 minutos):** **Correr intervalos:** Alterna 1 minuto a ritmo rápido/intenso con 2 minutos a ritmo moderado/recuperación. Repite 6-7 veces.\n" +
                                "   - **Fuerza (20 minutos):** Realiza los siguientes ejercicios en circuito, con 3-4 series, descansando 30-45 segundos entre ejercicios y 60-90 segundos entre rondas. Enfócate en la explosividad y un buen ritmo para quemar calorías.\n" +
                                "     1.  **Flexiones explosivas (Push-ups):** 4 series de 10-12 repeticiones.\n" +
                                "     2.  **Saltos al cajón (Box Jumps) en banco o escalón:** 3 series de 12 repeticiones.\n" +
                                "     3.  **Burpees (completos o modificados):** 3 series de 10-15 repeticiones.\n" +
                                "     4.  **Russian Twists con peso (mancuerna o balón medicinal):** 3 series de 20-25 repeticiones (total).\n" +
                                "     5.  **Plancha lateral (Side Plank):** 3 series de 30 segundos por lado.\n" +
                                "   - **Estiramiento (5 minutos):** Estiramientos estáticos profundos de los principales grupos musculares. Cada estiramiento por 20-30 segundos, enfocándose en relajar los músculos."
                });
            }

        } else if (datos.getGenero().equals("F")) { // Para mujeres
            if (datos.getEdad() >= 11 && datos.getEdad() < 18) { // Mujeres adolescentes (11-17 años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria para Mujeres Adolescentes (50 min - Repetir 6 días a la semana)**\n" +
                                "   - **Calentamiento (5 minutos):** 3 minutos de caminata rápida en el lugar o baile suave, 2 minutos de círculos de cadera y balanceos de piernas.\n" +
                                "   - **Cardio (25 minutos):** Caminata rápida o trote suave al aire libre/en cinta. Mantén un ritmo que eleve tu frecuencia cardíaca pero te permita respirar cómodamente.\n" +
                                "   - **Fuerza (15 minutos):** Realiza los siguientes ejercicios en circuito, con 3 series, descansando 15-30 segundos entre ejercicios y 45-60 segundos entre rondas. Concéntrate en el movimiento continuo.\n" +
                                "     1.  **Jumping Jacks:** 3 series de 30 repeticiones.\n" +
                                "     2.  **Zancadas (Lunges):** 3 series de 10 repeticiones por pierna (alternando).\n" +
                                "     3.  **Elevaciones de piernas acostada (Leg Raises):** 3 series de 15 repeticiones.\n" +
                                "     4.  **Plancha (Plank):** 3 series de 20 segundos.\n" +
                                "   - **Estiramiento (5 minutos):** Estiramientos suaves y mantenidos de piernas, glúteos y espalda baja. Mantén cada estiramiento por 20 segundos."
                });
            } else { // Mujeres adultas (18+ años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria para Mujeres Adultas (50 min - Repetir 6 días a la semana)**\n" +
                                "   - **Calentamiento (5 minutos):** 3 minutos de cardio (caminata rápida, elíptica) y 2 minutos de movilidad (círculos de cadera con banda, rotaciones de tronco).\n" +
                                "   - **Cardio HIIT (25 minutos):** Alterna 1 minuto de alta intensidad (saltos de tijera, mountain climbers, sprints) con 1 minuto de recuperación activa (caminata). Repite 10-12 veces.\n" +
                                "   - **Fuerza (15 minutos):** Realiza los siguientes ejercicios en circuito, con 3 series, descansando 20-30 segundos entre ejercicios y 60 segundos entre rondas. Mantén un ritmo dinámico.\n" +
                                "     1.  **Zancadas con peso corporal o mancuernas ligeras:** 3 series de 12 repeticiones por pierna.\n" +
                                "     2.  **Mountain Climbers:** 3 series de 30-45 segundos.\n" +
                                "     3.  **Abdominales de bicicleta (Bicycle Crunches):** 3 series de 20-30 repeticiones (total).\n" +
                                "     4.  **Plancha con toque de hombros (Shoulder Tap Plank):** 3 series de 15-20 repeticiones (total).\n" +
                                "     5.  **Saltos en tijera (Scissor Jumps):** 3 series de 30 segundos.\n" +
                                "   - **Estiramiento (5 minutos):** Estiramientos estáticos, enfocados en isquiotibiales, glúteos, cuádriceps, y abdomen. Mantén cada estiramiento por 20-30 segundos."
                });
                }
        }
    }
}

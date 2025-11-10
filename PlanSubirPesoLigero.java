package proyectoFinal;

public class PlanSubirPesoLigero extends PlanEjercicio {
    public PlanSubirPesoLigero(Usuario usuario) {
        super("Ligero", "Subir Peso",usuario);
    }

    @Override
    protected void generarPlan() {
        this.setDiasPorSemana(4);
        this.setDuracionSesion(45);
        if (datos.getGenero().equals("M")) { // Para hombres
            if (datos.getEdad() >= 10 && datos.getEdad() < 18) { // Hombres adolescentes (10-17 años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria para Hombres Adolescentes (45 min - Repetir 4 días a la semana)**\n" +
                                "   - **Calentamiento (5 minutos):** 3 minutos de cardio ligero (trote en el lugar, saltos de tijera) y 2 minutos de movilidad dinámica (círculos de brazos, piernas).\n" +
                                "   - **Entrenamiento de Fuerza con Peso Corporal (35 minutos):** Realiza 3 series por ejercicio, enfocándote en la forma correcta. Descanso de 60 segundos entre series.\n" +
                                "     1.  **Sentadillas con peso corporal:** 3 series de 10-12 repeticiones.\n" +
                                "     2.  **Flexiones de rodillas (Knee Push-ups) o inclinadas:** 3 series de 8-10 repeticiones.\n" +
                                "     3.  **Remo invertido (Inverted Row) o Remo con banda de resistencia:** 3 series de 10-12 repeticiones.\n" +
                                "     4.  **Zancadas (Lunges):** 2 series de 8-10 repeticiones por pierna.\n" +
                                "     5.  **Plancha (Plank):** 3 series de 30-45 segundos.\n" +
                                "     6.  **Dominadas asistidas (con salto o banda) o Jalón al pecho con banda:** 2 series de 6-8 repeticiones.\n" +
                                "   - **Estiramiento (5 minutos):** Estiramientos suaves de los principales grupos musculares."
                });
            } else { // Hombres adultos (18+ años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria para Hombres Adultos (45 min - Repetir 4 días a la semana)**\n" +
                                "   - **Calentamiento (5 minutos):** 3 minutos de cardio ligero (elíptica, bicicleta) y 2 minutos de movilidad articular (rotaciones de hombros, cadera).\n" +
                                "   - **Entrenamiento de Fuerza con Peso Corporal / Mancuernas Ligeras (35 minutos):** Realiza 3 series por ejercicio, priorizando la técnica y la activación muscular. Descanso de 60-90 segundos entre series.\n" +
                                "     1.  **Sentadillas (Goblet Squat con mancuerna ligera o peso corporal):** 3 series de 10-15 repeticiones.\n" +
                                "     2.  **Press de Pecho con Mancuernas (Dumbbell Bench Press) o Flexiones:** 3 series de 10-12 repeticiones.\n" +
                                "     3.  **Remo con Mancuernas (Bent-Over Dumbbell Row):** 3 series de 10-12 repeticiones por brazo.\n" +
                                "     4.  **Zancadas (Lunges):** 2 series de 10-12 repeticiones por pierna.\n" +
                                "     5.  **Press de Hombros (Dumbbell Shoulder Press):** 2 series de 12-15 repeticiones.\n" +
                                "     6.  **Plancha (Plank):** 3 series de 45-60 segundos.\n" +
                                "   - **Estiramiento (5 minutos):** Estiramientos estáticos de los músculos trabajados."
                });
            }
        } else if (datos.getGenero().equals("F")) { // Para mujeres
            if (datos.getEdad() >= 10 && datos.getEdad() < 18) { // Mujeres adolescentes (10-17 años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria para Mujeres Adolescentes (45 min - Repetir 4 días a la semana)**\n" +
                                "   - **Calentamiento (5 minutos):** 3 minutos de baile libre o caminata rápida, y 2 minutos de movilidad suave (círculos de cadera, balanceos de piernas).\n" +
                                "   - **Entrenamiento de Fuerza con Peso Corporal Ligero (35 minutos):** Realiza 3 series por ejercicio, prestando atención a la forma. Descanso de 60 segundos entre series.\n" +
                                "     1.  **Sentadillas con peso corporal:** 3 series de 12-15 repeticiones.\n" +
                                "     2.  **Elevación de cadera (Glute Bridge):** 3 series de 15-20 repeticiones.\n" +
                                "     3.  **Flexiones de rodillas (Knee Push-ups) o inclinadas:** 3 series de 8-10 repeticiones.\n" +
                                "     4.  **Patada de glúteo (Donkey Kicks) en el suelo:** 2 series de 12-15 repeticiones por pierna.\n" +
                                "     5.  **Zancadas estáticas (con apoyo):** 2 series de 8-10 repeticiones por pierna.\n" +
                                "     6.  **Plancha (Plank) en rodillas o completa:** 3 series de 30-45 segundos.\n" +
                                "   - **Estiramiento (5 minutos):** Estiramientos suaves para piernas y glúteos."
                });
            } else { // Mujeres adultas (18+ años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria para Mujeres Adultas (45 min - Repetir 4 días a la semana)**\n" +
                                "   - **Calentamiento (5 minutos):** 3 minutos de cardio ligero (bicicleta, elíptica) y 2 minutos de movilidad de cadera (activación de glúteos con banda, rotaciones de cadera).\n" +
                                "   - **Entrenamiento de Fuerza con Peso Corporal / Mancuernas Ligeras (35 minutos):** Realiza 3 series por ejercicio, enfocándote en la conexión mente-músculo. Descanso de 60-90 segundos entre series.\n" +
                                "     1.  **Sentadillas Sumo con Mancuerna (Goblet Sumo Squat):** 3 series de 12-15 repeticiones.\n" +
                                "     2.  **Peso Muerto Rumano (Romanian Deadlift) con mancuernas ligeras:** 3 series de 10-12 repeticiones.\n" +
                                "     3.  **Elevación de Cadera (Glute Bridge) con peso o banda:** 3 series de 12-15 repeticiones.\n" +
                                "     4.  **Press de Pecho con Mancuernas (Dumbbell Bench Press) o Flexiones inclinadas:** 2 series de 10-12 repeticiones.\n" +
                                "     5.  **Remo con Mancuernas (Bent-Over Dumbbell Row):** 2 series de 10-12 repeticiones.\n" +
                                "     6.  **Plancha Lateral (Side Plank):** 3 series de 30-45 segundos por lado.\n" +
                                "   - **Estiramiento (5 minutos):** Estiramientos estáticos para isquiotibiales, glúteos y espalda."
                });}
    }
}}

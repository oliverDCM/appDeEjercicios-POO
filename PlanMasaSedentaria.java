package proyectoFinal;

public class PlanMasaSedentaria extends PlanEjercicio {
    public PlanMasaSedentaria(Usuario usuario) {
        super("Sedentario", "Aumentar Masa Muscular",usuario);
    }
    @Override
    protected void generarPlan() {
        this.setDiasPorSemana(3);
        this.setDuracionSesion(40);
        if (datos.getGenero().equals("M")) { // Para hombres
            if (datos.getEdad() >= 10 && datos.getEdad() < 18) { // Hombres adolescentes (10-17 años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria para Hombres Adolescentes (40 min - Repetir 3 días a la semana)**\n" +
                                "   - **Calentamiento (5 minutos):** Caminata ligera en el lugar, círculos de brazos y piernas, movilidad de tobillos y muñecas.\n" +
                                "   - **Entrenamiento de Fuerza con Peso Corporal (30 minutos):** Realiza 2-3 series por ejercicio, concentrándote en una buena forma y movimientos controlados. Descanso de 60 segundos entre series.\n" +
                                "     1.  **Sentadillas con peso corporal:** 3 series de 10-12 repeticiones.\n" +
                                "     2.  **Flexiones de rodillas (Knee Push-ups):** 3 series de 6-8 repeticiones.\n" +
                                "     3.  **Superman (ejercicio de espalda baja):** 3 series de 10-12 repeticiones.\n" +
                                "     4.  **Zancadas estáticas (sin movimiento de los pies):** 2 series de 8 repeticiones por pierna.\n" +
                                "     5.  **Plancha (Plank):** 2 series de 30-40 segundos.\n" +
                                "   - **Estiramiento (5 minutos):** Estiramientos suaves de los músculos principales trabajados (piernas, pecho, espalda, abdomen)."
                });
            } else { // Hombres adultos (18+ años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria para Hombres Adultos (40 min - Repetir 3 días a la semana)**\n" +
                                "   - **Calentamiento (5 minutos):** Caminata enérgica o marcha en el lugar, rotaciones de hombros, inclinaciones laterales de tronco.\n" +
                                "   - **Entrenamiento de Fuerza con Peso Corporal / Mancuernas Ligeras (30 minutos):** Realiza 2-3 series por ejercicio, enfocándote en la técnica para una base sólida. Descanso de 60-90 segundos entre series.\n" +
                                "     1.  **Sentadillas con apoyo (usando una silla o pared):** 3 series de 12-15 repeticiones.\n" +
                                "     2.  **Flexiones inclinadas (contra una pared o mesa):** 3 series de 10-12 repeticiones.\n" +
                                "     3.  **Remo con Mancuerna ligera (Bent-Over Dumbbell Row):** 2 series de 10-12 repeticiones por brazo (o con banda de resistencia).\n" +
                                "     4.  **Elevación de talones (Calf Raises):** 3 series de 15-20 repeticiones.\n" +
                                "     5.  **Plancha de rodillas (Knee Plank):** 3 series de 30-45 segundos.\n" +
                                "     6.  **Abdominales Crunch:** 2 series de 15-20 repeticiones.\n" +
                                "   - **Estiramiento (5 minutos):** Estiramientos suaves de piernas, espalda y pecho. Mantén cada estiramiento por 20 segundos."
                });
            }
        } else if (datos.getGenero().equals("F")) { // Para mujeres
            if (datos.getEdad() >= 10 && datos.getEdad() < 18) { // Mujeres adolescentes (10-17 años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria para Mujeres Adolescentes (40 min - Repetir 3 días a la semana)**\n" +
                                "   - **Calentamiento (5 minutos):** Baile libre, saltos de tijera suaves, estiramientos dinámicos de brazos y piernas.\n" +
                                "   - **Entrenamiento de Fuerza con Peso Corporal Ligero (30 minutos):** Realiza 2-3 series por ejercicio, prestando atención a la forma. Descanso de 60 segundos entre series.\n" +
                                "     1.  **Sentadillas con peso corporal:** 3 series de 10-12 repeticiones.\n" +
                                "     2.  **Elevación de cadera (Glute Bridge):** 3 series de 12-15 repeticiones.\n" +
                                "     3.  **Flexiones de rodillas (Knee Push-ups):** 2 series de 6-8 repeticiones.\n" +
                                "     4.  **Patada de glúteo (Donkey Kicks) en el suelo:** 2 series de 10-12 repeticiones por pierna.\n" +
                                "     5.  **Plancha (Plank) en rodillas:** 2 series de 30-40 segundos.\n" +
                                "   - **Estiramiento (5 minutos):** Estiramientos suaves de piernas y glúteos. Mantén cada estiramiento por 15-20 segundos."
                });
            } else { // Mujeres adultas (18+ años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria para Mujeres Adultas (40 min - Repetir 3 días a la semana)**\n" +
                                "   - **Calentamiento (5 minutos):** Caminata moderada, círculos de cadera, balanceos de piernas suaves.\n" +
                                "   - **Entrenamiento de Fuerza con Peso Corporal / Mancuernas Ligeras (30 minutos):** Realiza 2-3 series por ejercicio, enfocándote en activar los músculos de forma efectiva. Descanso de 60-90 segundos entre series.\n" +
                                "     1.  **Sentadillas Sumo con peso corporal (o mancuerna ligera):** 3 series de 12-15 repeticiones.\n" +
                                "     2.  **Elevación de Cadera (Glute Bridge):** 3 series de 15-20 repeticiones.\n" +
                                "     3.  **Flexiones inclinadas (contra una pared):** 3 series de 10-12 repeticiones.\n" +
                                "     4.  **Zancadas estáticas (con apoyo si es necesario):** 2 series de 10-12 repeticiones por pierna.\n" +
                                "     5.  **Plancha (Plank) en rodillas:** 3 series de 30-45 segundos.\n" +
                                "     6.  **Abdominales Crunch:** 2 series de 15-20 repeticiones.\n" +
                                "   - **Estiramiento (5 minutos):** Estiramientos suaves de piernas, glúteos y abdomen. Mantén cada estiramiento por 20 segundos."
                });
    }
}}}
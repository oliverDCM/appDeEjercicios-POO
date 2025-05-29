package proyectoFinal;

public class PlanSubirPesoSedentario extends PlanEjercicio {
    public PlanSubirPesoSedentario(Usuario usuario) {
        super("Sedentario", "Subir Peso",usuario);
    }

    @Override
    protected void generarPlan() {
        this.setDiasPorSemana(3);
        this.setDuracionSesion(35);
        if (datos.getGenero().equals("M")) { // Para hombres
            if (datos.getEdad() >= 10 && datos.getEdad() < 18) { // Hombres adolescentes (10-17 años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria para Hombres Adolescentes (35 min - Repetir 3 días a la semana)**\n" +
                                "   - **Calentamiento (5 minutos):** Caminata suave en el lugar, círculos de brazos y piernas, rotación de tobillos y muñecas.\n" +
                                "   - **Entrenamiento de Fuerza con Peso Corporal (25 minutos):** Realiza 2-3 series por ejercicio, con énfasis en la técnica controlada. Descanso de 60 segundos entre series.\n" +
                                "     1.  **Sentadillas con peso corporal:** 3 series de 10-12 repeticiones.\n" +
                                "     2.  **Flexiones de rodillas (Knee Push-ups) o contra la pared:** 3 series de 6-8 repeticiones.\n" +
                                "     3.  **Superman (ejercicio de espalda baja):** 2 series de 10-12 repeticiones.\n" +
                                "     4.  **Zancadas estáticas (con apoyo):** 2 series de 8 repeticiones por pierna.\n" +
                                "     5.  **Plancha (Plank):** 2 series de 20-30 segundos.\n" +
                                "   - **Estiramiento (5 minutos):** Estiramientos suaves de los principales grupos musculares: piernas, brazos, espalda."
                });
            } else { // Hombres adultos (18+ años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria para Hombres Adultos (35 min - Repetir 3 días a la semana)**\n" +
                                "   - **Calentamiento (5 minutos):** Caminata enérgica en el lugar, movilidad articular suave (hombros, cadera), y estiramientos dinámicos ligeros.\n" +
                                "   - **Entrenamiento de Fuerza con Peso Corporal / Mancuernas Ligeras (25 minutos):** Realiza 2-3 series por ejercicio, concentrándote en aprender el movimiento. Descanso de 60-90 segundos entre series.\n" +
                                "     1.  **Sentadillas con apoyo (usando una silla o pared):** 3 series de 10-15 repeticiones.\n" +
                                "     2.  **Flexiones inclinadas (contra una pared o mesa):** 3 series de 8-10 repeticiones.\n" +
                                "     3.  **Remo con Mancuerna ligera (Bent-Over Dumbbell Row) o con banda de resistencia:** 2 series de 10-12 repeticiones por brazo.\n" +
                                "     4.  **Elevación de talones (Calf Raises):** 3 series de 15-20 repeticiones.\n" +
                                "     5.  **Plancha de rodillas (Knee Plank):** 3 series de 30-40 segundos.\n" +
                                "   - **Estiramiento (5 minutos):** Estiramientos suaves de piernas, espalda y pecho. Mantén cada estiramiento por 20 segundos."
                });
            }
        } else if (datos.getGenero().equals("F")) { // Para mujeres
            if (datos.getEdad() >= 10 && datos.getEdad() < 18) { // Mujeres adolescentes (10-17 años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria para Mujeres Adolescentes (35 min - Repetir 3 días a la semana)**\n" +
                                "   - **Calentamiento (5 minutos):** Caminar en el lugar, tocarse las rodillas con las manos alternas, círculos de cadera.\n" +
                                "   - **Entrenamiento de Fuerza con Peso Corporal Ligero (25 minutos):** Realiza 2-3 series por ejercicio, prestando atención a la forma. Descanso de 60 segundos entre series.\n" +
                                "     1.  **Sentadillas con peso corporal:** 3 series de 10-12 repeticiones.\n" +
                                "     2.  **Elevación de cadera (Glute Bridge):** 3 series de 12-15 repeticiones.\n" +
                                "     3.  **Flexiones de rodillas (Knee Push-ups):** 2 series de 6-8 repeticiones.\n" +
                                "     4.  **Patada de glúteo (Donkey Kicks) en el suelo:** 2 series de 10-12 repeticiones por pierna.\n" +
                                "     5.  **Abdominales Crunch:** 2 series de 12-15 repeticiones.\n" +
                                "   - **Estiramiento (5 minutos):** Estiramientos suaves de piernas, glúteos y abdomen. Mantén cada estiramiento por 15-20 segundos."
                });
            } else { // Mujeres adultas (18+ años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria para Mujeres Adultas (35 min - Repetir 3 días a la semana)**\n" +
                                "   - **Calentamiento (5 minutos):** Caminata moderada, círculos de hombros y cadera, estiramientos suaves de cuello.\n" +
                                "   - **Entrenamiento de Fuerza con Peso Corporal / Mancuernas Ligeras (25 minutos):** Realiza 2-3 series por ejercicio, enfocándote en la activación muscular y el control. Descanso de 60-90 segundos entre series.\n" +
                                "     1.  **Sentadillas Sumo con peso corporal (o mancuerna ligera):** 3 series de 12-15 repeticiones.\n" +
                                "     2.  **Elevación de Cadera (Glute Bridge):** 3 series de 15-20 repeticiones.\n" +
                                "     3.  **Flexiones inclinadas (contra una pared):** 3 series de 8-10 repeticiones.\n" +
                                "     4.  **Zancadas estáticas (con apoyo si es necesario):** 2 series de 8-10 repeticiones por pierna.\n" +
                                "     5.  **Plancha (Plank) en rodillas:** 3 series de 30-40 segundos.\n" +
                                "   - **Estiramiento (5 minutos):** Estiramientos suaves de piernas, glúteos y espalda baja. Mantén cada estiramiento por 20 segundos."
                });
            }
        }
    }
}
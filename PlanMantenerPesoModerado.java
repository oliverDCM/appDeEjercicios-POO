package proyectoFinal;

public class PlanMantenerPesoModerado extends PlanEjercicio {
    public PlanMantenerPesoModerado(Usuario usuario) {
        super("Moderado", "Mantener Peso",usuario);
    }

    @Override
    protected void generarPlan() {
        this.setDiasPorSemana(5);
        this.setDuracionSesion(45);
        if (datos.getGenero().equals("M")) { // Para hombres
            if (datos.getEdad() >= 18) { // Hombres adultos (18+ años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria (Repetir 5 días a la semana)**\n" +
                                "   - **Calentamiento (5 min):** Trote suave en el lugar, círculos de brazos y piernas, movilidad de cadera y hombros.\n" +
                                "   - **Cardiovascular (15 min):** Correr a ritmo moderado o ciclismo estático.\n" +
                                "   - **Fuerza (20 min):**\n" +
                                "     - Sentadillas con peso corporal: 3 series de 15 repeticiones.\n" +
                                "     - Flexiones (Push-ups): 3 series al fallo o 10-12 repeticiones.\n" +
                                "     - Zancadas (Lunges): 3 series de 10 repeticiones por pierna.\n" +
                                "     - Plancha (Plank): 3 series de 45-60 segundos.\n" +
                                "     - Remo con mancuernas (o banda de resistencia): 3 series de 12 repeticiones por brazo.\n" +
                                "   - **Estiramiento (5 min):** Estiramientos suaves de los principales grupos musculares trabajados."
                });
            } else if (datos.getEdad() >= 10 && datos.getEdad() < 18) { // Hombres adolescentes (10-17 años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria (Repetir 5 días a la semana)**\n" +
                                "   - **Calentamiento (5 min):** Saltos de tijera, rotación de tobillos y muñecas, trote ligero.\n" +
                                "   - **Cardiovascular (15 min):** Saltos de cuerda (jump rope) o juegos activos (correr, fútbol).\n" +
                                "   - **Fuerza con peso corporal (20 min):**\n" +
                                "     - Sentadillas con peso corporal: 3 series de 12-15 repeticiones.\n" +
                                "     - Flexiones de rodillas (Knee Push-ups): 3 series de 8-10 repeticiones.\n" +
                                "     - Zancadas: 3 series de 8 repeticiones por pierna.\n" +
                                "     - Plancha (Plank): 3 series de 30-45 segundos.\n" +
                                "     - Burpees modificados (sin flexión de pecho): 3 series de 8 repeticiones.\n" +
                                "   - **Estiramiento (5 min):** Estiramientos suaves y mantenidos."
                });
            }
        } else if (datos.getGenero().equals("F")) { // Para mujeres
            if (datos.getEdad() >= 18) { // Mujeres adultas (18+ años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria (Repetir 5 días a la semana)**\n" +
                                "   - **Calentamiento (5 min):** Caminata rápida, círculos de cadera, estiramientos dinámicos ligeros.\n" +
                                "   - **Cardiovascular (15 min):** Elíptica o máquina de remo a ritmo moderado.\n" +
                                "   - **Fuerza (20 min):**\n" +
                                "     - Sentadillas sumo con peso corporal (o mancuerna ligera): 3 series de 15 repeticiones.\n" +
                                "     - Flexiones inclinadas (contra pared o banco): 3 series de 12-15 repeticiones.\n" +
                                "     - Elevación de cadera (Glute Bridge): 3 series de 15-20 repeticiones.\n" +
                                "     - Plancha lateral (Side Plank): 3 series de 30 segundos por lado.\n" +
                                "     - Patada de glúteo (Donkey Kicks) en suelo: 3 series de 15 repeticiones por pierna.\n" +
                                "   - **Estiramiento (5 min):** Estiramientos para piernas, glúteos y core."
                });
            } else if (datos.getEdad() >= 10 && datos.getEdad() < 18) { // Mujeres adolescentes (10-17 años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria (Repetir 5 días a la semana)**\n" +
                                "   - **Calentamiento (5 min):** Bailar, saltos de tijera, movimientos articulares suaves.\n" +
                                "   - **Cardiovascular (15 min):** Bailar, zumba o trotar suave en el parque.\n" +
                                "   - **Fuerza con peso corporal ligero (20 min):**\n" +
                                "     - Sentadillas con peso corporal: 3 series de 12 repeticiones.\n" +
                                "     - Flexiones de rodillas (Knee Push-ups): 3 series de 8 repeticiones.\n" +
                                "     - Zancadas con apoyo (usando una silla): 3 series de 8 repeticiones por pierna.\n" +
                                "     - Plancha (Plank): 3 series de 20-30 segundos.\n" +
                                "     - Abdominales Crunch: 3 series de 12-15 repeticiones.\n" +
                                "   - **Estiramiento (5 min):** Estiramientos generales para mejorar la flexibilidad."
                });
        }
    }
}}
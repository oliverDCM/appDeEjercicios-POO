package proyectoFinal;
public class PlanDeficitSedentario extends PlanEjercicio {
    public PlanDeficitSedentario(Usuario usuario) {
        super("Sedentario", "Déficit Calórico",usuario);
    }

    @Override
    protected void generarPlan() {
        this.setDiasPorSemana(3);
        this.setDuracionSesion(30);
        if (datos.getGenero().equals("M")) { // Para hombres
            if (datos.getEdad() >= 11 && datos.getEdad() < 18) { // Hombres adolescentes (11-17 años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria para Hombres Adolescentes (30 min - Repetir 3 días a la semana)**\n" +
                                "   - **Calentamiento (5 minutos):** 3 minutos de caminata ligera en el lugar, 2 minutos de estiramientos dinámicos suaves (círculos de brazos, movilidad de tobillos).\n" +
                                "   - **Fuerza (20 minutos):** Realiza 2 series por ejercicio, concentrándote en la forma y un movimiento lento y controlado. Descanso de 45-60 segundos entre series.\n" +
                                "     1.  **Sentadillas con peso corporal:** 2 series de 15 repeticiones. Baja la cadera como si fueras a sentarte en una silla.\n" +
                                "     2.  **Flexiones modificadas (manos en la pared o en un banco):** 2 series de 10 repeticiones. Empuja contra la superficie controladamente.\n" +
                                "     3.  **Abdominales básicos (Crunches):** 2 series de 15 repeticiones. Levanta los hombros del suelo usando el abdomen.\n" +
                                "     4.  **Plancha (Plank):** 2 series de 20-25 segundos. Mantén el cuerpo recto y el abdomen contraído.\n" +
                                "   - **Estiramiento (5 minutos):** Estiramientos estáticos suaves para los principales grupos musculares: piernas, pecho, espalda y abdomen. Mantén cada estiramiento por 15-20 segundos."
                });
            } else { // Hombres adultos (18+ años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria para Hombres Adultos (30 min - Repetir 3 días a la semana)**\n" +
                                "   - **Calentamiento (5 minutos):** 3 minutos de caminata ligera o marcha en el lugar, 2 minutos de movilidad articular suave (rotaciones de hombros, cadera).\n" +
                                "   - **Cardio (10 minutos):** Caminata ligera a moderada. Enfócate en mantener un ritmo constante que eleve tu respiración suavemente.\n" +
                                "   - **Fuerza (10 minutos):** Realiza 3 series por ejercicio, enfocándote en la técnica para construir una base. Descanso de 60 segundos entre series.\n" +
                                "     1.  **Flexiones (Push-ups) en el suelo o inclinadas (manos en un banco):** 3 series de 10 repeticiones. Baja el pecho hacia el suelo (o superficie).\n" +
                                "     2.  **Sentadillas con peso corporal (con o sin apoyo de silla):** 3 series de 15 repeticiones. Baja hasta donde te sea cómodo.\n" +
                                "     3.  **Crunches (Abdominales básicos):** 3 series de 20 repeticiones. Contrae el abdomen al subir.\n" +
                                "     4.  **Plancha (Plank):** 2 series de 30 segundos. Mantén una línea recta desde la cabeza hasta los talones.\n" +
                                "   - **Estiramiento (5 minutos):** Estiramientos estáticos de piernas, pecho y abdomen. Mantén cada estiramiento por 20 segundos."
                });
            }
        } else if (datos.getGenero().equals("F")) { // Para mujeres
            if (datos.getEdad() >= 11 && datos.getEdad() < 18) { // Mujeres adolescentes (11-17 años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria para Mujeres Adolescentes (30 min - Repetir 3 días a la semana)**\n" +
                                "   - **Calentamiento (5 minutos):** 3 minutos de caminata suave, 2 minutos de balanceos de piernas y círculos de cadera.\n" +
                                "   - **Fuerza (20 minutos):** Realiza 2 series por ejercicio, prestando atención a la forma. Descanso de 45-60 segundos entre series.\n" +
                                "     1.  **Sentadillas con peso corporal:** 2 series de 15 repeticiones. Concéntrate en la profundidad y la postura.\n" +
                                "     2.  **Jumping Jacks (saltos de tijera) modificados (sin salto si es necesario):** 2 series de 20 repeticiones. Mantén un ritmo cómodo.\n" +
                                "     3.  **Abdominales bicicleta (Bicycle Crunches) lentos y controlados:** 2 series de 15 repeticiones (total). Gira el tronco hacia la rodilla opuesta.\n" +
                                "     4.  **Elevación de cadera (Glute Bridge):** 2 series de 15 repeticiones. Aprieta los glúteos en la parte superior.\n" +
                                "   - **Estiramiento (5 minutos):** Estiramientos suaves de piernas, glúteos y abdominales. Mantén cada estiramiento por 15-20 segundos."
                });
            } else { // Mujeres adultas (18+ años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria para Mujeres Adultas (30 min - Repetir 3 días a la semana)**\n" +
                                "   - **Calentamiento (5 minutos):** 3 minutos de caminata moderada en el lugar, 2 minutos de estiramientos suaves de hombros y cadera.\n" +
                                "   - **Cardio (10 minutos):** Caminata ligera a moderada. Si es posible, camina en una cinta con ligera inclinación o en un espacio amplio.\n" +
                                "   - **Fuerza (10 minutos):** Realiza 2-3 series por ejercicio, enfocándote en la activación muscular. Descanso de 60 segundos entre series.\n" +
                                "     1.  **Zancadas (Lunges) sin peso (con apoyo de silla si es necesario):** 2 series de 10 repeticiones por pierna. Mantén el equilibrio.\n" +
                                "     2.  **Abdominales básicos (Crunches):** 2 series de 20 repeticiones. Contrae el abdomen al subir.\n" +
                                "     3.  **Plancha (Plank):** 2 series de 20-30 segundos. Mantén el cuerpo en línea recta.\n" +
                                "     4.  **Elevación de talones (Calf Raises):** 2 series de 15-20 repeticiones. Eleva los talones con control.\n" +
                                "   - **Estiramiento (5 minutos):** Estiramientos suaves de piernas, glúteos y abdomen. Incluye estiramientos de yoga o movimientos suaves si te sientes cómodo."
                });
            }
        }
    }
}

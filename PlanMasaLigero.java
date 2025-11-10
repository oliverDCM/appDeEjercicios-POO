package proyectoFinal;

public class PlanMasaLigero extends PlanEjercicio {
    public PlanMasaLigero(Usuario usuarioDatos) {
        super("Ligero", "Aumentar Masa Muscular",usuarioDatos);
    }
    @Override
    protected void generarPlan() {
        this.setDiasPorSemana(4);
        this.setDuracionSesion(50);
        if (datos.getGenero().equals("M")) { // Para hombres
            if (datos.getEdad() >= 18) { // Hombres adultos (18+ años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria (50 minutos - Repetir 4 días a la semana)**\n" +
                                "   - **Calentamiento (5 minutos):** 3 minutos de cardio ligero (caminata rápida, trote suave en el lugar) seguido de 2 minutos de estiramientos dinámicos suaves (rotaciones de hombros, caderas, giros de tronco).\n" +
                                "   - **Entrenamiento de Fuerza (40 minutos):** Realiza 2-3 series por ejercicio, concentrándote en aprender la forma correcta. Descansa 60-90 segundos entre series.\n" +
                                "     1.  **Sentadillas (Goblet Squat con mancuerna ligera o peso corporal):** 3 series de 10-15 repeticiones. Concéntrate en la profundidad y mantener la espalda recta.\n" +
                                "     2.  **Flexiones (Push-ups de rodillas o inclinadas contra una pared/banco):** 3 series de 8-12 repeticiones. Baja el pecho lo más que puedas controladamente.\n" +
                                "     3.  **Remo con Mancuernas (Bent-Over Dumbbell Row):** 3 series de 10-12 repeticiones por brazo. Enfócate en apretar los omóplatos al subir.\n" +
                                "     4.  **Press de Hombros (Dumbbell Shoulder Press sentado):** 2 series de 12-15 repeticiones. Empuja las mancuernas por encima de tu cabeza.\n" +
                                "     5.  **Zancadas (Lunges):** 2 series de 10-12 repeticiones por pierna. Mantén el equilibrio y baja la rodilla trasera hacia el suelo.\n" +
                                "     6.  **Plancha (Plank):** 3 series de 30-45 segundos. Mantén el cuerpo en línea recta.\n" +
                                "   - **Estiramiento (5 minutos):** Estiramientos estáticos de los principales grupos musculares: cuádriceps, isquiotibiales, glúteos, pecho, espalda y hombros. Mantén cada estiramiento por 20 segundos."
                });
            } else if (datos.getEdad() >= 10 && datos.getEdad() < 18) { // Hombres adolescentes (10-17 años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria (50 minutos - Repetir 4 días a la semana)**\n" +
                                "   - **Calentamiento (5 minutos):** 3 minutos de saltos de tijera, trotar en el lugar, y 2 minutos de estiramientos dinámicos suaves (círculos de brazos, balanceos de piernas).\n" +
                                "   - **Entrenamiento de Fuerza con Peso Corporal (40 minutos):** Realiza 2-3 series por ejercicio, priorizando la técnica sobre el número de repeticiones. Descansa 60 segundos entre series.\n" +
                                "     1.  **Sentadillas con peso corporal:** 3 series de 12-15 repeticiones. Baja la cadera como si fueras a sentarte en una silla.\n" +
                                "     2.  **Flexiones de rodillas (Knee Push-ups):** 3 series de 8-10 repeticiones. Mantén el cuerpo recto desde las rodillas hasta los hombros.\n" +
                                "     3.  **Superman (ejercicio de espalda):** 3 series de 12-15 repeticiones. Levanta brazos y piernas del suelo simulando volar.\n" +
                                "     4.  **Zancadas (Lunges):** 2 series de 8-10 repeticiones por pierna. Da un paso largo y baja la rodilla trasera.\n" +
                                "     5.  **Plancha (Plank):** 3 series de 30-45 segundos. Aprieta el abdomen y mantén una línea recta.\n" +
                                "     6.  **Saltos de Cajón (Box Jumps) en escalón bajo o banco:** 2 series de 8-10 repeticiones. Sube y baja de forma controlada.\n" +
                                "   - **Estiramiento (5 minutos):** Estiramientos suaves de todo el cuerpo, especialmente la espalda, los isquiotibiales y los hombros. Mantén cada estiramiento por 15-20 segundos."
                });
            }
        } else if (datos.getGenero().equals("F")) { // Para mujeres
            if (datos.getEdad() >= 18) { // Mujeres adultas (18+ años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria (50 minutos - Repetir 4 días a la semana)**\n" +
                                "   - **Calentamiento (5 minutos):** 3 minutos de caminata enérgica o elíptica suave, seguido de 2 minutos de movilidad de cadera (círculos, balanceos de pierna) y estiramientos suaves de pecho.\n" +
                                "   - **Entrenamiento de Fuerza (40 minutos):** Realiza 2-3 series por ejercicio, enfocándote en la conexión mente-músculo. Descansa 60-90 segundos entre series.\n" +
                                "     1.  **Sentadillas Sumo con Mancuerna (Goblet Sumo Squat):** 3 series de 12-15 repeticiones. Pies anchos, puntas hacia afuera, baja el peso entre las piernas.\n" +
                                "     2.  **Elevación de Cadera (Glute Bridge):** 3 series de 15-20 repeticiones. Aprieta los glúteos en la parte superior del movimiento.\n" +
                                "     3.  **Flexiones Inclinadas (contra pared o banco):** 3 series de 10-15 repeticiones. Controla el movimiento al bajar.\n" +
                                "     4.  **Remo con Mancuernas (Bent-Over Dumbbell Row):** 2 series de 10-12 repeticiones. Concéntrate en la parte superior de la espalda.\n" +
                                "     5.  **Zancadas Laterales (Lateral Lunges):** 2 series de 10-12 repeticiones por pierna. Da un paso lateral y baja una pierna.\n" +
                                "     6.  **Plancha Lateral (Side Plank):** 3 series de 30-45 segundos por lado. Mantén el cuerpo recto y apoyado en un antebrazo.\n" +
                                "   - **Estiramiento (5 minutos):** Estiramientos estáticos de los principales grupos musculares: glúteos, isquiotibiales, aductores, pecho y espalda. Mantén cada estiramiento por 20 segundos."
                });
            } else if (datos.getEdad() >= 10 && datos.getEdad() < 18) { // Mujeres adolescentes (10-17 años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria (50 minutos - Repetir 4 días a la semana)**\n" +
                                "   - **Calentamiento (5 minutos):** 3 minutos de caminata rápida en el lugar, elevación de rodillas y talones al glúteo, y 2 minutos de movilidad suave (círculos de cadera, balanceos de brazos).\n" +
                                "   - **Entrenamiento de Fuerza con Peso Corporal Ligero (40 minutos):** Realiza 2-3 series por ejercicio, prestando atención a la forma. Descansa 60 segundos entre series.\n" +
                                "     1.  **Sentadillas con peso corporal:** 3 series de 12-15 repeticiones. Asegúrate de que las rodillas no pasen los pies.\n" +
                                "     2.  **Patada de Glúteo (Donkey Kicks) en el suelo:** 3 series de 12-15 repeticiones por pierna. Aprieta el glúteo al levantar la pierna.\n" +
                                "     3.  **Flexiones de rodillas (Knee Push-ups):** 3 series de 6-8 repeticiones. Baja el cuerpo de forma controlada.\n" +
                                "     4.  **Abdominales Crunch:** 3 series de 15-20 repeticiones. Levanta los hombros del suelo usando el abdomen.\n" +
                                "     5.  **Superman (ejercicio de espalda):** 2 series de 12-15 repeticiones. Levanta brazos y piernas suavemente.\n" +
                                "     6.  **Zancadas Estáticas (con apoyo si es necesario):** 2 series de 8-10 repeticiones por pierna.\n" +
                                "   - **Estiramiento (5 minutos):** Estiramientos suaves de piernas, espalda y abdomen. Mantén cada estiramiento por 15-20 segundos."
                });
        }
    }
}
}
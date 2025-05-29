package proyectoFinal;

public class PlanSubirPesoActivo extends PlanEjercicio {
    public PlanSubirPesoActivo(Usuario usuario) {
        super("Activo", "Subir Peso",usuario);
    }
    @Override
    protected void generarPlan() {
        this.setDiasPorSemana(6);
        this.setDuracionSesion(75);
        if (datos.getGenero().equals("M")) { // Para hombres
            if (datos.getEdad() >= 10 && datos.getEdad() < 18) { // Hombres adolescentes (10-17 años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria para Hombres Adolescentes (75 min - Repetir 6 días a la semana)**\n" +
                                "   - **Calentamiento (10 minutos):** 5 minutos de cardio ligero (trote, saltos de tijera) y 5 minutos de movilidad dinámica y estiramientos suaves (círculos de hombros y caderas, balanceos de piernas, giros de tronco).\n" +
                                "   - **Entrenamiento de Fuerza (60 minutos):** Concéntrate en la técnica y la sobrecarga progresiva gradual. Realiza 3-4 series por ejercicio, descansando 60-90 segundos entre series.\n" +
                                "     1.  **Sentadillas con peso corporal o mancuernas ligeras (Goblet Squat):** 4 series de 10-15 repeticiones.\n" +
                                "     2.  **Flexiones (Push-ups) en el suelo o con elevación:** 4 series de 8-12 repeticiones.\n" +
                                "     3.  **Remo invertido (Inverted Row) o Jalón al pecho con banda de resistencia:** 3 series de 10-15 repeticiones.\n" +
                                "     4.  **Zancadas (Lunges):** 3 series de 10-12 repeticiones por pierna (alternando).\n" +
                                "     5.  **Press de hombros con mancuernas ligeras (Dumbbell Shoulder Press):** 3 series de 10-15 repeticiones.\n" +
                                "     6.  **Peso Muerto Rumano (Romanian Deadlift) con peso corporal o mancuernas ligeras:** 3 series de 12-15 repeticiones.\n" +
                                "     7.  **Plancha (Plank):** 3 series de 45-60 segundos.\n" +
                                "     8.  **Burpees modificados (sin flexión de pecho):** 2 series de 8-10 repeticiones (al final de la sesión).\n" +
                                "   - **Estiramiento y Enfriamiento (5 minutos):** Estiramientos estáticos de los principales grupos musculares. Mantén cada estiramiento por 20-30 segundos."
                });
            } else { // Hombres adultos (18+ años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria para Hombres Adultos (75 min - Repetir 6 días a la semana)**\n" +
                                "   - **Calentamiento (10 minutos):** 5 minutos de cardio moderado (trotar, elíptica) y 5 minutos de movilidad articular dinámica y activación muscular (rotaciones de hombros con poco peso, balanceos de pierna, sentadillas con peso corporal).\n" +
                                "   - **Entrenamiento de Fuerza (60 minutos):** Concéntrate en levantar pesado con buena forma y buscar la **sobrecarga progresiva**. Realiza 3-5 series por ejercicio, descansando 90-120 segundos entre series para movimientos compuestos.\n" +
                                "     1.  **Sentadilla con Barra (Barbell Squat):** 4-5 series de 5-8 repeticiones.\n" +
                                "     2.  **Press de Banca (Barbell Bench Press) o Press de mancuernas:** 4-5 series de 6-10 repeticiones.\n" +
                                "     3.  **Peso Muerto (Deadlift) o Peso Muerto Rumano:** 3-4 series de 5-8 repeticiones.\n" +
                                "     4.  **Remo con Barra (Barbell Row) o Remo con Mancuernas:** 4 series de 8-12 repeticiones.\n" +
                                "     5.  **Press Militar (Overhead Press con barra o mancuernas):** 3-4 series de 8-12 repeticiones.\n" +
                                "     6.  **Dominadas (Pull-ups) o Jalón al Pecho (Lat Pulldowns):** 3 series al fallo o 8-12 repeticiones.\n" +
                                "     7.  **Curl de Bíceps (Barbell/Dumbbell Curl):** 3 series de 8-12 repeticiones.\n" +
                                "     8.  **Extensiones de Tríceps (Overhead Extension o Push-downs):** 3 series de 8-12 repeticiones.\n" +
                                "   - **Estiramiento y Enfriamiento (5 minutos):** Estiramientos estáticos profundos de los principales grupos musculares. Enfócate en aquellos que sientas más tensos."
                });
            }
        } else if (datos.getGenero().equals("F")) { // Para mujeres
            if (datos.getEdad() >= 10 && datos.getEdad() < 18) { // Mujeres adolescentes (10-17 años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria para Mujeres Adolescentes (75 min - Repetir 6 días a la semana)**\n" +
                                "   - **Calentamiento (10 minutos):** 5 minutos de cardio ligero (caminata rápida, baile libre) y 5 minutos de movilidad articular (círculos de cadera, balanceos de piernas, rotaciones de hombros).\n" +
                                "   - **Entrenamiento de Fuerza con Peso Corporal y Ligera Carga (60 minutos):** Concéntrate en la forma y la activación muscular. Realiza 3-4 series por ejercicio, descansando 60-90 segundos entre series.\n" +
                                "     1.  **Sentadilla Sumo con peso corporal o ligera mancuerna:** 4 series de 12-15 repeticiones.\n" +
                                "     2.  **Elevación de Cadera (Glute Bridge) con banda de resistencia o peso ligero:** 4 series de 15-20 repeticiones.\n" +
                                "     3.  **Flexiones de rodillas (Knee Push-ups) o inclinadas:** 3 series de 10-15 repeticiones.\n" +
                                "     4.  **Zancadas (Lunges):** 3 series de 10-12 repeticiones por pierna.\n" +
                                "     5.  **Remo con banda de resistencia o mancuernas ligeras:** 3 series de 12-15 repeticiones.\n" +
                                "     6.  **Patada de Glúteo (Donkey Kicks) con o sin banda de resistencia:** 3 series de 15-20 repeticiones por pierna.\n" +
                                "     7.  **Plancha Lateral (Side Plank):** 3 series de 45-60 segundos por lado.\n" +
                                "     8.  **Abdominales de bicicleta (Bicycle Crunches):** 2 series de 20-30 repeticiones (total).\n" +
                                "   - **Estiramiento y Enfriamiento (5 minutos):** Estiramientos estáticos de glúteos, isquiotibiales, cuádriceps, espalda y hombros."
                });
            } else { // Mujeres adultas (18+ años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria para Mujeres Adultas (75 min - Repetir 6 días a la semana)**\n" +
                                "   - **Calentamiento (10 minutos):** 5 minutos de cardio (elíptica, bicicleta) y 5 minutos de movilidad específica para sentadillas y peso muerto (ej. estiramientos de cadera con banda, activaciones de glúteos).\n" +
                                "   - **Entrenamiento de Fuerza (60 minutos):** Enfócate en levantar pesado con buena forma y buscar la **sobrecarga progresiva**. Realiza 3-5 series por ejercicio, descansando 90-120 segundos entre series para movimientos compuestos.\n" +
                                "     1.  **Sentadilla con Barra (Barbell Squat) o Sentadilla Búlgara con mancuernas:** 4-5 series de 8-12 repeticiones.\n" +
                                "     2.  **Peso Muerto Rumano (Romanian Deadlift) con barra o mancuernas:** 4-5 series de 10-15 repeticiones.\n" +
                                "     3.  **Hip Thrust con Barra (Barbell Hip Thrust) o Elevación de Cadera con peso:** 4 series de 10-15 repeticiones.\n" +
                                "     4.  **Press de Pecho (Dumbbell Bench Press) o Push-ups:** 3 series de 10-15 repeticiones.\n" +
                                "     5.  **Remo con Mancuernas (Bent-Over Dumbbell Row):** 3 series de 10-15 repeticiones por brazo.\n" +
                                "     6.  **Press de Hombros (Dumbbell Shoulder Press):** 3 series de 10-15 repeticiones.\n" +
                                "     7.  **Patada de Glúteo en cable o con banda (Cable Kickbacks/Banded Kickbacks):** 3 series de 12-18 repeticiones por pierna.\n" +
                                "     8.  **Abdominales (Ej. Russian Twists con peso, Leg Raises):** 3 series de 15-20 repeticiones.\n" +
                                "   - **Estiramiento y Enfriamiento (5 minutos):** Estiramientos estáticos profundos, priorizando glúteos, isquiotibiales, cuádriceps y espalda baja."
                });
        }
    }
}}
package proyectoFinal;

public class PlanSubirPesoModerado extends PlanEjercicio {
    public PlanSubirPesoModerado(Usuario usuario) {
        super("Moderado", "Subir Peso",usuario);
    }
    @Override
    protected void generarPlan() {
        this.setDiasPorSemana(5);
        this.setDuracionSesion(60);
        if (datos.getGenero().equals("M")) { // Para hombres
            if (datos.getEdad() >= 10 && datos.getEdad() < 18) { // Hombres adolescentes (10-17 años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria para Hombres Adolescentes (60 min - Repetir 5 días a la semana)**\n" +
                                "   - **Calentamiento (5 minutos):** 3 minutos de cardio ligero (trote en el lugar, saltos de tijera) y 2 minutos de movilidad dinámica (círculos de brazos y piernas, giros de tronco).\n" +
                                "   - **Entrenamiento de Fuerza (50 minutos):** Realiza 3-4 series por ejercicio, enfocándote en la técnica y la sobrecarga progresiva gradual. Descanso de 60-90 segundos entre series.\n" +
                                "     1.  **Sentadillas con peso corporal o mancuernas ligeras (Goblet Squat):** 4 series de 10-15 repeticiones.\n" +
                                "     2.  **Flexiones (Push-ups) en el suelo o elevadas (manos en banco):** 3 series de 10-15 repeticiones.\n" +
                                "     3.  **Remo invertido (Inverted Row) o Jalón al pecho con banda de resistencia:** 3 series de 10-15 repeticiones.\n" +
                                "     4.  **Zancadas (Lunges):** 3 series de 10-12 repeticiones por pierna (alternando).\n" +
                                "     5.  **Press de hombros con mancuernas ligeras (Dumbbell Shoulder Press):** 3 series de 10-15 repeticiones.\n" +
                                "     6.  **Plancha (Plank):** 3 series de 45-60 segundos.\n" +
                                "     7.  **Dominadas asistidas (con banda) o Jalón al pecho (Lat Pulldowns si hay máquina):** 3 series de 8-12 repeticiones.\n" +
                                "   - **Estiramiento (5 minutos):** Estiramientos estáticos de los principales grupos musculares (piernas, pecho, espalda, hombros, brazos)."
                });
            } else { // Hombres adultos (18+ años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria para Hombres Adultos (60 min - Repetir 5 días a la semana)**\n" +
                                "   - **Calentamiento (5 minutos):** 3 minutos de cardio moderado (elíptica, bicicleta) y 2 minutos de movilidad dinámica y activación muscular (rotaciones de hombros con poco peso, balanceos de pierna, sentadillas con peso corporal).\n" +
                                "   - **Entrenamiento de Fuerza (50 minutos):** Concéntrate en levantar con pesos desafiantes y buscar la **sobrecarga progresiva**. Realiza 3-4 series por ejercicio, descansando 60-90 segundos entre series.\n" +
                                "     1.  **Sentadilla con barra (Barbell Squat) o Sentadilla Goblet pesada:** 4 series de 8-12 repeticiones.\n" +
                                "     2.  **Press de Banca (Barbell Bench Press) o Press de mancuernas:** 4 series de 8-12 repeticiones.\n" +
                                "     3.  **Peso Muerto Rumano (Romanian Deadlift) con barra o mancuernas:** 3 series de 10-15 repeticiones.\n" +
                                "     4.  **Remo con barra (Barbell Row) o Remo con mancuernas:** 3 series de 8-12 repeticiones.\n" +
                                "     5.  **Press Militar (Overhead Press con barra o mancuernas):** 3 series de 10-15 repeticiones.\n" +
                                "     6.  **Dominadas (Pull-ups) o Jalón al pecho:** 3 series al fallo o 8-12 repeticiones.\n" +
                                "     7.  **Curl de bíceps (Barbell/Dumbbell Curl) o Extensión de tríceps (Overhead Extension):** 3 series de 10-15 repeticiones.\n" +
                                "   - **Estiramiento (5 minutos):** Estiramientos estáticos y profundos de los grupos musculares trabajados (piernas, pecho, espalda, hombros, brazos)."
                });
            }
        } else if (datos.getGenero().equals("F")) { // Para mujeres
            if (datos.getEdad() >= 10 && datos.getEdad() < 18) { // Mujeres adolescentes (10-17 años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria para Mujeres Adolescentes (60 min - Repetir 5 días a la semana)**\n" +
                                "   - **Calentamiento (5 minutos):** 3 minutos de baile libre o saltos de tijera y 2 minutos de movilidad articular (círculos de cadera, balanceos de piernas).\n" +
                                "   - **Entrenamiento de Fuerza con Peso Corporal y Ligera Carga (50 minutos):** Realiza 3-4 series por ejercicio, con descansos de 60-90 segundos. Enfócate en la conexión mente-músculo y la técnica.\n" +
                                "     1.  **Sentadillas Sumo con peso corporal o ligera mancuerna:** 4 series de 12-15 repeticiones.\n" +
                                "     2.  **Elevación de Cadera (Glute Bridge) con banda de resistencia o peso ligero:** 4 series de 15-20 repeticiones.\n" +
                                "     3.  **Flexiones de rodillas (Knee Push-ups) o inclinadas:** 3 series de 10-15 repeticiones.\n" +
                                "     4.  **Zancadas (Lunges):** 3 series de 10-12 repeticiones por pierna.\n" +
                                "     5.  **Remo con banda de resistencia o mancuernas ligeras:** 3 series de 12-15 repeticiones.\n" +
                                "     6.  **Plancha (Plank) o Plancha lateral (Side Plank):** 3 series de 45-60 segundos (por lado).\n" +
                                "     7.  **Patada de Glúteo (Donkey Kicks) con banda de resistencia:** 3 series de 15-20 repeticiones por pierna.\n" +
                                "   - **Estiramiento (5 minutos):** Estiramientos estáticos para glúteos, isquiotibiales, cuádriceps y espalda."
                });
            } else { // Mujeres adultas (18+ años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria para Mujeres Adultas (60 min - Repetir 5 días a la semana)**\n" +
                                "   - **Calentamiento (5 minutos):** 3 minutos de cardio (caminata rápida, elíptica) y 2 minutos de movilidad específica (activación de glúteos con bandas, rotaciones de columna).\n" +
                                "   - **Entrenamiento de Fuerza (50 minutos):** Realiza 3-4 series por ejercicio, enfocándote en la **sobrecarga progresiva** y la conexión mente-músculo. Descansa 60-90 segundos entre series.\n" +
                                "     1.  **Sentadilla con Barra (Barbell Squat) o Sentadilla Búlgara con mancuernas:** 4 series de 8-12 repeticiones.\n" +
                                "     2.  **Peso Muerto Rumano (Romanian Deadlift) con barra o mancuernas:** 4 series de 10-15 repeticiones.\n" +
                                "     3.  **Hip Thrust con Barra (Barbell Hip Thrust) o Elevación de Cadera con peso:** 3 series de 10-15 repeticiones.\n" +
                                "     4.  **Press de Pecho (Dumbbell Bench Press) o Push-ups:** 3 series de 10-15 repeticiones.\n" +
                                "     5.  **Remo con Mancuernas (Bent-Over Dumbbell Row):** 3 series de 10-15 repeticiones por brazo.\n" +
                                "     6.  **Press de Hombros (Dumbbell Shoulder Press):** 3 series de 10-15 repeticiones.\n" +
                                "     7.  **Plancha (Plank) con variaciones (con toques de hombro, lateral):** 3 series de 60 segundos (total).\n" +
                                "   - **Estiramiento (5 minutos):** Estiramientos estáticos profundos de glúteos, isquiotibiales, cuádriceps, espalda baja y hombros."
                });
        }
    }
}}
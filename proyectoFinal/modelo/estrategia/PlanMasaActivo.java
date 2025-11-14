package proyectoFinal.modelo.estrategia;

import proyectoFinal.modelo.dominio.Usuario;

public class PlanMasaActivo extends PlanEjercicio {
    public PlanMasaActivo(Usuario usuario) {
        super("Activo", "Aumentar Masa Muscular",usuario);
    }

    @Override
    protected void generarPlan() {
        this.setDiasPorSemana(5);
        this.setDuracionSesion(60);
        if (datos.getGenero().equals("M")) { // Para hombres
            if (datos.getEdad() >= 18) { // Hombres adultos (18+ años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria (60 minutos - Repetir 5 días a la semana)**\n" +
                                "   - **Calentamiento (5 minutos):** 3 minutos de cardio ligero (trotar en el lugar, saltos de tijera) seguido de 2 minutos de movilidad articular dinámica (rotaciones de hombros, caderas, tobillos).\n" +
                                "   - **Entrenamiento de Fuerza (50 minutos):** Realiza cada ejercicio con 3-4 series, enfocándote en la forma y buscando una sobrecarga progresiva (aumentar peso o repeticiones con el tiempo). Descanso de 60-90 segundos entre series.\n" +
                                "     1.  **Press de Banca (Barbell Bench Press o Dumbbell Press):** 4 series de 8-12 repeticiones.\n" +
                                "     2.  **Remo con Barra (Barbell Row) o Remo con Mancuernas:** 4 series de 8-12 repeticiones.\n" +
                                "     3.  **Sentadillas (Barbell Squat o Dumbbell Goblet Squat):** 4 series de 8-12 repeticiones.\n" +
                                "     4.  **Press Militar (Overhead Press con barra o mancuernas):** 3 series de 10-15 repeticiones.\n" +
                                "     5.  **Dominadas (Pull-ups) o Jalón al Pecho (Lat Pulldowns):** 3 series al fallo o 8-12 repeticiones.\n" +
                                "     6.  **Curl de Bíceps (Dumbbell Bicep Curl):** 3 series de 10-15 repeticiones.\n" +
                                "     7.  **Extensiones de Tríceps (Overhead Triceps Extension o Push-downs):** 3 series de 10-15 repeticiones.\n" +
                                "   - **Estiramiento (5 minutos):** Estiramientos estáticos de los principales grupos musculares trabajados (pecho, espalda, hombros, piernas, brazos). Mantén cada estiramiento por 20-30 segundos."
                });
            } else if (datos.getEdad() >= 10 && datos.getEdad() < 18) { // Hombres adolescentes (10-17 años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria (60 minutos - Repetir 5 días a la semana)**\n" +
                                "   - **Calentamiento (5 minutos):** 3 minutos de cardio ligero (saltos de tijera, trotar en el lugar) seguido de 2 minutos de movilidad dinámica (círculos de brazos, piernas, giros de tronco).\n" +
                                "   - **Entrenamiento de Fuerza con Peso Corporal y Ligeras Cargas (50 minutos):** Enfócate en aprender la técnica. 3 series por ejercicio. Descanso de 60 segundos entre series.\n" +
                                "     1.  **Sentadillas con peso corporal o con mancuernas ligeras (Goblet Squat):** 3 series de 12-15 repeticiones.\n" +
                                "     2.  **Flexiones (Push-ups) en el suelo o inclinadas:** 3 series de 10-15 repeticiones (ajusta a tu nivel).\n" +
                                "     3.  **Remo invertido (Inverted Row) o Remo con banda de resistencia:** 3 series de 10-15 repeticiones.\n" +
                                "     4.  **Zancadas (Lunges):** 3 series de 10-12 repeticiones por pierna.\n" +
                                "     5.  **Press de hombros con mancuernas ligeras (Dumbbell Shoulder Press):** 3 series de 10-15 repeticiones.\n" +
                                "     6.  **Plancha (Plank):** 3 series de 45-60 segundos.\n" +
                                "     7.  **Burpees modificados (sin flexión de pecho, solo sentadilla y salto):** 3 series de 8-10 repeticiones.\n" +
                                "   - **Estiramiento (5 minutos):** Estiramientos estáticos de los principales grupos musculares (piernas, espalda, pecho, brazos). Mantén cada estiramiento por 20-30 segundos."
                });
            }
        } else if (datos.getGenero().equals("F")) { // Para mujeres
            if (datos.getEdad() >= 18) { // Mujeres adultas (18+ años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria (60 minutos - Repetir 5 días a la semana)**\n" +
                                "   - **Calentamiento (5 minutos):** 3 minutos de cardio ligero (bicicleta estática, elíptica) seguido de 2 minutos de movilidad articular (círculos de cadera, rotaciones de tronco).\n" +
                                "   - **Entrenamiento de Fuerza (50 minutos):** Realiza cada ejercicio con 3-4 series, enfocándote en la conexión mente-músculo y buscando la progresión. Descanso de 60-90 segundos entre series.\n" +
                                "     1.  **Sentadilla Búlgara (Bulgarian Split Squat) o Sentadilla con Barra/Mancuernas:** 4 series de 8-12 repeticiones por pierna/total.\n" +
                                "     2.  **Peso Muerto Rumano (Romanian Deadlift) con mancuernas o barra:** 4 series de 10-15 repeticiones.\n" +
                                "     3.  **Press de Pecho (Dumbbell Bench Press o Push-ups):** 3 series de 10-15 repeticiones.\n" +
                                "     4.  **Remo con Mancuernas (Bent-Over Dumbbell Row):** 3 series de 10-15 repeticiones por brazo.\n" +
                                "     5.  **Press de Hombros con Mancuernas (Dumbbell Shoulder Press):** 3 series de 10-15 repeticiones.\n" +
                                "     6.  **Elevación de Cadera con Peso (Barbell Glute Bridge o Dumbbell Glute Bridge):** 3 series de 12-18 repeticiones.\n" +
                                "     7.  **Plancha (Plank) con variaciones (lateral, con elevación de pierna):** 3 series de 45-60 segundos.\n" +
                                "   - **Estiramiento (5 minutos):** Estiramientos estáticos enfocados en glúteos, isquiotibiales, cuádriceps, espalda y hombros. Mantén cada estiramiento por 20-30 segundos."
                });
            } else if (datos.getEdad() >= 10 && datos.getEdad() < 18) { // Mujeres adolescentes (10-17 años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria (60 minutos - Repetir 5 días a la semana)**\n" +
                                "   - **Calentamiento (5 minutos):** 3 minutos de cardio ligero (trotar en el lugar, saltos de tijera) seguido de 2 minutos de movilidad articular (círculos de tobillos, rodillas, cadera, hombros).\n" +
                                "   - **Entrenamiento de Fuerza con Peso Corporal y Ligeras Cargas (50 minutos):** Enfócate en la técnica y la constancia. 3 series por ejercicio. Descanso de 60 segundos entre series.\n" +
                                "     1.  **Sentadillas con peso corporal:** 3 series de 12-15 repeticiones.\n" +
                                "     2.  **Flexiones de rodillas (Knee Push-ups) o inclinadas:** 3 series de 8-12 repeticiones.\n" +
                                "     3.  **Elevación de cadera (Glute Bridge):** 3 series de 15-20 repeticiones.\n" +
                                "     4.  **Zancadas estáticas (sin mover los pies):** 3 series de 10-12 repeticiones por pierna.\n" +
                                "     5.  **Remo con banda de resistencia o con botellas de agua:** 3 series de 12-15 repeticiones.\n" +
                                "     6.  **Superman (ejercicio de espalda baja):** 3 series de 12-15 repeticiones.\n" +
                                "     7.  **Abdominales de bicicleta (Bicycle Crunches):** 3 series de 15-20 repeticiones (total).\n" +
                                "   - **Estiramiento (5 minutos):** Estiramientos suaves de todo el cuerpo, especialmente para la cadena posterior (isquiotibiales) y caderas. Mantén cada estiramiento por 20-30 segundos."
                });
    }
}}}
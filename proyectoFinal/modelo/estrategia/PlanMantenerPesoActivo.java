package proyectoFinal.modelo.estrategia;

import proyectoFinal.modelo.dominio.Usuario;

public class PlanMantenerPesoActivo extends PlanEjercicio {
    public PlanMantenerPesoActivo(Usuario usuario) {
        super("Activo", "Mantener Peso",usuario);
    }

    @Override
    protected void generarPlan() {
        this.setDiasPorSemana(6);
        this.setDuracionSesion(60);
        if (datos.getGenero().equals("M")) { // Para hombres
            if (datos.getEdad() >= 11 && datos.getEdad() < 18) { // Hombres adolescentes (11-17 años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria para Hombres Adolescentes (60 min - Repetir 6 días a la semana)**\n" +
                                "   - **Calentamiento (10 minutos):** 5 minutos de trote suave o saltos de tijera, 5 minutos de movilidad dinámica (círculos de brazos, piernas, estiramientos de gato-camello).\n" +
                                "   - **Cardio (25 minutos):** Trote continuo o carrera ligera a un ritmo que te desafíe pero que puedas mantener. Varía el terreno o la inclinación si es posible.\n" +
                                "   - **Fuerza y Agilidad (20 minutos):** Realiza 3-4 series por ejercicio, descansando 45-60 segundos entre series. Mantén un ritmo ágil.\n" +
                                "     1.  **Flexiones (Push-ups) en el suelo o con elevación de pies:** 3 series de 12-15 repeticiones. Busca la máxima profundidad.\n" +
                                "     2.  **Zancadas (Lunges) con salto:** 3 series de 10-12 repeticiones por pierna. Controla el aterrizaje.\n" +
                                "     3.  **Burpees (completos o modificados):** 3 series de 10-12 repeticiones. Concéntrate en la fluidez del movimiento.\n" +
                                "     4.  **Plancha (Plank) con elevación de pierna alterna:** 3 series de 30 segundos por lado. Mantén la estabilidad del tronco.\n" +
                                "   - **Estiramiento y Enfriamiento (5 minutos):** Estiramientos estáticos de los principales grupos musculares: isquiotibiales, cuádriceps, pecho, espalda y hombros. Cada estiramiento por 20-30 segundos."
                });
            } else { // Hombres adultos (18+ años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria para Hombres Adultos (60 min - Repetir 6 días a la semana)**\n" +
                                "   - **Calentamiento (10 minutos):** 5 minutos de cardio moderado (elíptica, remo) y 5 minutos de movilidad específica (rotaciones de hombros con poco peso, sentadillas con peso corporal, swings de cadera).\n" +
                                "   - **Cardio (25 minutos):** **Correr intervalos (HIIT):** Alterna 1 minuto a ritmo máximo (sprint) con 1.5 minutos de recuperación activa (caminata/trote ligero). Repite 8-10 veces.\n" +
                                "   - **Fuerza y Potencia (20 minutos):** Realiza 3-4 series por ejercicio, descansando 60-90 segundos entre series. Enfócate en la explosividad y el control.\n" +
                                "     1.  **Flexiones explosivas (Plyo Push-ups):** 4 series de 12 repeticiones. Intenta levantar las manos del suelo.\n" +
                                "     2.  **Saltos al cajón (Box Jumps) o sobre un banco robusto:** 3 series de 15 repeticiones. Aterriza suave y amortigua.\n" +
                                "     3.  **Russian Twists con peso (pesado):** 4 series de 25-30 repeticiones (total). Gira el torso controladamente y con velocidad.\n" +
                                "     4.  **Plancha con elevación de una pierna y brazo opuesto:** 3 series de 30-45 segundos por lado. Mantén el core estable.\n" +
                                "     5.  **Burpees:** 3 series de 15 repeticiones (si el tiempo lo permite y tienes energía).*\n" +
                                "   - **Estiramiento y Enfriamiento (5 minutos):** Estiramientos estáticos profundos de los principales grupos musculares. Cada estiramiento por 20-30 segundos, promoviendo la recuperación."
                });
            }
        } else if (datos.getGenero().equals("F")) { // Para mujeres
            if (datos.getEdad() >= 11 && datos.getEdad() < 18) { // Mujeres adolescentes (11-17 años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria para Mujeres Adolescentes (60 min - Repetir 6 días a la semana)**\n" +
                                "   - **Calentamiento (10 minutos):** 5 minutos de caminata rápida o trote ligero, 5 minutos de movilidad articular (círculos de cadera, balanceos de piernas, rotaciones de hombros).\n" +
                                "   - **Cardio (25 minutos):** Caminata rápida en pendiente, trote ligero o elíptica a un ritmo constante y desafiante.\n" +
                                "   - **Fuerza y Resistencia (20 minutos):** Realiza 3 series por ejercicio, con 45-60 segundos de descanso entre series. Enfócate en la activación muscular.\n" +
                                "     1.  **Jumping Jacks (saltos de tijera):** 3 series de 30-40 repeticiones. Mantén un ritmo vivo.\n" +
                                "     2.  **Sentadillas con peso corporal o mancuernas ligeras (Goblet Squat):** 3 series de 15 repeticiones. Concéntrate en la profundidad.\n" +
                                "     3.  **Abdominales bicicleta (Bicycle Crunches):** 3 series de 20-25 repeticiones (total). Coordinación y control.\n" +
                                "     4.  **Zancadas (Lunges) con peso corporal:** 3 series de 10-12 repeticiones por pierna. Mantén el equilibrio.\n" +
                                "     5.  **Plancha (Plank) con toque de hombros:** 3 series de 20-25 repeticiones (total). Mantén el core estable.\n" +
                                "   - **Estiramiento (5 minutos):** Estiramientos suaves de piernas, glúteos y abdominales. Mantén cada estiramiento por 20-30 segundos."
                });
            } else { // Mujeres adultas (18+ años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria para Mujeres Adultas (60 min - Repetir 6 días a la semana)**\n" +
                                "   - **Calentamiento (10 minutos):** 5 minutos de cardio (elíptica, bicicleta) y 5 minutos de movilidad específica para tren inferior (activaciones de glúteos con banda, movilidad de cadera) y tren superior.\n" +
                                "   - **Cardio (25 minutos):** **Cardio activo con variaciones:** 15 minutos de elíptica o bicicleta estática a ritmo moderado-alto, seguido de 10 minutos de saltos con cuerda o burpees modificados (sin flexión de pecho).\n" +
                                "   - **Fuerza y Tono (20 minutos):** Realiza 3-4 series por ejercicio, descansando 45-60 segundos entre series. Enfócate en la conexión mente-músculo y el control.\n" +
                                "     1.  **Zancadas con peso (mancuernas) o Zancadas inversas:** 3 series de 12-15 repeticiones por pierna. Controla el movimiento.\n" +
                                "     2.  **Plancha lateral (Side Plank):** 2 series de 30-40 segundos por lado. Activa los oblicuos.\n" +
                                "     3.  **Mountain Climbers:** 3 series de 25-30 segundos (ritmo rápido). Lleva las rodillas al pecho con intensidad.\n" +
                                "     4.  **Abdominales cruzados (Cross-body Crunches) o Russian Twists con peso:** 3 series de 20-25 repeticiones (total). Trabaja los oblicuos.\n" +
                                "     5.  **Sentadilla Búlgara (con o sin mancuernas):** 3 series de 10-12 repeticiones por pierna. (Si tienes tiempo y energía).* \n" +
                                "   - **Estiramiento (5 minutos):** Estiramientos estáticos profundos, priorizando glúteos, isquiotibiales, cuádriceps, espalda baja y abdominales."
                });
            }
        }
    }
}
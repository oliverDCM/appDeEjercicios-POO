package proyectoFinal.modelo.estrategia;

import proyectoFinal.modelo.dominio.Usuario;

public class PlanMantenerPesoLigero extends PlanEjercicio {
    public PlanMantenerPesoLigero(Usuario usuario) {
        super("Ligero", "Mantener Peso",usuario);
    }

    @Override
    protected void generarPlan() {
        this.setDiasPorSemana(4);
        this.setDuracionSesion(40);
        if (datos.getGenero().equals("M")) { // Para hombres
            if (datos.getEdad() >= 11 && datos.getEdad() < 18) { // Hombres adolescentes (11-17 años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria para Hombres Adolescentes (40 min - Repetir 4 días a la semana)**\n" +
                                "   - **Calentamiento (5 minutos):** 3 minutos de trote suave en el lugar, 2 minutos de movimientos articulares dinámicos (círculos de brazos, piernas).\n" +
                                "   - **Cardio (20 minutos):** Trote suave y continuo a un ritmo cómodo. Si es muy exigente, alterna con caminata rápida.\n" +
                                "   - **Fuerza (10 minutos):** Realiza 2 series por ejercicio, con 45-60 segundos de descanso entre series. Enfócate en la técnica.\n" +
                                "     1.  **Flexiones (Push-ups) de rodillas o inclinadas:** 2 series de 10-12 repeticiones. Controla el descenso.\n" +
                                "     2.  **Sentadillas con peso corporal:** 2 series de 15 repeticiones. Baja la cadera como si fueras a sentarte en una silla.\n" +
                                "     3.  **Plancha (Plank):** 2 series de 20-30 segundos. Mantén el cuerpo recto y el abdomen contraído.\n" +
                                "     4.  **Abdominales básicos (Crunches):** 2 series de 15-20 repeticiones. Contrae el abdomen al subir.\n" +
                                "   - **Estiramiento (5 minutos):** Estiramientos suaves de los principales grupos musculares: piernas, pecho, espalda y abdomen. Mantén cada estiramiento por 20 segundos."
                });
            } else { // Hombres adultos (18+ años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria para Hombres Adultos (40 min - Repetir 4 días a la semana)**\n" +
                                "   - **Calentamiento (5 minutos):** 3 minutos de caminata rápida o marcha en el lugar, 2 minutos de movilidad articular suave (rotaciones de hombros, cadera).\n" +
                                "   - **Cardio (25 minutos):** Caminata rápida o trote ligero a un ritmo constante. Busca una intensidad que te permita hablar con frases cortas.\n" +
                                "   - **Fuerza (10 minutos):** Realiza 3 series por ejercicio, con 60 segundos de descanso entre series. Concéntrate en la activación muscular.\n" +
                                "     1.  **Flexiones (Push-ups) en el suelo o inclinadas:** 3 series de 10-12 repeticiones. Baja el pecho hacia el suelo (o superficie).\n" +
                                "     2.  **Sentadillas con peso corporal (o con mancuerna ligera tipo 'Goblet'):** 3 series de 15 repeticiones. Baja hasta donde te sea cómodo.\n" +
                                "     3.  **Russian Twists (sin peso o con objeto ligero):** 3 series de 20-25 repeticiones (total). Gira el torso controladamente.\n" +
                                "     4.  **Plancha (Plank):** 2 series de 30-40 segundos. Mantén una línea recta desde la cabeza hasta los talones.\n" +
                                "   - **Estiramiento (5 minutos):** Estiramientos estáticos de piernas, pecho y abdomen. Mantén cada estiramiento por 20-30 segundos."
                });
            }
        } else if (datos.getGenero().equals("F")) { // Para mujeres
            if (datos.getEdad() >= 11 && datos.getEdad() < 18) { // Mujeres adolescentes (11-17 años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria para Mujeres Adolescentes (40 min - Repetir 4 días a la semana)**\n" +
                                "   - **Calentamiento (5 minutos):** 3 minutos de caminata ligera o baile suave, 2 minutos de círculos de cadera y balanceos de brazos.\n" +
                                "   - **Cardio (20 minutos):** Caminata ligera o trote suave a un ritmo constante que te eleve la respiración.\n" +
                                "   - **Fuerza (10 minutos):** Realiza 2 series por ejercicio, con 45-60 segundos de descanso entre series. Presta atención a la forma.\n" +
                                "     1.  **Jumping Jacks (saltos de tijera):** 2 series de 25-30 repeticiones. Mantén un ritmo cómodo.\n" +
                                "     2.  **Sentadillas con peso corporal:** 2 series de 15 repeticiones. Concéntrate en la profundidad y la postura.\n" +
                                "     3.  **Elevaciones de piernas acostada (Leg Raises):** 2 series de 15-20 repeticiones. Mantén la espalda baja pegada al suelo.\n" +
                                "     4.  **Abdominales básicos (Crunches):** 2 series de 15-20 repeticiones. Contrae el abdomen al subir.\n" +
                                "   - **Estiramiento (5 minutos):** Estiramientos suaves de piernas, glúteos y abdominales. Mantén cada estiramiento por 15-20 segundos."
                });
            } else { // Mujeres adultas (18+ años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria para Mujeres Adultas (40 min - Repetir 4 días a la semana)**\n" +
                                "   - **Calentamiento (5 minutos):** 3 minutos de caminata moderada o elíptica suave, 2 minutos de movilidad de cadera (activaciones de glúteos, aperturas de piernas).\n" +
                                "   - **Cardio (25 minutos):** Caminata rápida o elíptica a un ritmo constante. Intenta mantener tu frecuencia cardíaca elevada de forma cómoda.\n" +
                                "   - **Fuerza (10 minutos):** Realiza 3 series por ejercicio, con 60 segundos de descanso entre series. Enfócate en la conexión mente-músculo.\n" +
                                "     1.  **Zancadas (Lunges) sin peso:** 3 series de 10-12 repeticiones por pierna. Enfócate en el equilibrio y la forma.\n" +
                                "     2.  **Abdominales bicicleta (Bicycle Crunches):** 3 series de 15-20 repeticiones (total). Mueve las piernas como si pedalearas.\n" +
                                "     3.  **Mountain Climbers:** 2 series de 20-30 segundos. Lleva las rodillas al pecho alternadamente.\n" +
                                "     4.  **Plancha (Plank):** 2 series de 25-35 segundos. Mantén el cuerpo en línea recta.\n" +
                                "   - **Estiramiento (5 minutos):** Estiramientos estáticos de isquiotibiales, glúteos y abdominales. Mantén cada estiramiento por 20-30 segundos."
                });
            }
        }
    }
}
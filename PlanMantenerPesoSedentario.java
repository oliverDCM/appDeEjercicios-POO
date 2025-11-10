package proyectoFinal;
public class PlanMantenerPesoSedentario extends PlanEjercicio {
    public PlanMantenerPesoSedentario(Usuario usuario) {
        super("Sedentario", "Mantener Peso",usuario);
    }

    @Override
    protected void generarPlan() {
        this.setDiasPorSemana(3);
        this.setDuracionSesion(30);
        if (datos.getGenero().equals("M")) { // Para hombres
            if (datos.getEdad() >= 18) { // Hombres adultos (18+ años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria (30 minutos - Repetir 3 días a la semana)**\n" +
                                "   - **Calentamiento (5 minutos):** Caminata suave en el lugar, círculos de brazos y piernas, movimientos de cuello y hombros. El objetivo es preparar el cuerpo suavemente.\n" +
                                "   - **Cardiovascular (10 minutos):** Caminata enérgica o marcha en el lugar a paso ligero. Puedes usar escaleras si tienes acceso, subiendo y bajando a un ritmo cómodo. Mantén una respiración ligeramente agitada.\n" +
                                "   - **Fuerza (10 minutos):** Realiza los siguientes ejercicios con movimientos controlados y descansos cortos entre series:\n" +
                                "     1.  **Sentadillas con apoyo (usando una silla o pared):** 2 series de 10-12 repeticiones. Baja hasta donde te sientas cómodo.\n" +
                                "     2.  **Flexiones inclinadas (contra pared o mesa):** 2 series de 8-10 repeticiones. Empuja desde los brazos, manteniendo el cuerpo recto.\n" +
                                "     3.  **Elevación de talones (Calf Raises):** 2 series de 15 repeticiones. Ponte de puntillas y baja lentamente.\n" +
                                "     4.  **Plancha de rodillas (Knee Plank):** 2 series de 20-30 segundos. Apóyate en rodillas y antebrazos, manteniendo la espalda recta.\n" +
                                "   - **Estiramiento (5 minutos):** Estiramientos suaves y mantenidos de piernas (isquiotibiales, cuádriceps) y tronco. Mantén cada estiramiento por 20 segundos, sin rebotes."
                });
            } else if (datos.getEdad() >= 10 && datos.getEdad() < 18) { // Hombres adolescentes (10-17 años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria (30 minutos - Repetir 3 días a la semana)**\n" +
                                "   - **Calentamiento (5 minutos):** Caminata suave, saltos suaves en el lugar, movimientos de brazos como molinos de viento. Preparación ligera del cuerpo.\n" +
                                "   - **Cardiovascular (10 minutos):** Caminata rápida o un juego de 'seguir al líder' que implique caminar, trotar suave o saltar suavemente. Puedes usar un parque o patio si es seguro.\n" +
                                "   - **Fuerza con peso corporal (10 minutos):** Realiza estos ejercicios con buena forma, prestando atención a tus movimientos:\n" +
                                "     1.  **Sentadillas con peso corporal:** 2 series de 10 repeticiones. Intenta bajar hasta que tus muslos estén paralelos al suelo.\n" +
                                "     2.  **Flexiones de rodillas (Knee Push-ups):** 2 series de 6-8 repeticiones. Asegúrate de bajar el pecho hacia el suelo.\n" +
                                "     3.  **Marcha del oso (Bear Crawl):** 2 series de 20 segundos. Gatea hacia adelante y hacia atrás en el suelo.\n" +
                                "     4.  **Plancha (Plank) en rodillas:** 2 series de 20 segundos. Mantén el abdomen apretado.\n" +
                                "   - **Estiramiento (5 minutos):** Estiramientos suaves de todo el cuerpo, especialmente para la espalda, las piernas y los brazos. Mantén cada estiramiento por 15-20 segundos."
                });
            }
        } else if (datos.getGenero().equals("F")) { // Para mujeres
            if (datos.getEdad() >= 18) { // Mujeres adultas (18+ años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria (30 minutos - Repetir 3 días a la semana)**\n" +
                                "   - **Calentamiento (5 minutos):** Caminata lenta, balanceo suave de piernas, rotaciones de hombros y estiramientos suaves de cuello. Prepara tus músculos.\n" +
                                "   - **Cardiovascular (10 minutos):** Caminata a paso moderado en el vecindario o en casa (marcha en el lugar con rodillas altas). Concéntrate en mantener un ritmo constante.\n" +
                                "   - **Fuerza (10 minutos):** Realiza los siguientes ejercicios con movimientos lentos y controlados, con especial atención a la activación muscular:\n" +
                                "     1.  **Sentadillas con apoyo (usando una silla):** 2 series de 10-12 repeticiones. Siéntate y levántate de la silla de forma controlada.\n" +
                                "     2.  **Flexiones inclinadas (contra una pared):** 2 series de 8-10 repeticiones. Empuja desde la pared.\n" +
                                "     3.  **Elevación de cadera (Glute Bridge):** 2 series de 12-15 repeticiones. Levanta la cadera del suelo apretando los glúteos.\n" +
                                "     4.  **Plancha (Plank) en rodillas:** 2 series de 20-30 segundos. Mantén una línea recta desde hombros hasta rodillas.\n" +
                                "   - **Estiramiento (5 minutos):** Estiramientos suaves de piernas, glúteos y espalda baja. Realiza cada estiramiento por 20 segundos, sin forzar."
                });
            } else if (datos.getEdad() >= 10 && datos.getEdad() < 18) { // Mujeres adolescentes (10-17 años)
                this.setEjercicios(new String[]{
                        "**Rutina Diaria (30 minutos - Repetir 3 días a la semana)**\n" +
                                "   - **Calentamiento (5 minutos):** Caminar en el lugar, tocarse las rodillas con las manos alternas, círculos de brazos. Calienta suavemente.\n" +
                                "   - **Cardiovascular (10 minutos):** Caminata enérgica o juegos sencillos como 'atrapar la bandera' o 'pilla-pilla' si hay espacio y compañía. El objetivo es moverse de forma activa.\n" +
                                "   - **Fuerza con peso corporal ligero (10 minutos):** Enfócate en aprender la técnica y sentir los músculos trabajar:\n" +
                                "     1.  **Sentadillas con peso corporal:** 2 series de 10 repeticiones. Bajar como si fueras a sentarte en una silla.\n" +
                                "     2.  **Flexiones inclinadas (contra una pared):** 2 series de 8 repeticiones. Manos en la pared, pies atrás, empuja.\n" +
                                "     3.  **Patada de glúteo (Donkey Kicks) en suelo:** 2 series de 10 repeticiones por pierna. Apóyate en manos y rodillas, levanta una pierna.\n" +
                                "     4.  **Abdominales Crunch:** 2 series de 10-12 repeticiones. Acostada, levanta solo la cabeza y los hombros.\n" +
                                "   - **Estiramiento (5 minutos):** Estiramientos suaves y de cuerpo completo, prestando atención a la parte posterior de las piernas y los hombros. Cada estiramiento de 15-20 segundos."
                });
        }
    }
}}

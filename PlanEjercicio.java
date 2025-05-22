package proyectoFinal;
    public abstract class PlanEjercicio {
        protected String nivel;
        protected String objetivo;
        protected String[] ejercicios;
        protected Integer diasPorSemana;
        protected Integer duracionSesion;
        FrasesMotivacionales generador = new FrasesMotivacionales();
        public PlanEjercicio(String nivel, String objetivo) {
            this.nivel = nivel;
            this.objetivo = objetivo;
            generarPlan();
        }
        protected abstract void generarPlan();
        public void mostrarPlan() {
            System.out.println("\n=== PLAN DE EJERCICIOS ===");
            System.out.println("Nivel: " + nivel);
            System.out.println("Objetivo: " + objetivo);
            System.out.println("Días por semana: " + diasPorSemana);
            System.out.println("Duración por sesión: " + duracionSesion + " minutos");
            System.out.println("Rutina recomendada:");
            for (String ejercicio : ejercicios) {
                System.out.println("- " + ejercicio);
            }
            System.out.println(generador.obtenerFraseAleatoria()+" \uD83D\uDCAA");
        }
    }
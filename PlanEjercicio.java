package proyectoFinal;
    public abstract class PlanEjercicio {
        private String nivel;
        private String objetivo;
        private String[] ejercicios;
        private Integer diasPorSemana;
        private Integer duracionSesion;
        protected Usuario datos;
        public PlanEjercicio(String nivel, String objetivo,Usuario usuarioDatos) {
            this.nivel = nivel;
            this.objetivo = objetivo;
            this.datos = usuarioDatos;
            generarPlan();
        }
        protected abstract void generarPlan();
        public void mostrarPlan() {

            FrasesMotivacionales generador = new FrasesMotivacionales();
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

        public String getNivel() {return nivel;}
        public void setNivel(String nivel) {this.nivel = nivel;}

        public String getObjetivo() {return objetivo;}
        public void setObjetivo(String objetivo) {this.objetivo = objetivo;}

        public String[] getEjercicios() {return ejercicios;}
        public void setEjercicios(String[] ejercicios) {this.ejercicios = ejercicios;}

        public Integer getDiasPorSemana() {return diasPorSemana;}
        public void setDiasPorSemana(Integer diasPorSemana) {this.diasPorSemana = diasPorSemana;}

        public Integer getDuracionSesion() {return duracionSesion;}
        public void setDuracionSesion(Integer duracionSesion) {this.duracionSesion = duracionSesion;}
    }
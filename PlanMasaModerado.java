package proyectoFinal;

public class PlanMasaModerado extends PlanEjercicio {
    public PlanMasaModerado() {
        super("Moderado", "Aumentar Masa Muscular");
    }

    @Override
    protected void generarPlan() {
        this.diasPorSemana = 5;
        this.duracionSesion = 60;
        this.ejercicios = new String[]{
                "Sentadillas hack 5x6",
                "Press Arnold 4x8",
                "Remo con barra T 4x8",
                "Curl martillo 3x12"
        };
    }
}
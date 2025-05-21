package proyectoFinal;

public class PlanDeficitModerado extends PlanEjercicio {
    public PlanDeficitModerado() {
        super("Moderado", "Déficit Calórico");
    }

    @Override
    protected void generarPlan() {
        this.diasPorSemana = 5;
        this.duracionSesion = 45;
        this.ejercicios = new String[]{
                "HIIT básico (20 seg activo/40 seg descanso)",
                "Burpees modificados 3x8",
                "Mountain climbers 3x15",
                "Abdominales isométricos 3x30 seg"
        };
    }
}

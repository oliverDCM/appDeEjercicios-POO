package proyectoFinal;

public class PlanMantenerPesoModerado extends PlanEjercicio {
    public PlanMantenerPesoModerado() {
        super("Moderado", "Mantener Peso");
    }

    @Override
    protected void generarPlan() {
        this.diasPorSemana = 5;
        this.duracionSesion = 45;
        this.ejercicios = new String[]{
                "Natación recreativa 30 min",
                "Peso muerto con kettlebell 4x8",
                "Dominadas asistidas 3x6",
                "Core: Plancha lateral 3x30 seg"
        };
    }
}
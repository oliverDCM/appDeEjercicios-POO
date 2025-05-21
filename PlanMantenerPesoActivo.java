package proyectoFinal;

public class PlanMantenerPesoActivo extends PlanEjercicio {
    public PlanMantenerPesoActivo() {
        super("Activo", "Mantener Peso");
    }

    @Override
    protected void generarPlan() {
        this.diasPorSemana = 6;
        this.duracionSesion = 60;
        this.ejercicios = new String[]{
                "CrossTraining funcional",
                "Clean and press 4x6",
                "Sprints en colina 10x30 seg",
                "Movimientos gimnásticos básicos"
        };
    }
}
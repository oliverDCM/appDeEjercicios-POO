package proyectoFinal;
public class PlanMantenerPesoSedentario extends PlanEjercicio {
    public PlanMantenerPesoSedentario() {
        super("Sedentario", "Mantener Peso");
    }

    @Override
    protected void generarPlan() {
        this.diasPorSemana = 3;
        this.duracionSesion = 30;
        this.ejercicios = new String[]{
                "Yoga en silla 20 min",
                "Puente de glúteos 3x12",
                "Levantamiento de piernas 3x10",
                "Ejercicios de respiración"
        };
    }
}

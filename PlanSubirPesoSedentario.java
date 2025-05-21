package proyectoFinal;

public class PlanSubirPesoSedentario extends PlanEjercicio {
    public PlanSubirPesoSedentario() {
        super("Sedentario", "Subir Peso");
    }

    @Override
    protected void generarPlan() {
        this.diasPorSemana = 3;
        this.duracionSesion = 35;
        this.ejercicios = new String[]{
                "Press de pierna máquina 4x10",
                "Chest press máquina 4x8",
                "Leg curl sentado 3x12",
                "Suplementación hipercalórica controlada"
        };
    }
}
package proyectoFinal;

public class PlanMasaLigero extends PlanEjercicio {
    public PlanMasaLigero() {
        super("Ligero", "Aumentar Masa Muscular");
    }

    @Override
    protected void generarPlan() {
        this.diasPorSemana = 4;
        this.duracionSesion = 50;
        this.ejercicios = new String[]{
                "Peso muerto sumo 4x8",
                "Press inclinado con mancuernas 4x10",
                "Jalón al pecho 4x10",
                "Elevaciones laterales 3x15"
        };
    }
}
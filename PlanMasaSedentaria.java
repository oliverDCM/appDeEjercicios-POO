package proyectoFinal;

public class PlanMasaSedentaria extends PlanEjercicio {
    public PlanMasaSedentaria() {
        super("Sedentario", "Aumentar Masa Muscular");
    }

    @Override
    protected void generarPlan() {
        this.diasPorSemana = 3;
        this.duracionSesion = 40;
        this.ejercicios = new String[]{
                "Press de banca con barra 4x8",
                "Curl de bíceps alterno 3x10",
                "Extensiones de tríceps 3x12",
                "Encogimientos con mancuernas 4x15"
        };
    }
}
package proyectoFinal;
public class PlanMasaActivo extends PlanEjercicio {
    public PlanMasaActivo() {
        super("Activo", "Aumentar Masa Muscular");
    }

    @Override
    protected void generarPlan() {
        this.diasPorSemana = 5;
        this.duracionSesion = 60;
        this.ejercicios = new String[]{
                "Press banca 4x10",
                "Peso muerto 4x8",
                "Dominadas 4xMax",
                "Curl de bíceps 3x12",
                "Descanso activo con cardio ligero"
        };
    }
}
package proyectoFinal;

public class PlanDeficitActivo extends PlanEjercicio {
    public PlanDeficitActivo() {
        super("Activo", "Déficit Calórico");
    }

    @Override
    protected void generarPlan() {
        this.diasPorSemana = 6;
        this.duracionSesion = 50;
        this.ejercicios = new String[]{
                "Correr intervalos (30 min)",
                "Push-ups explosivos 4x10",
                "Box jumps 3x12",
                "Russian twists con peso 3x20"
        };
    }
}

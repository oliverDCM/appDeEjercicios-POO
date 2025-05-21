package proyectoFinal;
public class PlanDeficitSedentario extends PlanEjercicio {
    public PlanDeficitSedentario() {
        super("Sedentario", "Déficit Calórico");
    }

    @Override
    protected void generarPlan() {
        this.diasPorSemana = 3;
        this.duracionSesion = 30;
        this.ejercicios = new String[]{
                "Caminata rápida 15 min",
                "Ejercicios cuerpo peso (sentadillas, flexiones modificadas)",
                "Estiramientos 10 min"
        };
    }
}

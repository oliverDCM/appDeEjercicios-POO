package proyectoFinal;

public class PlanSubirPesoModerado extends PlanEjercicio {
    public PlanSubirPesoModerado() {
        super("Moderado", "Subir Peso");
    }

    @Override
    protected void generarPlan() {
        this.diasPorSemana = 5;
        this.duracionSesion = 60;
        this.ejercicios = new String[]{
                "Sentadillas frontales 5x5",
                "Press militar 4x6",
                "Peso muerto convencional 4x6",
                "Hiperextensiones lumbar 3x12"
        };
    }
}
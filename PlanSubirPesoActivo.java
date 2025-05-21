package proyectoFinal;

public class PlanSubirPesoActivo extends PlanEjercicio {
    public PlanSubirPesoActivo() {
        super("Activo", "Subir Peso");
    }

    @Override
    protected void generarPlan() {
        this.diasPorSemana = 6;
        this.duracionSesion = 75;
        this.ejercicios = new String[]{
                "Sentadillas traseras 5x5",
                "Dominadas lastradas 4x6",
                "Press de banca declinado 4x6",
                "Gemelos en máquina 5x15"
        };
    }
}
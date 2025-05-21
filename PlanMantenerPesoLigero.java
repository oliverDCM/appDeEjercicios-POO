package proyectoFinal;
public class PlanMantenerPesoLigero extends PlanEjercicio {
    public PlanMantenerPesoLigero() {
        super("Ligero", "Mantener Peso");
    }

    @Override
    protected void generarPlan() {
        this.diasPorSemana = 4;
        this.duracionSesion = 40;
        this.ejercicios = new String[]{
                "Caminata rápida 25 min",
                "Sentadillas con peso corporal 3x12",
                "Flexiones inclinadas 3x10",
                "Remo con bandas elásticas 3x15"
        };
    }
}
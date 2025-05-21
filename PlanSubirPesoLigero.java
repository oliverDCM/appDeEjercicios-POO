package proyectoFinal;

public class PlanSubirPesoLigero extends PlanEjercicio {
    public PlanSubirPesoLigero() {
        super("Ligero", "Subir Peso");
    }

    @Override
    protected void generarPlan() {
        this.diasPorSemana = 4;
        this.duracionSesion = 45;
        this.ejercicios = new String[]{
                "Sentadillas con barra vacía 5x5",
                "Press de banca con mancuernas 4x8",
                "Remo con barra 4x10",
                "Batidos proteicos post-entreno"
        };
    }
}

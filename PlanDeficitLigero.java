package proyectoFinal;

public class PlanDeficitLigero extends PlanEjercicio {
    public PlanDeficitLigero() {
        super("Ligero", "Deficit Calorico");
    }

    @Override
    protected void generarPlan() {
        this.diasPorSemana = 4;
        this.duracionSesion = 35;
        this.ejercicios = new String[]{
                "Ciclismo estático 20 min",
                "Flexiones de rodillas 3x8",
                "Zancadas estáticas 3x10",
                "Saltos de cuerda imaginarios 5 min"
        };
}
}

package proyectoFinal;

public class Fits {
    private double peso; // en kg
    private double altura; // en metros
    private String nivelActividad;
    private String objetivo;
    private boolean datosCompletos;

    public static final String[] NIVELES_ACTIVIDAD = {"Sedentario", "Activo", "Deportista"};
    public static final String[] OBJETIVOS = {"Déficit calórico", "Mantener peso", "Aumentar masa muscular", "Subir peso"};
    public Fits() {
        this.datosCompletos = false;
    }
    public Fits(double peso, double altura, String nivelActividad, String objetivo) {}
    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }
    public double getAltura() { return altura; }
    public void setAltura(double altura) { this.altura = altura; }
    public String getNivelActividad() { return nivelActividad; }
    public void setNivelActividad(String nivelActividad) { this.nivelActividad = nivelActividad; }
    public String getObjetivo() { return objetivo; }
    public void setObjetivo(String objetivo) { this.objetivo = objetivo; }
    public boolean isDatosCompletos() { return datosCompletos; }
    public void setDatosCompletos(boolean datosCompletos) { this.datosCompletos = datosCompletos; }
    public Fits getDatosFitness() {
    }
}
package proyectoFinal;

public class Fits {
    private double peso; // en kg
    private double altura; // en metros
    private String nivelActividad;
    private String objetivo;



    private String Aditivos;
    private Integer DiasDeActividad;
    private boolean datosCompletos;
    public Fits() {

    }
    public Fits(double peso, double altura,String nivelActividad, String objetivo, String Aditivos, Integer DiasDeActividad) {
        this.peso = peso;
        this.altura = altura;
        this.datosCompletos = true;
        this.nivelActividad = nivelActividad;
        this.objetivo = objetivo;
        this.Aditivos = Aditivos;
        this.DiasDeActividad = DiasDeActividad;
        this.datosCompletos = false;
    }

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

    public String getAditivos() {return Aditivos;}
    public void setAditivos(String aditivos) {Aditivos = aditivos;}

    public Integer getDiasDeActividad() {return DiasDeActividad;}
    public void setDiasDeActividad(Integer diasDeActividad) {DiasDeActividad = diasDeActividad;}
}

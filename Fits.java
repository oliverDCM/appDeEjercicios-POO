package proyectoFinal;

import java.util.ArrayList;
import java.util.List;

public class Fits {
    private List<Double> historialIMC = new ArrayList<Double>();
    private Double peso; // en kg
    private Double altura; // en metros
    private String nivelActividad;
    private String objetivo;
    private boolean datosCompletos;
    private double imc;

    public Fits() {
        this.datosCompletos = false;
    }
    public Fits(double peso, double altura, String nivelActividad, String objetivo) {
        this.peso = peso;
        this.altura = altura;
        this.nivelActividad = nivelActividad;
        this.objetivo = objetivo;
        calcularIMC();
        this.datosCompletos = true;
    }
    private void calcularIMC() {
        if (altura > 0 ) {
            this.imc = peso / (altura * altura);
            historialIMC.add(this.imc);
        }

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

    public double getImc() { return imc; }
    public void setImc(double imc) { this.imc = imc; }

    public List<Double> getHistorialIMC() {
        return historialIMC;
    }
}

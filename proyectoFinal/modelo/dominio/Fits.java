package proyectoFinal.modelo.dominio;

import java.io.Serializable;

public class Fits implements Serializable {
    private static final long serialVersionUID = 1L;

    private Double peso;
    private Double altura;
    private String nivelActividad;
    private String objetivo;
    private Double imc;
    private boolean datosCompletos;

    public Fits() {
        this.datosCompletos = false;
        this.imc = 0.0;
    }

    public Fits(Double peso, Double altura, String nivelActividad, String objetivo) {
        this.peso = peso;
        this.altura = altura;
        this.nivelActividad = nivelActividad;
        this.objetivo = objetivo;
        this.datosCompletos = true;
        this.calcularImc();
    }

    // Lógica para calcular el IMC
    private void calcularImc() {
        if (peso != null && altura != null && altura > 0) {
            this.imc = peso / (altura * altura);
        } else {
            this.imc = 0.0;
        }
    }

    public Double getPeso() { return peso; }
    public Double getAltura() { return altura; }
    public String getNivelActividad() { return nivelActividad; }
    public String getObjetivo() { return objetivo; }
    public Double getImc() { return imc; }
    public boolean isDatosCompletos() { return datosCompletos; }

    public void setPeso(Double peso) {
        this.peso = peso;
        this.calcularImc();
    }

    public void setAltura(Double altura) {
        this.altura = altura;
        this.calcularImc();
    }

    public void setNivelActividad(String nivelActividad) { this.nivelActividad = nivelActividad; }
    public void setObjetivo(String objetivo) { this.objetivo = objetivo; }
    public void setDatosCompletos(boolean datosCompletos) { this.datosCompletos = datosCompletos; }
}
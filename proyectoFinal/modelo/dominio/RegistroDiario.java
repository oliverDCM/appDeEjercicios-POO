package proyectoFinal.modelo.dominio;

import java.io.Serializable;
import java.time.LocalDate;

public class RegistroDiario implements Serializable {
    private static final long serialVersionUID = 1L;

    private LocalDate fecha;
    private Double pesoRegistrado;
    private boolean completado;
    private Integer minutosEjercicio;
    private Integer caloriasConsumidas; // ✅ Nuevo atributo
    private String notas;

    public RegistroDiario(Double pesoRegistrado, boolean completado, Integer minutosEjercicio, String notas) {
        this.fecha = LocalDate.now();
        this.pesoRegistrado = pesoRegistrado;
        this.completado = completado;
        this.minutosEjercicio = minutosEjercicio;
        this.notas = notas;
        this.caloriasConsumidas = 0; // Valor inicial por defecto
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Double getPesoRegistrado() {
        return pesoRegistrado;
    }

    public Double getPeso() {
        return pesoRegistrado;
    }

    public boolean isCompletado() {
        return completado;
    }

    public boolean isPlanCompletado() {
        return completado;
    }

    public Integer getMinutosEjercicio() {
        return minutosEjercicio;
    }

    public Integer getMinutosEntrenados() {
        return minutosEjercicio;
    }

    public String getNotas() {
        return notas;
    }

    public Integer getCaloriasConsumidas() {
        return caloriasConsumidas;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setPesoRegistrado(Double pesoRegistrado) {
        this.pesoRegistrado = pesoRegistrado;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }

    public void setMinutosEjercicio(Integer minutosEjercicio) {
        this.minutosEjercicio = minutosEjercicio;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public void setCaloriasConsumidas(Integer caloriasConsumidas) {
        this.caloriasConsumidas = caloriasConsumidas;
    }

    @Override
    public String toString() {
        return "Registro del " + fecha +
                " - Peso: " + pesoRegistrado + " kg, Ejercicio: " +
                minutosEjercicio + " min, Calorías: " + caloriasConsumidas +
                ", Completado: " + completado;
    }
}

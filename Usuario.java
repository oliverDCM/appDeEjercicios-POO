package proyectoFinal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Usuario implements Serializable {
    private static final long serialVersionUID = 3L;

    private String correo;
    private String nombre;
    private String genero;
    private Integer edad;
    private String contrasena;
    private Fits datosFitness;

    private List<RegistroDiario> registrosDiarios;

    public Usuario(String correo, String nombre, String genero, int edad, String contrasena) {
        this.correo = correo;
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.contrasena = contrasena;
        this.datosFitness = null;
        this.registrosDiarios = new ArrayList<>();
    }

    public Usuario() {
        this.registrosDiarios = new ArrayList<>();
    }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public Integer getEdad() { return edad; }
    public void setEdad(Integer edad) { this.edad = edad; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public Fits getDatosFitness() { return datosFitness; }
    public void setDatosFitness(Fits datosFitness) { this.datosFitness = datosFitness; }

    public List<RegistroDiario> getRegistrosDiarios() {
        if (registrosDiarios == null) {
            registrosDiarios = new ArrayList<>();
        }
        return registrosDiarios;
    }

    public void agregarRegistroDiario(RegistroDiario registro) {
        if (registro != null) {
            getRegistrosDiarios().add(registro);
        }
    }

    public List<RegistroDiario> getHistorialDiario() {
        return getRegistrosDiarios();
    }
    public Double getUltimoPesoRegistrado() {
        if (registrosDiarios != null && !registrosDiarios.isEmpty()) {
            RegistroDiario ultimo = registrosDiarios.get(registrosDiarios.size() - 1);
            return ultimo.getPeso();
        } else if (datosFitness != null) {
            return datosFitness.getPeso();
        } else {
            return 0.0;
        }
    }
    @Override
    public String toString() {
        return "Usuario{" +
                "correo='" + correo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", genero='" + genero + '\'' +
                ", edad=" + edad +
                ", datosFitness=" + (datosFitness != null ? "presente" : "null") +
                ", registros=" + registrosDiarios.size() +
                '}';
    }
}

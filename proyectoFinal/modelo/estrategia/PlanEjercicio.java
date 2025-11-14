package proyectoFinal.modelo.estrategia;

import proyectoFinal.modelo.dominio.Usuario;

public abstract class PlanEjercicio {
    private String nivel;
    private String objetivo;
    private String[] ejercicios;
    private Integer diasPorSemana;
    private Integer duracionSesion;
    protected Usuario datos;

    public PlanEjercicio(String nivel, String objetivo,Usuario usuarioDatos) {
        this.nivel = nivel;
        this.objetivo = objetivo;
        this.datos = usuarioDatos;
        generarPlan();
    }

    protected abstract void generarPlan(); // Se mantiene abstracta

    public String getNivel() {return nivel;}
    public void setNivel(String nivel) {this.nivel = nivel;}

    public String getObjetivo() {return objetivo;}
    public void setObjetivo(String objetivo) {this.objetivo = objetivo;}

    public String[] getEjercicios() {return ejercicios;}
    public void setEjercicios(String[] ejercicios) {this.ejercicios = ejercicios;}

    public Integer getDiasPorSemana() {return diasPorSemana;}
    public void setDiasPorSemana(Integer diasPorSemana) {this.diasPorSemana = diasPorSemana;}

    public Integer getDuracionSesion() {return duracionSesion;}
    public void setDuracionSesion(Integer duracionSesion) {this.duracionSesion = duracionSesion;}
}
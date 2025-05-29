package proyectoFinal;

public class Usuario {
    private String correo;
    private String nombre;
    private String genero;
    private Integer edad;
    private String contrasena;
    private Fits datosFitness;


    public Usuario(String correo, String nombre, String genero, int edad, String contrasena) {
        this.correo = correo;
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.contrasena = contrasena;
        this.datosFitness = null;
    }

    public Usuario() {}

    @Override
    public String toString() {
        return "Usuario{" +
                "correo='" + correo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", datosFitness=" + (datosFitness != null ? "presente" : "null") +
                '}';
    }

    public void setCorreo(String correo) { this.correo = correo; }
    public String getCorreo() { return correo; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getNombre() { return nombre; }

    public void setGenero(String genero) { this.genero = genero; }
    public String getGenero() { return genero; }

    public void setEdad( Integer edad) { this.edad = edad; }
    public int getEdad() { return edad; }

    public void setContrasena(String contrasena) { this.contrasena = contrasena; }
    public String getContrasena() { return contrasena; }

    public void setDatosFitness(Fits datosFitness) {this.datosFitness = datosFitness;}
    public Fits getDatosFitness() {return datosFitness;}
}
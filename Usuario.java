package proyectoFinal;

public class Usuario {
    protected String correo;
    protected String nombre;
    protected String genero;
    protected Integer edad;
    protected String contraseña;
    public Usuario(String correo, String nombre, String genero, int edad, String contraseña) {
        this.correo = correo;
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.contraseña = contraseña;
    }
    public Usuario() {}
    public String getCorreo() { return correo; }
    public String getNombre() { return nombre; }
    public String getGenero() { return genero; }
    public int getEdad() { return edad; }
    public String getContraseña() { return contraseña; }
    public void setCorreo(String correo) { this.correo = correo; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setGenero(String genero) { this.genero = genero; }
    public void setEdad( Integer edad) { this.edad = edad; }
    public void setContraseña(String contraseña) { this.contraseña = contraseña; }
}
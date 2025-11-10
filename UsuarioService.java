package proyectoFinal;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioService {
    private List<Usuario> usuarios = new ArrayList<>();
    private static final String USUARIOS_FILE = "usuarios.dat";

    public UsuarioService() {
        cargarUsuarios();
    }

    @SuppressWarnings("unchecked")
    private void cargarUsuarios() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(USUARIOS_FILE))) {
            usuarios = (List<Usuario>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo de usuarios no encontrado. Iniciando con lista vacía.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void guardarUsuarios() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USUARIOS_FILE))) {
            oos.writeObject(usuarios);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Usuario iniciarSesion(String correo, String contrasena) {
        for (Usuario u : usuarios) {
            if (u.getCorreo().equalsIgnoreCase(correo) && u.getContrasena().equals(contrasena)) {
                return u;
            }
        }
        return null;
    }

    public void agregarUsuario(Usuario nuevoUsuario) {
        usuarios.add(nuevoUsuario);
        guardarUsuarios();
    }
}
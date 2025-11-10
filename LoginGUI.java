package proyectoFinal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class LoginGUI extends JFrame {
    private AppController controller;

    private JTextField correoField;
    private JPasswordField contrasenaField;
    private JButton loginButton;
    private JButton registerButton;

    public LoginGUI(AppController controller) {
        this.controller = controller;
        setTitle("Inicio de Sesión");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar ventana

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("Correo Electrónico:"));
        correoField = new JTextField();
        panel.add(correoField);

        panel.add(new JLabel("Contraseña:"));
        contrasenaField = new JPasswordField();
        panel.add(contrasenaField);
        loginButton = new JButton("Iniciar Sesión");
        loginButton.addActionListener(new LoginActionListener());
        panel.add(loginButton);

        registerButton = new JButton("Registrarse");
        registerButton.addActionListener(e -> mostrarRegistro()); // Llama al diálogo de registro
        panel.add(registerButton);

        add(panel);
    }

    private class LoginActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String correo = correoField.getText();
            String contrasena = new String(contrasenaField.getPassword());

            controller.autenticarUsuario(correo, contrasena);
        }
    }

    private void mostrarRegistro() {
        String correo = JOptionPane.showInputDialog(this, "Ingrese su nuevo correo:", "Registro", JOptionPane.PLAIN_MESSAGE);
        String nombre = JOptionPane.showInputDialog(this, "Ingrese su nombre:", "Registro", JOptionPane.PLAIN_MESSAGE);

        String[] generos = {"M", "F"};
        String genero = (String) JOptionPane.showInputDialog(this,
                "Seleccione su género:",
                "Registro",
                JOptionPane.PLAIN_MESSAGE,
                null,
                generos,
                "M");

        String edadStr = JOptionPane.showInputDialog(this, "Ingrese su edad:", "Registro", JOptionPane.PLAIN_MESSAGE);
        String contrasena = JOptionPane.showInputDialog(this, "Ingrese su nueva contraseña:", "Registro", JOptionPane.PLAIN_MESSAGE);

        try {
            int edad = Integer.parseInt(edadStr);
            if (correo != null && nombre != null && genero != null && contrasena != null) {
                controller.registrarNuevoUsuario(correo, nombre, genero, edad, contrasena);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "La edad debe ser un número válido.", "Error de Entrada", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public boolean isVisible() {
        return super.isVisible();
    }
}
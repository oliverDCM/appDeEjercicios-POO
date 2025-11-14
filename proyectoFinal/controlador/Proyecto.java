package proyectoFinal.controlador;

import javax.swing.SwingUtilities;

public class Proyecto {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AppController();
        });
    }
}
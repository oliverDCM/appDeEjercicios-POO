package proyectoFinal.vista;

import proyectoFinal.controlador.AppController;

import javax.swing.*;
import java.awt.*;

public class DialogoRegistroDiario extends JDialog {
    private JTextField txtPesoActual = new JTextField(10);
    private JCheckBox chkCompletado = new JCheckBox("Sí, completé mi rutina.");
    private JTextField txtMinutos = new JTextField("0", 5);
    private JTextArea txtNotas = new JTextArea(3, 20);
    private JButton btnGuardar = new JButton("Guardar Registro");

    private AppController controller;

    public DialogoRegistroDiario(JFrame parent, AppController controller, Double pesoInicial) {
        super(parent, "Registro Diario de Progreso", true); // Modal
        this.controller = controller;

        txtPesoActual.setText(String.format("%.2f", pesoInicial));

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JPanel pnlDatos = new JPanel(new GridLayout(4, 2, 5, 5));
        pnlDatos.add(new JLabel("Peso Actual (kg):"));
        pnlDatos.add(txtPesoActual);
        pnlDatos.add(new JLabel("Plan de Hoy Completado:"));
        pnlDatos.add(chkCompletado);
        pnlDatos.add(new JLabel("Minutos Entrenados:"));
        pnlDatos.add(txtMinutos);
        pnlDatos.add(new JLabel("Notas/Sensaciones:"));
        pnlDatos.add(new JScrollPane(txtNotas));

        panel.add(pnlDatos, BorderLayout.CENTER);
        panel.add(btnGuardar, BorderLayout.SOUTH);

        btnGuardar.addActionListener(e -> guardarRegistro());

        setContentPane(panel);
        pack();
        setLocationRelativeTo(parent);
    }

    private void guardarRegistro() {
        try {
            Double nuevoPeso = Double.parseDouble(txtPesoActual.getText().trim());
            Integer minutos = Integer.parseInt(txtMinutos.getText().trim());
            boolean completado = chkCompletado.isSelected();
            String notas = txtNotas.getText().trim();

            if (nuevoPeso <= 0 || minutos < 0) {
                JOptionPane.showMessageDialog(this, "Peso y Minutos deben ser valores positivos.", "Error de Entrada", JOptionPane.ERROR_MESSAGE);
                return;
            }

            controller.registrarDia(nuevoPeso, completado, minutos, notas);

            JOptionPane.showMessageDialog(this, "¡Registro guardado exitosamente!","Éxito", JOptionPane.INFORMATION_MESSAGE);

            dispose();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese números válidos para Peso y Minutos.", "Error de Entrada", JOptionPane.ERROR_MESSAGE);
        }
    }
}
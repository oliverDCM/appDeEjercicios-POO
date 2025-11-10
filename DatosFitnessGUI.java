package proyectoFinal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DatosFitnessGUI extends JFrame {
    private AppController controller;

    private JTextField pesoField;
    private JTextField alturaField;
    private JComboBox<String> nivelCombo;
    private JComboBox<String> objetivoCombo;
    private JButton saveButton;

    public DatosFitnessGUI(AppController controller) {
        this.controller = controller;
        setTitle("Ingrese sus Datos Fitness");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.add(new JLabel("Peso (kg):"));
        pesoField = new JTextField();
        panel.add(pesoField);

        panel.add(new JLabel("Altura (m):"));
        alturaField = new JTextField();
        panel.add(alturaField);

        panel.add(new JLabel("Nivel de Actividad:"));
        String[] niveles = {"Sedentario", "Ligero", "Moderado", "Activo"};
        nivelCombo = new JComboBox<>(niveles);
        panel.add(nivelCombo);

        panel.add(new JLabel("Objetivo:"));
        String[] objetivos = {"Déficit Calórico", "Mantener Peso", "Subir Peso", "Aumentar Masa Muscular"};
        objetivoCombo = new JComboBox<>(objetivos);
        panel.add(objetivoCombo);

        saveButton = new JButton("Guardar y Ver Plan");
        saveButton.addActionListener(new SaveDataListener());
        panel.add(new JLabel(""));
        panel.add(saveButton);

        add(panel);
    }

    private class SaveDataListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Double peso = Double.parseDouble(pesoField.getText());
                Double altura = Double.parseDouble(alturaField.getText());
                String nivel = (String) nivelCombo.getSelectedItem();
                String objetivo = (String) objetivoCombo.getSelectedItem();

                if (peso <= 0 || altura <= 0) {
                    JOptionPane.showMessageDialog(DatosFitnessGUI.this, "Peso y altura deben ser mayores a cero.", "Error de Datos", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                controller.guardarDatosFitness(peso, altura, nivel, objetivo);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(DatosFitnessGUI.this, "Asegúrate de que Peso y Altura sean números válidos.", "Error de Entrada", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @Override
    public boolean isVisible() {
        return super.isVisible();
    }
}
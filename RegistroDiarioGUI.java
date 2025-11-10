package proyectoFinal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistroDiarioGUI extends JFrame {
    private AppController controller;
    private Usuario usuario;

    private JTextField pesoField;
    private JTextField tiempoField;
    private JTextField caloriasField;
    private JCheckBox completadoCheck;
    private JTextArea observacionArea;
    private JButton registrarButton;

    public RegistroDiarioGUI(AppController controller, Usuario usuario) {
        this.controller = controller;
        this.usuario = usuario;

        setTitle("Registro Diario de Progreso - " + usuario.getNombre());
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("Peso actual (kg):"));
        pesoField = new JTextField();
        panel.add(pesoField);

        panel.add(new JLabel("Tiempo entrenado (min):"));
        tiempoField = new JTextField();
        panel.add(tiempoField);

        panel.add(new JLabel("Calorías consumidas:"));
        caloriasField = new JTextField();
        panel.add(caloriasField);

        panel.add(new JLabel("¿Entrenamiento completado?:"));
        completadoCheck = new JCheckBox("Sí");
        panel.add(completadoCheck);

        panel.add(new JLabel("Observaciones:"));
        observacionArea = new JTextArea(3, 20);
        panel.add(new JScrollPane(observacionArea));

        registrarButton = new JButton("Registrar");
        panel.add(new JLabel()); // celda vacía
        panel.add(registrarButton);

        add(panel);

        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Double peso = Double.parseDouble(pesoField.getText());
                    Integer tiempo = Integer.parseInt(tiempoField.getText());
                    Integer calorias = Integer.parseInt(caloriasField.getText());
                    boolean completado = completadoCheck.isSelected();
                    String observacion = observacionArea.getText().trim();

                    RegistroDiario registro = new RegistroDiario(peso, completado, tiempo, observacion);
                    registro.setCaloriasConsumidas(calorias);

                    controller.agregarRegistro(usuario, registro);

                    JOptionPane.showMessageDialog(null,
                            "Registro guardado correctamente.",
                            "Éxito",
                            JOptionPane.INFORMATION_MESSAGE);

                    pesoField.setText("");
                    tiempoField.setText("");
                    caloriasField.setText("");
                    completadoCheck.setSelected(false);
                    observacionArea.setText("");

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null,
                            "Por favor, ingresa valores válidos en los campos numéricos.",
                            "Error de formato",
                            JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,
                            "Error al registrar: " + ex.getMessage(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}

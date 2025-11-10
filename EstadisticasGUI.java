package proyectoFinal;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class EstadisticasGUI extends JFrame {
    private AppController controller;
    private JTextArea txtHistorial = new JTextArea(20, 60);
    private JTextArea txtResumen = new JTextArea(5, 60);
    private JButton btnVolver = new JButton("Cerrar");

    public EstadisticasGUI(AppController controller) {
        this.controller = controller;
        setTitle("Historial de Progreso y Estadísticas");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        txtHistorial.setEditable(false);
        txtResumen.setEditable(false);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JPanel pnlHistorial = new JPanel(new BorderLayout());
        pnlHistorial.add(new JLabel("=== HISTORIAL DE REGISTROS DIARIOS ==="), BorderLayout.NORTH);
        pnlHistorial.add(new JScrollPane(txtHistorial), BorderLayout.CENTER);

        JPanel pnlResumen = new JPanel(new BorderLayout());
        pnlResumen.add(new JLabel("=== RESUMEN DE PROGRESO ==="), BorderLayout.NORTH);
        pnlResumen.add(new JScrollPane(txtResumen), BorderLayout.CENTER);

        panel.add(pnlResumen, BorderLayout.NORTH);
        panel.add(pnlHistorial, BorderLayout.CENTER);
        panel.add(btnVolver, BorderLayout.SOUTH);

        add(panel);
        pack();
        setLocationRelativeTo(null);

        btnVolver.addActionListener(e -> {
            setVisible(false);
        });
    }

    public void cargarDatos(List<RegistroDiario> historial) {
        if (historial == null || historial.isEmpty()) {
            txtHistorial.setText("Aún no tienes registros de progreso. ¡Empieza hoy!");
            txtResumen.setText("--- Sin datos para calcular estadísticas ---");
            return;
        }

        StringBuilder sbHistorial = new StringBuilder();
        sbHistorial.append(String.format("%-10s | %-8s | %-7s | %-11s | %s\n",
                "FECHA", "PESO (kg)", "MINUTOS", "COMPLETADO", "NOTAS"));
        sbHistorial.append("--------------------------------------------------------------------------------\n");

        double pesoInicial = historial.get(0).getPesoRegistrado();
        double pesoFinal = historial.get(historial.size() - 1).getPesoRegistrado();
        int diasCompletados = 0;
        int totalMinutos = 0;

        for (RegistroDiario registro : historial) {
            String notasCortas = registro.getNotas().length() > 20 ? registro.getNotas().substring(0, 17) + "..." : registro.getNotas();

            sbHistorial.append(String.format("%-10s | %-8.2f | %-7d | %-11s | %s\n",
                    registro.getFecha().toString(),
                    registro.getPesoRegistrado(),
                    registro.getMinutosEntrenados(),
                    registro.isPlanCompletado() ? "SI" : "NO",
                    notasCortas
            ));

            if (registro.isPlanCompletado()) {
                diasCompletados++;
            }
            totalMinutos += registro.getMinutosEntrenados();
        }

        txtHistorial.setText(sbHistorial.toString());
        txtHistorial.setCaretPosition(0);

        String progreso;
        double cambioPeso = pesoInicial - pesoFinal;
        if (cambioPeso > 0) {
            progreso = String.format("¡Felicidades! Has perdido %.2f kg.", cambioPeso);
        } else if (cambioPeso < 0) {
            progreso = String.format("Has ganado %.2f kg. Sigue con tu objetivo.", Math.abs(cambioPeso));
        } else {
            progreso = "Tu peso se ha mantenido estable.";
        }

        txtResumen.setText(String.format(
                "Período de %d días registrado.\n" +
                        "Peso Inicial: %.2f kg | Peso Más Reciente: %.2f kg\n" +
                        "Total de Minutos Entrenados: %d\n" +
                        "Días con Plan Completado: %d de %d (%.1f%%)\n\n" +
                        "**Progreso de Peso: %s**",
                historial.size(),
                pesoInicial, pesoFinal,
                totalMinutos,
                diasCompletados, historial.size(), (historial.size() > 0 ? diasCompletados * 100.0 / historial.size() : 0.0),
                progreso
        ));
    }
}
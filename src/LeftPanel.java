import javax.swing.*;
import java.awt.*;

public
    class LeftPanel
    extends JPanel {

    private final JPanel panel;

    public LeftPanel() {
        panel = createLeftPanel();
    }

    public JPanel getPanel() {
        return panel;
    }

    private JPanel createLeftPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> {
            String message = JOptionPane.showInputDialog("Enter message:");
            if (message != null && !message.isEmpty()) {
                createVirtualDevice(message);
            }
        });

        panel.add(addButton, BorderLayout.SOUTH);
        panel.add(new JScrollPane(createDevicePanel()), BorderLayout.CENTER);

        return panel;
    }

    private JPanel createDevicePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        return panel;
    }

    private void createVirtualDevice(String message) {
        JPanel devicePanel = new JPanel();
        devicePanel.setLayout(new GridLayout(4, 1));

        JSlider frequencySlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        JButton stopButton = new JButton("Stop");
        JTextField numberField = new JTextField("Device number");
        JComboBox<String> statusComboBox = new JComboBox<>(new String[]{"WAITING", "ACTIVE"});

        devicePanel.add(frequencySlider);
        devicePanel.add(stopButton);
        devicePanel.add(numberField);
        devicePanel.add(statusComboBox);

        ((JPanel) panel.getComponent(1)).add(devicePanel);
        panel.revalidate();
    }
}

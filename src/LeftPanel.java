import javax.swing.*;
import java.awt.*;

public
    class LeftPanel
    extends JPanel {

    //    public LeftPanel() {
//        panel = createLeftPanel();
//    }
//
//    public JPanel getPanel() {
//        return panel;
//    }
//
//    private JPanel createLeftPanel() {
//        JPanel panel = new JPanel();
//        panel.setLayout(new BorderLayout());
//
//        JButton addButton = new JButton("Add");
//        addButton.addActionListener(e -> {
//            String message = JOptionPane.showInputDialog("Enter message:");
//            if (message != null && !message.isEmpty()) {
//                createVirtualDevice(message);
//            }
//        });
//
//        panel.add(addButton, BorderLayout.SOUTH);
//        panel.add(new JScrollPane(createDevicePanel()), BorderLayout.CENTER);
//
//        return panel;
//    }
//
//    private JPanel createDevicePanel() {
//        JPanel panel = new JPanel();
//        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
//        return panel;
//    }
//
//    private void createVirtualDevice(String message) {
//        JPanel devicePanel = new JPanel();
//        devicePanel.setLayout(new GridLayout(4, 1));
//
//        JSlider frequencySlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
//        JButton stopButton = new JButton("Stop");
//        JTextField numberField = new JTextField("Device number");
//        JComboBox<String> statusComboBox = new JComboBox<>(new String[]{"WAITING", "ACTIVE"});
//
//        devicePanel.add(frequencySlider);
//        devicePanel.add(stopButton);
//        devicePanel.add(numberField);
//        devicePanel.add(statusComboBox);
//
//        ((JPanel) panel.getComponent(1)).add(devicePanel);
//        panel.revalidate();
//    }

    private JPanel panel;

    public LeftPanel() {
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(215, 215));
        panel.setBorder(BorderFactory.createTitledBorder("VBD"));

        JPanel devicesPanel = new JPanel();
        devicesPanel.setLayout(new BoxLayout(devicesPanel, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(devicesPanel);
        panel.add(scrollPane, BorderLayout.CENTER);

        JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> {
            String message = JOptionPane.showInputDialog("Enter a message");
            if (message != null && !message.isEmpty()) {
                addVirtualDevice(devicesPanel, message);
            }
        });
        panel.add(addButton, BorderLayout.SOUTH);
    }

    private void addVirtualDevice(JPanel devicesPanel, String message) {
        JPanel devicePanel = new JPanel();
        devicePanel.setLayout(new GridLayout(4, 1));
        devicePanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        JButton stopButton = new JButton("Stop");
        JTextField numberField = new JTextField("Device Number");
        JComboBox<String> statusComboBox = new JComboBox<>(new String[]{"WAITING", "ACTIVE"});

        devicePanel.add(slider);
        devicePanel.add(stopButton);
        devicePanel.add(numberField);
        devicePanel.add(statusComboBox);

        devicesPanel.add(devicePanel);
        devicesPanel.revalidate();
        devicesPanel.repaint();
    }

    public JPanel getPanel() {
        return panel;
    }
}

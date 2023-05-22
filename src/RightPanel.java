import javax.swing.*;
import java.awt.*;

public
    class RightPanel
    extends JPanel {

    private final JPanel panel;

    public RightPanel() {
        panel = createRightPanel();
    }

    public JPanel getPanel() {
        return panel;
    }

    private JPanel createRightPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> createReceiverDevice());

        panel.add(addButton, BorderLayout.SOUTH);
        panel.add(new JScrollPane(createReceiverPanel()), BorderLayout.CENTER);

        return panel;
    }

    private JPanel createReceiverPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        return panel;
    }

    private void createReceiverDevice() {
        JPanel devicePanel = new JPanel();
        devicePanel.setLayout(new GridLayout(3, 1));

        JButton stopButton = new JButton("Stop");
        JLabel messageCountLabel = new JLabel("Message Count: 0");
        JCheckBox autoClearCheckBox = new JCheckBox("Auto Clear");

        devicePanel.add(stopButton);
        devicePanel.add(messageCountLabel);
        devicePanel.add(autoClearCheckBox);

        ((JPanel) panel.getComponent(1)).add(devicePanel);
        panel.revalidate();
    }

}

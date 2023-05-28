import javax.swing.*;
import java.awt.*;

public
    class RightPanel
    extends JPanel {

    //
//    public RightPanel() {
//        panel = createRightPanel();
//    }
//
//    public JPanel getPanel() {
//        return panel;
//    }
//
//    private JPanel createRightPanel() {
//        JPanel panel = new JPanel();
//        panel.setLayout(new BorderLayout());
//
//        JButton addButton = new JButton("Add");
//        addButton.addActionListener(e -> createReceiverDevice());
//
//        panel.add(addButton, BorderLayout.SOUTH);
//        panel.add(new JScrollPane(createReceiverPanel()), BorderLayout.CENTER);
//
//        return panel;
//    }
//
//    private JPanel createReceiverPanel() {
//        JPanel panel = new JPanel();
//        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
//        return panel;
//    }
//
//    private void createReceiverDevice() {
//        JPanel devicePanel = new JPanel();
//        devicePanel.setLayout(new GridLayout(3, 1));
//
//        JButton stopButton = new JButton("Stop");
//        JLabel messageCountLabel = new JLabel("Message Count: 0");
//        JCheckBox autoClearCheckBox = new JCheckBox("Auto Clear");
//
//        devicePanel.add(stopButton);
//        devicePanel.add(messageCountLabel);
//        devicePanel.add(autoClearCheckBox);
//
//        ((JPanel) panel.getComponent(1)).add(devicePanel);
//        panel.revalidate();
//    }

    private JPanel panel;

    public RightPanel() {
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(215, 215));
        panel.setBorder(BorderFactory.createTitledBorder("VRD"));

        JPanel receiversPanel = new JPanel();
        receiversPanel.setLayout(new BoxLayout(receiversPanel, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(receiversPanel);
        panel.add(scrollPane, BorderLayout.CENTER);

        JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> addReceiver(receiversPanel));
        panel.add(addButton, BorderLayout.SOUTH);
    }

    private void addReceiver(JPanel receiversPanel) {
        JPanel receiverPanel = new JPanel();
        receiverPanel.setLayout(new GridLayout(3, 1));
        receiverPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        JButton stopButton = new JButton("Stop");
        JLabel messageCountLabel = new JLabel("Received Messages: 0");
        JCheckBox autoDeleteCheckbox = new JCheckBox("Auto Delete");

        receiverPanel.add(stopButton);
        receiverPanel.add(messageCountLabel);
        receiverPanel.add(autoDeleteCheckbox);

        receiversPanel.add(receiverPanel);
        receiversPanel.revalidate();
        receiversPanel.repaint();
    }

    public JPanel getPanel() {
        return panel;
    }

}

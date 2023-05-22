import javax.swing.*;
import java.awt.*;

public
    class CenterPanel
    extends JPanel {

    private final JPanel panel;

    public CenterPanel() {
        panel = createCenterPanel();
    }

    public JPanel getPanel() {
        return panel;
    }

    private JPanel createCenterPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel btsPanel = createBTSPanel();
        JPanel bscPanel = createBSCPanel();
        JPanel buttonsPanel = createButtonsPanel();

        panel.add(btsPanel, BorderLayout.WEST);
        panel.add(bscPanel, BorderLayout.EAST);
        panel.add(buttonsPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createBTSPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("BTS"));
        return panel;
    }

    private JPanel createBSCPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("BSC"));
        return panel;
    }

    private JPanel createButtonsPanel() {
        JPanel panel = new JPanel();

        JButton addBTSButton = new JButton("Add BTS");
        addBTSButton.addActionListener(e -> createBTS());

        JButton addBSCButton = new JButton("Add BSC");
        addBSCButton.addActionListener(e -> createBSC());

        JButton removeBSCButton = new JButton("Remove BSC");
        removeBSCButton.addActionListener(e -> removeBSC());

        panel.add(addBTSButton);
        panel.add(addBSCButton);
        panel.add(removeBSCButton);

        return panel;
    }

    private void createBTS() {
        JPanel btsPanel = (JPanel) panel.getComponent(0);

        JPanel stationPanel = new JPanel();
        stationPanel.setLayout(new GridLayout(3, 1));
        stationPanel.add(new JLabel("BTS Number"));
        stationPanel.add(new JLabel("Processed SMS: 0"));
        stationPanel.add(new JLabel("Waiting SMS: 0"));

        btsPanel.add(stationPanel);
        btsPanel.revalidate();
    }

    private void createBSC() {
        JPanel bscPanel = (JPanel) panel.getComponent(1);

        JPanel stationPanel = new JPanel();
        stationPanel.setLayout(new GridLayout(3, 1));
        stationPanel.add(new JLabel("BSC Number"));
        stationPanel.add(new JLabel("Processed SMS: 0"));
        stationPanel.add(new JLabel("Waiting SMS: 0"));

        bscPanel.add(stationPanel);
        bscPanel.revalidate();
    }

    private void removeBSC() {
        JPanel bscPanel = (JPanel) panel.getComponent(1);
        int componentCount = bscPanel.getComponentCount();
        if (componentCount > 0) {
            bscPanel.remove(componentCount - 1);
            bscPanel.revalidate();
            bscPanel.repaint();
        }
    }
}

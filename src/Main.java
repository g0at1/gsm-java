import javax.swing.*;
import java.awt.*;

public
    class Main
    extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }

    public Main() {

        LeftPanel leftPanel = new LeftPanel();
        RightPanel rightPanel = new RightPanel();
        CenterPanel centerPanel = new CenterPanel();

        this.getContentPane().add(leftPanel.getPanel(), BorderLayout.WEST);
        this.getContentPane().add(rightPanel.getPanel(), BorderLayout.EAST);
        this.getContentPane().add(centerPanel.getPanel(), BorderLayout.CENTER);


        this.setSize( 1920, 1080);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
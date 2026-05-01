package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ComponentManageFrame extends JFrame {
    public ComponentManageFrame() {
        setTitle("Component Management");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(new JLabel("Component management page", SwingConstants.CENTER));
    }
}

package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class WarningFrame extends JFrame {
    public WarningFrame() {
        setTitle("Stock Warnings");
        setSize(500, 360);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(new JLabel("Stock warning page", SwingConstants.CENTER));
    }
}

package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class LocationManageFrame extends JFrame {
    public LocationManageFrame() {
        setTitle("Location Management");
        setSize(500, 360);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(new JLabel("Location management page", SwingConstants.CENTER));
    }
}

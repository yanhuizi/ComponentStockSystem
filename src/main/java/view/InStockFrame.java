package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class InStockFrame extends JFrame {
    public InStockFrame() {
        setTitle("In Stock");
        setSize(500, 360);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(new JLabel("In-stock page", SwingConstants.CENTER));
    }
}

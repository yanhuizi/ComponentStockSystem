package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class OutStockFrame extends JFrame {
    public OutStockFrame() {
        setTitle("Out Stock");
        setSize(500, 360);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(new JLabel("Out-stock page", SwingConstants.CENTER));
    }
}

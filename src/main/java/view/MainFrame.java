package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Component Stock System");
        setSize(480, 320);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        JButton locationButton = new JButton("Locations");
        JButton componentButton = new JButton("Components");
        JButton inStockButton = new JButton("In Stock");
        JButton outStockButton = new JButton("Out Stock");
        JButton warningButton = new JButton("Warnings");
        JButton exitButton = new JButton("Exit");

        panel.add(locationButton);
        panel.add(componentButton);
        panel.add(inStockButton);
        panel.add(outStockButton);
        panel.add(warningButton);
        panel.add(exitButton);
        setContentPane(panel);

        locationButton.addActionListener(event -> new LocationManageFrame().setVisible(true));
        componentButton.addActionListener(event -> new ComponentManageFrame().setVisible(true));
        inStockButton.addActionListener(event -> new InStockFrame().setVisible(true));
        outStockButton.addActionListener(event -> new OutStockFrame().setVisible(true));
        warningButton.addActionListener(event -> new WarningFrame().setVisible(true));
        exitButton.addActionListener(event -> dispose());
    }
}

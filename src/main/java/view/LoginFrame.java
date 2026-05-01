package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.GridLayout;

public class LoginFrame extends JFrame {
    private final JTextField usernameField = new JTextField("admin");
    private final JPasswordField passwordField = new JPasswordField("123456");

    public LoginFrame() {
        setTitle("Component Stock System - Login");
        setSize(320, 180);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3, 2, 8, 8));
        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);

        JButton loginButton = new JButton("Login");
        JButton exitButton = new JButton("Exit");
        panel.add(loginButton);
        panel.add(exitButton);
        setContentPane(panel);

        loginButton.addActionListener(event -> openMainFrame());
        exitButton.addActionListener(event -> dispose());
    }

    private void openMainFrame() {
        if (usernameField.getText().isBlank() || passwordField.getPassword().length == 0) {
            JOptionPane.showMessageDialog(this, "Please enter username and password.");
            return;
        }
        new MainFrame().setVisible(true);
        dispose();
    }
}

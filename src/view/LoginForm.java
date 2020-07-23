package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class LoginForm {
    private JPanel paneLogin;
    private JTextField txtUser;
    private JButton btnLogin;
    private JLabel lblTitulo;
    private JLabel lblUser;
    private JLabel lblPassword;
    private JPasswordField passPassword;

    public LoginForm() {
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = txtUser.getText();
                char[] password = passPassword.getPassword();

                JOptionPane.showMessageDialog(null,
                        String.format("As informações passadas foram:\n%s\n%s", user, Arrays.toString(password)),
                        "Informações do Login", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Login Title");
        frame.setContentPane(new LoginForm().paneLogin);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(300, 200));
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }
}

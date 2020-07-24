package view;

import model.User;
import myutil.Util;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class RegisterForm {
    private JTextField userName;
    private JTextField userEmail;
    private JTextField userCountry;
    private JPasswordField userPassword;
    private JTextField userBirthdate;
    private JButton btnOK;
    private JPanel paneRegister;

    private final JFrame currentFrame;

    public RegisterForm(JFrame frame) {
        this.currentFrame = frame;

        btnOK.addActionListener(listener -> {
            String name = userName.getText();
            String country = userCountry.getText();
            String birthdate = userBirthdate.getText();
            String email = userEmail.getText();
            String password = new String(userPassword.getPassword());

            // Checks if all the boxes were filled
            if(name.length() <= 0 || country.length() <= 0 || birthdate.length() <= 0 || email.length() <= 0 || password.length() <= 0){
                JOptionPane.showMessageDialog(null, "Favor preencher todos os campos.",
                        "Erro no login", JOptionPane.ERROR_MESSAGE);
            }

            else {
                // Checks if the email and password are valid - and if they aren't, return false.
                if (!Util.isValidEmailAddress(email)) {
                    JOptionPane.showMessageDialog(null, "O email informado é inválido!",
                            "Erro no login", JOptionPane.ERROR_MESSAGE);
                } else if (!Util.isValidPassword(password)) {
                    JOptionPane.showMessageDialog(null, "A senha informada é inválida!",
                            "Erro no login", JOptionPane.ERROR_MESSAGE);
                } else {

                    try {
                        User.createAccount(name, country, birthdate, email, password);
                        JOptionPane.showMessageDialog(null, "Conta criada com sucesso! Seja bem vindo(a), " + name + "!");

                        // open a new window and close the currentFrame
                        LoginForm.main(null);
                        this.currentFrame.dispose();
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, "Erro ao acessar dados: " + e,
                                "Erro ao criar conta", JOptionPane.ERROR_MESSAGE);
                    }

                }
            }

        });
    }

    public static void openWindow() {
        JFrame frame = new JFrame("Criar conta");
        frame.setContentPane(new RegisterForm(frame).paneRegister);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(550, 300));
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        RegisterForm.openWindow();
    }
}

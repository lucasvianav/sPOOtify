package view;

import model.User;
import myutil.Util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class RegisterForm {
    private JTextField txtName;
    private JTextField txtEmail;
    private JTextField txtCountry;
    private JPasswordField passPassword;
    private JButton btnOK;
    private JPanel paneRegister;
    private JFormattedTextField txtBirthDate;
    private JLabel lblBirthDate;

    private final JFrame currentFrame;

    public RegisterForm(JFrame frame) {
        this.currentFrame = frame;

        btnOK.addActionListener(listener -> {
            String name = txtName.getText();
            String country = txtCountry.getText();
            String birthdate = txtBirthDate.getText();
            String email = txtEmail.getText();
            String password = new String(passPassword.getPassword());

            // Checks if all the boxes were filled
            if(name.isBlank() || country.isBlank() || birthdate.isBlank() || email.isBlank() || password.isBlank())
                JOptionPane.showMessageDialog(null, "Favor preencher todos os campos.",
                        "Erro no preenchimento dos campos", JOptionPane.ERROR_MESSAGE);
            else {
                // Checks if the email and password are valid - and if they aren't, return false.
                if (!Util.isValidEmailAddress(email)) {
                    JOptionPane.showMessageDialog(null, "O email informado é inválido!",
                            "Erro no preenchimento dos campos", JOptionPane.ERROR_MESSAGE);
                } else if (!Util.isValidPassword(password)) {
                    JOptionPane.showMessageDialog(null, "A senha informada é inválida!",
                            "Erro no preenchimento dos campos", JOptionPane.ERROR_MESSAGE);
                } else if (!Util.isValidDateFormat(birthdate)) {
                    JOptionPane.showMessageDialog(null, "A data informada é inválida!",
                            "Erro no preenchimento dos campos", JOptionPane.ERROR_MESSAGE);
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

        txtBirthDate.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                txtBirthDate.setText("");
                txtBirthDate.setForeground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent e) {
                txtBirthDate.setText("AAAA-MM-DD");
                txtBirthDate.setForeground(Color.GRAY);
            }
        });
    }

    public static void openWindow() {
        JFrame frame = new JFrame("Criar conta");
        frame.setContentPane(new RegisterForm(frame).paneRegister);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(550, 250));
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        RegisterForm.openWindow();
    }
}

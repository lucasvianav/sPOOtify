package view;

import model.User;
import myutil.Util;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class LoginForm {
    private JPanel paneLogin;
    private JTextField txtUser;
    private JButton btnLogin;
    private JLabel lblTitulo;
    private JLabel lblUser;
    private JLabel lblPassword;
    private JPasswordField passPassword;

    private User user = null;

    public LoginForm() {
        btnLogin.addActionListener(listener -> {
            String email = txtUser.getText();
            String password = new String(passPassword.getPassword());

            JOptionPane.showMessageDialog(null,
                    String.format("As informações passadas foram:\n%s\n%s", email, password),
                    "Informações do Login", JOptionPane.INFORMATION_MESSAGE);

            try {
                if(login(email, password)) {
                    // send user object to another form
                    JOptionPane.showMessageDialog(null, "Bem-vindo " + user.getName() + "!");
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erro ao acessar dados: " + e,
                        "Erro no login", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private boolean login(String email, String password) throws IOException {
        // Checks if the email and password are valid - and if they aren't, return false.
        if (!Util.isValidEmailAddress(email)) {
            JOptionPane.showMessageDialog(null, "O email informado é inválido!",
                    "Erro no login", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (!Util.isValidPassword(password)) {
            JOptionPane.showMessageDialog(null, "A senha informada é inválida!",
                    "Erro no login", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        Scanner read = new Scanner(Util.accountsDatabase);
        String auxEmail, auxPassword, auxName, auxCountry, auxDate;

        // Reads each line of the list
        while (read.hasNextLine()) {
            auxEmail = read.nextLine();     // Saves the line x as an email
            auxPassword = read.nextLine();  // and the line x+1 as a password
            auxName = read.nextLine();
            auxCountry = read.nextLine();
            auxDate = read.nextLine();

            if (auxEmail.equals(email)) {               // If it finds the entered email, check the password
                if (auxPassword.equals(password)) {     // If the password was corrected, login is successful
                    user = new User(auxName, auxCountry, auxDate, auxEmail, auxPassword);
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "A senha informada está incorreta!",
                            "Erro no login", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
        }

        // Will be executed only if all the lines were read and the entered email wasn't found
        System.out.println("O email informado está incorreto!");

        return false;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Login do Sistema");
        frame.setContentPane(new LoginForm().paneLogin);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(300, 200));
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }
}

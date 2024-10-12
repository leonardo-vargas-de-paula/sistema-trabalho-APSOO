package sistema.view.login;

import javax.swing.*;

public class LoginForm extends JFrame {
    private JPanel MainPanel;
    private JLabel labelTitulo;
    private JButton btnEntrar;
    private JLabel labelId;
    private JLabel labelSenha;
    private JTextField textField1;
    private JTextField textField2;

    public LoginForm () {
        setContentPane(MainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Login");
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setSize(900, 600);
    }

    public static void main(String[] args) {
        new LoginForm();
    }
}

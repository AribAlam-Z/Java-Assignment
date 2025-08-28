package apumedicalcentre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class RegisterPage extends JFrame {
    private JTextField regIdField;
    private JTextField regNameField;
    private JPasswordField regPasswordField;
    private JTextField regRoleField;

    public RegisterPage() {
        setTitle("APU Medical Centre - Register");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Closes only this window
        setLayout(null);

        // Registration Fields
        JLabel regIdLabel = new JLabel("Reg ID:");
        regIdLabel.setBounds(50, 50, 80, 25);
        add(regIdLabel);

        regIdField = new JTextField();
        regIdField.setBounds(140, 50, 400, 25);
        add(regIdField);

        JLabel regNameLabel = new JLabel("Name:");
        regNameLabel.setBounds(50, 100, 80, 25);
        add(regNameLabel);

        regNameField = new JTextField();
        regNameField.setBounds(140, 100, 400, 25);
        add(regNameField);

        JLabel regPasswordLabel = new JLabel("Password:");
        regPasswordLabel.setBounds(50, 150, 80, 25);
        add(regPasswordLabel);

        regPasswordField = new JPasswordField();
        regPasswordField.setBounds(140, 150, 400, 25);
        add(regPasswordField);

        JLabel regRoleLabel = new JLabel("Role (Manager/Staff/Doctor/Customer):");
        regRoleLabel.setBounds(50, 200, 200, 25);
        add(regRoleLabel);

        regRoleField = new JTextField();
        regRoleField.setBounds(250, 200, 290, 25);
        add(regRoleField);

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(50, 250, 100, 30);
        add(registerButton);

        JButton backButton = new JButton("Back to Login");
        backButton.setBounds(160, 250, 120, 30);
        add(backButton);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = regIdField.getText();
                String name = regNameField.getText();
                String password = new String(regPasswordField.getPassword());
                String role = regRoleField.getText();
                if (id.isEmpty() || name.isEmpty() || password.isEmpty() || role.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "All fields are required");
                    return;
                }
                User newUser = null;
                switch (role.toLowerCase()) {
                    case "manager":
                        newUser = new Manager(id, name, password, role);
                        break;
                    case "staff":
                        newUser = new Staff(id, name, password, role);
                        break;
                    case "doctor":
                        newUser = new Doctor(id, name, password, role);
                        break;
                    case "customer":
                        newUser = new Customer(id, name, password, role);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Invalid role");
                        return;
                }
                newUser.saveToFile(newUser.getUserFilePath(role));
                JOptionPane.showMessageDialog(null, "Registration successful");
                regIdField.setText("");
                regNameField.setText("");
                regPasswordField.setText("");
                regRoleField.setText("");
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close register page
                LoginPage loginPage = new LoginPage();
                loginPage.setVisible(true);
            }
        });
    }
}
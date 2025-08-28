package apumedicalcentre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;

public class LoginPage extends JFrame {
    private JTextField idField;
    private JPasswordField passwordField;

    public LoginPage() {
        setTitle("APU Medical Centre - Login");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Login Fields
        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(50, 50, 80, 25);
        add(idLabel);

        idField = new JTextField();
        idField.setBounds(140, 50, 400, 25);
        add(idField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 100, 80, 25);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(140, 100, 400, 25);
        add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(50, 150, 100, 30);
        add(loginButton);

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(160, 150, 100, 30);
        add(registerButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                String password = new String(passwordField.getPassword());
                if (id.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "ID and Password cannot be empty");
                    return;
                }
                String[] roles = {"Manager", "Staff", "Doctor", "Customer"};
                boolean loginSuccess = false;
                for (String role : roles) {
                    List<User> users = User.loadUsersFromFile(User.getUserFilePath(role));
                    for (User user : users) {
                        if (user.login(id, password)) {
                            openRoleScreen(user);
                            dispose();
                            loginSuccess = true;
                            return;
                        }
                    }
                }
                if (!loginSuccess) {
                    JOptionPane.showMessageDialog(null, "Invalid credentials. Redirecting to Register Page.");
                    dispose(); // Close current login page
                    RegisterPage registerPage = new RegisterPage();
                    registerPage.setVisible(true);
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close login page
                RegisterPage registerPage = new RegisterPage();
                registerPage.setVisible(true);
            }
        });
    }

    private void openRoleScreen(User user) {
        if (user instanceof Manager) {
            Manager manager = (Manager) user;
            new ManagerScreen(manager).setVisible(true);
        } else if (user instanceof Staff) {
            Staff staff = (Staff) user;
            new StaffScreen(staff).setVisible(true);
        } else if (user instanceof Doctor) {
            Doctor doctor = (Doctor) user;
            new DoctorScreen(doctor).setVisible(true);
        } else if (user instanceof Customer) {
            Customer customer = (Customer) user;
            new CustomerScreen(customer).setVisible(true);
        }
    }
}
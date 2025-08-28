package apumedicalcentre;

import javax.swing.*;

public class ManagerScreen extends JFrame {
    private Manager manager;

    public ManagerScreen(Manager manager) {
        this.manager = manager;
        setTitle("Manager Dashboard");
        setSize(500, 400);
        setLayout(null);

        JButton createUserButton = new JButton("Create User");
        createUserButton.setBounds(10, 10, 150, 25);
        add(createUserButton);

        JButton viewAppointmentsButton = new JButton("View All Appointments");
        viewAppointmentsButton.setBounds(10, 40, 150, 25);
        add(viewAppointmentsButton);

        JButton viewFeedbackButton = new JButton("View Feedback");
        viewFeedbackButton.setBounds(10, 70, 150, 25);
        add(viewFeedbackButton);

        JButton generateReportButton = new JButton("Generate Report");
        generateReportButton.setBounds(10, 100, 150, 25);
        add(generateReportButton);

        createUserButton.addActionListener(e -> {
            // Open registration dialog or form (simplified here)
            String id = JOptionPane.showInputDialog("Enter ID");
            String name = JOptionPane.showInputDialog("Enter Name");
            String password = JOptionPane.showInputDialog("Enter Password");
            String role = JOptionPane.showInputDialog("Enter Role (Manager/Staff/Doctor/Customer)");
            if (id != null && name != null && password != null && role != null) {
                User newUser = null;
                switch (role.toLowerCase()) {
                    case "manager": newUser = new Manager(id, name, password, role); break;
                    case "staff": newUser = new Staff(id, name, password, role); break;
                    case "doctor": newUser = new Doctor(id, name, password, role); break;
                    case "customer": newUser = new Customer(id, name, password, role); break;
                }
                if (newUser != null) {
                    manager.createUser(newUser);
                    JOptionPane.showMessageDialog(null, "User created");
                }
            }
        });
    }
}

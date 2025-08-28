package apumedicalcentre;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class HomePage extends JFrame {
    public HomePage() {
        setTitle("APU Medical Centre");
        setSize(800, 600); // Larger window for a beautiful layout
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Header Panel (Simulating a Hero Image)
        JPanel headerPanel = new JPanel();
        headerPanel.setBounds(0, 0, 800, 200);
        headerPanel.setBackground(new Color(0, 120, 215)); // Blue background as a placeholder
        JLabel headerLabel = new JLabel("Welcome to APU Medical Centre");
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 30));
        headerLabel.setBounds(50, 50, 700, 100);
        headerPanel.add(headerLabel);
        add(headerPanel);

        // Navigation Buttons
        JButton findDoctorButton = new JButton("Find a Doctor");
        findDoctorButton.setBounds(50, 250, 150, 40);
        findDoctorButton.setBackground(new Color(34, 139, 34)); // Green
        findDoctorButton.setForeground(Color.WHITE);
        findDoctorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Find a Doctor feature coming soon!");
            }
        });
        add(findDoctorButton);

        JButton bookAppointmentButton = new JButton("Book Appointment");
        bookAppointmentButton.setBounds(220, 250, 150, 40);
        bookAppointmentButton.setBackground(new Color(255, 165, 0)); // Orange
        bookAppointmentButton.setForeground(Color.WHITE);
        bookAppointmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Book Appointment feature coming soon!");
            }
        });
        add(bookAppointmentButton);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(390, 250, 150, 40);
        loginButton.setBackground(new Color(0, 0, 139)); // Dark blue
        loginButton.setForeground(Color.WHITE);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close home page
                LoginPage loginPage = new LoginPage();
                loginPage.setVisible(true);
            }
        });
        add(loginButton);

        // Info Section
        JLabel infoLabel = new JLabel("<html><body>APU Medical Centre provides top-quality healthcare services.<br>" +
                                     "Our dedicated team is here to support your health needs 24/7.</body></html>");
        infoLabel.setBounds(50, 320, 700, 100);
        infoLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        add(infoLabel);

        // Footer
        JPanel footerPanel = new JPanel();
        footerPanel.setBounds(0, 500, 800, 100);
        footerPanel.setBackground(new Color(169, 169, 169)); // Gray
        JLabel footerLabel = new JLabel("Contact us: info@apumedicalcentre.com | +601-234-5678");
        footerLabel.setForeground(Color.WHITE);
        footerLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        footerLabel.setBounds(50, 10, 700, 30);
        footerPanel.add(footerLabel);
        add(footerPanel);
    }
}

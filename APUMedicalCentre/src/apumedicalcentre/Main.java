package apumedicalcentre;

import javax.swing.SwingUtilities;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Create empty text files
        createTextFiles();

        // Add a default Manager to managers.txt
        addDefaultManager();

        SwingUtilities.invokeLater(() -> {
            HomePage homePage = new HomePage(); // This should work if HomePage.java is correct
            homePage.setVisible(true);
        });
    }

    private static void createTextFiles() {
        String[] files = {
            "managers.txt", "staff.txt", "doctors.txt", "customers.txt",
            "appointments.txt", "payments.txt", "feedbacks.txt",
            "doctor_availability.txt", "reports.txt", "activity_log.txt"
        };

        for (String file : files) {
            File f = new File(file);
            try {
                if (f.createNewFile()) {
                    System.out.println(file + " created successfully.");
                } else {
                    System.out.println(file + " already exists.");
                }
            } catch (IOException e) {
                System.out.println("Error creating " + file + ": " + e.getMessage());
            }
        }
    }

    private static void addDefaultManager() {
        Manager defaultManager = new Manager("M001", "AdminManager", "admin123", "Manager");
        defaultManager.saveToFile(defaultManager.getUserFilePath("Manager"));
        System.out.println("Default Manager (M001, AdminManager) added to managers.txt.");
    }
}
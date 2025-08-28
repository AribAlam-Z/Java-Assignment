package apumedicalcentre;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class User {
    private String id;
    private String name;
    private String password;
    private String role;

    public User(String id, String name, String password, String role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public boolean login(String enteredId, String enteredPassword) {
        List<User> users = loadUsersFromFile(getUserFilePath(role));
        for (User user : users) {
            if (user.getId().equals(enteredId) && user.getPassword().equals(enteredPassword)) {
                return true;
            }
        }
        return false;
    }

    public void editProfile(String newName, String newPassword) {
        this.name = newName;
        this.password = newPassword;
        saveToFile(getUserFilePath(role));
    }

    public abstract void performRoleSpecificActions();

    public static String getUserFilePath(String role) {
        switch (role.toLowerCase()) {
            case "manager": return "managers.txt";
            case "staff": return "staff.txt";
            case "doctor": return "doctors.txt";
            case "customer": return "customers.txt";
            default: throw new IllegalArgumentException("Invalid role");
        }
    }

    public static List<User> loadUsersFromFile(String filePath) {
        List<User> users = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String currentRole = parts[3].trim();
                    switch (currentRole.toLowerCase()) {
                        case "manager":
                            users.add(new Manager(parts[0], parts[1], parts[2], currentRole));
                            break;
                        case "staff":
                            users.add(new Staff(parts[0], parts[1], parts[2], currentRole));
                            break;
                        case "doctor":
                            users.add(new Doctor(parts[0], parts[1], parts[2], currentRole));
                            break;
                        case "customer":
                            users.add(new Customer(parts[0], parts[1], parts[2], currentRole));
                            break;
                    }
                }
            }
        } catch (IOException e) {
            // File might be empty or not exist yet; return empty list
        }
        return users;
    }

    public void saveToFile(String filePath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            bw.write(id + "," + name + "," + password + "," + role);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void logActivity(String timestamp, String userId, String action) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("activity_log.txt", true))) {
            bw.write(timestamp + "," + userId + "," + action);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
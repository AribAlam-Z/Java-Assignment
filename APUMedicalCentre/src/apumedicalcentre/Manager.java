package apumedicalcentre;

public class Manager extends User {
    public Manager(String id, String name, String password, String role) {
        super(id, name, password, role);
    }

    public void createUser(User newUser) {
        newUser.saveToFile(getUserFilePath(newUser.getRole()));
    }

    public void deleteUser(String userId, String role) {
        // Logic to remove from file (not implemented here)
    }

    public void viewAllAppointments() {
        // Load from appointments.txt
    }

    public void viewFeedback() {
        // Load from feedbacks.txt
    }

    public void generateReport() {
        // Use reports.txt
    }

    @Override
    public void performRoleSpecificActions() {
        // Manager-specific logic
    }
}

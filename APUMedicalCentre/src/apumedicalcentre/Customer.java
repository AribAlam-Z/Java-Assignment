package apumedicalcentre;

public class Customer extends User {
    public Customer(String id, String name, String password, String role) {
        super(id, name, password, role);
    }

    @Override
    public void editProfile(String newName, String newPassword) {
        super.editProfile(newName, newPassword);
    }

    public void checkAppointments() {
        // Load from appointments.txt
    }

    public void provideComment(String appointmentId, String comment) {
        // Save to feedbacks.txt
    }

    public void viewHistory() {
        // Load from appointments.txt
    }

    @Override
    public void performRoleSpecificActions() {
        // Customer-specific logic
    }
}

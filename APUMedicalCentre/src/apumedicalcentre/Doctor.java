package apumedicalcentre;

public class Doctor extends User {
    public Doctor(String id, String name, String password, String role) {
        super(id, name, password, role);
    }

    @Override
    public void editProfile(String newName, String newPassword) {
        super.editProfile(newName, newPassword);
    }

    public void checkAppointments() {
        // Load from appointments.txt
    }

    public void enterCharges(String appointmentId, double charges) {
        // Update appointments.txt
    }

    public void enterFeedback(String appointmentId, String feedback) {
        // Save to feedbacks.txt
    }

    public void viewHistory() {
        // Load from appointments.txt
    }

    @Override
    public void performRoleSpecificActions() {
        // Doctor-specific logic
    }
}

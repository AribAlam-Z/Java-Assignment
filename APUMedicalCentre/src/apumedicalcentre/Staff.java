package apumedicalcentre;

public class Staff extends User {
    public Staff(String id, String name, String password, String role) {
        super(id, name, password, role);
    }

    public void createCustomer(Customer customer) {
        customer.saveToFile(getUserFilePath("Customer"));
    }

    public void deleteCustomer(String customerId) {
        // Logic to remove from customers.txt
    }

    public void assistBooking(Appointment appointment) {
        appointment.saveToFile("appointments.txt");
    }

    public void assignDoctor(String appointmentId, String doctorId) {
        // Update appointments.txt
    }

    public void collectPayment(Payment payment) {
        payment.saveToFile("payments.txt");
    }

    public void generateReceipt(String paymentId) {
        // Logic to generate receipt
    }

    @Override
    public void performRoleSpecificActions() {
        // Staff-specific logic
    }
}
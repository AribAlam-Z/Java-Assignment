package apumedicalcentre;

import javax.swing.*;

public class StaffScreen extends JFrame {
    private Staff staff;

    public StaffScreen(Staff staff) {
        this.staff = staff;
        setTitle("Staff Dashboard");
        setSize(400, 300);
        setLayout(null);

        JButton assistBookingButton = new JButton("Assist Booking");
        assistBookingButton.setBounds(10, 10, 150, 25);
        add(assistBookingButton);

        JButton collectPaymentButton = new JButton("Collect Payment");
        collectPaymentButton.setBounds(10, 40, 150, 25);
        add(collectPaymentButton);

        assistBookingButton.addActionListener(e -> {
            String date = JOptionPane.showInputDialog("Enter Date (YYYY-MM-DD)");
            String doctorId = JOptionPane.showInputDialog("Enter Doctor ID");
            if (date != null && doctorId != null) {
                String id = "A" + System.currentTimeMillis();
                Appointment appt = new Appointment(id, date, doctorId, staff.getId(), "Scheduled", 0.0, "");
                staff.assistBooking(appt);
                JOptionPane.showMessageDialog(null, "Appointment booked: " + id);
            }
        });

        collectPaymentButton.addActionListener(e -> {
            String amountStr = JOptionPane.showInputDialog("Enter Amount");
            String method = JOptionPane.showInputDialog("Enter Payment Method");
            if (amountStr != null && method != null) {
                try {
                    double amount = Double.parseDouble(amountStr);
                    String id = "P" + System.currentTimeMillis();
                    Payment pay = new Payment("A001", amount, method, java.time.LocalDate.now().toString());
                    staff.collectPayment(pay);
                    staff.generateReceipt(id);
                    JOptionPane.showMessageDialog(null, "Payment collected, Receipt ID: " + id);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid amount");
                }
            }
        });
    }
}

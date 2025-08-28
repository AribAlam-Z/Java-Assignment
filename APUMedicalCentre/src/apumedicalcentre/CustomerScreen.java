package apumedicalcentre;

import javax.swing.*;

public class CustomerScreen extends JFrame {
    private Customer customer;

    public CustomerScreen(Customer customer) {
        this.customer = customer;
        setTitle("Customer Dashboard");
        setSize(400, 300);
        setLayout(null);

        JButton provideCommentButton = new JButton("Provide Comment");
        provideCommentButton.setBounds(10, 10, 150, 25);
        add(provideCommentButton);

        provideCommentButton.addActionListener(e -> {
            String apptId = JOptionPane.showInputDialog("Enter Appointment ID");
            String comment = JOptionPane.showInputDialog("Enter Comment");
            if (apptId != null && comment != null) {
                customer.provideComment(apptId, comment);
                Feedback fb = new Feedback(apptId, customer.getId(), comment, 0);
                fb.saveToFile("feedbacks.txt");
                JOptionPane.showMessageDialog(null, "Comment saved");
            }
        });
    }
}

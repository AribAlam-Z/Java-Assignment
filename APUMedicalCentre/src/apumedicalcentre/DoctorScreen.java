package apumedicalcentre;

import javax.swing.*;

public class DoctorScreen extends JFrame {
    private Doctor doctor;

    public DoctorScreen(Doctor doctor) {
        this.doctor = doctor;
        setTitle("Doctor Dashboard");
        setSize(400, 300);
        setLayout(null);

        JButton enterFeedbackButton = new JButton("Enter Feedback");
        enterFeedbackButton.setBounds(10, 10, 150, 25);
        add(enterFeedbackButton);

        enterFeedbackButton.addActionListener(e -> {
            String apptId = JOptionPane.showInputDialog("Enter Appointment ID");
            String feedback = JOptionPane.showInputDialog("Enter Feedback");
            if (apptId != null && feedback != null) {
                doctor.enterFeedback(apptId, feedback);
                Feedback fb = new Feedback(apptId, doctor.getId(), feedback, 0);
                fb.saveToFile("feedbacks.txt");
                JOptionPane.showMessageDialog(null, "Feedback saved");
            }
        });
    }
}

package apumedicalcentre;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;

public class Feedback {
    private String appointmentId;
    private String userId;
    private String comment;
    private int rating;

    public Feedback(String appointmentId, String userId, String comment, int rating) {
        this.appointmentId = appointmentId;
        this.userId = userId;
        this.comment = comment;
        this.rating = rating;
    }

    // Getters
    public String getAppointmentId() { return appointmentId; }
    public String getUserId() { return userId; }
    public String getComment() { return comment; }
    public int getRating() { return rating; }

    public void saveToFile(String filePath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            bw.write(appointmentId + "," + userId + "," + comment + "," + rating);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Feedback> loadFeedbacksFromFile(String filePath) {
        List<Feedback> feedbacks = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    feedbacks.add(new Feedback(parts[0], parts[1], parts[2], Integer.parseInt(parts[3])));
                }
            }
        } catch (IOException e) {
            // File might be empty; return empty list
        }
        return feedbacks;
    }
}

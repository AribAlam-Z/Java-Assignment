package apumedicalcentre;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;

public class Appointment {
    private String id;
    private String date;
    private String doctorId;
    private String customerId;
    private String status;
    private double charges;
    private String feedback;

    public Appointment(String id, String date, String doctorId, String customerId, String status, double charges, String feedback) {
        this.id = id;
        this.date = date;
        this.doctorId = doctorId;
        this.customerId = customerId;
        this.status = status;
        this.charges = charges;
        this.feedback = feedback;
    }

    // Getters
    public String getId() { return id; }
    public String getDate() { return date; }
    public String getDoctorId() { return doctorId; }
    public String getCustomerId() { return customerId; }
    public String getStatus() { return status; }
    public double getCharges() { return charges; }
    public String getFeedback() { return feedback; }

    public void saveToFile(String filePath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            bw.write(id + "," + date + "," + doctorId + "," + customerId + "," + status + "," + charges + "," + feedback);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Appointment> loadAppointmentsFromFile(String filePath) {
        List<Appointment> appointments = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 7) {
                    appointments.add(new Appointment(parts[0], parts[1], parts[2], parts[3], parts[4], Double.parseDouble(parts[5]), parts[6]));
                }
            }
        } catch (IOException e) {
            // File might be empty; return empty list
        }
        return appointments;
    }
}

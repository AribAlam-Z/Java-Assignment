package apumedicalcentre;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;

public class Payment {
    private String appointmentId;
    private double amount;
    private String method;
    private String date;

    public Payment(String appointmentId, double amount, String method, String date) {
        this.appointmentId = appointmentId;
        this.amount = amount;
        this.method = method;
        this.date = date;
    }

    // Getters
    public String getAppointmentId() { return appointmentId; }
    public double getAmount() { return amount; }
    public String getMethod() { return method; }
    public String getDate() { return date; }

    public void saveToFile(String filePath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            bw.write(appointmentId + "," + amount + "," + method + "," + date);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Payment> loadPaymentsFromFile(String filePath) {
        List<Payment> payments = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    payments.add(new Payment(parts[0], Double.parseDouble(parts[1]), parts[2], parts[3]));
                }
            }
        } catch (IOException e) {
            // File might be empty; return empty list
        }
        return payments;
    }
}
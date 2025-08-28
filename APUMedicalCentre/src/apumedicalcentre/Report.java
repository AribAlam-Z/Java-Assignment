package apumedicalcentre;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Report {
    public void generateAnalyzedReport(String date, String metric, String value) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("reports.txt", true))) {
            bw.write(date + "," + metric + "," + value);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

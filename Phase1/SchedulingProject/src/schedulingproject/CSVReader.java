package schedulingproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {

    public static CPUProcess[] readProcesses(
            String fileName,
            int numberOfProcesses) {

        CPUProcess[] processes =
                new CPUProcess[numberOfProcesses];

        try {

            BufferedReader br =
                    new BufferedReader(
                            new FileReader(fileName)
                    );

            // Skip header
            br.readLine();

            String line;
            int index = 0;

            while ((line = br.readLine()) != null
                    && index < numberOfProcesses) {

                String[] data = line.split(",");

                String processId = data[0];

                int arrivalTime =
                        Integer.parseInt(data[1]);

                int burstTime =
                        Integer.parseInt(data[2]);

                processes[index] =
                        new CPUProcess(
                                processId,
                                arrivalTime,
                                burstTime
                        );

                index++;
            }

            br.close();

        } catch (IOException e) {

            System.out.println(
                    "Error reading file: "
                    + e.getMessage()
            );
        }

        return processes;
    }
}
package schedulingproject;

import java.util.Scanner;

public class SchedulingProject {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int quantum = 3;
        int numberOfProcesses;

        System.out.println("CPU Scheduling Project");
        System.out.println("----------------------");

        System.out.print(
                "Enter number of processes (1 - 500): "
        );

        numberOfProcesses = input.nextInt();

        // Check number
        while (numberOfProcesses < 1
                || numberOfProcesses > 500) {

            System.out.println(
                    "Please enter a number between 1 and 500."
            );

            System.out.print(
                    "Enter number of processes: "
            );

            numberOfProcesses = input.nextInt();
        }

        System.out.println();
        System.out.println(
                "Number of Processes = "
                + numberOfProcesses
        );

        System.out.println(
                "Quantum = " + quantum
        );

        System.out.println();
        System.out.println(
                "========================================"
        );
        System.out.println();


        // FCFS
        CPUProcess[] fcfsProcesses =
                createProcesses(numberOfProcesses);

        FCFSScheduler.run(fcfsProcesses);

        System.out.println();
        System.out.println(
                "========================================"
        );
        System.out.println();


        // Round Robin
        CPUProcess[] rrProcesses =
                createProcesses(numberOfProcesses);

        RoundRobinScheduler.run(
                rrProcesses,
                quantum
        );

        System.out.println();
        System.out.println(
                "========================================"
        );
        System.out.println();


        // SPF
        CPUProcess[] spfProcesses =
                createProcesses(numberOfProcesses);

        SPFScheduler.run(spfProcesses);

        System.out.println();
        System.out.println(
                "========================================"
        );
        System.out.println();


        // SRT
        CPUProcess[] srtProcesses =
                createProcesses(numberOfProcesses);

        SRTScheduler.run(srtProcesses);

        System.out.println();
        System.out.println(
                "========================================"
        );
        System.out.println();


        // Comparison
        System.out.println(
                "Algorithms Comparison"
        );

        System.out.println();

        System.out.println(
                "-------------------------------------------------------------------"
        );

        System.out.printf(
                "%-15s %-15s %-15s %-15s%n",
                "Algorithm",
                "Avg TAT",
                "Avg WT",
                "Avg RT"
        );

        System.out.println(
                "-------------------------------------------------------------------"
        );

        printAverage(
                "FCFS",
                fcfsProcesses
        );

        printAverage(
                "Round Robin",
                rrProcesses
        );

        printAverage(
                "SPF",
                spfProcesses
        );

        printAverage(
                "SRT",
                srtProcesses
        );

        System.out.println(
                "-------------------------------------------------------------------"
        );

        input.close();
    }


    public static CPUProcess[] createProcesses(
            int numberOfProcesses) {

        CPUProcess[] processes =
                CSVReader.readProcesses(
                        "src/cpu_scheduling_dataset_500_wide.csv",
                        numberOfProcesses
                );

        return processes;
    }


    public static void printAverage(
            String name,
            CPUProcess[] processes) {

        double totalTurnaround = 0;
        double totalWaiting = 0;
        double totalResponse = 0;

        for (CPUProcess p : processes) {

            totalTurnaround +=
                    p.turnaroundTime;

            totalWaiting +=
                    p.waitingTime;

            totalResponse +=
                    p.responseTime;
        }

        double avgTurnaround =
                totalTurnaround
                / processes.length;

        double avgWaiting =
                totalWaiting
                / processes.length;

        double avgResponse =
                totalResponse
                / processes.length;

        System.out.printf(
                "%-15s %-15.3f %-15.3f %-15.3f%n",
                name,
                avgTurnaround,
                avgWaiting,
                avgResponse
        );
    }
}
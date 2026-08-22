package schedulingproject;

public class FCFSScheduler {

    public static void run(CPUProcess[] processes) {

        int currentTime = 0;

        double totalTurnaround = 0;
        double totalWaiting = 0;
        double totalResponse = 0;

        String gantt = "0";

        System.out.println("FIFO Results");
        System.out.println("Process\tTAT\tWT\tRT");

        for (CPUProcess p : processes) {

            if (currentTime < p.arrivalTime) {
                currentTime = p.arrivalTime;
            }

            p.startTime = currentTime;

            gantt += " | " + p.processId;

            p.completionTime = p.startTime + p.burstTime;

            gantt += " | " + p.completionTime;

            p.turnaroundTime =
                    p.completionTime - p.arrivalTime;

            p.waitingTime =
                    p.turnaroundTime - p.burstTime;

            p.responseTime =
                    p.startTime - p.arrivalTime;

            currentTime = p.completionTime;

            totalTurnaround += p.turnaroundTime;
            totalWaiting += p.waitingTime;
            totalResponse += p.responseTime;

            System.out.println(
                    p.processId + "\t" +
                    p.turnaroundTime + "\t" +
                    p.waitingTime + "\t" +
                    p.responseTime
            );
        }

        System.out.println();

        System.out.println(
                "Average Turnaround Time = "
                + totalTurnaround / processes.length
        );

        System.out.println(
                "Average Waiting Time = "
                + totalWaiting / processes.length
        );

        System.out.println(
                "Average Response Time = "
                + totalResponse / processes.length
        );

        System.out.println();
        System.out.println("Gantt Chart:");
        System.out.println(gantt);
    }
}
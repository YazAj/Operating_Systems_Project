package schedulingproject;

public class SPFScheduler {

    public static void run(CPUProcess[] processes) {

        int currentTime = 0;
        int completed = 0;

        boolean[] done = new boolean[processes.length];

        double totalTurnaround = 0;
        double totalWaiting = 0;
        double totalResponse = 0;

        String gantt = "0";

        while (completed < processes.length) {

            int shortest = -1;

            for (int i = 0; i < processes.length; i++) {

                if (!done[i] && processes[i].arrivalTime <= currentTime) {

                    if (shortest == -1 ||
                        processes[i].burstTime < processes[shortest].burstTime) {

                        shortest = i;
                    }
                }
            }

            if (shortest == -1) {
                currentTime++;
            } else {

                CPUProcess p = processes[shortest];

                p.startTime = currentTime;

                gantt += " | " + p.processId;

                p.completionTime =
                        p.startTime + p.burstTime;

                gantt += " | " + p.completionTime;

                p.turnaroundTime =
                        p.completionTime - p.arrivalTime;

                p.waitingTime =
                        p.turnaroundTime - p.burstTime;

                p.responseTime =
                        p.startTime - p.arrivalTime;

                currentTime = p.completionTime;

                done[shortest] = true;
                completed++;

                totalTurnaround += p.turnaroundTime;
                totalWaiting += p.waitingTime;
                totalResponse += p.responseTime;
            }
        }

        System.out.println("SPF Results");
        System.out.println("Process\tTAT\tWT\tRT");

        for (CPUProcess p : processes) {

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
package schedulingproject;

public class RoundRobinScheduler {

    public static void run(CPUProcess[] processes, int quantum) {

        int currentTime = 0;
        int completed = 0;

        double totalTurnaround = 0;
        double totalWaiting = 0;
        double totalResponse = 0;

        String gantt = "0";

        for (CPUProcess p : processes) {
            p.remainingTime = p.burstTime;
            p.startTime = -1;
        }

        while (completed < processes.length) {

            for (CPUProcess p : processes) {

                if (p.remainingTime > 0) {

                    if (p.startTime == -1) {
                        p.startTime = currentTime;
                    }

                    gantt += " | " + p.processId;

                    if (p.remainingTime > quantum) {

                        currentTime += quantum;
                        p.remainingTime -= quantum;

                    } else {

                        currentTime += p.remainingTime;
                        p.remainingTime = 0;

                        p.completionTime = currentTime;
                        completed++;
                    }

                    gantt += " | " + currentTime;
                }
            }
        }

        System.out.println("Round Robin Results");
        System.out.println("Process\tTAT\tWT\tRT");

        for (CPUProcess p : processes) {

            p.turnaroundTime = p.completionTime;

            p.waitingTime =
                    p.turnaroundTime - p.burstTime;

            p.responseTime = p.startTime;

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
package schedulingproject;

public class SRTScheduler {

    public static void run(CPUProcess[] processes) {

        int currentTime = 0;
        int completed = 0;

        double totalTurnaround = 0;
        double totalWaiting = 0;
        double totalResponse = 0;

        String gantt = "0";
        String lastProcess = "";

        for (CPUProcess p : processes) {
            p.remainingTime = p.burstTime;
            p.startTime = -1;
        }

        while (completed < processes.length) {

            int shortest = -1;

            for (int i = 0; i < processes.length; i++) {

                if (processes[i].arrivalTime <= currentTime
                        && processes[i].remainingTime > 0) {

                    if (shortest == -1
                            || processes[i].remainingTime
                            < processes[shortest].remainingTime) {

                        shortest = i;
                    }
                }
            }

            if (shortest == -1) {
                currentTime++;
                continue;
            }

            CPUProcess p = processes[shortest];

            if (p.startTime == -1) {
                p.startTime = currentTime;
            }

            if (!lastProcess.equals(p.processId)) {

                if (!lastProcess.equals("")) {
                    gantt += " | " + currentTime;
                }

                gantt += " | " + p.processId;
                lastProcess = p.processId;
            }

            p.remainingTime--;
            currentTime++;

            if (p.remainingTime == 0) {

                p.completionTime = currentTime;

                p.turnaroundTime =
                        p.completionTime - p.arrivalTime;

                p.waitingTime =
                        p.turnaroundTime - p.burstTime;

                p.responseTime =
                        p.startTime - p.arrivalTime;

                completed++;
            }
        }

        gantt += " | " + currentTime;

        System.out.println("SRT Results");
        System.out.println("Process\tTAT\tWT\tRT");

        for (CPUProcess p : processes) {

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
package schedulingproject;

public class CPUProcess {

    String processId;
    int arrivalTime;
    int burstTime;

    int remainingTime;

    int startTime;
    int completionTime;

    int turnaroundTime;
    int waitingTime;
    int responseTime;

    public CPUProcess(String processId, int arrivalTime, int burstTime) {

        this.processId = processId;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;

        this.remainingTime = burstTime;

        this.startTime = -1;
        this.completionTime = 0;

        this.turnaroundTime = 0;
        this.waitingTime = 0;
        this.responseTime = 0;
    }
}
package deadlockproject;

public class DeadlockDetector {

    public void detectDeadlock(int numProcesses, int numResources,
                               int[] available, int[][] allocation, int[][] request) {

        boolean[] finish = new boolean[numProcesses];
        int[] work = new int[numResources];

        for (int j = 0; j < numResources; j++) {
            work[j] = available[j];
        }

        System.out.println("========== Graph Reduction Steps ==========");
        System.out.println();
        System.out.print("Initial Available: ");
        printArray(work, numResources);
        System.out.println();

        boolean reduced = true;
        int step = 1;

        while (reduced) {

            reduced = false;

            for (int i = 0; i < numProcesses; i++) {

                if (!finish[i]) {

                    boolean canFinish = true;

                    // Check if the process request can be satisfied
                    for (int j = 0; j < numResources; j++) {
                        if (request[i][j] > work[j]) {
                            canFinish = false;
                            break;
                        }
                    }

                    if (canFinish) {
                        System.out.println("Step " + step + ":");
                        System.out.println("Process P" + i + " can be reduced.");
                        System.out.println("P" + i + " releases its allocated resources.");

                        // Release allocated resources
                        for (int j = 0; j < numResources; j++) {
                            work[j] = work[j] + allocation[i][j];
                        }

                        // Mark the process as finished
                        finish[i] = true;
                        reduced = true;

                        System.out.print("Updated Available: ");
                        printArray(work, numResources);
                        System.out.println();

                        step++;
                    }
                }
            }
        }

        printFinalResult(finish, numProcesses);
    }

    public void printFinalResult(boolean[] finish, int numProcesses) {

        boolean deadlockFound = false;

        for (int i = 0; i < numProcesses; i++) {
            if (!finish[i]) {
                deadlockFound = true;
                break;
            }
        }

        System.out.println("========================================");
        System.out.println("FINAL RESULT");
        System.out.println("========================================");
        System.out.println();

        if (!deadlockFound) {
            System.out.println("NO DEADLOCK");
            System.out.println();
            System.out.println("All processes were reduced successfully.");
        } else {
            System.out.println("DEADLOCK DETECTED");
            System.out.println();
            System.out.println("Deadlocked Processes:");

            for (int i = 0; i < numProcesses; i++) {
                if (!finish[i]) {
                    System.out.println("P" + i);
                }
            }
        }
    }

    public void printArray(int[] array, int numResources) {
        System.out.print("[");

        for (int j = 0; j < numResources; j++) {
            System.out.print(array[j]);

            if (j < numResources - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }
}

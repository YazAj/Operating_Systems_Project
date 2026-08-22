package deadlockproject;

public class DeadlockProject {

    public static void main(String[] args) {

        runTest("src/input_no_deadlock.txt", "TEST 1 - NO DEADLOCK");

        System.out.println();
        System.out.println("========================================");
        System.out.println();

        runTest("src/input_deadlock.txt", "TEST 2 - DEADLOCK");
    }


    public static void runTest(String fileName, String testName) {

        System.out.println("========================================");
        System.out.println("   " + testName);
        System.out.println("========================================");
        System.out.println();

        InputReader inputReader = new InputReader();

        if (!inputReader.readInputFile(fileName)) {
            return;
        }

        displayInputData(inputReader);

        DeadlockDetector detector = new DeadlockDetector();

        detector.detectDeadlock(
                inputReader.numProcesses,
                inputReader.numResources,
                inputReader.available,
                inputReader.allocation,
                inputReader.request
        );
    }


    public static void displayInputData(InputReader inputReader) {

        System.out.println(
                "Number of Processes: "
                + inputReader.numProcesses
        );

        System.out.println(
                "Number of Resources: "
                + inputReader.numResources
        );

        System.out.println();

        System.out.println("Available:");

        printResourceHeader(
                inputReader.numResources
        );

        printArray(
                inputReader.available,
                inputReader.numResources
        );

        System.out.println();

        System.out.println("Allocation Matrix:");

        printResourceHeader(
                inputReader.numResources
        );

        printMatrix(
                inputReader.allocation,
                inputReader.numProcesses,
                inputReader.numResources
        );

        System.out.println();

        System.out.println("Request Matrix:");

        printResourceHeader(
                inputReader.numResources
        );

        printMatrix(
                inputReader.request,
                inputReader.numProcesses,
                inputReader.numResources
        );

        System.out.println();
    }


    public static void printResourceHeader(
            int numResources) {

        System.out.print("       ");

        for (int j = 0;
                j < numResources;
                j++) {

            System.out.print(
                    "R" + j + "  "
            );
        }

        System.out.println();
    }


    public static void printArray(
            int[] array,
            int numResources) {

        System.out.print("       ");

        for (int j = 0;
                j < numResources;
                j++) {

            System.out.print(
                    array[j] + "   "
            );
        }

        System.out.println();
    }


    public static void printMatrix(
            int[][] matrix,
            int numProcesses,
            int numResources) {

        for (int i = 0;
                i < numProcesses;
                i++) {

            System.out.print(
                    "P" + i + "     "
            );

            for (int j = 0;
                    j < numResources;
                    j++) {

                System.out.print(
                        matrix[i][j] + "   "
                );
            }

            System.out.println();
        }
    }
}
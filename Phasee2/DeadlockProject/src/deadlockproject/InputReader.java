package deadlockproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputReader {

    public int numProcesses;
    public int numResources;
    public int[] available;
    public int[][] allocation;
    public int[][] request;

    public boolean readInputFile(String fileName) {

        try {
            Scanner scanner = new Scanner(new File(fileName));

            numProcesses = scanner.nextInt();
            numResources = scanner.nextInt();

            available = new int[numResources];
            allocation = new int[numProcesses][numResources];
            request = new int[numProcesses][numResources];

            for (int j = 0; j < numResources; j++) {
                available[j] = scanner.nextInt();
            }

            for (int i = 0; i < numProcesses; i++) {
                for (int j = 0; j < numResources; j++) {
                    allocation[i][j] = scanner.nextInt();
                }
            }

            for (int i = 0; i < numProcesses; i++) {
                for (int j = 0; j < numResources; j++) {
                    request[i][j] = scanner.nextInt();
                }
            }

            scanner.close();
            return true;

        } catch (FileNotFoundException e) {
            System.out.println("Error: input.txt not found.");
            return false;

        } catch (Exception e) {
            System.out.println("Error: input data is invalid.");
            return false;
        }
    }
}

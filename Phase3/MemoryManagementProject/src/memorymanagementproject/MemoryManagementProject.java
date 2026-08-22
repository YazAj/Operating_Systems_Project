package memorymanagementproject;

import java.util.Scanner;

public class MemoryManagementProject {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println("   MEMORY MANAGEMENT - PHASE 3");
        System.out.println("====================================");
        System.out.println();

        System.out.println("Choose an Algorithm:");
        System.out.println();
        System.out.println("1. First Fit");
        System.out.println("2. Best Fit");
        System.out.println("3. Worst Fit");
        System.out.println("4. FIFO");
        System.out.println("5. LRU");
        System.out.println("6. Optimal");
        System.out.println("7. Clock / Second Chance");
        System.out.println("8. Run All");

        System.out.println();
        System.out.print("Enter choice: ");

        int choice = input.nextInt();

        System.out.println();

        // Placement Algorithms
        if (choice >= 1 && choice <= 3) {

            runPlacement(input, choice);
        }

        // Replacement Algorithms
        else if (choice >= 4 && choice <= 7) {

            runReplacement(input, choice);
        }

        // Run everything
        else if (choice == 8) {

            System.out.println("===== MEMORY PLACEMENT =====");

            int[] blocks = readBlocks(input);
            int[] processes = readProcesses(input);

            PlacementAlgorithms.firstFit(
                    blocks,
                    processes
            );

            PlacementAlgorithms.bestFit(
                    blocks,
                    processes
            );

            PlacementAlgorithms.worstFit(
                    blocks,
                    processes
            );

            System.out.println();
            System.out.println(
                    "===== PAGE REPLACEMENT ====="
            );

            int[] pages = readPages(input);

            System.out.print(
                    "Enter number of frames: "
            );

            int numberOfFrames =
                    input.nextInt();

            ReplacementAlgorithms.fifo(
                    pages,
                    numberOfFrames
            );

            ReplacementAlgorithms.lru(
                    pages,
                    numberOfFrames
            );

            ReplacementAlgorithms.optimal(
                    pages,
                    numberOfFrames
            );

            ReplacementAlgorithms.clock(
                    pages,
                    numberOfFrames
            );
        }

        else {

            System.out.println("Invalid Choice.");
        }

        input.close();
    }


    public static void runPlacement(
            Scanner input,
            int choice) {

        int[] blocks = readBlocks(input);

        int[] processes =
                readProcesses(input);

        if (choice == 1) {

            PlacementAlgorithms.firstFit(
                    blocks,
                    processes
            );
        }

        else if (choice == 2) {

            PlacementAlgorithms.bestFit(
                    blocks,
                    processes
            );
        }

        else if (choice == 3) {

            PlacementAlgorithms.worstFit(
                    blocks,
                    processes
            );
        }
    }


    public static void runReplacement(
            Scanner input,
            int choice) {

        int[] pages = readPages(input);

        System.out.print(
                "Enter number of frames: "
        );

        int numberOfFrames =
                input.nextInt();

        if (choice == 4) {

            ReplacementAlgorithms.fifo(
                    pages,
                    numberOfFrames
            );
        }

        else if (choice == 5) {

            ReplacementAlgorithms.lru(
                    pages,
                    numberOfFrames
            );
        }

        else if (choice == 6) {

            ReplacementAlgorithms.optimal(
                    pages,
                    numberOfFrames
            );
        }

        else if (choice == 7) {

            ReplacementAlgorithms.clock(
                    pages,
                    numberOfFrames
            );
        }
    }


    public static int[] readBlocks(
            Scanner input) {

        System.out.print(
                "Enter number of memory blocks: "
        );

        int numberOfBlocks =
                input.nextInt();

        int[] blocks =
                new int[numberOfBlocks];

        System.out.println(
                "Enter block sizes:"
        );

        for (int i = 0;
                i < numberOfBlocks;
                i++) {

            System.out.print(
                    "Block " + i + ": "
            );

            blocks[i] =
                    input.nextInt();
        }

        return blocks;
    }


    public static int[] readProcesses(
            Scanner input) {

        System.out.println();

        System.out.print(
                "Enter number of processes: "
        );

        int numberOfProcesses =
                input.nextInt();

        int[] processes =
                new int[numberOfProcesses];

        System.out.println(
                "Enter process sizes:"
        );

        for (int i = 0;
                i < numberOfProcesses;
                i++) {

            System.out.print(
                    "Process P" + i + ": "
            );

            processes[i] =
                    input.nextInt();
        }

        return processes;
    }


    public static int[] readPages(
            Scanner input) {

        System.out.print(
                "Enter number of page references: "
        );

        int numberOfPages =
                input.nextInt();

        int[] pages =
                new int[numberOfPages];

        System.out.println(
                "Enter page reference string:"
        );

        for (int i = 0;
                i < numberOfPages;
                i++) {

            pages[i] =
                    input.nextInt();
        }

        return pages;
    }
}
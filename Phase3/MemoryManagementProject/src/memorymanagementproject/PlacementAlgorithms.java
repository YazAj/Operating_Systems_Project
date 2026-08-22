package memorymanagementproject;

public class PlacementAlgorithms {

    public static void firstFit(int[] blocks, int[] processes) {

        int[] remainingBlocks = new int[blocks.length];

        for (int i = 0; i < blocks.length; i++) {
            remainingBlocks[i] = blocks[i];
        }

        System.out.println();
        System.out.println("========== FIRST FIT ==========");
        System.out.println();

        System.out.println("Process\tSize\tBlock");

        for (int i = 0; i < processes.length; i++) {

            boolean allocated = false;

            for (int j = 0; j < remainingBlocks.length; j++) {

                if (remainingBlocks[j] >= processes[i]) {

                    System.out.println(
                            "P" + i + "\t"
                            + processes[i] + "\t"
                            + "B" + j
                    );

                    remainingBlocks[j]
                            = remainingBlocks[j] - processes[i];

                    allocated = true;

                    break;
                }
            }

            if (allocated == false) {

                System.out.println(
                        "P" + i + "\t"
                        + processes[i] + "\t"
                        + "Not Allocated"
                );
            }
        }

        printMemoryMap(remainingBlocks);
    }


    public static void bestFit(int[] blocks, int[] processes) {

        int[] remainingBlocks = new int[blocks.length];

        for (int i = 0; i < blocks.length; i++) {
            remainingBlocks[i] = blocks[i];
        }

        System.out.println();
        System.out.println("========== BEST FIT ==========");
        System.out.println();

        System.out.println("Process\tSize\tBlock");

        for (int i = 0; i < processes.length; i++) {

            int bestBlock = -1;

            for (int j = 0; j < remainingBlocks.length; j++) {

                if (remainingBlocks[j] >= processes[i]) {

                    if (bestBlock == -1
                            || remainingBlocks[j]
                            < remainingBlocks[bestBlock]) {

                        bestBlock = j;
                    }
                }
            }

            if (bestBlock != -1) {

                System.out.println(
                        "P" + i + "\t"
                        + processes[i] + "\t"
                        + "B" + bestBlock
                );

                remainingBlocks[bestBlock]
                        = remainingBlocks[bestBlock]
                        - processes[i];

            } else {

                System.out.println(
                        "P" + i + "\t"
                        + processes[i] + "\t"
                        + "Not Allocated"
                );
            }
        }

        printMemoryMap(remainingBlocks);
    }


    public static void worstFit(int[] blocks, int[] processes) {

        int[] remainingBlocks = new int[blocks.length];

        for (int i = 0; i < blocks.length; i++) {
            remainingBlocks[i] = blocks[i];
        }

        System.out.println();
        System.out.println("========== WORST FIT ==========");
        System.out.println();

        System.out.println("Process\tSize\tBlock");

        for (int i = 0; i < processes.length; i++) {

            int worstBlock = -1;

            for (int j = 0; j < remainingBlocks.length; j++) {

                if (remainingBlocks[j] >= processes[i]) {

                    if (worstBlock == -1
                            || remainingBlocks[j]
                            > remainingBlocks[worstBlock]) {

                        worstBlock = j;
                    }
                }
            }

            if (worstBlock != -1) {

                System.out.println(
                        "P" + i + "\t"
                        + processes[i] + "\t"
                        + "B" + worstBlock
                );

                remainingBlocks[worstBlock]
                        = remainingBlocks[worstBlock]
                        - processes[i];

            } else {

                System.out.println(
                        "P" + i + "\t"
                        + processes[i] + "\t"
                        + "Not Allocated"
                );
            }
        }

        printMemoryMap(remainingBlocks);
    }


    public static void printMemoryMap(int[] remainingBlocks) {

    int totalFreeMemory = 0;
    int largestFreeBlock = 0;

    System.out.println();
    System.out.println("Memory Map After Allocation:");
    System.out.println();

    System.out.println("Block\tRemaining Memory");

    for (int i = 0; i < remainingBlocks.length; i++) {

        System.out.println(
                "B" + i + "\t" + remainingBlocks[i]
        );

        totalFreeMemory = totalFreeMemory + remainingBlocks[i];

        if (remainingBlocks[i] > largestFreeBlock) {

            largestFreeBlock = remainingBlocks[i];
        }
    }

    int externalFragmentation = totalFreeMemory - largestFreeBlock;

    System.out.println();

    System.out.println(
            "Total Free Memory = " + totalFreeMemory
    );

    System.out.println(
            "Internal Fragmentation = 0"
    );

    System.out.println(
            "External Fragmentation = " + externalFragmentation
    );
}
}
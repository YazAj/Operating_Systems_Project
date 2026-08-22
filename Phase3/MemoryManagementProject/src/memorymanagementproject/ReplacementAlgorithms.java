package memorymanagementproject;

public class ReplacementAlgorithms {

    public static void fifo(
            int[] pages,
            int numberOfFrames) {

        int[] frames = new int[numberOfFrames];

        for (int i = 0; i < numberOfFrames; i++) {
            frames[i] = -1;
        }

        int pageFaults = 0;
        int pageHits = 0;

        int nextFrame = 0;

        System.out.println();
        System.out.println("========== FIFO ==========");
        System.out.println();

        System.out.println("Page\tFrames\t\tResult");

        for (int i = 0; i < pages.length; i++) {

            int page = pages[i];

            boolean found = false;

            for (int j = 0; j < numberOfFrames; j++) {

                if (frames[j] == page) {
                    found = true;
                    break;
                }
            }

            if (found) {

                pageHits++;

            } else {

                pageFaults++;

                frames[nextFrame] = page;

                nextFrame++;

                if (nextFrame == numberOfFrames) {
                    nextFrame = 0;
                }
            }

            System.out.print(page + "\t");

            for (int j = 0; j < numberOfFrames; j++) {

                if (frames[j] == -1) {
                    System.out.print("- ");
                } else {
                    System.out.print(frames[j] + " ");
                }
            }

            if (found) {
                System.out.println("\t\tHit");
            } else {
                System.out.println("\t\tFault");
            }
        }

        double hitRatio =
                ((double) pageHits / pages.length) * 100;

        System.out.println();

        System.out.println(
                "Page Faults = " + pageFaults
        );

        System.out.println(
                "Page Hits = " + pageHits
        );

        System.out.printf(
                "Hit Ratio = %.2f%%%n",
                hitRatio
        );
    }


    public static void lru(
            int[] pages,
            int numberOfFrames) {

        int[] frames = new int[numberOfFrames];
        int[] lastUsed = new int[numberOfFrames];

        for (int i = 0; i < numberOfFrames; i++) {
            frames[i] = -1;
            lastUsed[i] = -1;
        }

        int pageFaults = 0;
        int pageHits = 0;

        System.out.println();
        System.out.println("========== LRU ==========");
        System.out.println();

        System.out.println("Page\tFrames\t\tResult");

        for (int i = 0; i < pages.length; i++) {

            int page = pages[i];
            int foundIndex = -1;

            // Check if page already exists
            for (int j = 0; j < numberOfFrames; j++) {

                if (frames[j] == page) {
                    foundIndex = j;
                    break;
                }
            }

            if (foundIndex != -1) {

                pageHits++;

                // Update last used time
                lastUsed[foundIndex] = i;

            } else {

                pageFaults++;

                int emptyFrame = -1;

                // Find empty frame
                for (int j = 0; j < numberOfFrames; j++) {

                    if (frames[j] == -1) {
                        emptyFrame = j;
                        break;
                    }
                }

                if (emptyFrame != -1) {

                    frames[emptyFrame] = page;
                    lastUsed[emptyFrame] = i;

                } else {

                    // Find least recently used frame
                    int lruFrame = 0;

                    for (int j = 1; j < numberOfFrames; j++) {

                        if (lastUsed[j] < lastUsed[lruFrame]) {
                            lruFrame = j;
                        }
                    }

                    frames[lruFrame] = page;
                    lastUsed[lruFrame] = i;
                }
            }

            System.out.print(page + "\t");

            for (int j = 0; j < numberOfFrames; j++) {

                if (frames[j] == -1) {
                    System.out.print("- ");
                } else {
                    System.out.print(frames[j] + " ");
                }
            }

            if (foundIndex != -1) {
                System.out.println("\t\tHit");
            } else {
                System.out.println("\t\tFault");
            }
        }

        double hitRatio =
                ((double) pageHits / pages.length) * 100;

        System.out.println();

        System.out.println(
                "Page Faults = " + pageFaults
        );

        System.out.println(
                "Page Hits = " + pageHits
        );

        System.out.printf(
                "Hit Ratio = %.2f%%%n",
                hitRatio
        );
    }


    public static void optimal(
            int[] pages,
            int numberOfFrames) {

        int[] frames = new int[numberOfFrames];

        for (int i = 0; i < numberOfFrames; i++) {
            frames[i] = -1;
        }

        int pageFaults = 0;
        int pageHits = 0;

        System.out.println();
        System.out.println("========== OPTIMAL ==========");
        System.out.println();

        System.out.println("Page\tFrames\t\tResult");

        for (int i = 0; i < pages.length; i++) {

            int page = pages[i];
            boolean found = false;

            // Check if page is already in memory
            for (int j = 0; j < numberOfFrames; j++) {

                if (frames[j] == page) {
                    found = true;
                    break;
                }
            }

            if (found) {

                pageHits++;

            } else {

                pageFaults++;

                int emptyFrame = -1;

                // Find empty frame
                for (int j = 0; j < numberOfFrames; j++) {

                    if (frames[j] == -1) {
                        emptyFrame = j;
                        break;
                    }
                }

                if (emptyFrame != -1) {

                    frames[emptyFrame] = page;

                } else {

                    int replaceFrame = -1;
                    int farthestUse = -1;

                    // Check future use of each page
                    for (int j = 0; j < numberOfFrames; j++) {

                        int nextUse = -1;

                        for (int k = i + 1; k < pages.length; k++) {

                            if (pages[k] == frames[j]) {
                                nextUse = k;
                                break;
                            }
                        }

                        // Page will never be used again
                        if (nextUse == -1) {

                            replaceFrame = j;
                            break;
                        }

                        // Find page used farthest in future
                        if (nextUse > farthestUse) {

                            farthestUse = nextUse;
                            replaceFrame = j;
                        }
                    }

                    frames[replaceFrame] = page;
                }
            }

            System.out.print(page + "\t");

            for (int j = 0; j < numberOfFrames; j++) {

                if (frames[j] == -1) {
                    System.out.print("- ");
                } else {
                    System.out.print(frames[j] + " ");
                }
            }

            if (found) {
                System.out.println("\t\tHit");
            } else {
                System.out.println("\t\tFault");
            }
        }

        double hitRatio =
                ((double) pageHits / pages.length) * 100;

        System.out.println();

        System.out.println(
                "Page Faults = " + pageFaults
        );

        System.out.println(
                "Page Hits = " + pageHits
        );

        System.out.printf(
                "Hit Ratio = %.2f%%%n",
                hitRatio
        );
    }


    public static void clock(
            int[] pages,
            int numberOfFrames) {

        int[] frames = new int[numberOfFrames];
        int[] referenceBit = new int[numberOfFrames];

        for (int i = 0; i < numberOfFrames; i++) {
            frames[i] = -1;
            referenceBit[i] = 0;
        }

        int pointer = 0;
        int pageFaults = 0;
        int pageHits = 0;

        System.out.println();
        System.out.println(
                "========== CLOCK / SECOND CHANCE =========="
        );
        System.out.println();

        System.out.println("Page\tFrames\t\tResult");

        for (int i = 0; i < pages.length; i++) {

            int page = pages[i];
            int foundIndex = -1;

            // Check if page is already in memory
            for (int j = 0; j < numberOfFrames; j++) {

                if (frames[j] == page) {
                    foundIndex = j;
                    break;
                }
            }

            if (foundIndex != -1) {

                pageHits++;

                // Give second chance
                referenceBit[foundIndex] = 1;

            } else {

                pageFaults++;

                while (referenceBit[pointer] == 1) {

                    referenceBit[pointer] = 0;

                    pointer++;

                    if (pointer == numberOfFrames) {
                        pointer = 0;
                    }
                }

                frames[pointer] = page;
                referenceBit[pointer] = 1;

                pointer++;

                if (pointer == numberOfFrames) {
                    pointer = 0;
                }
            }

            System.out.print(page + "\t");

            for (int j = 0; j < numberOfFrames; j++) {

                if (frames[j] == -1) {
                    System.out.print("- ");
                } else {
                    System.out.print(frames[j] + " ");
                }
            }

            if (foundIndex != -1) {
                System.out.println("\t\tHit");
            } else {
                System.out.println("\t\tFault");
            }
        }

        double hitRatio =
                ((double) pageHits / pages.length) * 100;

        System.out.println();

        System.out.println(
                "Page Faults = " + pageFaults
        );

        System.out.println(
                "Page Hits = " + pageHits
        );

        System.out.printf(
                "Hit Ratio = %.2f%%%n",
                hitRatio
        );
    }
}
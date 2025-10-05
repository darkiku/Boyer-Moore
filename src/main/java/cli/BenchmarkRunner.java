package cli;

import algorithms.BoyerMooreMajorityVote;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class BenchmarkRunner {
    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000, 100000};
        String outputPath = "docs/performance-data.csv";

        try (FileWriter writer = new FileWriter(outputPath)) {
            writer.write("n,time_ms,comparisons,array_accesses,memory_allocations,majority\n");

            for (int n : sizes) {
                int[] arr = generateArray(n);
                BoyerMooreMajorityVote algo = new BoyerMooreMajorityVote();

                long start = System.nanoTime();
                Integer result = algo.findMajority(arr);
                long end = System.nanoTime();

                double timeMs = (end - start) / 1e6;
                String summary = String.format(
                        "%d,%.3f,%d,%d,%d,%s\n",
                        n, timeMs,
                        algo.getTracker().getComparisons(),
                        algo.getTracker().getArrayAccesses(),
                        algo.getTracker().getMemoryAllocations(),
                        result == null ? "null" : result.toString()
                );

                writer.write(summary);
                System.out.printf("n=%d | time=%.3f ms | %s%n", n, timeMs, algo.getTracker().summary());
            }

            System.out.println("\nCSV saved to: " + outputPath);
        } catch (IOException e) {
            System.err.println("Error writing CSV: " + e.getMessage());
        }
    }

    private static int[] generateArray(int n) {
        Random r = new Random();
        int[] arr = new int[n];
        int majorityValue = r.nextInt(10);
        for (int i = 0; i < n; i++) {
            arr[i] = (r.nextDouble() < 0.55) ? majorityValue : r.nextInt(10);
        }
        return arr;
    }
}

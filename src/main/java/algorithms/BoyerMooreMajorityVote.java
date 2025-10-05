package algorithms;

import metrics.PerformanceTracker;

public class BoyerMooreMajorityVote {
    private final PerformanceTracker tracker = new PerformanceTracker();

    public Integer findMajority(int[] arr) {
        tracker.reset();
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }

        int candidate = 0, count = 0;
        for (int i = 0; i < arr.length; i++) {
            tracker.incrementArrayAccesses(1);
            if (count == 0) {
                candidate = arr[i];
                count = 1;
            } else if (arr[i] == candidate) {
                count++;
            } else {
                count--;
            }
            tracker.incrementComparisons(1);
        }

        int verifyCount = 0;
        for (int n : arr) {
            tracker.incrementArrayAccesses(1);
            if (n == candidate) verifyCount++;
            tracker.incrementComparisons(1);
        }

        return verifyCount > arr.length / 2 ? candidate : null;
    }

    public PerformanceTracker getTracker() {
        return tracker;
    }
}

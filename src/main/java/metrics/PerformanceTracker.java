package metrics;

public class PerformanceTracker {
    private long comparisons;
    private long arrayAccesses;
    private long memoryAllocations;

    public void incrementComparisons(long n) { comparisons += n; }
    public void incrementArrayAccesses(long n) { arrayAccesses += n; }
    public void incrementMemoryAllocations(long n) { memoryAllocations += n; }

    public void reset() {
        comparisons = 0;
        arrayAccesses = 0;
        memoryAllocations = 0;
    }

    public long getComparisons() { return comparisons; }
    public long getArrayAccesses() { return arrayAccesses; }
    public long getMemoryAllocations() { return memoryAllocations; }

    public String summary() {
        return String.format("Comparisons: %d, ArrayAccesses: %d, MemoryAllocations: %d",
                comparisons, arrayAccesses, memoryAllocations);
    }
}
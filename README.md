Overview

This project implements the Boyer–Moore Majority Vote algorithm, a linear-time solution for detecting whether an array contains a majority element — an element that appears more than ⌊n/2⌋ times.
The algorithm was proposed by Robert S. Boyer and J Strother Moore in 1981. It is widely recognized for its simplicity, efficiency, and constant memory usage.

How It Works
Candidate Selection
Traverse the array once.
Maintain a candidate and a count.
If count becomes zero, assign the current element as the new candidate.
Increase or decrease the count depending on whether the next element matches the candidate.

Verification Phase
Re-scan the array to verify that the chosen candidate actually appears more than ⌊n/2⌋ times.

Complexity
Aspect	Complexity	Description
Time	  O(n)	      Two linear passes through the array
Space  	O(1)	      Uses only a few integer variables



Testing and Benchmarking
Unit tests (JUnit) verify correctness for:
Empty arrays
Single-element arrays
Arrays with and without majority elements

The project also includes a BenchmarkRunner that measures:
Execution time (ms)
Number of comparisons
Array accesses
Memory allocations
Example result table:

<img width="1052" height="229" alt="image" src="https://github.com/user-attachments/assets/4ee814bf-5baa-4b08-abad-894017ff0ab4" />

Performance Graph
<img width="596" height="359" alt="image" src="https://github.com/user-attachments/assets/5b26136d-902f-43b9-b5d5-d79e448b9f09" />

The runtime grows linearly with input size, which confirms the theoretical Θ(n) complexity.


How to Run

Clone the repository:

git clone https://github.com/darkiku/Boyer-Moore.git


Open the project in IntelliJ IDEA or VS Code with Java extensions.

Run BenchmarkRunner.java or execute tests via Maven:

mvn test

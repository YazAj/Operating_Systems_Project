# Operating Systems Project

A complete Operating Systems project developed in **Java** using **Apache NetBeans**.

The project is divided into three main phases:

1. **Phase 1 - CPU Scheduling**
2. **Phase 2 - Deadlock Detection**
3. **Phase 3 - Memory Management**

Each phase includes its own source code, test data, implementation, and documentation.

---

## 📁 Project Structure

```text
Operating-Systems-Project-G1/
│
├── Phase-1-CPU-Scheduling/
│
├── Phase-2-Deadlock-Detection/
│
├── Phase-3-Memory-Management/
│
└── README.md
```

---

# Phase 1 - CPU Scheduling

Phase 1 focuses on implementing and comparing different **CPU Scheduling Algorithms**.

## Implemented Algorithms

- FCFS / FIFO
- Round Robin
- SPF / SJF Non-Preemptive
- SRT Preemptive

## Input Data

Each process contains:

- Process ID
- Arrival Time
- Burst Time

Round Robin also uses a:

- Time Quantum

## Calculated Metrics

The program calculates:

- Turnaround Time
- Waiting Time
- Response Time
- Average Turnaround Time
- Average Waiting Time
- Average Response Time

The program also displays the execution order and compares the performance of the scheduling algorithms.

## Main Files

```text
CPUProcess.java
CSVReader.java
FCFSScheduler.java
RoundRobinScheduler.java
SPFScheduler.java
SRTScheduler.java
SchedulingProject.java
```

## Dataset

A dataset containing **500 processes** is used for testing the scheduling algorithms.

---

# Phase 2 - Deadlock Detection

Phase 2 focuses on detecting deadlocks using the **Graph Reduction Algorithm**.

## Main Idea

The program checks whether each process can complete using the currently available resources.

If a process can complete:

1. The process is marked as finished.
2. Its allocated resources are released.
3. The available resources are updated.
4. The algorithm checks the remaining processes again.

If all processes finish:

```text
NO DEADLOCK
```

If some processes cannot finish:

```text
DEADLOCK DETECTED
```

The program also displays the IDs of the deadlocked processes.

## Data Structures

The implementation uses:

- Available Array
- Allocation Matrix
- Request Matrix
- Finish Array

## Test Cases

Two main test cases are included.

### Test Case 1 - No Deadlock

All processes can eventually complete and release their resources.

Expected result:

```text
NO DEADLOCK
```

### Test Case 2 - Deadlock

Some processes cannot continue because the required resources are unavailable.

Expected result:

```text
DEADLOCK DETECTED
```

## Main Files

```text
DeadlockProject.java
InputReader.java
DeadlockDetector.java
input_no_deadlock.txt
input_deadlock.txt
```

---

# Phase 3 - Memory Management

Phase 3 focuses on two important areas of Memory Management:

1. **Memory Placement Algorithms**
2. **Page Replacement Algorithms**

---

## Memory Placement Algorithms

The following algorithms are implemented:

### First Fit

Allocates each process to the **first memory block** that has enough free space.

### Best Fit

Allocates each process to the **smallest available block** that can hold it.

### Worst Fit

Allocates each process to the **largest available memory block**.

## Placement Output

The program displays:

- Process ID
- Process Size
- Allocated Block
- Not Allocated processes
- Memory Map after allocation
- Remaining Memory
- Total Free Memory
- Internal Fragmentation
- External Fragmentation

## Example Memory Blocks

```text
100
500
200
300
600
```

## Example Process Sizes

```text
212
417
112
426
```

---

## Page Replacement Algorithms

The following algorithms are implemented:

### FIFO

Replaces the page that entered memory first.

### LRU

Replaces the page that has not been used for the longest period of time.

### Optimal

Replaces the page whose next use is farthest in the future.

### Clock / Second Chance

Uses a circular pointer and reference bits to give recently used pages a second chance before replacement.

---

## Page Replacement Output

For every page reference, the program displays:

- Current Page
- Current Frames
- Hit or Fault

At the end, the program calculates:

- Page Faults
- Page Hits
- Hit Ratio

## Example Reference String

```text
7 0 1 2 0 3 0 4 2 3 0 3 2
```

Number of Frames:

```text
3
```

## Example Results

| Algorithm | Page Faults | Page Hits | Hit Ratio |
|---|---:|---:|---:|
| FIFO | 10 | 3 | 23.08% |
| LRU | 9 | 4 | 30.77% |
| Optimal | 7 | 6 | 46.15% |
| Clock / Second Chance | 9 | 4 | 30.77% |

---

## Phase 3 Menu

The program allows the user to run any algorithm separately or run all algorithms together.

```text
1. First Fit
2. Best Fit
3. Worst Fit
4. FIFO
5. LRU
6. Optimal
7. Clock / Second Chance
8. Run All
```

## Main Files

```text
MemoryManagementProject.java
PlacementAlgorithms.java
ReplacementAlgorithms.java
```

---

# 🛠 Technologies Used

- Java
- Apache NetBeans IDE
- Git
- GitHub
- CSV Files
- TXT Files
- Microsoft Word Documentation

---

# 🎯 Project Objectives

The main objective of this project is to understand and implement important Operating Systems concepts.

The project covers:

- CPU Scheduling
- Process Execution
- Turnaround Time
- Waiting Time
- Response Time
- Resource Allocation
- Deadlock Detection
- Graph Reduction
- Memory Allocation
- Memory Placement
- Memory Fragmentation
- Page Replacement
- Page Faults
- Page Hits

---



# 📄 Documentation

Each phase contains its own documentation file.

The documentation explains:

- Project Requirements
- Algorithm Concepts
- Implementation
- Source Code Structure
- Input Data
- Test Cases
- Program Output
- Results
- Algorithm Comparison
- Conclusion

Repository documentation includes:

```text
Phase 1 - CPU Scheduling Documentation
Phase 2 - Deadlock Detection Documentation
Phase 3 - Memory Management Documentation
```

---

# ▶️ How to Run

1. Open the required phase project using **Apache NetBeans**.
2. Clean and Build the project.
3. Run the main Java class.
4. Enter the requested input values.
5. View the algorithm execution in the console.
6. Review the final results.

---

# 📂 Repository Organization

```text
Operating-Systems-Project-G1/
│
├── Phase-1-CPU-Scheduling/
│   ├── Source Code
│   ├── Dataset
│   └── Documentation
│
├── Phase-2-Deadlock-Detection/
│   ├── Source Code
│   ├── Test Cases
│   └── Documentation
│
├── Phase-3-Memory-Management/
│   ├── Source Code
│   └── Documentation
│
└── README.md
```

---

# ✅ Project Status

| Phase | Topic | Status |
|---|---|---|
| Phase 1 | CPU Scheduling | ✅ Completed |
| Phase 2 | Deadlock Detection | ✅ Completed |
| Phase 3 | Memory Management | ✅ Completed |

---

# Final Result

All three phases were successfully implemented and tested.

```text
BUILD SUCCESSFUL
```

---

## Project Information

**Course:** Operating Systems  
**Programming Language:** Java  
**IDE:** Apache NetBeans  
**Number of Phases:** 3  
**Project Status:** Completed
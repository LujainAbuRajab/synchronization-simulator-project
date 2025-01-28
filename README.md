# :card_file_box: **Synchronization Simulator Project**

The **Synchronization Simulator Project** is designed to demonstrate and compare the effects of synchronization on shared data accessed by multiple concurrent threads. 
This project explores how synchronization mechanisms can ensure data consistency in a multithreaded environment.


---

## :white_medium_square: **Objectives**

+ Simulate a multithreaded system where producer and consumer threads modify a shared variable.
+ Compare the results with and without synchronization.
+ Highlight the importance of synchronization tools like semaphores in managing access to critical sections.

---

## :white_medium_square: **Features**

+ **Programming Language:** `Java`
+ **Core Classes:**
    - `Data`: Manages the shared variable.
    - `Producer`: Implements producer threads to increment the shared variable.
    - `Consumer`: Implements consumer threads to decrement the shared variable.
    - `OS`: Simulates the system without synchronization.
    - `OSWithSync`: Simulates the system with synchronization using semaphores.
    
+ **Thread Management:**
    - Randomized number of threads => `producers` and `consumers`.
      
     ![Producer-Consumer Workflow](https://github.com/LujainAbuRajab/synchronization-simulator-projectt/blob/cafdb83553a9595cc9ada991ef5870b4410f4847/Producer-Consumer%20Workflow.jpg)
    - Controlled operations ensuring adherence to conditions:
        - Shared variable `X` starts at `1000`.
        - Producers increment `X` but stop if it exceeds `1800`.
        - Consumers decrement `X` but stop if it drops below `0`.

---

## :white_medium_square: **How It Works**
1. **Without Synchronization:**
    - Producer and consumer threads access the shared variable concurrently without any synchronization.
    - Results vary depending on the order of thread execution.    
2. **With Synchronization:**
    - Semaphore-based synchronization ensures that only one thread accesses the shared variable at a time.
    - Results are consistent and adhere to the defined conditions.      
3. **Execution Flow:**
    - Randomized thread generation with random numbers of operations.
    - Results are displayed for both synchronized and non-synchronized executions.

---

## :white_medium_square: **Implementation**
### Classes and Responsibilities
1. `Data`:
    - Defines the shared variable `X`.
    - Initializes `X` to 1000.
      
2. `Producer`:
    - Implements threads that increment the shared variable.
    - Ensures `X` does not exceed 1800.
      
3. `Consumer`:
    - Implements threads that decrement the shared variable.
    - Ensures `X` does not fall below 0.
      
4. `OS`:
   - Runs producer and consumer threads without synchronization.
   - Displays results showcasing inconsistencies caused by thread interference.
  
5. `OSWithSync`:
    - Uses semaphores (`acquire` and `release` methods) to synchronize thread access.
    - Ensures consistent results regardless of thread execution order.
      
> [!NOTE]
> for more detailed info you can read [the project Report](https://github.com/LujainAbuRajab/synchronization-simulator-projectt/blob/cafdb83553a9595cc9ada991ef5870b4410f4847/Synchronization%20Simulator%20progict%20Report.pdf)

---

## :clipboard: **Results**
### Without Synchronization
  - Results depend heavily on the order of thread execution.
  - Shared variable X often deviates from expected values due to race conditions.
    
### Without Synchronization
  - Results are consistent and align with the conditions set for the shared variable.
  - Demonstrates the effectiveness of semaphore-based synchronization.

---
## :bulb: **Learning Outcomes**
  - Understand the impact of synchronization in multithreaded systems.
  - Analyze the behavior of shared data with and without synchronization tools.
  - Gain hands-on experience with Java threads and semaphore mechanisms.

    

# Day 06 - ConcurrentHashMap & AtomicInteger

## Objective

Understand how to safely manage shared mutable data when multiple threads access and modify it concurrently.

In this exercise, multiple threads simulate employee access and update the access count concurrently.

---

## Project Structure

```text
Day06
└── src
    └── main
        └── java
            └── com
                └── sanidhya
                    └── day06
                        ├── Main.java
                        │
                        ├── model
                        │   └── Employee.java
                        │
                        ├── service
                        │   ├── AccessService.java
                        │   ├── EmployeeAccessService.java
                        │   └── UnsafeEmployeeAccessService.java
                        │
                        └── task
                            └── AccessTask.java
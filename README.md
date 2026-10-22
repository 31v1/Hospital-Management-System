# Hospital-Management-System

🏥 Hospital & Patient Management – Stack & Queue (GUI Version)

A Java Swing application developed as part of the Data Structures course at UNED. This project implements a **Stack (LIFO)** for hospital registration and a **Queue (FIFO)** for patient management per hospital — using only fixed-size arrays and object references, with **no Java Collections** — applying all core operations through a clean layered architecture and a fully graphical interface.

🚀 Features

Hospital Registration (Stack – LIFO):
- Auto-generated consecutive ID starting at 1 (non-editable by the user)
- Register hospitals with name only
- Stored in a fixed-size array of 20 `Hospital` objects
- Array behaves strictly as a **Stack (LIFO)**
- Graphical table auto-updates after every operation
- Full-stack validation: no insertion allowed when full, with message shown in the GUI

Patient Registration (Queue per hospital – FIFO):
- Auto-generated consecutive ID starting at 1 (non-editable)
- User must select a hospital before registering a patient
- Fields: name and attention type (Consulta, Emergencia, Cirugía)
- Each hospital has its own fixed-size array of 20 patients
- Structure behaves strictly as a **Queue (FIFO)**
- Validation: hospital must be selected before registering

Patient Deletion (FIFO):
- Automatically removes the **first** registered patient (FIFO)
- Manual selection of which patient to delete is **not allowed**
- Blocked with message when the queue is empty
- Table auto-updates after deletion

Patient Transfer (between hospitals):
- Transfers **all** patients from an origin hospital to a destination hospital
- Mandatory validations:
  - At least 2 hospitals must exist
  - Origin hospital must have patients
  - Origin and destination must be different
  - Destination queue must have enough capacity for all transferred patients
- Transfer respects **FIFO order**
- Origin queue is left empty; destination preserves correct order
- Transferred patients receive **new consecutive IDs** according to the destination queue (to avoid duplicates)
- If destination lacks capacity, the transfer is **not performed** and a message is shown in the GUI

Hospital Deletion (LIFO):
- Only the **last added** hospital is deleted (LIFO)
- Deletion only allowed if its patient queue is empty
- Blocked with message if it still has patients
- Table auto-updates after deletion

🛠️ Technologies

- Java (NetBeans IDE)
- Java Swing (GUI, no console mode)
- Fixed-size arrays as Stack and Queue (no ArrayList, Queue, or any Java Collections)
- Object-oriented layered architecture (models → logic → GUI)
- Input validation (empty fields, capacity limits, queue/stack states)
- MessageBox used **only** for validations and error messages (never for success or data input)

🎯 Learning Outcomes

This project demonstrates:

- Implementing a Stack (LIFO) and a Queue (FIFO) from scratch using only fixed-size arrays and references
- Managing per-hospital queues within a global stack of hospitals
- Applying capacity and state validations (stack full/empty, queue full/empty, destination capacity)
- Designing a layered architecture (models → logic → GUI)
- Building a fully graphical Java Swing interface without console input
- Enforcing business rules such as FIFO transfer with ID reassignment and LIFO deletion restricted to empty queues
- Handling edge cases and mandatory validations required by the course rubric

👩‍💻 Author: Elvia Sanchez Leiva 📚 Course: Data Structures – UNE

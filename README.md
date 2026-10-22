# Hospital-Management-System

Sistema-Salud

🏥 Hospital & Patient Management – Stack & Queue (GUI Version)

A Java Swing application developed as part of the Data Structures course at UNED. This project implements a **Stack (LIFO)** for hospital registration and a **Queue (FIFO)** for patient management per hospital — using only fixed-size arrays and object references, with **no Java Collections** — applying a clean layered architecture with graphical interfaces for every operation.

🚀 Features

Hospital Management (Stack – LIFO):
- Auto-generated consecutive ID starting at 1 (non-editable by the user)
- Register hospitals with name only
- Stored in a fixed-size array of 20 `Hospital` objects
- Array behaves strictly as a **Stack (LIFO)**
- Graphical table auto-updates after every operation
- Full-stack validation: no insertion allowed when full, with message shown in the GUI
- LIFO deletion: only the last added hospital can be deleted, and only if its patient queue is empty

Patient Management (Queue per hospital – FIFO):
- Auto-generated consecutive ID starting at 1 (non-editable)
- User must select a hospital before registering a patient
- Fields: name and attention type (Consulta, Emergencia, Cirugía)
- Each hospital has its own fixed-size array of 20 patients
- Structure behaves strictly as a **Queue (FIFO)**
- FIFO deletion: automatically removes the first registered patient
- Validation: hospital must be selected before registering or deleting

Patient Transfer (between hospitals):
- Transfers **all** patients from an origin hospital to a destination hospital
- Mandatory validations:
  - At least 2 hospitals must exist
  - Origin hospital must have patients
  - Origin and destination must be different
  - Destination queue must have enough capacity for all transferred patients
- Transfer respects **FIFO order**
- Origin queue is left empty; destination preserves correct order
- Transferred patients receive **new consecutive IDs** according to the destination queue
- If destination lacks capacity, the transfer is **not performed** and a message is shown in the GUI

🛠️ Technologies

- Java (NetBeans IDE)
- Java Swing (GUI, multiple dedicated windows per operation)
- Fixed-size arrays as Stack and Queue (no ArrayList, Queue, or any Java Collections)
- Object-oriented layered architecture (models → logic/validations → GUI)
- Input validation with regular expressions and custom logic
- MessageBox used **only** for validations and error messages

📂 Project Structure

Paciente.java → patient model: id, name, attention type
Hospital.java → hospital model: id, name, and its own patient queue
TipoAtencion.java → enum or constants for attention types (Consulta, Emergencia, Cirugía)
ColaPacientes.java → FIFO queue implementation using a circular array of size 20
PilaHospitales.java → LIFO stack implementation using a fixed-size array of size 20
GestorHospitales.java → bridges the GUI and the data structures; coordinates logic and returns success/error messages
Validaciones.java → standalone validations (empty fields, ID generation, capacity checks)
Main.java → entry point of the application
VentanaPrincipal.java → main menu/dashboard
VentanaRegistroHospital.java → GUI for registering hospitals
VentanaEliminacionHospital.java → GUI for LIFO hospital deletion
VentanaRegistroPacientes.java → GUI for registering patients in a selected hospital
VentanaEliminacionPaciente.java → GUI for FIFO patient deletion
VentanaTraslados.java → GUI for transferring patients between hospitals

📊 Example Outputs

Hospital Stack (LIFO):
| ID | Nombre           | Pacientes |
|----|------------------|-----------|
| 3  | Hospital San Juan| 2         |
| 2  | Hospital México  | 0         |
| 1  | Hospital Central | 5         |

Patient Queue (FIFO) – Hospital San Juan:
| ID | Nombre       | Tipo Atención |
|----|--------------|---------------|
| 1  | Ana Mora     | Emergencia    |
| 2  | Luis Rojas   | Consulta      |

🎯 Learning Outcomes

This project demonstrates:

- Implementing a Stack (LIFO) and a Queue (FIFO) from scratch using only fixed-size arrays and references
- Managing per-hospital queues within a global stack of hospitals
- Applying capacity and state validations (stack full/empty, queue full/empty, destination capacity)
- Designing a layered architecture (models → logic → validations → GUI)
- Building a fully graphical Java Swing interface with dedicated windows for each operation
- Enforcing business rules such as FIFO transfer with ID reassignment and LIFO deletion restricted to empty queues
- Handling edge cases and mandatory validations required by the course rubric


👩‍💻 Author: Elvia Sanchez Leiva 📚 Course: Data Structures – UNE

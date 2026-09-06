package hospital;

import java.util.LinkedList;
import java.util.Queue;

public class EmergencyQueue {

    Queue<Patient> queue = new LinkedList<>();

    // Add patient to the queue
    public void enqueue(Patient patient) {
        queue.add(patient);
    }

    // Remove the first patient
    public Patient dequeue() {

        if (queue.isEmpty()) {
            return null;
        }

        return queue.poll();
    }

    // View the first patient
    public Patient peek() {

        if (queue.isEmpty()) {
            return null;
        }

        return queue.peek();
    }

    // Display all waiting patients
    public void displayQueue() {

        if (queue.isEmpty()) {
            System.out.println("No patients are waiting.");
            return;
        }

        for (Patient patient : queue) {

            System.out.println(
                "ID: " + patient.patientId +
                ", Name: " + patient.patientName +
                ", Age: " + patient.age +
                ", Contact: " + patient.contactNumber +
                ", Condition: " + patient.medicalCondition
            );
        }
    }

    // Check whether the queue is empty
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
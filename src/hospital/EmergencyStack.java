package hospital;

import java.util.Stack;

public class EmergencyStack {

    Stack<Patient> stack = new Stack<>();

    // Push - Add completed treatment record
    public void push(Patient patient) {
        stack.push(patient);
    }

    // Pop - Remove most recently completed treatment record
    public Patient pop() {

        if (stack.isEmpty()) {
            return null;
        }

        return stack.pop();
    }

    // Peek - View the top treatment record
    public Patient peek() {

        if (stack.isEmpty()) {
            return null;
        }

        return stack.peek();
    }

    // Display all treatment records
    public void displayStack() {

        if (stack.isEmpty()) {
            System.out.println("No treatment records available.");
            return;
        }

        for (int i = stack.size() - 1; i >= 0; i--) {

            Patient patient = stack.get(i);

            System.out.println(
                "ID: " + patient.patientId +
                ", Name: " + patient.patientName +
                ", Age: " + patient.age +
                ", Contact: " + patient.contactNumber +
                ", Condition: " + patient.medicalCondition
            );
        }
    }

    // Check whether stack is empty
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
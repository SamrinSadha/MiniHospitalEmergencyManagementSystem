package hospital;

public class Main {

    public static void main(String[] args) {

        System.out.println("Mini Hospital Emergency Management System");


        // =========================
        // CREATE PATIENTS
        // =========================

        Patient patient1 = new Patient(
                101, "Kamal", 25, "0771234567", "Fever"
        );

        Patient patient2 = new Patient(
                105, "Nimal", 40, "0712345678", "Heart Pain"
        );

        Patient patient3 = new Patient(
                103, "Saman", 32, "0756789012", "Injury"
        );


        // =========================
        // 1. BINARY SEARCH TREE
        // =========================

        PatientBST patientBST = new PatientBST();

        patientBST.insert(patient1);
        patientBST.insert(patient2);
        patientBST.insert(patient3);

        System.out.println("\nPatients in BST:");

        patientBST.inorder();


        // =========================
        // BST SEARCH
        // =========================

        Patient foundPatient = patientBST.search(103);

        System.out.println("\nSearching Patient ID 103:");

        if (foundPatient != null) {
            System.out.println(
                    "Patient Found: " + foundPatient.patientName
            );
        } else {
            System.out.println("Patient Not Found");
        }


        // =========================
        // BST DELETE
        // =========================

        patientBST.delete(105);

        System.out.println("\nAfter Deleting Patient ID 105:");

        patientBST.inorder();


        // =========================
        // 2. EMERGENCY QUEUE
        // =========================

        EmergencyQueue emergencyQueue = new EmergencyQueue();

        emergencyQueue.enqueue(patient1);
        emergencyQueue.enqueue(patient2);
        emergencyQueue.enqueue(patient3);

        System.out.println("\nEmergency Queue - Waiting Patients:");

        emergencyQueue.displayQueue();


        Patient firstPatient = emergencyQueue.dequeue();

        if (firstPatient != null) {
            System.out.println(
                    "\nTreated Patient: " + firstPatient.patientName
            );
        } else {
            System.out.println("\nNo patient available for treatment.");
        }


        Patient nextPatient = emergencyQueue.peek();

        if (nextPatient != null) {
            System.out.println(
                    "Next Patient: " + nextPatient.patientName
            );
        } else {
            System.out.println("No patients are waiting.");
        }


        System.out.println(
                "Queue Empty: " + emergencyQueue.isEmpty()
        );


        // =========================
        // 3. EMERGENCY STACK
        // =========================

        EmergencyStack emergencyStack = new EmergencyStack();

        emergencyStack.push(patient1);
        emergencyStack.push(patient2);
        emergencyStack.push(patient3);

        System.out.println("\nEmergency Stack - Treatment Records:");

        emergencyStack.displayStack();


        Patient topPatient = emergencyStack.peek();

        if (topPatient != null) {
            System.out.println(
                    "\nTop Patient: " + topPatient.patientName
            );
        } else {
            System.out.println("\nStack is empty.");
        }


        Patient removedPatient = emergencyStack.pop();

        if (removedPatient != null) {
            System.out.println(
                    "Removed Patient: " + removedPatient.patientName
            );
        } else {
            System.out.println("No treatment record to remove.");
        }


        System.out.println(
                "Stack Empty: " + emergencyStack.isEmpty()
        );


        // =========================
        // 4. PATIENT VISIT HISTORY
        // =========================

        PatientLinkedList visitHistory = new PatientLinkedList();


        // Create visits

        Visit visit1 = new Visit(
                1,
                "2026-09-01",
                "Dr. Perera",
                "Fever",
                "Medication"
        );

        Visit visit2 = new Visit(
                2,
                "2026-09-03",
                "Dr. Silva",
                "Headache",
                "Pain Relief"
        );

        Visit visit3 = new Visit(
                3,
                "2026-09-05",
                "Dr. Fernando",
                "Injury",
                "Wound Treatment"
        );


        // Add visits

        visitHistory.addVisit(visit1);
        visitHistory.addVisit(visit2);
        visitHistory.addVisit(visit3);


        // Display visit history

        System.out.println("\nPatient Visit History:");

        visitHistory.displayVisitHistory();


        // =========================
        // SEARCH VISIT
        // =========================

        Visit foundVisit = visitHistory.searchVisit(2);

        System.out.println("\nSearching Visit ID 2:");

        if (foundVisit != null) {
            System.out.println(
                    "Visit Found: " +
                    foundVisit.doctorName +
                    " - " +
                    foundVisit.diagnosis
            );
        } else {
            System.out.println("Visit Not Found");
        }


        // =========================
        // REMOVE VISIT
        // =========================

        visitHistory.removeVisit(2);

        System.out.println("\nAfter Removing Visit ID 2:");

        visitHistory.displayVisitHistory();
    }
}
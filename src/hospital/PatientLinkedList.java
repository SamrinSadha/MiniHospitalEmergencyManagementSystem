package hospital;

public class PatientLinkedList {

    class Node {
        Visit visit;
        Node next;

        Node(Visit visit) {
            this.visit = visit;
            this.next = null;
        }
    }

    Node head;

    // Add a new visit
    public void addVisit(Visit visit) {

        Node newNode = new Node(visit);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    // Remove a visit by Visit ID
    public void removeVisit(int visitId) {

        if (head == null) {
            return;
        }

        if (head.visit.visitId == visitId) {
            head = head.next;
            return;
        }

        Node current = head;

        while (current.next != null) {

            if (current.next.visit.visitId == visitId) {
                current.next = current.next.next;
                return;
            }

            current = current.next;
        }
    }

    // Search for a visit by Visit ID
    public Visit searchVisit(int visitId) {

        Node current = head;

        while (current != null) {

            if (current.visit.visitId == visitId) {
                return current.visit;
            }

            current = current.next;
        }

        return null;
    }

    // Display all visit history
    public void displayVisitHistory() {

        if (head == null) {
            System.out.println("No visit history available.");
            return;
        }

        Node current = head;

        while (current != null) {

            System.out.println(
                "Visit ID: " + current.visit.visitId +
                ", Date: " + current.visit.visitDate +
                ", Doctor: " + current.visit.doctorName +
                ", Diagnosis: " + current.visit.diagnosis +
                ", Treatment: " + current.visit.treatment
            );

            current = current.next;
        }
    }
}
package hospital;

public class PatientBST {

    PatientNode root;

    // Insert a patient
    public void insert(Patient patient) {
        root = insertRecursive(root, patient);
    }

    // Recursive insert
    private PatientNode insertRecursive(PatientNode current, Patient patient) {

        if (current == null) {
            return new PatientNode(patient);
        }

        if (patient.patientId < current.patient.patientId) {
            current.left = insertRecursive(current.left, patient);

        } else if (patient.patientId > current.patient.patientId) {
            current.right = insertRecursive(current.right, patient);
        }

        return current;
    }

    // Search a patient by ID
    public Patient search(int patientId) {

        PatientNode current = root;

        while (current != null) {

            if (patientId == current.patient.patientId) {
                return current.patient;
            }

            if (patientId < current.patient.patientId) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return null;
    }

    // Delete a patient by ID
    public void delete(int patientId) {
        root = deleteRecursive(root, patientId);
    }

    // Recursive delete
    private PatientNode deleteRecursive(PatientNode current, int patientId) {

        if (current == null) {
            return null;
        }

        if (patientId < current.patient.patientId) {

            current.left = deleteRecursive(current.left, patientId);

        } else if (patientId > current.patient.patientId) {

            current.right = deleteRecursive(current.right, patientId);

        } else {

            // Case 1: No child
            if (current.left == null && current.right == null) {
                return null;
            }

            // Case 2: Only right child
            if (current.left == null) {
                return current.right;
            }

            // Case 3: Only left child
            if (current.right == null) {
                return current.left;
            }

            // Case 4: Two children
            PatientNode smallestNode = findSmallestNode(current.right);

            current.patient = smallestNode.patient;

            current.right = deleteRecursive(
                    current.right,
                    smallestNode.patient.patientId
            );
        }

        return current;
    }

    // Find the smallest node
    private PatientNode findSmallestNode(PatientNode root) {

        PatientNode current = root;

        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    // Display patients in ascending order
    public void inorder() {
        inorderRecursive(root);
    }

    private void inorderRecursive(PatientNode current) {

        if (current != null) {

            inorderRecursive(current.left);

            System.out.println(
                "ID: " + current.patient.patientId +
                ", Name: " + current.patient.patientName +
                ", Age: " + current.patient.age +
                ", Contact: " + current.patient.contactNumber +
                ", Condition: " + current.patient.medicalCondition
            );

            inorderRecursive(current.right);
        }
    }
}
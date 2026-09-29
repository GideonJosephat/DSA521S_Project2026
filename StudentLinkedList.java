public class StudentLinkedList {

    private Node head;

    private class Node {
        Student student;
        Node next;

        Node(Student student) {
            this.student = student;
            this.next = null;
        }
    }

    public void insertAtBeginning(Student student) {

        Node newNode = new Node(student);

        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd(Student student) {

        Node newNode = new Node(student);

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

    public void insertStudent(Student student, int position) {

        if (position <= 1) {
            insertAtBeginning(student);
            return;
        }

        Node newNode = new Node(student);

        Node current = head;

        int count = 1;

        while (current != null
                && count < position - 1) {

            current = current.next;
            count++;
        }

        if (current == null) {
            insertAtEnd(student);
            return;
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    public boolean deleteStudent(int studentNo) {

        if (head == null) {
            return false;
        }

        if (head.student.getStudentNumber() == studentNo) {
            head = head.next;
            return true;
        }

        Node current = head;

        while (current.next != null
                && current.next.student.getStudentNumber() != studentNo) {

            current = current.next;
        }

        if (current.next == null) {
            return false;
        }

        current.next = current.next.next;
        return true;
    }
    public void displayList() {
            Node current = head;
            if (current == null) {
                System.out.println("The list is empty.");
                return;
            }
            while (current != null) {
                System.out.println(current.student);
                current = current.next;
            }
        }
        // Method to search for a student by their ID number
    public Student searchStudent(int studentNumber) {
        Node current = head;
        while (current != null) {
            if (current.student.getStudentNumber() == studentNumber) {
                return current.student;
            }
            current = current.next;
        }
        return null; 
    }
    }

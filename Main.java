class Student {
    private int studentNumber;
    private String name;
    private String serviceType;
    private int waitingTime;

    public Student(int studentNumber, String name, String serviceType, int waitingTime) {
        this.studentNumber = studentNumber;
        this.name = name;
        this.serviceType = serviceType;
        this.waitingTime = waitingTime;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public String getName() {
        return name;
    }

    public String getServiceType() {
        return serviceType;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }
}

class StudentQueue {
    private Student[] queue;
    private int front;
    private int rear;
    private int size;

    public StudentQueue(int capacity) {
        queue = new Student[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == queue.length;
    }

    public void enqueue(Student student) {
        if (isFull()) {
            System.out.println("Queue is full.");
            return;
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = student;
        size++;
    }

    public Student dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return null;
        }
        Student student = queue[front];
        queue[front] = null;
        front = (front + 1) % queue.length;
        size--;

        if (size == 0) {
            front = 0;
            rear = -1;
        }

        return student;
    }

    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        int index = front;
        for (int i = 0; i < size; i++) {
            Student student = queue[index];
            System.out.println("Student ID: " + student.getStudentNumber() + ", Name: " + student.getName() + ", Service: " + student.getServiceType());
            index = (index + 1) % queue.length;
        }
    }
}

class StudentLinkedList {
    private Node head;

    private static class Node {
        private Student student;
        private Node next;

        Node(Student student) {
            this.student = student;
            this.next = null;
        }
    }

    public StudentLinkedList() {
        head = null;
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
        if (position <= 1 || head == null) {
            insertAtBeginning(student);
            return;
        }

        Node newNode = new Node(student);
        Node current = head;
        for (int i = 1; i < position - 1 && current.next != null; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    public void displayList() {
        Node current = head;
        if (current == null) {
            System.out.println("List is empty.");
            return;
        }
        while (current != null) {
            Student student = current.student;
            System.out.println("ID: " + student.getStudentNumber() + ", Name: " + student.getName() + ", Service: " + student.getServiceType() + ", Wait: " + student.getWaitingTime() + " minutes");
            current = current.next;
        }
    }

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

    public void deleteStudent(int studentNumber) {
        if (head == null) {
            return;
        }

        if (head.student.getStudentNumber() == studentNumber) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.student.getStudentNumber() != studentNumber) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }
}

class PostfixStack {
    public static int evaluatePostfix(String expression) {
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            if (token.matches("-?\\d+")) {
                stack.push(Integer.parseInt(token));
            } else {
                int right = stack.pop();
                int left = stack.pop();

                switch (token) {
                    case "+":
                        stack.push(left + right);
                        break;
                    case "-":
                        stack.push(left - right);
                        break;
                    case "*":
                        stack.push(left * right);
                        break;
                    case "/":
                        stack.push(left / right);
                        break;
                    default:
                        throw new IllegalArgumentException("Unsupported operator: " + token);
                }
            }
        }

        return stack.pop();
    }
}

class ArrayStatistics {
    public static void displayStatistics(int[] values) {
        if (values == null || values.length == 0) {
            System.out.println("No values available.");
            return;
        }

        int min = values[0];
        int max = values[0];
        int total = 0;

        for (int value : values) {
            total += value;
            if (value < min) {
                min = value;
            }
            if (value > max) {
                max = value;
            }
        }

        double average = (double) total / values.length;
        System.out.println("Minimum: " + min);
        System.out.println("Maximum: " + max);
        System.out.println("Average: " + average);
        System.out.println("Total: " + total);
    }
}

class SortingAlgorithms {
    public static void selectionSort(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = data[i];
                data[i] = data[minIndex];
                data[minIndex] = temp;
            }
        }
    }

    public static void insertionSort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            int key = data[i];
            int j = i - 1;
            while (j >= 0 && data[j] > key) {
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = key;
        }
    }

    public static void displayArray(int[] data) {
        for (int value : data) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}

public class Main {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("CAMPUS SERVICE CENTRE TEST");
        System.out.println("=================================");

        Student maria =
                new Student(221045678,
                        "Maria",
                        "Registration",
                        12);

        Student tomas =
                new Student(222034512,
                        "Tomas",
                        "Student Card",
                        5);

        Student ndapewa =
                new Student(223041876,
                        "Ndapewa",
                        "Fees",
                        8);

        Student simon =
                new Student(221067341,
                        "Simon",
                        "Documents",
                        4);

        Student aina =
                new Student(224000001,
                        "Aina",
                        "Academic",
                        7);

        Student brian =
                new Student(224000002,
                        "Brian",
                        "Documents",
                        15);

        // QUEUE

        System.out.println("\nQUEUE DEMO");

        StudentQueue queue =
                new StudentQueue(10);

        queue.enqueue(maria);
        queue.enqueue(tomas);
        queue.enqueue(ndapewa);
        queue.enqueue(simon);
        queue.enqueue(aina);
        queue.enqueue(brian);

        System.out.println("\nAfter 6 arrivals:");
        queue.displayQueue();

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        System.out.println("\nAfter 3 students served:");
        queue.displayQueue();

        // LINKED LIST

        System.out.println("\nLINKED LIST DEMO");

        StudentLinkedList list =
                new StudentLinkedList();

        list.insertAtBeginning(maria);

        list.insertAtEnd(tomas);

        list.insertStudent(
                ndapewa,
                2);

        list.insertAtEnd(simon);

        list.displayList();

        System.out.println("\nSearch Student:");

        Student found = list.searchStudent(223041876);

        if (found != null) {
            System.out.println("Student found:");
            System.out.println("ID: " + found.getStudentNumber());
            System.out.println("Name: " + found.getName());
            System.out.println("Service Type: " + found.getServiceType());
            System.out.println("Waiting Time: " + found.getWaitingTime() + " minutes");
        } else {
            System.out.println("Student not found.");
        }

        System.out.println("\nDelete Student:");

        list.deleteStudent(
                222034512);

        list.displayList();

        // STACK

        System.out.println("\nPOSTFIX STACK");

        int result =
                PostfixStack.evaluatePostfix(
                        "5 3 + 2 *");

        System.out.println(
                "Final Result = "
                        + result);

        // ARRAY

        System.out.println(
                "\nARRAY STATISTICS");

        int[] serviceTimes =
                {12, 5, 8, 4, 7, 15};

        ArrayStatistics.displayStatistics(
                serviceTimes);

        // SORTING

        System.out.println(
                "\nSELECTION SORT");

        int[] data1 =
                {17, 5, 23, 8, 14,
                        3, 11, 20, 6, 9};

        SortingAlgorithms.selectionSort(
                data1);

        SortingAlgorithms.displayArray(
                data1);

        System.out.println(
                "\nINSERTION SORT");

        int[] data2 =
                {17, 5, 23, 8, 14,
                        3, 11, 20, 6, 9};

        SortingAlgorithms.insertionSort(
                data2);

        SortingAlgorithms.displayArray(
                data2);

        System.out.println(
                "\nPROGRAM COMPLETE");
    }
}

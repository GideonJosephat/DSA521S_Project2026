public class Student {

    private int studentNo;
    private String name;
    private String serviceType;
    private int estimatedServiceTime;

    public Student(int studentNo, String name,
                   String serviceType,
                   int estimatedServiceTime) {

        this.studentNo = studentNo;
        this.name = name;
        this.serviceType = serviceType;
        this.estimatedServiceTime = estimatedServiceTime;
    }

    public int getStudentNo() {
        return studentNo;
    }

    public String getName() {
        return name;
    }

    public String getServiceType() {
        return serviceType;
    }

    public int getEstimatedServiceTime() {
        return estimatedServiceTime;
    }

    @Override
    public String toString() {
        return studentNo + " | "
                + name + " | "
                + serviceType + " | "
                + estimatedServiceTime + " min";
    }
    // Getter method for student number
    public int getStudentNumber() {
        return this.studentNo;
    }
    // Getter method for waiting time
    public int getWaitingTime() {
        return this.estimatedServiceTime;
    }
}

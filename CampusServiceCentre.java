public class CampusServiceCentre {
    static int[] serviceTimes = {35, 15, 8, 20, 12, 18, 6, 25, 10, 14};

    public static void main(String[] args) {
        displayStatistics();
    }

    static void displayStatistics() {
    if (serviceTimes == null || serviceTimes.length == 0) {
        System.out.println("\nDaily Statistics");
        System.out.println("No service data available.");
        return;
    }

    int total = 0;
    int highest = serviceTimes[0];
    int lowest = serviceTimes[0];
    int overTen = 0;

    for (int i = 0; i < serviceTimes.length; i++) {

        total += serviceTimes[i];

        if (serviceTimes[i] > highest) {
            highest = serviceTimes[i];
        }

        if (serviceTimes[i] < lowest) {
            lowest = serviceTimes[i];
        }

        if (serviceTimes[i] > 10) {
            overTen++;
        }
    }

    double average = (double) total / serviceTimes.length;

    System.out.println("\nDaily Statistics");
    System.out.println("Total Students Served: " + serviceTimes.length);
    System.out.println("Total Service Time: " + total);
    System.out.printf("Average Service Time: %.2f%n", average);
    System.out.println("Highest Service Time: " + highest);
    System.out.println("Lowest Service Time: " + lowest);
    System.out.println("Services >10 Minutes: " + overTen);
    }
}

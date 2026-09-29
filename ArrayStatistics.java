public class ArrayStatistics {

    public static void displayStatistics(int[] serviceTimes) {

        if (serviceTimes.length == 0) {
            System.out.println("No service times available.");
            return;
        }

        int totalStudents = serviceTimes.length;
        int totalTime = 0;
        int highest = serviceTimes[0];
        int lowest = serviceTimes[0];
        int longerThan10 = 0;

        for (int i = 0; i < serviceTimes.length; i++) {

            int time = serviceTimes[i];

            totalTime += time;

            if (time > highest) {
                highest = time;
            }

            if (time < lowest) {
                lowest = time;
            }

            if (time > 10) {
                longerThan10++;
            }
        }

        double average =
                (double) totalTime / totalStudents;

        System.out.println("Total students served : "
                + totalStudents);

        System.out.println("Total service time    : "
                + totalTime + " min");

        System.out.println("Average service time  : "
                + average + " min");

        System.out.println("Highest service time  : "
                + highest + " min");

        System.out.println("Lowest service time   : "
                + lowest + " min");

        System.out.println("Services > 10 min     : "
                + longerThan10);
    }
}


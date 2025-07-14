package stack_queue;

public class CircularTour {

    // Function to find starting point
    public static int findStartingPoint(int[] petrol, int[] distance) {
        int n = petrol.length;
        int start = 0;
        int surplus = 0; // petrol left after each pump
        int deficit = 0; // track fuel shortfall

        for (int i = 0; i < n; i++) {
            surplus += petrol[i] - distance[i];

            // If surplus becomes negative, can't start from 'start'
            if (surplus < 0) {
                deficit += surplus;
                surplus = 0;
                start = i + 1; // try next station as starting point
            }
        }

        return (surplus + deficit >= 0) ? start : -1;
    }

    // For testing
    public static void main(String[] args) {
        int[] petrol =  {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        int start = findStartingPoint(petrol, distance);

        if (start != -1) {
            System.out.println("Start at pump: " + start);
        } else {
            System.out.println("No feasible starting point.");
        }
    }
}


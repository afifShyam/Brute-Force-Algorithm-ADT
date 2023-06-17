
import java.util.Scanner;

public class ContestBF {

    public static void main(String[] args) {

        System.out.println("Using Divide and Conquer and Dynamic Programming Approach");

        try (Scanner sc = new Scanner(System.in)) {
            // Input number of questions in the competition
            System.out.print("\nTotal number of questions: ");
            int numQuestions = sc.nextInt();

            int[] questions = new int[3];
            String[] types = {"Brute Force", "Divide and Conquer", "Greedy"};
            int total = 0;

            for (int i = 0; i < questions.length; i++) {
                System.out.print("\nNumber of questions for " + types[i] + ": ");
                questions[i] = sc.nextInt();
                total += questions[i];
                if (total > numQuestions) {
                    System.out.println("Number of questions for " + types[i] + " exceeds remaining number of questions. Exiting program.");
                    System.exit(0);
                }
            }
            // Input time taken for each member to solve
            int[][] times = new int[3][3];
            for (int i = 0; i < 3; i++) {
                System.out.println("\nTime taken for member " + (i + 1) + " to solve:");
                System.out.print("Brute Force: ");
                times[i][0] = sc.nextInt();
                System.out.print("Divide and Conquer: ");
                times[i][1] = sc.nextInt();
                System.out.print("Greedy: ");
                times[i][2] = sc.nextInt();
            }

            // Calculate the fastest time to complete the competition using brute force
            // int totalTime = bruteForce(times, numQuestions, numBruteForce, numDivideConquer, numGreedy);
            long start = System.nanoTime();
            long startTime = System.nanoTime();
            // Call the divide and conquer function
            int minTime = bruteForce(times, numQuestions, questions[0], questions[1], questions[2]);
            long endTime = System.nanoTime();
            long totalTime1 = endTime - startTime;
            long end = System.nanoTime();
            long worstCaseRuntime = (end - start);
            // Output the minimum time taken to solve all questions
            System.out.println("\nFastest time to complete the competition: " + minTime + " minutes (BF)");
            System.out.println("Total runtime: " + (totalTime1 / 1000000.0) + " mileseconds");
            System.out.println("Worst Case runtime: " + (worstCaseRuntime / 1000000.0) + " mileseconds");

        }
    }

    public static int bruteForce(int[][] times, int numQuestions, int numBruteForce, int numDivideConquer, int numGreedy) {
        int totalTime = 0;
        for (int i = 0; i < numQuestions; i++) {
            int minTime = Integer.MAX_VALUE;
            for (int j = 0; j < 3; j++) {
                int time;
                if (i < numBruteForce) {
                    time = times[j][0];
                } else if (i < numBruteForce + numDivideConquer) {
                    time = times[j][1];
                } else {
                    time = times[j][2];
                }
                minTime = Math.min(minTime, time);
            }
            totalTime += minTime;
        }
        return totalTime;
    }
}

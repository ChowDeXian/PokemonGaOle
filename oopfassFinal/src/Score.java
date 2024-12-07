import java.io.*;
import java.util.*;

public class Score {
    private static final String SCORE_FILE = "top_scores.txt";
    private static final int TOP_SCORES_LIMIT = 5;

    private List<Integer> topScores;

    public Score() {
        this.topScores = new ArrayList<>();
        loadTopScores();
        saveTopScores();
    }

    public void calculateAndShowScore(int userScore, int computerScore) {
        int totalScore = userScore + Math.abs(computerScore);
        System.out.println("Battle Score: " + totalScore);
        System.out.println("\nScore will be saved after quitting the game");
        checkTopScores(totalScore);
    }

    public void displayTopScores() {
        System.out.println("\nTop Scores:");

        for (int i = 0; i < topScores.size(); i++) {
            System.out.println((i + 1) + ". " + topScores.get(i));
        }
    }

    private void loadTopScores() {
        try (Scanner fileScanner = new Scanner(new File(SCORE_FILE))) {
            while (fileScanner.hasNextInt()) {
                topScores.add(fileScanner.nextInt());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Top scores file not found. Creating a new one.");
        }
    }

    private void saveTopScores() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(SCORE_FILE))) {
            for (int score : topScores) {
                writer.println(score);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void checkTopScores(int newScore) {
        topScores.add(newScore);
        Collections.sort(topScores, Collections.reverseOrder());

        if (topScores.size() > TOP_SCORES_LIMIT) {
            topScores = topScores.subList(0, TOP_SCORES_LIMIT);
        }

        System.out.println("\nTop Scores:");

        for (int i = 0; i < topScores.size(); i++) {
            System.out.println((i + 1) + ". " + topScores.get(i));
        }
        saveTopScores();
    }
}

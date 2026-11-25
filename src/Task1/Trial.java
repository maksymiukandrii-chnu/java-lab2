package Task1;

public class Trial {
    private String subject;
    private int maxScore;

    public Trial(String subject, int maxScore) {
        this.subject = subject;
        this.maxScore = maxScore;
    }

    public String getSubject() {
        return subject;
    }

    public int getMaxScore() {
        return maxScore;
    }

    // Виведення даних про випробування
    public void Show() {
        System.out.printf("[Trial] Subject: %s | Max Score: %d%n", subject, maxScore);
    }
}
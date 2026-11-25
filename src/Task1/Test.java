package Task1;

public class Test extends Trial {
    private int questionsCount;

    public Test(String subject, int maxScore, int questionsCount) {
        super(subject, maxScore);
        this.questionsCount = questionsCount;
    }

    @Override
    public void Show() {
        System.out.printf("[Test] Subject: %s | Max Score: %d | Questions: %d%n",
                getSubject(), getMaxScore(), questionsCount);
    }
}
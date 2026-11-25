package Task1;

public class Exam extends Trial {
    private String examiner;

    public Exam(String subject, int maxScore, String examiner) {
        super(subject, maxScore);
        this.examiner = examiner;
    }

    public String getExaminer() {
        return examiner;
    }

    @Override
    public void Show() {
        System.out.printf("[Exam] Subject: %s | Max Score: %d | Examiner: %s%n",
                getSubject(), getMaxScore(), examiner);
    }
}
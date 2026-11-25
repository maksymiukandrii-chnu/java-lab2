package Task1;

public class FinalExam extends Exam {
    private String commissionHead;

    public FinalExam(String subject, int maxScore, String examiner, String commissionHead) {
        super(subject, maxScore, examiner);
        this.commissionHead = commissionHead;
    }

    @Override
    public void Show() {
        System.out.printf("[FinalExam] Subject: %s | Max Score: %d | Examiner: %s | Commission Head: %s%n",
                getSubject(), getMaxScore(), getExaminer(), commissionHead);
    }
}
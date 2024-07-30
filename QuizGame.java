import java.util.*;

public class QuizGame {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Question> questions = new ArrayList<>();
    private static int score = 0;

    public static void main(String[] args) {
        setupQuestions();
        startQuiz();
        displayResults();
    }

    private static void setupQuestions() {
        questions.add(new Question("What is the capital of France?", new String[]{"1. Berlin", "2. Madrid", "3. Paris", "4. Rome"}, 3));
        questions.add(new Question("What is 2 + 2?", new String[]{"1. 3", "2. 4", "3. 5", "4. 6"}, 2));
        questions.add(new Question("Who wrote 'To Kill a Mockingbird'?", new String[]{"1. Harper Lee", "2. Mark Twain", "3. J.K. Rowling", "4. Ernest Hemingway"}, 1));
        // Add more questions as needed
    }

    private static void startQuiz() {
        for (Question question : questions) {
            displayQuestion(question);
        }
    }

    private static void displayQuestion(Question question) {
        System.out.println(question.getQuestionText());
        for (String option : question.getOptions()) {
            System.out.println(option);
        }

        int userAnswer = getUserAnswer();

        if (userAnswer == question.getCorrectOption()) {
            score++;
            System.out.println("Correct!");
        } else {
            System.out.println("Wrong!");
        }
    }

    private static int getUserAnswer() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("\nTime's up!");
                System.exit(0);
            }
        };
        timer.schedule(task, 10000); // 10 seconds timer

        System.out.print("Enter your answer (1-4): ");
        int answer = scanner.nextInt();
        timer.cancel();
        return answer;
    }

    private static void displayResults() {
        System.out.println("\nQuiz over!");
        System.out.println("Your score: " + score + "/" + questions.size());
        for (Question question : questions) {
            System.out.println(question.getQuestionText());
            System.out.println("Correct answer: " + question.getOptions()[question.getCorrectOption() - 1]);
        }
    }

    static class Question {
        private final String questionText;
        private final String[] options;
        private final int correctOption;

        public Question(String questionText, String[] options, int correctOption) {
            this.questionText = questionText;
            this.options = options;
            this.correctOption = correctOption;
        }

        public String getQuestionText() {
            return questionText;
        }

        public String[] getOptions() {
            return options;
        }

        public int getCorrectOption() {
            return correctOption;
        }
    }
}

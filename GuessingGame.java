import java.util.Random;
    import java.util.Scanner;
    
    public class GuessingGame {
    
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            boolean playAgain = true;
            int score = 0;
    
            while (playAgain) {
                int number = generateRandomNumber();
                int attempts = 0;
                final int maxAttempts = 10;
                boolean guessedCorrectly = false;
    
                System.out.println("Guess the number between 1 and 100. You have " + maxAttempts + " attempts.");
    
                while (attempts < maxAttempts && !guessedCorrectly) {
                    System.out.print("Enter your guess: ");
                    int guess = scanner.nextInt();
                    attempts++;
    
                    if (guess < number) {
                        System.out.println("Too low!");
                    } else if (guess > number) {
                        System.out.println("Too high!");
                    } else {
                        System.out.println("Correct!");
                        guessedCorrectly = true;
                        score += maxAttempts - attempts + 1; // Higher score for fewer attempts
                    }
                }
    
                if (!guessedCorrectly) {
                    System.out.println("Sorry, you've used all " + maxAttempts + " attempts. The correct number was: " + number);
                }
    
                System.out.print("Do you want to play again? (yes/no): ");
                playAgain = scanner.next().equalsIgnoreCase("yes");
            }
    
            System.out.println("Your final score is: " + score);
            scanner.close();
        }
    
        private static int generateRandomNumber() {
            Random random = new Random();
            return random.nextInt(100) + 1;
        }
    }
    
    


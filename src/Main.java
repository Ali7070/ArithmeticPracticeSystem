
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        System.out.println();
        System.out.println("*** Welcome to the Arithmetic Practice System ***");
        System.out.println("*** Instruction: Two random numbers will be provided. Make a guess to solve the problem! If your answer is wrong, the program will show the correct answer! Good luck practicing! ***");
        System.out.println();

        String userInput;
        int totalQuestions = 0;
        int correctAnswers = 0;

        while (true) {
            System.out.println("1. Addition problem");
            System.out.println("2. Subtraction problem");
            System.out.println("3. Multiplication problem");
            System.out.println("4. Division problem");
            System.out.println("5. Quit");
            System.out.print("Enter your choice (1 - 4): ");

            userInput = scanner.nextLine();

            if (userInput.equals("5")) {
                System.out.println("Thank you for using the Arithmetic Practice System.");
                System.out.println("You answered " + correctAnswers + " out of " + totalQuestions + " correctly.");
                break;
            } else if (!userInput.equals("1") && !userInput.equals("2") && !userInput.equals("3") && !userInput.equals("4")) {
                System.out.println();
                System.out.println("Please choose a number from 1-5.");
                System.out.println();
                continue;
            }

            System.out.println();

            if (userInput.equals("1") || userInput.equals("2")) {
                int firstNum = getRandomInt(1000, rand);
                int secondNum = getRandomInt(1000, rand);

                if (userInput.equals("2") && secondNum > firstNum) {
                    int temp = secondNum;
                    secondNum = firstNum;
                    firstNum = temp;
                }

                String A = String.format("%5d", firstNum);
                String B = String.format("%4d", secondNum);
                int correctAnswer = userInput.equals("1") ? firstNum + secondNum : firstNum - secondNum;
                char operator = userInput.equals("1") ? '+' : '-';

                System.out.println(A);
                System.out.println(operator + B);
                System.out.println("-----");
                System.out.print("> ");
                String answer = scanner.nextLine();
                totalQuestions++;

                if (answer.equals(Integer.toString(correctAnswer))) {
                    System.out.println("Great job! Your answer " + answer + " is correct.");
                    correctAnswers++;
                } else {
                    System.out.println("Sorry your answer is incorrect, the correct answer is: " + correctAnswer);
                }

            } else if (userInput.equals("3")) {
                int firstNum1 = getRandomInt(100, rand);
                int secondNum1 = getRandomInt(10, rand);
                int correctAnswer = firstNum1 * secondNum1;

                String C = String.format("%5d", firstNum1);
                String G = String.format("%4d", secondNum1);

                System.out.println(C);
                System.out.println("*" + G);
                System.out.println("-----");
                System.out.print("> ");
                String answer = scanner.nextLine();
                totalQuestions++;

                if (answer.equals(Integer.toString(correctAnswer))) {
                    System.out.println("Great job! Your answer " + answer + " is correct.");
                    correctAnswers++;
                } else {
                    System.out.println("Sorry your answer is incorrect, the correct answer is: " + correctAnswer);
                }

            } else {
                int secondNum1 = getRandomIntInRange(1, 9, rand); // avoid zero
                int correctAnswer = getRandomIntInRange(1, 12, rand);
                int firstNum1 = secondNum1 * correctAnswer;

                String C = String.format("%5d", firstNum1);
                String G = String.format("%4d", secondNum1);

                System.out.println(C);
                System.out.println("/" + G);
                System.out.println("-----");
                System.out.print("> ");
                String answer = scanner.nextLine();
                totalQuestions++;

                if (answer.equals(Integer.toString(correctAnswer))) {
                    System.out.println("Great job! Your answer " + answer + " is correct.");
                    correctAnswers++;
                } else {
                    System.out.println("Sorry your answer is incorrect, the correct answer is: " + correctAnswer);
                }
            }

            // Display score after each question
            System.out.println("Current Score: " + correctAnswers + " out of " + totalQuestions);
            System.out.println();
        }
    }

    public static int getRandomInt(int bound, Random rand) {
        return rand.nextInt(bound);
    }

    public static int getRandomIntInRange(int min, int max, Random rand) {
        return rand.nextInt((max - min + 1)) + min;
    }
}


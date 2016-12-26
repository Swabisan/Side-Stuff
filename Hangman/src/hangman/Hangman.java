package hangman;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

/**
 *
 * @author Michael Swanson
 */
public class Hangman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // initialize essentials
        Random rnd = new Random();
        Scanner input = new Scanner(System.in);
        String[] answerLibrary = { // **note: use only lowercase
            "cat", "dog", "rat",
            "town", "nerd", "tall",
            "gourd", "bough", "wierd",
            "through", "pickel", "pander",};
        char[] answerKey = answerLibrary[rnd.nextInt(answerLibrary.length)].toCharArray();
        char[] answerVisual = new char[answerKey.length];
        Arrays.fill(answerVisual, '_');

        // begin frontend
        splashMessage();
        mainMenu(input, answerLibrary, answerKey);
        System.out.println("\nInstructions: Enter ONE letter at a time to figure out the word.\n"
                + "If you try to enter multiple letters at the same time or a word, the first letter is what will be taken.\n"
                + "You have 6 tries.\n");
        int mistakes = 0;
        int correct = 0;
        do{
        printAnswerVisual(answerVisual);
        System.out.println("\nYou have " + (6 - mistakes) + " remaining.\n");
        char userAnswer = getUserAnswer(input);
        if(validateAnswer(userAnswer, answerKey, answerVisual)){
            System.out.println("\nCorrect!\n");
            correct++;
        } else{
            System.out.println("\nWrong!\n");
            mistakes++;
        }
        drawHangman(mistakes);
        if(correct == answerKey.length){
            System.out.println("Congratulations you win!");
            System.exit(0);
        }
        }while(mistakes < 6);
        System.out.println("You lose!");
        System.out.println(Arrays.toString(answerKey));
    }

    public static void splashMessage() {
        System.out.println("Welcome to 'Hangman!'");
        System.out.println("The goal is to guess the word before the hangman is complete. (6 tries)\n");
    }

    public static void mainMenu(Scanner input, String[] answerLibrary, char[] answerKey) {
        System.out.print("****Main Menu****\n"
                + "To make your selection, type the corrosponding number and hit [Enter].\n");
        boolean error = true;
        int userSelection;
        do {
            System.out.print("(1) Start Game\n"
                    + "(2) Credits\n"
                    + "(3) Word Database\n"
                    + "(4) Exit\n"
                    + "Your selection: ");
            if (input.hasNextInt()) {
                userSelection = input.nextInt();
                switch (userSelection) {
                    case 4:
                        System.exit(0);
                    case 3:
                        System.out.println("\n" + Arrays.toString(answerLibrary) + "\n");
                        break;
                    case 2:
                        credits();
                        break;
                    case 1:
                        error = false;
                        break;
                    case 1998:
                        System.out.println("\n" + Arrays.toString(answerKey) + "\n");
                        break;
                    default:
                        System.out.println("Error! Selection is invalid.\n");
                        input.nextLine();
                        break;
                }
            } else {
                System.out.println("Error! Input is not a number.\n");
                input.nextLine();
            }
        } while (error);
    }

    public static void credits() {
        System.out.println("\nBy Michael Swanson.\n");
    }

    public static char getUserAnswer(Scanner input) {
        System.out.print("Enter one letter: ");
            return input.next().trim().charAt(0);
    }

    public static boolean validateAnswer(char userAnswer, char[] answerKey, char[] answerVisual) {
        boolean isCorrect = false;
        for (int i = 0; i < answerKey.length; i++) {
            if (userAnswer == answerKey[i]) {
                answerVisual[i] = userAnswer;
                isCorrect = true;
            }
        }
        return isCorrect;
    }

    public static void printAnswerVisual(char[] answerVisual) {
        System.out.println("THE WORD");
        for (int i = 0; i < answerVisual.length; i++) {
            System.out.print(answerVisual[i] + " ");
        }
        System.out.println("\n");
    }

    public static void drawHangman(int x) {
        if (x == 6) {

        } else if (x == 5) {

        } else if (x == 4) {

        } else if (x == 3) {

        } else if (x == 2) {

        } else if (x == 1) {

        } else {

        }
    }
}

class HangmanFigure {

    private boolean head = false;
    private boolean torso = false;
    private boolean leftArm = false;
    private boolean rightArm = false;
    private boolean leftLeg = false;
    private boolean rightLeg = false;

    public HangmanFigure() {
    }

    public boolean isHead() {                                                   // getters
        return head;
    }

    public boolean isTorso() {
        return torso;
    }

    public boolean isLeftArm() {
        return leftArm;
    }

    public boolean isRightArm() {
        return rightArm;
    }

    public boolean isLeftLeg() {
        return leftLeg;
    }

    public boolean isRightLeg() {
        return rightLeg;
    }

    public void setHead(boolean head) {                                         // setters
        this.head = head;
    }

    public void setTorso(boolean torso) {
        this.torso = torso;
    }

    public void setLeftArm(boolean leftArm) {
        this.leftArm = leftArm;
    }

    public void setRightArm(boolean rightArm) {
        this.rightArm = rightArm;
    }

    public void setLeftLeg(boolean leftLeg) {
        this.leftLeg = leftLeg;
    }

    public void setRightLeg(boolean rightLeg) {
        this.rightLeg = rightLeg;
    }

}

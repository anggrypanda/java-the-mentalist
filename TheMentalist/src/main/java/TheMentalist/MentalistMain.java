package TheMentalist;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class MentalistMain {
    public static void main(String[] args) {
        HashSet<Integer> randomNumber = new HashSet(5);
        String randomString = new String();
        Random rand = new Random();
        int randomDigit = rand.nextInt(10);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a 5 digit number (different digits): ");
        String inputString = scanner.next();

        while (randomNumber.size() < 5) {
            if (!randomNumber.add(randomDigit)) {
                randomDigit = rand.nextInt(10);
            }
            randomNumber.add(randomDigit);
            randomString = randomNumber.toString();
            randomString = randomString.replaceAll("\\W", "");
        }

        if (inputString.matches("(?:\\d{5})")) {
            for (int i = 0; i < randomString.length(); i++) {
                if (inputString.charAt(i) == randomString.charAt(i)) {
                    System.out.print("*");
                }
                else if (randomString.contains(inputString.valueOf(inputString.charAt(i)))) {
                    System.out.print("+");
                }
            }
            System.out.print("\n" + randomString);
        }
        else{
                System.out.println("Invalid input.");
            }
    }
}
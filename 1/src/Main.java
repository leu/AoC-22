import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            File inputFile = new File("src/input.txt");
            Scanner inputReader = new Scanner(inputFile);

            int currentElfCalories = 0;
            PriorityQueue<Integer> highestCalories = new PriorityQueue<>(List.of(0, 0, 0));
            while (inputReader.hasNextLine()) {
                String data = inputReader.nextLine();
                System.out.println(data);
                if (!data.equals("")) {
                    currentElfCalories += Integer.parseInt(data);
                } else {
                    if (currentElfCalories > highestCalories.peek()) {
                        highestCalories.poll();
                        highestCalories.offer(currentElfCalories);
                    }
                    currentElfCalories = 0;
                }
            }
            inputReader.close();
            System.out.println(highestCalories);
            System.out.println(highestCalories.stream().reduce(0, Integer::sum));
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

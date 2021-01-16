// This Program is to caculate sum of two integer
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Sum{

    public static void main(String[]args){
        if (args.length <= 0) {
            System.out.println("Pls input your test case file");
            return;
        }
        try {
            File file = new File(args[0]);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] array = line.split(" ");
                int x = Integer.parseInt(array[0]);
                int y = Integer.parseInt(array[1]);
                System.out.format("The sum of %d and %d is: %d\n", x, y, x+y);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
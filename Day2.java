import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) throws FileNotFoundException {
        challage2();
    }

    public static void challage1() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("inputFiles/d2input.txt"));

        int x  = 0;
        int y = 0;
        while(sc.hasNext()){
            String cc = sc.next();
            int m  = sc.nextInt();

            switch (cc){
                case "forward": x+=m; break;
                case "up": y-=m; break;
                case "down": y+=m; break;

            }
        }

        System.out.println(x*y);

    }

    public static void challage2() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("inputFiles/d2input.txt"));

        int x  = 0;
        int y = 0;
        int aim = 0;
        while(sc.hasNext()){
            String cc = sc.next();
            int m  = sc.nextInt();

            switch (cc){
                case "forward": x+=m;
                                y += aim*m;
                                break;
                case "up": aim-=m; break;
                case "down": aim+=m; break;

            }
        }

        System.out.println(x*y);
    }
}

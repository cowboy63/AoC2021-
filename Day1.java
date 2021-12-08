import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) throws FileNotFoundException {
        challage2();
    }

    public static void challage1() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("inputFiles/d1input.txt"));

        int p = -1;
        int cnt = 0;
        while(sc.hasNext()){
            if(p == -1){
                p = sc.nextInt();
                continue;
            }
            int t = sc.nextInt();
            cnt += p<t? 1: 0;
            p = t;
        }

        System.out.println(cnt);
    }

    public static void challage2() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("inputFiles/d1input.txt"));

        ArrayList<Integer> nm = new ArrayList<>();
        while(sc.hasNext()){
            nm.add(sc.nextInt());
        }

        int cnt = 0;
        int sum = nm.get(0)+nm.get(1)+nm.get(2);
        for(int i = 3; i < nm.size(); i++){
            if(sum < sum - nm.get(i-3) + nm.get(i)){
                cnt++;
            }
            sum-= nm.get(i-3);
            sum+= nm.get(i);
        }

        System.out.println(cnt);
    }

}

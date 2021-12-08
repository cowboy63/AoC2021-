import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day3 {
    public static void main(String[] args) throws FileNotFoundException {
        challage2();
    }

    public static void challage1() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("inputFiles/d3input.txt"));

        int[] bit = new int[12]; //12
        while(sc.hasNext()){
            String x = sc.next();
            for(int i =0; i < x.length(); i++){
                bit[i] += x.charAt(i) == '1'? 1:-1;
            }
        }

        String out = "";
        String out1 = "";
        for(int i =0; i < bit.length; i++){
            out += bit[i] >= 1? "1":"0";
            out1 += bit[i] >= 1? "0":"1";
        }

        System.out.println(Integer.parseInt(out,2) * Integer.parseInt(out1, 2));

    }

    public static void challage2() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("inputFiles/d3input.txt"));

        ArrayList<String> num = new ArrayList<>();
        ArrayList<String> num1 = new ArrayList<>();

        while(sc.hasNext()){
            String x = sc.next();
            num.add(x);
            num1.add(x);
        }

        System.out.println(Integer.parseInt(getCrit(num1, '1', 0, true),2) * Integer.parseInt(getCrit(num, '0', 0, false), 2));

    }


    public static String getCrit(ArrayList<String> num, char x, int yt, boolean pog){

        if(num.size() == 1){
            return num.get(0);
        }

        int xap = 0;

        for(int i = 0; i < num.size(); i++){
            xap += num.get(i).charAt(yt) == x ? 1:0;
        }

        char mostCommon = '0';

        if(pog) {
            if (xap >= num.size() - xap) {
                mostCommon = x;
            } else {
                mostCommon = x == '1' ? '0' : '1';
            }
            for(int i = num.size()-1; i>=0; i--){
                if(num.get(i).charAt(yt) != mostCommon){
                    num.remove(i);
                }
            }
        }
        else{
            if (xap <= num.size() - xap) {
                mostCommon = x;
            } else {
                mostCommon = x == '1' ? '0' : '1';
            }
            for(int i = num.size()-1; i>=0; i--){
                if(num.get(i).charAt(yt) != mostCommon){
                    num.remove(i);
                }
            }
        }





       return getCrit(num, x, yt+1, pog);

    }
}

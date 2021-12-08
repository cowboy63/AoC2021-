import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day8 {
    public static void main(String[] args) throws FileNotFoundException {
        challage2();
    }

    public static void challage1() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("inputFiles/d8input.txt"));

        int cnt = 0;
        while(sc.hasNext()){
            String[] ki = sc.nextLine().split(" \\| ");
            String[] ll = ki[1].split(" ");

            for (String lol: ll){
                if(lol.length() == 2 || lol.length() == 7 || lol.length() == 4 || lol.length() == 3){
                    cnt++;
                }
            }

        }
        System.out.println(cnt);

    }

    public static void challage2() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("inputFiles/d8input.txt"));

        int coo =  0;
        while(sc.hasNext()){
            String[] ki = sc.nextLine().split(" \\| ");
            String[] l3 = ki[0].split(" ");
            String[] ll = ki[1].split(" ");

            String[] num = new String[10];
            num[1] = sizSZ(l3,2).get(0);
            num[4] = sizSZ(l3,4).get(0);
            num[7] = sizSZ(l3,3).get(0);
            num[8] = sizSZ(l3,7).get(0);

            ArrayList<String> _069 = sizSZ(l3, 6);
            ArrayList<String> _235 = sizSZ(l3, 5);

            for(int i =0; i < _069.size(); i++){
                String ty = _069.get(i);
                if(!contains(ty,num[7])){
                    num[6] = _069.get(i);
                    _069.remove(i);
                    break;
                }
            }

            for(int i =0; i < _069.size(); i++){
                String ty = _069.get(i);
                if(contains(ty,num[4])){
                    num[9] = _069.get(i);
                    _069.remove(i);
                    break;
                }
            }
            num[0] = _069.get(0);

            for(int i =0; i < _235.size(); i++){
                String ty = _235.get(i);
                if(contains(ty, num[7])){
                    num[3] = _235.get(i);
                    _235.remove(i);
                    break;
                }
            }

            for(int i =0; i < _235.size(); i++){
                String ty = _235.get(i);
                if(contains(num[6], ty)){
                    num[5] = _235.get(i);
                    _235.remove(i);
                    break;
                }
            }
            num[2] = _235.get(0);

            String con = "";

            for (String lol: ll){
                for(int i =0; i<num.length; i++){
                    if(equals(lol, num[i])){
                        con+=""+i;
                    }
                }
            }
            coo+= Integer.parseInt(con);

        }

        System.out.println(coo);
    }

    public static boolean contains(String a, String b){
        for(int i =0; i < b.length(); i++){
            if(a.indexOf(b.charAt(i)) == -1){
                return false;
            }
        }
        return true;
    }

    public static boolean equals(String a, String b){
        char[] x = a.toCharArray();
        char[] x1 = b.toCharArray();
        Arrays.sort(x);
        Arrays.sort(x1);

        if(x1.length != x.length){
            return false;
        }

        for (int i =0; i < x.length; i++){
            if(x[i]!=x1[i]){
                return false;
            }
        }
        return true;

    }
    public static ArrayList<String> sizSZ(String[] d, int s){
        ArrayList<String> tmp = new ArrayList<>();
        for (String ll: d){
            if(ll.length() == s){
                tmp.add(ll);
            }
        }
        return tmp;
    }
}

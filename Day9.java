import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Day9 {
    public static void main(String[] args) throws FileNotFoundException {
        challage2();
    }

    public static void challage1() throws FileNotFoundException {
        Scanner file = new Scanner(new File("inputFiles/d9input.txt"));

        int size = 100;
        int[][] mat = new int[size][];
        for(int i =0; i < size; i++){
            String a = file.nextLine();
            mat[i] = new int[a.length()];
            for(int j =0; j < a.length(); j++){
                mat[i][j] = a.charAt(j)-48;
            }
        }

        int sum =0;

        for(int r =0; r < mat.length; r++){
            for (int c =0; c < mat[r].length; c++){
                int dd = dec(mat, r, c);
                sum += dd==-1?0:dd;

            }
        }
        System.out.println(sum);

    }

    public static int dec(int[][] mat, int r, int c){

        if(r>0 && mat[r-1][c] <= mat[r][c]){
            return -1;
        }
        if(r<mat.length-1 && mat[r+1][c] <= mat[r][c]){
            return -1;
        }
        if(c>0 && mat[r][c-1] <= mat[r][c]){
            return -1;
        }
        if(c<mat[0].length-1 && mat[r][c+1] <= mat[r][c]){
            return -1;
        }

        return mat[r][c]+1;
    }

    public static void challage2() throws FileNotFoundException {
        Scanner file = new Scanner(new File("inputFiles/d9input.txt"));

        int size = 100;
        int[][] mat = new int[size][];
        for(int i =0; i < size; i++){
            String a = file.nextLine();
            mat[i] = new int[a.length()];
            for(int j =0; j < a.length(); j++){
                mat[i][j] = a.charAt(j)-48;
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        boolean[][] shadow = new boolean[size][mat[0].length];

        for(int r =0; r < mat.length; r++){
            for (int c =0; c < mat[r].length; c++){
                int dd = dec(mat, r, c);
                if(dd != -1){
                    int ll = blob(mat,shadow,r,c);
                    pq.add(ll/2);
                }

            }
        }
        System.out.println(pq.poll()*pq.poll()*pq.poll());

    }

    public static int blob(int[][] mat, boolean[][] shadow, int r, int c){
        if(r>=0 && c>=0 && r<mat.length && c<mat[0].length && mat[r][c] != 9 && !shadow[r][c]){
            shadow[r][c] = true;
            return 1+blob(mat, shadow,r-1,c)+1+blob(mat, shadow,r+1,c)+blob(mat, shadow,r,c-1)+blob(mat, shadow,r,c+1);

        }
        return 0;
    }
}

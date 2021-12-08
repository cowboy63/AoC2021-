import javax.print.DocFlavor;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day4 {
    public static void main(String[] args) throws FileNotFoundException {
        challage2();
    }

    public static void challage1() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("inputFiles/d4input.txt"));

        String[] xd = sc.nextLine().split(",");
        int[] bingo = new int[xd.length];
        for(int i =0; i < bingo.length; i++){
            bingo[i] = Integer.parseInt(xd[i]);
        }


        ArrayList<Board> boards = new ArrayList<>();
        while(sc.hasNext()){
            sc.nextLine();

            int[][] temp = new int[5][5];
            for (int r =0; r < temp.length; r++){
                for(int c = 0; c < temp[0].length; c++){
                    temp[r][c] = sc.nextInt();
                }
            }
            boards.add(new Board(temp));
        }

        out:
        for (int xp : bingo){
            for (Board bb: boards){
                bb.mark(xp);
                if (bb.won()){
                    System.out.println(xp*bb.unMarked());
                    break out;
                }
            }
        }


    }


    public static void challage2() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("inputFiles/d4input.txt"));

        String[] xd = sc.nextLine().split(",");
        int[] bingo = new int[xd.length];
        for(int i =0; i < bingo.length; i++){
            bingo[i] = Integer.parseInt(xd[i]);
        }


        ArrayList<Board> boards = new ArrayList<>();
        while(sc.hasNext()){
            sc.nextLine();

            int[][] temp = new int[5][5];
            for (int r =0; r < temp.length; r++){
                for(int c = 0; c < temp[0].length; c++){
                    temp[r][c] = sc.nextInt();
                }
            }
            boards.add(new Board(temp));
        }

        int last = 0;
        for (int xp : bingo){
            for (Board bb: boards){
                bb.mark(xp);
                if(!bb.hasWon && bb.won())
                {
                    last = xp*bb.unMarked();
                }
            }
        }

        System.out.println(last);



    }

    static class Board{

        int[][] mat;
        boolean[][] shadow;

        boolean hasWon = false;

        public Board(int[][] m){
            mat = m;
            shadow = new boolean[m.length][m[0].length];
        }

        public void mark(int y){
            for(int i =0; i < mat.length; i++){
                for (int x=0; x < mat[0].length; x++){
                    if(mat[i][x] == y){
                        shadow[i][x] = true;
                    }
                }
            }
        }

        public boolean won(){
            boolean checkZ = true;
            boolean checkW = true;
            for (int i =0; i < mat.length; i++){
                boolean checkX = true;
                boolean checkY = true;

                checkZ&= shadow[i][i];
                checkW&= shadow[mat.length-1-i][mat.length-1-i];

                for(int x = 0; x < mat[0].length; x++){
                    checkX&= shadow[i][x];
                    checkY&= shadow[x][i];
                }
                if(checkY || checkX){
                    hasWon = true;
                    return hasWon;
                }
            }

            hasWon = checkZ || checkW;
            return hasWon;

        }

        public int unMarked(){
            int sum = 0;
            for (int r =0; r < mat.length; r++){
                for(int c = 0; c < mat[0].length; c++){
                    sum += !shadow[r][c] ? mat[r][c] : 0;
                }
            }
            return sum;
        }
    }
}

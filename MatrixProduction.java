
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class MatrixProduction {
    public int[][] readMatrix(String path){
        int [][] matrix;
        try{
            File file = new File(path);
            InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
            BufferedReader read = new BufferedReader(isr);
            String[] arr = read.readLine().split(" ");
            matrix = new int[Integer.parseInt(arr[0])][Integer.parseInt(arr[1])];

            int row = 0;
            String line;
            while((line = read.readLine())!=null){
                String [] tem =line.split(" ");
                for (int i=0; i<matrix[row].length;i++){
                    matrix[row][i] = Integer.parseInt(tem[i]);
                }
                row++;
            }
            return matrix;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean saveMatrix(String path){
        return true;
    }

    public int[] getVector(int[][] matrix,int flag, int index){
        if (flag == 0){
            return matrix[index];
        }else{
            int [] ans = new int[matrix.length];
            for (int i = 0; i<matrix.length;i++){
                ans[i] = matrix[i][index];
            }
            return  ans;
        }
    }
    public int Doc(int[] vector1, int[] vector2){
        int ans = 0;
        for (int i=0; i< vector1.length;i++){
            ans += vector1[i]*vector2[i];
        }
        return ans;
    }
    public int[][] production(int[][] matrixA, int[][] matrixB){
        int [][] matrixC = new int[matrixA.length][matrixB[0].length];

        for (int i = 0 ; i < matrixC.length; i++){
            for (int j = 0; j < matrixC[i].length ; j++){
                int[] vectorRow = getVector(matrixA,0,i);
                int[] vectorCol = getVector(matrixB,0,j);
                matrixC[i][j] = Doc(vectorRow,vectorCol);
            }
        }

        return matrixC;
    }

    public  static void main(String[]args){
        String apath = "A.txt";
        String bpath = "B.txt";
        String savepath = "C.txt";
        MatrixProduction mp = new MatrixProduction();

        int [][] matrixA = mp.readMatrix(apath);
        int [][] matrixB = mp.readMatrix(bpath);
        int [][] matrixC = mp.production(matrixA,matrixB);

        System.out.println(Arrays.deepToString(matrixC));
        //boolean status = mp.saveMatrix(savepath);
    }
}

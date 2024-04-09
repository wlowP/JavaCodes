package wlow01_java_basic._4_array;

import java.util.Scanner;
        //用包含二维数组的类实现矩阵的乘法.
        /*输入格式:
        按下面格式输入行数、列数和矩阵:
        矩阵1：
        2 3
        1 2 3
        4 5 6
        矩阵2：
        3 2
        7 8
        9 0
        1 2
        输出格式:
        按下面格式输出乘积矩阵，每行后面有一个空格符和回车换行符：
        28 14
        79 44 */
public class _4_1_MatrixMultiply {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Matrix m1 = new Matrix(sc);
        Matrix m2 = new Matrix(sc);
        traverse(m1.multiply(m2));
    }

    public static void traverse(int[][] arr){
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}

class Matrix{
    int[][] matrix;
    int row, col;

    public Matrix(int[][] temp){
        row = temp.length;
        col = temp[0].length;
        matrix = temp;
    }
    public Matrix(Scanner sc){
        int[][] temp;
        row = sc.nextInt();
        col = sc.nextInt();
        temp = new int[row][col];
        for(int i = 0; i < row * col; i++){
            temp[i / col][i % col] = sc.nextInt();
        }
        matrix = temp;
    }

    public int[][] multiply(Matrix another){
        int[][] temp = new int[row][another.col];
        int tempNum = 0;
        for (int i = 0; i < row * another.col; i++) {
            for (int j = 0; j < col; j++) {
                tempNum += matrix[i / row][j] * another.matrix[j][i % row];
            }
            temp[i / another.col][i % another.col] = tempNum;
            tempNum = 0;
        }
        return temp;
    }
}

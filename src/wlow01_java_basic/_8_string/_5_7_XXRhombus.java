package wlow01_java_basic._8_string;

import java.util.Scanner;

public class _5_7_XXRhombus {
    public static void main(String[] args) {
//        rhombus();
        rhombusFilled();
    }

    private static void rhombus() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] c = new char[2 * n - 1];
        for (int i = 0; i < 2 * n - 1; i++) {
            c[i] = ' ';
        }
        String space = new String(c);
        StringBuilder sb = new StringBuilder(space);
        for (int i = n - 1; Math.abs(i) < n ; i--){
            int left = Math.abs(i), right = 2 * n - 2 - (Math.abs(i));
            sb.append(space);
            sb.replace(left, left + 1, "*");
            sb.replace(right, right + 1, "*");
            System.out.println(sb);
            sb.delete(0, sb.length());
        }
    }

    public static void rhombusFilled(){
        Scanner sc = new Scanner(System.in);
        int k, n = sc.nextInt();
        for (int i = n - 1, j = n; Math.abs(i) < n; i--, j = 2 * n - 1 - Math.abs(i)){
            k = Math.abs(i);
            for(int i1 = 0; i1 < k; i1++){
                System.out.print(' ');
            }
            for(int i2 = 0; i2 <(j - k); i2++){
                System.out.print('*');
            }
            System.out.println();
        }
    }
}

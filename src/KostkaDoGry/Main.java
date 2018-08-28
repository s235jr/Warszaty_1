package KostkaDoGry;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] A = {1, 3, 6, 4, 1, 2};
        //int[] A = {1, 2, 3};
        Main main = new Main();
        main.solution(A);



    }

    public int solution(int[] A) {

        int min = 1;
        Arrays.sort(A);

        for (int i = 1; i < A.length-1 ; i++) {
            if(A[i] > 0 && A[i+1] - A[i] > 1) {
                min = A[i]+1;
                break;
            } else if (A[i] > 0 && A[i+1] - A[i] == 1) {
                min = A[i]+1;
            }
        }


        System.out.println(min);
        return min;
    }

}

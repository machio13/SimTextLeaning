package JavaWeb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArrayAns {
    public void arrayAnswer() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int values[] = new int[10];

        for( int i = 0 ; i < 10 ; i++ ) {
            values[i] = Integer.parseInt( bufferedReader.readLine() );
        }
        for( int i = 0 ; i < 10 ; i++ )
            System.out.println( values[i] * 2 );
    }

    public void arrayMine() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> evenNumList = new ArrayList<>();
        List<Integer> oddNumList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int num = scanner.nextInt();

            if (num % 2 == 0) {
                evenNumList.add(num);
            }
            else {
                oddNumList.add(num);
            }

            Arrays.sort(new List[]{evenNumList});
            Arrays.sort(new List[]{oddNumList});
//            numList.add(num * 2);
        }
        System.out.println("偶数：" + evenNumList);
        System.out.println("奇数：" + oddNumList);
    }
}

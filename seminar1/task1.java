package seminar1;

import java.util.Arrays;
import java.util.Random;

public class task1 {
    public static int GetRandomNum(int n) {
        return new Random().nextInt(n);
    }

    public static int GetMaxBitNum(int i) {
        return Integer.toBinaryString(i).length();
    }

    public static int[] GetArrayDiv(int i, int n) {
        int minDivider = i / n + 1 * ((i % n == 0) ? 0 : 1);
        int firstElement = minDivider * n;
        int maxDivider = Short.MAX_VALUE / n;
        int count = maxDivider - minDivider + 1;

        int[] result = new int[count];
        int k = firstElement;
        for (int j = 0; j < result.length; j++) {
            result[j] = k;
            k += n;
        }
        return result;
    }

    public static int[] GetArrayInDiv(int i, int n) {
        int minDivider = -Short.MIN_VALUE / n;
        int maxDivider = i / n;
        int count = i - Short.MIN_VALUE - minDivider - maxDivider;
        int[] result = new int[count];
        int k = 0;
        for (int j = Short.MIN_VALUE; j <= i; j++) {
            if (j % n != 0) {
                result[k] = j;
                k++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int i = GetRandomNum(2000);
        System.out.println(i); // рандом

        int n = GetMaxBitNum(i);
        System.out.println(n); // бит

        int[] m1 = GetArrayDiv(i, n); // кратные
        System.out.println(Arrays.toString(m1));

        int[] m2 = GetArrayInDiv(i, n); // не кратные
        System.out.println(Arrays.toString(m2));

    }
}
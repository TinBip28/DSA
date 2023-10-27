package week4.lt1;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueSupPrime {
    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        int n = 30;
        for (int i = 2; i <= n && i < 10; i++) {
            if (isPrime(i)){
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            for (int i = 1; i <= 9; i++) {
                int k = queue.peek() * 10 + i;
                if (k <= n && isPrime(k)) {
                    queue.add(queue.peek() * 10 + i);
                }
            }
            System.out.print(queue.peek() + " ");
            queue.poll();
        }
    }
}

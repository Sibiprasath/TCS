import java.util.PriorityQueue;
import java.util.Scanner;

class Order implements Comparable<Order> {
    int priority;
    int position;

    Order(int priority, int position) {
        this.priority = priority;
        this.position = position;
    }

    @Override
    public int compareTo(Order o) {
        if (this.priority == o.priority) {
            return this.position - o.position;
        }
        return o.priority - this.priority;
    }
}

public class problemD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] priorities = new int[n];
        for (int i = 0; i < n; i++) {
            priorities[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();

        PriorityQueue<Order> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            queue.add(new Order(priorities[i], i));
        }

        int served = 0;
        while (!queue.isEmpty()) {
            Order current = queue.poll();
            served++;

            if (current.position == k - 1) {
                break;
            }
            for (int i = 0; i < current.position; i++) {
                priorities[i]++;
            }
            for (int i = 0; i < current.position; i++) {
                queue.add(new Order(priorities[i], i));
            }
        }

        System.out.println(served);
    }
}


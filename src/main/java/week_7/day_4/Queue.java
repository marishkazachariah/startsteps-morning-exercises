package week_7.day_4;

import java.util.ArrayList;
import java.util.List;

public class Queue<T> {
    private int queueLength;
//    private int[] items;
    private List<T> items;
    private int front;
    private int back;


    public Queue(int maxSize) {
        this.queueLength = maxSize;
        this.items = new ArrayList<>(queueLength);
        this.front = -1;
        this.back = -1;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return front == 0 && back == queueLength - 1 || (front == back + 1);
    }

    // had to look up the modulus solution due to indexOutOfBounds errors i was getting
    public void enqueue(T item) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else {
            if (front == -1) {
                front = 0;
            }
            back++;
            items.add(back, item);
        }
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Nothing to dequeue");
        } else {
            if (front == back) {
                front = back = - 1;
            }
            front++;
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            for (int i = front; i != back; i = (i + 1) % queueLength) {
                System.out.print(items.get(i) + ", ");
            }
            System.out.println(items.get(back)); // Display the last element
        }
    }


    public void peak() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Front item: " + items.get(front));
        }
    }

    public static void main(String[] args) {
        Queue<String> queue = new Queue<>(5);
        queue.enqueue("Tom");
        queue.enqueue("Jones");
        queue.enqueue("Kate");

        queue.display();
        queue.peak();

        queue.dequeue();
        queue.display();

        queue.enqueue("Charlie");
        queue.display();
        queue.enqueue("Anna");
        queue.enqueue("Stacey");
        queue.peak();
        queue.display();
        queue.enqueue("Kyle"); // print "Queue is full"
    }
}

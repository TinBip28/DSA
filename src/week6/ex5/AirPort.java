package week6.ex5;

import java.util.PriorityQueue;

public class AirPort {
    protected PriorityQueue<PlaneEvent> airQueue = new PriorityQueue<>();
    protected int limit = 6;

    public void add(PlaneEvent planeEvent) {
        airQueue.add(planeEvent);
    }

    public PlaneEvent upComing() {
        if (airQueue.isEmpty()) {
            throw new IllegalStateException("Khong co chuyen bay hien hanh");
        }
        return airQueue.peek();
    }

    public String showEvent() {
        StringBuilder builder = new StringBuilder();
        int count = 0;
        while (!airQueue.isEmpty()) {
            builder.append(airQueue.poll());
            builder.append("\n");
            count++;
            if (count > limit) {
                System.out.println("So luong may bay vuot qua gioi han vui long chuyen tuyen");
                break;
            }
        }
        return String.valueOf(builder);
    }
}

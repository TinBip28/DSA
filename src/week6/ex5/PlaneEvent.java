package week6.ex5;

public class PlaneEvent implements Comparable<PlaneEvent>{
    private String time;
    private String id;
    private String activity;

    private String company;

    public PlaneEvent(String time, String id, String activity, String company) {
        this.time = time;
        this.id = id;
        this.activity = activity;
        this.company = company;
    }
    @Override
    public int compareTo(PlaneEvent o) {
        return this.time.compareTo(o.time);
    }

    @Override
    public String toString() {
        return "PlaneEvent[" +
                "time='" + time + '\'' +
                ", id='" + id + '\'' +
                ", activity='" + activity + '\'' +
                ", company='" + company + '\'' +
                ']';
    }
}

package hw1_ex4;

public class Sphere {
    private double radius = 1.0;
    private double x = 0;
    private double y = 0;
    private double z = 0;

    public Sphere() {

    }

    public Sphere(double radix, double x, double y, double z) {
        this.radius = radix;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public void setXY(double x, double y) {
        this.setX(x);
        this.setY(y);
    }

    public void setYZ(double y, double z) {
        this.setY(y);
        this.setZ(z);
    }

    public void setZX(double z, double x) {
        this.setZ(z);
        this.setX(x);
    }

    public void setXYZ(double x, double y, double z) {
        setXY(x, y);
        this.setZ(z);
    }


    //Diện tích xung quanh
    public double surroundingArea() {
        double area = 4 * Math.PI * Math.pow(radius, 2);
        return (double) Math.round(area * 100) / 100;
    }

    // Thể tích
    public double volume() {
        double volume = (double) 4 / 3 * Math.PI * radius * radius * radius;
        return (double) Math.round(volume * 100) / 100;
    }

    // Khoảng cách giữa hai tâm
    public double centerDistance(Sphere that) {
        double distance = Math.sqrt(Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2) + Math.pow(this.z - that.z, 2));
        return (double) Math.round(distance * 100) / 100;
    }

    // Kiểu tiếp xúc
    public void contact(Sphere that) {
        double distance = centerDistance(that);
        double sumRadius = this.radius + that.radius;
        if (Double.compare(distance, sumRadius) > 0) {
            System.out.println("Không tiếp xúc");
        } else if (Double.compare(distance, sumRadius) == 0) {
            System.out.println("Tiếp xúc ngoài");
        } else {
            if (distance < Math.max(this.radius, that.radius)) {
                biggerSphere(that);
            } else {
                System.out.println("Tiếp xúc trong");
            }
        }
    }

    public void biggerSphere(Sphere that) {
        if (this.radius > that.radius) {
            System.out.println("Hình cầu 1 bao hình cầu 2");
        } else {
            System.out.println("Hình cầu 2 bao hình cầu 1");
        }
    }


    @Override
    public String toString() {
        return "Sphere[" +
                "radius=" + radius +
                ", x=" + x +
                ", y=" + y +
                ", z=" + z +
                ']';
    }
}

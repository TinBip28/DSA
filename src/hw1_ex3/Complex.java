package hw1_ex3;

public class Complex {
    private double real = 1.0;
    private double img = 1.0;

    public Complex() {
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImg() {
        return img;
    }

    public void setImg(double img) {
        this.img = img;
    }

    public void setRound() {
        setReal((double) Math.round((this.getReal() * 100)) / 100);
        setImg((double) Math.round((this.getImg() * 100)) / 100);
    }

    public Complex(double real, double img) {
        this.real = real;
        this.img = img;
    }

    public Complex addComplex(Complex that) {
        return new Complex(this.real + that.real, this.img + that.img);
    }

    public Complex subtractComplex(Complex that) {
        return new Complex(this.real - that.real, this.img - that.img);
    }

    public Complex multiComplex(Complex that) {
        return new Complex(this.real * that.real, this.img * that.img);
    }


    public boolean equals(Complex that) {
        return (this.real == that.real && this.img == that.img);
    }

    @Override
    public String toString() {
        return img >= 0 ? real + " + " + img + "i" : real + " - " + Math.abs(img) + "i";
    }
}

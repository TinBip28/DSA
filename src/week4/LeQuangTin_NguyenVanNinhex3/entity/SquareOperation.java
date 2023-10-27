package week4.LeQuangTin_NguyenVanNinhex3.entity;

public class SquareOperation extends Operation {
    @Override
    public double perform(double base, double exponent) {
        return Math.pow(base, exponent);
    }
}

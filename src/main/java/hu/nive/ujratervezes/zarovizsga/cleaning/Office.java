package hu.nive.ujratervezes.zarovizsga.cleaning;

public class Office extends House implements Cleanable {

    private int floor;

    public Office(String address, int area, int floor) {
        super(address, area);
        this.floor = floor;
    }

    @Override
    public int getArea() {
        return super.getArea() * floor;
    }

    @Override
    public int clean() {
        return getArea() * 100;
    }
}

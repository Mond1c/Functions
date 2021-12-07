package Functions;

public abstract class ConstantToken {
    public abstract double calculate();
}

class Number extends ConstantToken {
    private double number;

    public Number(double number) {
        this.number = number;
    }

    @Override
    public double calculate() {
        return number;
    }
}

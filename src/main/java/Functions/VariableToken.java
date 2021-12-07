package Functions;

public abstract class VariableToken {
    protected ConstantToken constantToken;

    public VariableToken(ConstantToken constantToken) {
        this.constantToken = constantToken;
    }

    public abstract double calculate(double x);
}

class LinearToken extends VariableToken {
    public LinearToken(ConstantToken constantToken) {
        super(constantToken);
    }

    @Override
    public double calculate(double x) {
        return constantToken.calculate() * x;
    }
}

class QuadraticToken extends VariableToken {
    public QuadraticToken(ConstantToken constantToken) {
        super(constantToken);
    }

    @Override
    public double calculate(double x) {
        return constantToken.calculate() * x * x;
    }
}
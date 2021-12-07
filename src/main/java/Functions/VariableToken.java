package Functions;

public abstract class VariableToken {
    protected ConstantToken constantToken;

    public VariableToken(ConstantToken constantToken) {
        this.constantToken = constantToken;
    }

    public double getFactor() {
        return constantToken.calculate();
    }
}

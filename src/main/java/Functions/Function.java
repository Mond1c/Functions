package Functions;

import java.util.ArrayList;
import java.util.List;

public class Function {
    protected List<VariableToken> variableTokenList;
    protected List<ConstantToken> constantTokenList;

    public Function() {
        variableTokenList = new ArrayList<>();
        constantTokenList = new ArrayList<>();
    }

    public void addToken(VariableToken variableToken) {
        variableTokenList.add(variableToken);
    }

    public void addToken(ConstantToken constantToken) {
        constantTokenList.add(constantToken);
    }

    public double calculate(double x) {
        double y = 0;
        for (VariableToken variableToken : variableTokenList) y += variableToken.calculate(x);
        for (ConstantToken constantToken : constantTokenList) y += constantToken.calculate();
        return y;
    }
}

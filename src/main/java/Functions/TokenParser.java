package Functions;

public class TokenParser {
    private static final Character POWERSYMBOL = '^';

    public static ConstantToken parseConstant(String s) {
        return parseNumber(s);
    }

    public static VariableToken parseVariable(String s) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; s.charAt(i) != 'x'; ++i) str.append(s.charAt(i));
        if (s.contains(POWERSYMBOL.toString())) return parseQuadraticToken(str.toString(), s);
        return parseLinearToken(str.toString());
    }

    private static Number parseNumber(String s) {
        if (s.isEmpty()) s = "1";
        else if (s.equals("-")) s = "-1";
        return new Number(Double.parseDouble(s));
    }

    private static LinearToken parseLinearToken(String s) {
        return new LinearToken(parseConstant(s));
    }

    private static PowerToken parseQuadraticToken(String s, String exp) {
        StringBuilder str = new StringBuilder();
        boolean isPower = false;
        for (int i = 0; i < exp.length(); ++i) {
            if (exp.charAt(i) == POWERSYMBOL) isPower = true;
            else if (isPower) str.append(exp.charAt(i));
        }
        return new PowerToken(parseConstant(s), Double.parseDouble(str.toString()));
    }
}

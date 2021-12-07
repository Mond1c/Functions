package Functions;

public class TokenParser {
    public static ConstantToken parseConstant(String s) {
        return parseNumber(s);
    }

    public static VariableToken parseVariable(String s) {
        String str = "";
        for (int i = 0; s.charAt(i) != 'x'; ++i) str += s.charAt(i);
        return parseLinearToken(str);
    }

    private static Number parseNumber(String s) {
        if (s.isEmpty()) s = "1";
        else if (s.equals("-")) s = "-1";
        return new Number(Double.parseDouble(s));
    }

    private static LinearToken parseLinearToken(String s) {
        return new LinearToken(parseConstant(s));
    }
}

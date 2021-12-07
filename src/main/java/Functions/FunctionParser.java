package Functions;

public class FunctionParser {
    public static Function parse(String s) {
        Function function = new Function();
        String[] expression = s.split(" ");
        for (String str : expression) {
            if (str.contains("x")) function.addToken(TokenParser.parseVariable(str));
            else function.addToken(TokenParser.parseConstant(str));
        }
        return function;
    }
}

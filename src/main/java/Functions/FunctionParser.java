package Functions;

import java.util.List;

public class FunctionParser {
    private static final List<Character> OPERATIONS = List.of('+', '-', '*', '/');

    public static Function parse(String s) {
        Function function = new Function();
        String[] expression = s.split(" ");
        String operation = "";
        for (String str : expression) {
            if (str.length() == 1 && OPERATIONS.contains(str.charAt(0))) {
                operation = str;
                continue;
            }
            if (str.contains("x")) function.addToken(TokenParser.parseVariable(operation + str));
            else function.addToken(TokenParser.parseConstant(operation + str));
        }
        return function;
    }
}

package Vista;

public class ConvertirSimbolos {
    
    public static String toAlternativeNotation(String input) {
        if (input == null) {
            return null;
        }

        StringBuilder output = new StringBuilder();

        for (char c : input.toCharArray()) {
            switch (c) {
                case '¬':
                    output.append('~');
                    break;
                case '∨':
                    output.append('+');
                    break;
                case '∧':
                    output.append('*');
                    break;
                default:
                    output.append(c);
                    break;
            }
        }

        return output.toString();
    }

    public static String toOriginalNotation(String input) {
        if (input == null) {
            return null;
        }

        StringBuilder output = new StringBuilder();

        for (char c : input.toCharArray()) {
            switch (c) {
                case '~':
                    output.append('¬');
                    break;
                case '+':
                    output.append('∨');
                    break;
                case '*':
                    output.append('∧');
                    break;
                default:
                    output.append(c);
                    break;
            }
        }

        return output.toString();
    }
}

    


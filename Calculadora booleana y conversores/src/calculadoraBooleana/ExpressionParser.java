package calculadoraBooleana;

/**
 * @author Marck Hernández
 */
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ExpressionParser {  //En esta clase no hice nada para no dañar la logica del mismo 

    private int precedence(String op) {
        switch (op) {
            case "~":
                return 3;
            case "*":
                return 2;
            case "+":
                return 1;
            default:
                return 0;
        }
    }

    public void applyOperator(Stack<String> operators, Stack<Node> output) {
        String operator = operators.pop();
        Node node;
        if (operator.equals("~") || operator.equals("!")) {
            node = new Node(operator, output.pop(), null);
        } else {
            Node right=null, left=null;
            if(!output.isEmpty()){
                right = output.pop();
            }
            if(!output.isEmpty()){
                left = output.pop();
            }
            
            node = new Node(operator, left, right);
        }
        output.push(node);
    }

    public Node parseExpression(String expression) {
        Pattern pattern = Pattern.compile("[A-Z01]|~|\\(|\\)|\\+|\\*");
        Matcher matcher = pattern.matcher(expression);

        Stack<Node> output = new Stack<>();
        Stack<String> operators = new Stack<>();

        while (matcher.find()) {
            String token = matcher.group();
            if (token.matches("[A-Z01]")) {
                output.push(new Node(token));
            } else if (token.equals("(")) {
                operators.push(token);
            } else if (token.equals(")")) {
                while (!operators.peek().equals("(")) {
                    applyOperator(operators, output);
                }
                operators.pop();
            } else {
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(token)) {
                    applyOperator(operators, output);
                }
                operators.push(token);
            }
        }

        while (!operators.isEmpty()) {
            applyOperator(operators, output);
        }

        return output.pop();
    }
}


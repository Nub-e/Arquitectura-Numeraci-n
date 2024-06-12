package calculadoraBooleana;

/**
 * @author Marck Hernández
 */
class ExpressionSimplifier {

    public Node simplify(Node node) {
        if (node == null) {
            return null;
        }

        // Simplificar nodos hijos primero
        node.left = simplify(node.left); //-> A diferencia del codigo anterior para que funcione bien el codigo tenemos que simplificar los nodos inferiores 
        node.right = simplify(node.right);

        // Aplicar simplificación de Morgan si es un nodo de negación
        if (node.value.equals("~")) {
            if(node.left.value.equals("0")){
                node =  new Node("1");
            } else if (node.left.value.equals("1")){
                node = new Node("0");
            } else {
                OperacionesBooleanas op = new OperacionesBooleanas();
                node = op.Morgan(node.left);
            }
            return node;
        }
        
        // Aplicar simplificación de expresiones booleanas
        OperacionesBooleanas op = new OperacionesBooleanas();
        ExpressionParser parseo = new ExpressionParser();
        node = parseo.parseExpression(op.simplificarBoolean(node));
        return node;
    }
    
    public String printExpression(Node node) {
        if (node == null) {
            return "";
        }
        if (node.value.matches("[ABC01]")) {
            return node.value;
        }
        if (node.value.matches("~")) {
            return  "~" + printExpression(node.left);
        }
        String leftExpr = printExpression(node.left);
        String rightExpr = printExpression(node.right);
        return leftExpr + node.value + rightExpr;
    }
    
    public String impresionFinal(Node node) {
        if (node == null) {
            return "";
        }
        if (node.value.matches("[ABC01]")) { //Se agrego en todas las regex ABC01 por que 0 y 1 ahora tambien son argumento, quise hacer los mismo con +~* para que agarre con a+~a pero manda error 
            return node.value;
        }
        if (node.value.matches("~")) {
            return  "(~" + impresionFinal(node.left) + ")";
        }
        String leftExpr = impresionFinal(node.left);
        String rightExpr = impresionFinal(node.right);
        return "(" + leftExpr + node.value + rightExpr + ")";
    }
}

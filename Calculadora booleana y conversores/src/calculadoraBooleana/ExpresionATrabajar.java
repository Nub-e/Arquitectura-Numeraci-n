package calculadoraBooleana;

/**
 *
 * @author Marck Hernández
 */
public class ExpresionATrabajar {
    
    String medio = "salida 1";
            //String expression:
        //Valen:                      //No valen:
        //B+((~A+C)*(C+B))
        //A*B+A*(C+B)+B*(B+C)
        //B*A+(A*C+A*(~C))*B
        //(A*C+(B*C+C*B)*B)*C+B
        //~(B*C)+C*(A*1+~(0*(~B))) 
        //(0*C+BC)*(~A)+~(1*B)
                                                 //~(A+(~B))+(C*A+B*(~A)+C)*(~C)//~((~B)*B)+C*(C*B+~(1*(~A)))
                                                 //B*A+C*(~(B*C)+C)*B+C*C
        
        //El código que sigue es el que nos permite realizar de forma iterativa los cálculos de las expresiones
        //que se van a simplificar y realiza las asociaciones de multiplicación y sumas. Regresa la expresión simplificada.        
    public String exprTrab(String expression){
        OperacionesBooleanas op = new OperacionesBooleanas();      
        int contador = 0;
        String salida="";
        while(!expression.equals(salida)){
            ExpressionParser parsedExpression = new ExpressionParser();
            Node nodo;
            nodo =  parsedExpression.parseExpression(expression);
            Node aux;
            ExpressionSimplifier simplifiedExpression = new ExpressionSimplifier();
            aux= simplifiedExpression.simplify(nodo);
            salida = simplifiedExpression.impresionFinal(aux);
            if(salida.charAt(0)=='(' && salida.charAt(salida.length()-1)==')'){
                salida=salida.substring(1, salida.length()-1); 
            } 
            if(!expression.equals(salida)){
                expression = salida;
                expression=asoMult(expression, op);
                expression=asoSums(expression, op);
//                System.out.println("Expresion simplificada: " +expression);
                salida = medio;
            }
            contador++;
            
        } 
        return expression;
    }
    
    public String asoMult(String expression, OperacionesBooleanas op){
        String regex = "(\\([ABC~*+()]+\\))(\\+)([ABC~+*()]+)";
        if(expression.matches(regex)){
            medio = op.asociarMultiplicaciones(expression.replaceAll(regex, "$1"))+"+";
            medio+= op.asociarMultiplicaciones(expression.replaceAll(regex, "$3"));
            expression=medio;
            medio="";
        }
        return expression;
    }
    public String asoSums(String expression, OperacionesBooleanas op){
        String regex = "(\\([ABC~*+()]+\\))(\\+)([ABC~*()]+)";
        if(expression.matches(regex)){
            medio = op.asociarSumas(expression.replaceAll(regex, "$1+$3"));
            expression=medio;
            medio="";
        }
        return expression;
    }
}

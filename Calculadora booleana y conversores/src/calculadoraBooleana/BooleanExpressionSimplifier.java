/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadoraBooleana;

/**
 *
 * @author Marck Hernández
 */
    
import java.util.*;

public class BooleanExpressionSimplifier {
    
    private int pivote;
    public String simplificarExpresion(String input) {
        Stack<String> stack = new Stack<>();
        StringBuilder currentExpr = new StringBuilder(" ");
        String aux; 
        char[] c = input.toCharArray();
        for (int i=0; i<input.length(); i++) {
            if (c[i] == '(') {
                if(currentExpr.charAt(currentExpr.length()-1)=='+'){
                    currentExpr.append(" ");
                    stack.push(currentExpr.toString());
                } else {
                    stack.push(currentExpr.toString());
                }
                currentExpr = new StringBuilder();
            } else if (c[i] == ')') {
                String subExpr = currentExpr.toString();
                currentExpr = new StringBuilder(stack.pop());
                aux=procesarSubExpresionIzq(subExpr,currentExpr.toString(),input,i);
                i=i+pivote;
                currentExpr.replace(0, currentExpr.length(), "");
                currentExpr.append(aux);
            } else {
                currentExpr.append(c[i]);
            }
        }
        
        return currentExpr.toString();
    }

    private String procesarSubExpresionIzq(String subExpr,String currentExpr,String input, int j) {
        StringBuilder result = new StringBuilder();
        String[] terms = subExpr.split("\\+");
        String[] prodTerms = currentExpr.split("\\+");
        String termDer = procesarSubExpresionDer(input.substring(j+1),j);
        List<String> processedTerms = new ArrayList<>();
        String aux;
        for (String term : terms) {
            if (term.contains("*")) {
                aux = prodTerms[prodTerms.length-1]+term+termDer;
                processedTerms.addAll(expandirTermino(aux));
            } else {
                aux = prodTerms[prodTerms.length-1]+term+termDer;
                processedTerms.add(aux);
            }
        }
        
        for (int i=0; i<prodTerms.length-1; i++){
            result.append(prodTerms[i]).append('+');
        }
        for (String term : processedTerms) {
            result.append(term).append('+');
        }
        
        return result.length() > 0 ? result.substring(0, result.length() - 1) : "";
    }
    
    private String procesarSubExpresionDer(String parteDer,int j) {
        if(parteDer.charAt(0)=='*' || Character.isLetter(parteDer.charAt(0))){
            String[] result = parteDer.split("\\+");
            pivote = result[0].length();
            return result[0];
        }
        pivote = 0;
        return "";
    }

    private List<String> expandirTermino(String term) {
        List<String> expandedTerms = new ArrayList<>();
        String[] factors = term.split("\\*");
        
        if (factors.length == 2 && factors[1].contains("(")) {
            String innerExpr = factors[1].substring(1, factors[1].length() - 1);
            String[] innerTerms = innerExpr.split("\\+");
            
            for (String innerTerm : innerTerms) {
                expandedTerms.add(factors[0] + '*' + innerTerm);
            }
        } else {
            expandedTerms.add(term);
        }
        
        return expandedTerms;
    }

    public static void main(String[] args) {
        BooleanExpressionSimplifier simplifier = new BooleanExpressionSimplifier();
        String input = "(A+C)+a*b*(c+b)*C*A+(a+b)*A";
        String result = simplifier.simplificarExpresion(input);
        System.out.println("Expresión Original: " + input);
        System.out.println("Expresión simplificada: " + result); // Expected output: "A+B*C+B*D+E"
    }
}


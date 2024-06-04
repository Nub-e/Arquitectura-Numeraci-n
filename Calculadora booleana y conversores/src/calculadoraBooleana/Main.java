package calculadoraBooleana;

/**
 *
 * @author Marck Hernández
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ExpresionBooleana simplifier = new ExpresionBooleana();
        String input = "A+C+~a(a+b*c+a+c)+(a+b)*A";
        String result = simplifier.simplificarExpresion(input);
        System.out.println("Expresión Original: " + input);
        System.out.println("Expresión simplificada: " + result); // Expected output: "A+B*C+B*D+E"
    }
    //~*b*c ~,b,c  ; ~aa
}

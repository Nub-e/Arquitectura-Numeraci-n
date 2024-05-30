package Negocio;
import java.util.StringTokenizer;
/**
 * @author Marck Hernández
 */
public class Dec_bin {
    
    private double numero;
    private int entero;
    private double decimal;
    
    //Constructor para leer y asignar el número decimal a una variable global
    //con la que se va a trabajar.
    public Dec_bin(double numero) {
        this.numero = numero;
    }
    
    //Método para separar la parte entera y decimal para su posterior uso.
    public void separar(){
        StringTokenizer tokens = new StringTokenizer(String.valueOf(numero),".");
        String en = tokens.nextToken();
        String dec = "." + tokens.nextToken();
        entero = Integer.parseInt(en);
        decimal = Double.parseDouble(dec);
    }
    
    //Método para saber si se debe agregar un 0 o 1 como el valor del bit del signo.
    public int signo(){
        if(entero < 0){
            return 1;
        }else{
            return 0;
        }
    }
    
    //Método para convertir la parte entera del número decimal a binario
    //almacenando el módulo de cada división sucesiva para invertir el String
    //posteriormente.
    public String entero(){
        StringBuilder ent = new StringBuilder();
        int absEntero = Math.abs(entero);
        if(absEntero == 0){
            ent.append(0);
        }else{
            while(absEntero != 0){
                int num = absEntero % 2;
                absEntero /= 2;
                ent.append(num);
            }
        }
        return ent.reverse().toString();
    }
    
    //Método para convertir la parte flotante del número decimal a binario
    //almacenando la parte entera de las diferentes multiplicaciones hasta tener
    //como máximo 25 cifras.
    public String decimal(){
        StringBuilder deci = new StringBuilder();
        double frac = decimal;
        for(int i = 0; i < 25 && frac !=0.0; i++){
             frac *=2; 
             if(frac >= 1){
                 deci.append("1");
                 frac -= 1;
             }else{
                 deci.append("0");
             }
        }
        return deci.toString();
    }
    
    //Método para almacenar el valor de la mantisa luego de haber logrado mover la coma.
    //Ingresa como parámetro un string de la forma 10110.01110 y retorna un string de la 
    //forma 011001110, es decir, elimina el primer término y el punto, pero almacena el
    //resto del string.
    public String mantisa(String numero){
        StringBuilder mantisa = new StringBuilder();
        int indicePunto = numero.indexOf('.');
        int indicePrimerUno = numero.indexOf('1');
        if (indicePrimerUno < indicePunto){ 
            mantisa.append(numero,1,indicePunto);
            mantisa.append(numero.substring(indicePunto+1));
        } else if (indicePunto == -1){
            mantisa.append(numero.substring(1));
        }else {
            mantisa.append(numero.substring(indicePrimerUno+1));
        }
        while(mantisa.length()<23){
            mantisa.append('0');
        }
        return mantisa.substring(0, 23);
    }
    
    //Método para unir las conversiones de la parte entera y flotante en un solo
    //número binario de la forma 10110.01110 
    public String coma(){
        StringBuilder coma = new StringBuilder();
        coma.append(entero()).append(".").append(decimal());
        return coma.toString();
    }
    
    //Método para obtener el valor del exponente al pasar el número binario flotante
    //a su notación exponencial en base dos. El exponente corresponde a la potencia 
    //de la base 2.
    public int exponente(){
        StringBuilder coma = new StringBuilder();
        coma.append(entero()).append(".").append(decimal());
        int i;
        for( i = 1; i < coma.length();i++){
            char punto = coma.charAt(i);
            if(punto == '.'){
                break;
            }   
        }
        int primerUno = coma.indexOf("1");
        if(primerUno < i){
            return i - primerUno - 1;
        }else{
            return i-primerUno;
        }
    }
    
    //Método para convertir el valor de exponente obtenido de la notación cientifica
    //en base 2 al formato binario de 8 bits.
    public String exp(){
        StringBuilder exp = new StringBuilder();
        int n = exponente();
        int nfinal = 127 + n;
        while(nfinal > 0){
            exp.append(nfinal%2);
            nfinal /= 2;
        }
        while(exp.length()<8){
            exp.append('0');
        }
        return exp.reverse().toString();
    }
    
    //Método para imprimir el número binario obtenido al transformar el número decimal.
    public String impresion(){
       String imp = signo()+exp()+mantisa(coma());
       return imp;
   }
}

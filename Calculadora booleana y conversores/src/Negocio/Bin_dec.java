package Negocio;

import java.text.DecimalFormat;

/**
 * @author Marck Hernández, Leandro Bravo, Anthony Contreras, Michael Enriquez, Edison Quizhpe, Yasid Jiménez, Cristian
 */
public class Bin_dec {
    
    private String sbin;
    private String ssgn;
    private String sexp;
    private String smant;
    
    //Constructor para crear el string asociado al número binario en el formato
    //IEEE 754
    public Bin_dec(String Sbin) {
        this.sbin = Sbin;
    }
    
    //Método para separar los bits del número binario en 1 bit para el signo,
    //8 bits para el exponente y 23 bits para la mantisa.
    public void separacion(){
        this.ssgn = sbin.substring(0, 1);
        this.sexp = sbin.substring(1, 9);
        this.smant = sbin.substring(9);
    }
    
    //Método para hallar el valor del exponente en decimal, se usa el método
    //bin_Dec_E para calcular el valor decimal de un binario entero.
    public double exponente(){
        double exp = bin_Dec_E(sexp);
        exp = exp - 127;
        return exp;
    } 
    
    //Método para retornar el número decimal con su parte decimal y signo. Se analizan
    //los casos especiales en que el número es muy muy pequeño, muy muy grande o un binario
    //no válido con conversión NaN. Si todo va bien, se usa el método bin_Dec_D para 
    //transformar la parte flotante del binario a decimal.
     public double numDec() {
        if (sexp.equals("00000000")) {
            // Caso para números subnormales o cero
            double nD = bin_Dec_D(smant);
            return Math.pow(-1, Integer.parseInt(ssgn)) * Math.pow(2, -126) * nD;
        } else if (sexp.equals("11111111")) {
            // Caso para infinito o NaN
            if (smant.equals("00000000000000000000000")) {
                return ssgn.equals("1") ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
            } else {
                return Double.NaN;
            }
        } else {
            int sgn = Integer.parseInt(ssgn);
            double nD = bin_Dec_D(smant);
            return Math.pow(-1, sgn) * (Math.pow(2, exponente())) * (1 + nD);
        }
    }
    
    //Método para convertir un binario a un decimal entero.
    public double bin_Dec_E(String bin){
        double dec = 0;
        int tamaño = bin.length();
        int i = 0;
        while ( i < tamaño){
            int b = Integer.parseInt(bin.substring(i, i+1));
            dec += b*Math.pow(2, tamaño-i-1);
            i++;
        }        
        return dec;
    }
    
    //Método para convertir un binario a un decimal flotante.
    public double bin_Dec_D(String binFlotante){
        double bF = 0;
        int tamaño = binFlotante.length();
        int i = 0;
        while ( i < tamaño){
            int b = Integer.parseInt(binFlotante.substring(i, i+1));
            bF += b*Math.pow(2, -i-1);
            i++;
        }        
        return bF;
    }
    
    //Método para imprimir el número decimal luego de la conversión con 6 decimales
    //significativos.
    public String impresion(){
        String salida = "";
        if(sexp.equals("00000000") || numDec()>10000){
            DecimalFormat formato = new DecimalFormat("0.######E0");
            salida = formato.format(numDec());
        } else {
            salida = String.format("%.6f",numDec());
        }
        return salida;
    }

}

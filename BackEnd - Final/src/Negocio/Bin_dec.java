package Negocio;

/**
 * @author Marck Hernández, Leandro Bravo, Anthony Contreras, Michael Enriquez, Edison Quizhpe, Yasid 
 */
public class Bin_dec {
       
    private String Sbin;
    private String Ssgn;
    private String Sexp;
    private String Smant;
    
    public Bin_dec(String Sbin) {
        this.Sbin = Sbin;
    }
    
    public void separacion(){
        this.Ssgn = Sbin.substring(0, 1);
        this.Sexp = Sbin.substring(1, 9);
        this.Smant = Sbin.substring(9);
    }
            
    public String signo(){
        String signo = "";
        if (Ssgn.equals("1")){
            signo = "-";
        } else {
            signo = "+";
        }
        return signo;
    }
    
    public double exponente(){
        double exp = bin_Dec_E(Sexp);
        exp = exp - 127;
        return exp;
    } 
    
     public double numDec() {
        if (Sexp.equals("00000000")) {
            // Caso para números subnormales o cero
            double nD = bin_Dec_D(Smant);
            return Math.pow(-1, Integer.parseInt(Ssgn)) * Math.pow(2, -126) * nD;
        } else if (Sexp.equals("11111111")) {
            // Caso para infinito o NaN
            if (Smant.equals("00000000000000000000000")) {
                return Ssgn.equals("1") ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
            } else {
                return Double.NaN;
            }
        } else {
            int sgn = Integer.parseInt(Ssgn);
            double nD = bin_Dec_D(Smant);
            return Math.pow(-1, sgn) * (Math.pow(2, exponente())) * (1 + nD);
        }
    }
    
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
    
    public String impresion(){
        String salida = "El numero decimal es: "+numDec();
        return salida;
    }
            
}

package Negocio;
import java.util.StringTokenizer;
/**
 * @author Marck Hernández
 */
public class Dec_bin {
     private double numero;
    private int entero;
    private double decimal;

    public Dec_bin(double numero) {
        this.numero = numero;
    }
    
    public void separar(){
        StringTokenizer tokens = new StringTokenizer(String.valueOf(numero),".");
        String en = tokens.nextToken();
        String dec = "." + tokens.nextToken();
        entero = Integer.parseInt(en);
        decimal = Double.parseDouble(dec);
    }
    
    public int signo(){
        if(entero < 0){
            return 1;
        }else{
            return 0;
        }
    }
    
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
    
    public String mantisa(String numero){
        StringBuilder mantisa = new StringBuilder();
        int indicePunto = numero.indexOf('.');
        if (indicePunto!=-1){ 
            mantisa.append(numero,1,indicePunto);
            mantisa.append(numero.substring(indicePunto+1));
        } else {
            mantisa.append(numero);
        }
        while(mantisa.length()<23){
            mantisa.append('0');
        }
        return mantisa.substring(0, 23);
    }

    public String coma(){
        StringBuilder coma = new StringBuilder();
        coma.append(entero()).append(".").append(decimal());
        return coma.toString();
    }
     
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
            return primerUno -i;
        }
    }
    
    
    public String exp(){
        StringBuilder exp = new StringBuilder();
        int n = exponente();
        int nfinal = 127 + n;
        while(nfinal > 0){
            exp.append(nfinal%2);
            nfinal /= 2;
        }
        return exp.reverse().toString();
    }
        

   public String impresion(){
       String imp = "El numero binario: " +signo()+ "."+exp()+"."+mantisa(coma());
       return imp;
   }
}

package Negocio;

/**
 * @author Marck Hernández
 */
public class BinDec_8bits {
    
    String nBin;

    public BinDec_8bits(String nBin) {
        this.nBin = nBin;
    }
    
    private double transformar(){
        Bin_dec conversion = new Bin_dec(null);
        double dec=0;
        if(nBin.charAt(0)=='1'){
            dec-=128;
            dec+= conversion.bin_Dec_E(nBin.substring(1));
        } else {
            
            dec = conversion.bin_Dec_E(nBin);
        }
        return dec;
    }
    
    public String impresion8bits(){
        String salida="El valor decimal asociado al numero de 8 bits es: "+String.valueOf(transformar());
        return salida;
    }
}

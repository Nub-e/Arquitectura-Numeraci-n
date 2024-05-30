package Negocio;

/**
 * @author Marck Hernández, Leandro Bravo, Anthony Contreras, Michael Enriquez, Edison Quizhpe, Yasid Jiménez, Cristian
 */
public class BinDec_8bits {
    
    StringBuilder nBin;
    
    //Constructor para leer y guardar el número binario en el formato de 8 bits.
    public BinDec_8bits(StringBuilder nBin) {
        this.nBin= new StringBuilder();
        if(nBin.length()<8){
            for(int i=0; i < 8-nBin.length(); i++){
                this.nBin.append(0);
            }
            this.nBin.append(nBin);
        } else if (nBin.length()==8){
            this.nBin.append(nBin);
        } 
    }
    
    //Método usado para realizar la conversión de binario a decimal,
    //se analiza si el primer bit es 0 o 1, en caso de ser 1 se adjunta el valor de
    //-128 al número decimal y el resto se manda a transformar con el método 
    //bin_Dec_E de la clase Bin_dec. Retorna un valor de tipo double que representa
    //el número decimal obtenido.
    private double transformar(){
        Bin_dec conversion = new Bin_dec(null);
        double dec=0;
        if(nBin.charAt(0)=='1'){
            dec-=128;
            dec+= conversion.bin_Dec_E(nBin.substring(1));
        } else {
            dec = conversion.bin_Dec_E(nBin.toString());
        }
        return dec;
    }
    
    //Método para imprimir el valor decimal asociado al número binario ingresado.
    public String impresion8bits(){
        String salida=String.valueOf(transformar());
        return salida;
    }
}

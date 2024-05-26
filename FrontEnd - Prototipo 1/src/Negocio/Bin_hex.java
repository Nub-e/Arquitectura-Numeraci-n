package Negocio;

/**
 * @author Marck Hernández
 */
public class Bin_hex {
    
    String sbin;
    
    public Bin_hex(String Sbin) {
        this.sbin = Sbin;
    }
    
    public String transformar(){
        String aux = "";
        StringBuilder hex = new StringBuilder();
        Bin_dec dec = new Bin_dec("");
        int tamanio = sbin.length();
        int i = 0;
        while (i<tamanio){
            aux = sbin.substring(i, i+4);
            hex.append(hex(dec.bin_Dec_E(aux)));
            i = i+4;
        }
        return hex.toString();
    }
    
    public String hex(double dec){
        StringBuilder hex = new StringBuilder();
        int aux_dec = (int) dec;
        switch (aux_dec) {
            case 0: hex.append('0'); break;
            case 1: hex.append('1'); break;
            case 2: hex.append('2'); break;
            case 3: hex.append('3'); break;
            case 4: hex.append('4'); break;
            case 5: hex.append('5'); break;
            case 6: hex.append('6'); break;
            case 7: hex.append('7'); break;
            case 8: hex.append('8'); break;
            case 9: hex.append('9'); break;
            case 10: hex.append('A'); break;
            case 11: hex.append('B'); break;
            case 12: hex.append('C'); break;
            case 13: hex.append('D'); break;
            case 14: hex.append('E'); break;
            case 15: hex.append('F'); break;
            default:
                throw new AssertionError();
        }
        return hex.toString();
    }
    
    public String decimal(){
        Bin_dec dec = new Bin_dec(sbin);
        dec.separacion();
        return dec.impresion();
    }
    
    public String impresion(){
        String salida = "El numero hexadecimal es: "+transformar()+"\n"+decimal();
        return salida;
    }
}

package Negocio;

/**
 * @author Marck Hernández
 */
public class Hex_bin {
    
    private String hexa;
    
    //Constructor para leer y asignar el número hexadecimal a una variable global
    //del tipo String que será utilizada en los diferentes métodos de esta clase.
    public Hex_bin(String hexa) {
        this.hexa = hexa.toUpperCase();
    }
    
    //Método para verificar si se ingresaron 8 caracteres hexadecimales, si se 
    //ingresaron menos caracteres se agregan ceros al inicio.
    public String verificar(){
        while(hexa.length() < 8){
            hexa = "0" +  hexa ;
        }
        return hexa;
    }
    
    //Método que nos permite asociar un valor binario de 4 digitos para cada 
    //caracter hexadecimal, es decir, transforma caracter por caracter.
    public String bin(){
        StringBuilder bin = new StringBuilder();
        int i =0;
        while( i < hexa.length()){
            char ch = hexa.charAt(i);
            switch(ch){
                case '0' : bin.append("0000");break;
                case '1' : bin.append("0001");break;
                case '2' : bin.append("0010");break;
                case '3' : bin.append("0011");break;
                case '4' : bin.append("0100");break;
                case '5' : bin.append("0101");break;
                case '6' : bin.append("0110");break;
                case '7' : bin.append("0111");break;
                case '8' : bin.append("1000");break;
                case '9' : bin.append("1001");break;
                case 'A' : bin.append("1010");break;
                case 'B' : bin.append("1011");break;
                case 'C' : bin.append("1100");break;
                case 'D' : bin.append("1101");break;
                case 'E' : bin.append("1110");break;
                case 'F' : bin.append("1111");break;
                default:
                    throw new IllegalArgumentException("Invalid hexadecimal character: " + ch);
            }
            i++;
        }
        return bin.toString();
    }
    
    //Método para imprimir el valor del número binario obtenido al convertir el número 
    //hexadecimal ingresado.
    public String impresion(){
       String imp =  bin();
       return imp;
   }
    
}

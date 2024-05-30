package Negocio;

/**
 * @author asus
 */
public class dec_bin8bits {
    private int numero;

    public dec_bin8bits(int numero) {
        this.numero = numero;
    }
    
    
    public String binario(){
        StringBuilder bin = new StringBuilder();
        Dec_bin binario = new Dec_bin (numero);
        binario.separar();
        String numero = binario.entero();
        for(int i = 0; i < numero.length();i++){
            bin.append(numero.charAt(i));
        }
        while(bin.length() < 7){
            bin.insert(0,'0');
        }
        return bin.toString();
    }
    
    public String complemento1(String binario){
        StringBuilder complemento = new StringBuilder();
        for(char bin : binario.toCharArray()){
            complemento.append(bin == '0' ? '1' : '0');
        }
        return complemento.toString();
    }
    
   public String complemento2(String complemento1){
       StringBuilder comp2 = new StringBuilder();
       boolean acarreo = true;
       for(int i = complemento1.length() - 1; i>=0 ; i--){
           char bit = complemento1.charAt(i);
           if(acarreo){
               if(bit == '1'){
                   comp2.append('0');
               }else{
                   comp2.append('1');
                   acarreo = false;
               }
           }else{
               comp2.append(bit);
           }
       }if(acarreo){
           comp2.append('1');
       }
       return comp2.reverse().toString();
   } 
   
   public boolean signo(){
        int n = numero;
        if(n < 0){
            return true;
        }else{
            return false;
        }
    }
   
   public String imprimir(){
       if(signo() == false){
            return "El numero es positivo y su complemento a 2 es: " + binario();
        }else{
            return "El numero es negativo y su complemento a 2 es: " + complemento2(complemento1(binario()));
        }
   }
  
   
   
}

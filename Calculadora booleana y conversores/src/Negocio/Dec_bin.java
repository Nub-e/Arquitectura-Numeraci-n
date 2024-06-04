package Negocio;

/**
 * @author answ3r
 */
public class Dec_bin {

    private float numero;

    // Constructor para leer y asignar el número decimal a una variable global con la que se va a trabajar.
    public Dec_bin(float numero) {
        this.numero = numero;
    }

    // Método para saber si se debe agregar un 0 o 1 como el valor del bit del signo.
    public int signo() {
        return (numero < 0) ? 1 : 0;
    }
    
    // Método para obtener los bits del número en formato float
    public int bits() {
        return Float.floatToIntBits(numero); 
    }

    // Método para obtener el valor de exponente en formato binario.
    public String obtenerExponente(int bits) {
        // Extraer los bits del exponente (bits 23 a 30, 8 bits en total)
        int exponente = (bits >>> 23) & 0xFF; // -> 0xFF es una máscara para obtener 8 bits
        StringBuilder exp = new StringBuilder();
        while (exponente > 0) {
            exp.append(exponente % 2);
            exponente /= 2;
        }

        while (exp.length() < 8) {
            exp.append('0');
        }

        return exp.reverse().toString();
    }

    // Método para obtener el valor de la mantisa.
    public String obtenerMantisa(int bits) {
        // Extraer los bits de la mantisa (bits 0 a 22, 23 bits en total)
        int mantisa = bits & 0x7FFFFF; // 23 bits para la mantisa
        StringBuilder mantisaStr = new StringBuilder();
        for (int i = 0; i < 23; i++) {
            mantisaStr.append((mantisa & 0x400000) == 0 ? '0' : '1'); //-> solo el segundo bit es uno los demás son 0 
            mantisa <<= 1; // -> desplaza a la izquierda la mantisa
        }

        return mantisaStr.toString();
    }

    // Método para imprimir el número binario obtenido al transformar el número decimal.
    public String impresion() {
        int bits = bits();
        return signo() + obtenerExponente(bits) + obtenerMantisa(bits);
    }
}

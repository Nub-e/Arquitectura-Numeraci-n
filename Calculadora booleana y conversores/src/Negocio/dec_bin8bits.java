package Negocio;

/**
 * @author asus
 */
public class dec_bin8bits {
    
    private int numero;  // Cambiar a entero para asegurar una representación adecuada en binario

    public dec_bin8bits(int numero) {
        this.numero = numero;
    }

    // Método para obtener la representación binaria de un número entero en 8 bits
    public String binario() {
        StringBuilder bin = new StringBuilder();
        int num = Math.abs(numero);
        while (num > 0) {
            bin.append(num % 2);
            num /= 2;
        }
        while (bin.length() < 8) {
            bin.append('0');
        }
        return bin.reverse().toString();
    }

    // Método para calcular el complemento a uno
    public String complemento1(String binario) {
        StringBuilder complemento = new StringBuilder();
        for (char bin : binario.toCharArray()) {
            complemento.append(bin == '0' ? '1' : '0');
        }
        return complemento.toString();
    }

    // Método para calcular el complemento a dos
    public String complemento2(String complemento1) {
        StringBuilder comp2 = new StringBuilder();
        boolean acarreo = true;
        for (int i = complemento1.length() - 1; i >= 0; i--) {
            char bit = complemento1.charAt(i);
            if (acarreo) {
                if (bit == '1') {
                    comp2.append('0');
                } else {
                    comp2.append('1');
                    acarreo = false;
                }
            } else {
                comp2.append(bit);
            }
        }
        if (acarreo) {
            comp2.append('1');
        }
        return comp2.reverse().toString();
    }

    // Método para imprimir la representación binaria o su complemento a dos según el signo del número
    public String imprimir() {
        if (numero >= 0) {
            return "El numero es positivo y su complemento a 2 es: " + binario();
        } else {
            return "El numero es negativo y su complemento a 2 es: " + complemento2(complemento1(binario()));
        }
    }
}


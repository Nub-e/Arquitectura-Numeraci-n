package Negocio;

import Vista.Bienvenida;
import java.util.Scanner;

/**
 * @author Marck Hernández
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        
//        System.out.println("TRANSFORMACION BINARIO A DECIMAL FORMATO 8 BITS:\n");
//        System.out.println("Ingrese el numero binario que desea transformar:\n");
//        String sbin8 =  scan.next();
//        StringBuilder s = new StringBuilder(sbin8);
//        BinDec_8bits bin8 = new BinDec_8bits(s);
//        System.out.println(bin8.impresion8bits());
//        
//        System.out.println("TRANSFORMACION BINARIO A DECIMAL:\n");
//        System.out.println("Ingrese el numero binario que desea transformar en el formato IEEE 754:\n");
//        String sbind = scan.next();
//        Bin_dec dbinario  = new Bin_dec(sbind);
//        dbinario.separacion();
//        System.out.println(dbinario.impresion());
//        System.out.println("\nTRANSFORMACION DECIMAL A BINARIO:\n");
//        System.out.println("Ingrese el numero decimal que desea transformar:\n");
//        String numero = scan.next();
//        float ndec = Float.parseFloat(numero);
//        Dec_bin decimal = new Dec_bin(ndec);
//        System.out.print(decimal.impresion());
//        
//        System.out.println("\n\nTRANSFORMACION BINARIO A HEXADECIMAL:\n");
//        System.out.println("Ingrese el numero binario que desea transformar en el formato IEEE 754:\n");
//        String sbinh = scan.next();
//        Bin_hex hexadecimal = new Bin_hex(sbinh);
//        System.out.println(hexadecimal.impresion());
//        
//        System.out.println("\nTRANSFORMACION HEXADECIMAL A BINARIO:\n");
//        System.out.println("Ingrese el numero hexadecimal que desea transformar:\n");
//        String shex = scan.next();
//        Hex_bin hbinario = new Hex_bin(shex);
//        hbinario.verificar();
//        System.out.println(hbinario.impresion());

        Bienvenida bien = new Bienvenida();
        bien.setVisible(true);

//        System.out.println("\nTRANSFORMACION DECIMAL A BINARIO en 8 bits:\n");
//        System.out.println("Ingrese el numero decimal que desea transformar:\n");
//        String num = scan.next();
//        double n = Double.parseDouble(num);
//        dec_bin8bits bit = new dec_bin8bits((int) n);
//        System.out.print(bit.imprimir());

        
    }
    
}
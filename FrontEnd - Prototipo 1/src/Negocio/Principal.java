package Negocio;

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
        
        System.out.println("TRANSFORMACION BINARIO A DECIMAL FORMATO 8 BITS:\n");
        System.out.println("Ingrese el numero binario que desea transformar:\n");
        String sbin8 = scan.next();
        BinDec_8bits bin8 = new BinDec_8bits(sbin8);
        System.out.println(bin8.impresion8bits());
        
        System.out.println("TRANSFORMACION BINARIO A DECIMAL:\n");
        System.out.println("Ingrese el numero binario que desea transformar en el formato IEEE 754:\n");
        String sbind = scan.next();
        Bin_dec dbinario  = new Bin_dec(sbind);
        dbinario.separacion();
        System.out.println(dbinario.impresion());
        
        System.out.println("\nTRANSFORMACION DECIMAL A BINARIO:\n");
        System.out.println("Ingrese el numero decimal que desea transformar:\n");
        double ndec = scan.nextDouble();
        Dec_bin decimal = new Dec_bin(ndec);
        decimal.separar();
        System.out.print(decimal.impresion());
        
        System.out.println("\n\nTRANSFORMACION BINARIO A HEXADECIMAL:\n");
        System.out.println("Ingrese el numero binario que desea transformar en el formato IEEE 754:\n");
        String sbinh = scan.next();
        Bin_hex hexadecimal = new Bin_hex(sbinh);
        System.out.println(hexadecimal.impresion());
        
        System.out.println("\nTRANSFORMACION HEXADECIMAL A BINARIO:\n");
        System.out.println("Ingrese el numero hexadecimal que desea transformar:\n");
        String shex = scan.next();
        Hex_bin hbinario = new Hex_bin(shex);
        hbinario.verificar();
        System.out.println(hbinario.impresion());
        
    }
    
}

package calculadoraBooleana;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Marck Hernández
 */
public class OperacionesBooleanas {
    
  private String exprVerif;
  private String[] expRegAlgBoole = new String[] {"([a-zA-Z])\\+0", 
                                                  "([a-zA-Z])\\+1",
                                                  "([a-zA-Z])\\+1", 
                                                  "([a-zA-Z])\\+1([a-zA-Z])"};

    public OperacionesBooleanas(String exprVerif) {
        this.exprVerif = exprVerif;
    }
    
    public void algebraBoole(String lectura){
        for(String expReg: expRegAlgBoole){
            if(comprobar(lectura, expReg)){
                
            }
        }
    }
    
    public boolean comprobar(String datos, String patron){
        Pattern pat= Pattern.compile(patron);
        Matcher mat= pat.matcher(datos);
        return mat.matches();
    }
  

    
}

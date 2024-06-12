package calculadoraBooleana;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Marck Hernández
 */
public class OperacionesBooleanas {
    
    public OperacionesBooleanas() {
    }
    
    //Método recursivo que envía las expresiones en sumas o multiplicaciones hasta poner negar
    //cada uno de los términos, la negación se la realiza en MorganEjec() en el else.
    public Node Morgan(Node nodo){
        ExpressionSimplifier simplificar = new ExpressionSimplifier();
        String expr = simplificar.impresionFinal(nodo);
        if(expr.charAt(0)=='(' && expr.charAt(expr.length()-1)==')'){
            expr=expr.substring(1, expr.length()-1);        
        }
        Queue<Node> negados = new LinkedList<>();
        
        Node aux=null;
        if(expr.matches("(\\([ABC01+*~\\(\\)]+\\))+(\\+)+(\\([ABC01~+*\\(\\)]+\\))+(\\+|\\*)*([ABC01*+~])*")){
            String[] sumandos = expr.split("\\)\\+\\(");
            negados = reagruparArbol(quitarParentesis(sumandos, negados),"*");
            return negados.poll();
        }else if(expr.matches("(\\([ABC01+*~\\(\\)]+\\))+(\\*)+(\\([ABC01~+*\\(\\)]+\\))+(\\+|\\*)*([ABC01*+~])*")){
            String[] multiplicandos = expr.split("\\)\\*\\(");
            negados = reagruparArbol(quitarParentesis(multiplicandos, negados),"+");
            return negados.poll();
        } else {
            aux = MorganEjec(nodo,simplificar);
        }
        return aux;
    }
    
    //Cuenta el número de paréntesis de apertura
    public int contarApertura(String contA){
        int count = 0;
        int i=0;
        while(i < contA.length()){
            if(contA.charAt(i)=='('){                
                count++;
            }
            i++;
        }
        return count;
    }
    
    //Cuenta el número de paréntesis de cerrado
    public int contarCerrado(String contC){
        int count = 0;
        int i=0;
        while(i < contC.length()){
            if(contC.charAt(i)==')'){                
                count++;
            }
            i++;
        }
        return count;
    }
    
    //Método ocupado en Morgan() para quitar los paréntesis(Balanceo de paréntesis) de las expresiones enviadas nuevamente de
    //manera recursiva
    public Queue<Node> quitarParentesis(String[] operandos, Queue<Node> procesados){
        Node aux;
        int difCont=0;
        for(String term: operandos){
            difCont = contarApertura(term)-contarCerrado(term);
            if(difCont > 0){
                while(difCont!=0){
                    int vP = term.indexOf('(');
                    term = term.substring(0,vP)+term.substring(vP+1);
                    difCont--;
                }
            } else {
                int vP=0;
                StringBuilder termT = new StringBuilder(term);
                termT = termT.reverse();
                while (difCont!=0){
                    vP = termT.indexOf(")");
                    vP = term.length()-1-vP;
                    term = term.substring(0,vP)+term.substring(vP+1);
                    termT= new StringBuilder(term).reverse();
                    difCont++;
                }
            }
            aux=Morgan(new Node(term));
            procesados.add(aux);
        }
        return procesados;
    }
    
    //Este método toma una cola de nodos y reagrupa el árbol en base a la prioridad de sus signos.
    public Queue<Node> reagruparArbol(Queue<Node> procesados,String signo){
        Node aux;
        while(procesados.size()>1){
            Node left= null,right=null;
            if(!procesados.isEmpty()){
                left = procesados.poll();
            }
            if(!procesados.isEmpty()){
                right = procesados.poll();
            }
            aux = new Node(signo, left, right);
            procesados.add(aux);
        }
        return procesados;
    }
    
    //Este método realiza las operaciones de negación e involución empezando desde las hojas y subiendo a sus predecesores.
    public Node MorganEjec(Node nodo,ExpressionSimplifier simplificar){
        ExpressionParser parsear = new ExpressionParser();
        String expr = simplificar.impresionFinal(nodo);
        Node aux;
        if(expr.matches("\\([ABC01~*+\\(\\)]+\\)\\*[ABC01~*+\\(\\)]+")){ // agregue que todo lo que se añade al lado derecho se añada al izquiero y viceversa asi no hay el error de tener signos afuera del parenteis
            String [] previo = expr.split("\\)\\*");                    //ejemplo (~((a)) cuando deberia ser (~a).
            Queue<Node> trabajados = new LinkedList<>();
            trabajados = quitarParentesis(previo, trabajados);
            trabajados = reagruparArbol(trabajados, "+");
            aux = trabajados.poll();
        } else if(expr.matches("\\([ABC01~*+\\(\\)]+\\)\\+[ABC01~*+\\(\\)]+")){
            String [] previo = expr.split("\\)\\+");
            Queue<Node> trabajados = new LinkedList<>();
            trabajados = quitarParentesis(previo, trabajados);
            trabajados = reagruparArbol(trabajados, "*");
            aux = trabajados.poll();
        }
        else {
            if(expr.charAt(0)=='(' && expr.charAt(expr.length()-1)==')'){
                expr=expr.substring(1, expr.length()-1);        
            }
            String[] sumandos = expr.split("\\+");
            String[] multiplicandos;
            String juntar="";
            for(int i=0; i<sumandos.length;i++){
                multiplicandos = sumandos[i].split("\\*");
                for(int j=0; j<multiplicandos.length;j++){
                    if(multiplicandos[j].matches("(\\~[ABC01+~*])")){ //añadi los signos si se los saca no habria problema pero estaba intentando tener el regex de las 4 ultimas expresiones 
                        multiplicandos[j]=multiplicandos[j].substring(1);
                    } else {
                        multiplicandos[j]="~"+multiplicandos[j]; //negación
                    }
                }
                juntar="";
                for(String term: multiplicandos){
                    juntar+=term+"+";
                }
                sumandos[i]="("+juntar.substring(0, juntar.length()-1)+")";
            }
            juntar="";
            for(String term: sumandos){
                juntar+=term+"*";
            }
            expr = juntar.substring(0, juntar.length()-1);
            aux = parsear.parseExpression(expr);
        }
        return aux;
    }
    
    //Aplicación de las propiedades del algebra de boole junto con algunas operaciones básicas.
    public String aplicarReglasBasicas(String expr,ExpressionSimplifier simplificar) {
        
        //Funcionan Bien 
        if(expr.matches("([ABC~()]+)\\*\\(([ABC~(*]+)\\)")){
            expr=expr.replaceAll("\\(", "");
            expr=expr.replaceAll("\\)", "");
        }
        
        expr = expr.replaceAll("([ABC*+~()]+)\\+\\(\\~\\1\\)", "1");  // a + (~a) = 1
        expr = expr.replaceAll("([ABC*+~()]+)\\*\\(\\~\\1\\)", "0");  // a * (~a) = 0
        expr = expr.replaceAll("\\(\\~([ABC*+]+)\\)\\+\\1", "1");  // (~a) + a = 1
        expr = expr.replaceAll("\\~([ABC~*+]+)\\*\\1", "0");  // (~a) * a = 0
        
        expr = expr.replaceAll("([ABC~*+()]+)\\+0", "$1");  // a + 0 = a // w quiere decir caracter alfa numerico y cuando la expresion tiene esta forma w \\+1 quiere decir que si encuntra un 1 
        expr = expr.replaceAll("0\\+([ABC~*+()]+)", "$1");  // 0 + a = a // y seguido tiene el mismo caracter la aplica 
        expr = expr.replaceAll("([ABC~*+()]+)\\+1", "1");   // a + 1 = 1
        expr = expr.replaceAll("1\\+([ABC~*+()]+)", "1");   // 1 + a = 1
        expr = expr.replaceAll("([ABC~*+()]+)\\*0", "0");   // a * 0 = 0
        expr = expr.replaceAll("0\\*([ABC~*+()]+)", "0");   // 0 * a = 0
        expr = expr.replaceAll("([ABC~*+()]+)\\*1", "$1");  // a * 1 = a
        expr = expr.replaceAll("1\\*([ABC~*+()]+)", "$1");  // 1 * a = a
        expr = expr.replaceAll("\\(([ABC*~+()]+)\\)\\+\\1", "$1");  // a + a = a
        expr = expr.replaceAll("\\(([ABC~])\\*([ABC~])\\)\\+\\((\\2\\*\\1)\\)", "$3"); // (A*B)+(B*A)=B*A
        
        expr = expr.replaceAll("\\(([ABC~*+()]+)\\)\\*\\1", "$1");  // (a) * a = a
        expr = expr.replaceAll("([ABC~]+)\\*\\1", "$1");  //  a * a = a        
        
       
        expr = expr.replaceAll("\\(*([ABC~*+()]+)\\)*\\+\\(*\\1\\)*\\*\\(*([ABC~*+()]+)\\)*", "$1");  // (a) + (a)*(b) = a
        expr = expr.replaceAll("\\(*([ABC~*+()]+)\\)*\\+([ABC~*()]+)\\*\\(*\\1\\)*", "$1");  // (a) + (b)*(a) = a
        expr = expr.replaceAll("\\(*([ABC~*()]+)\\)*\\*\\(*([ABC~*()]+)\\)*\\+\\(*\\1\\)", "$1");  // (a)*(b) + (a) = a
        expr = expr.replaceAll("\\(*([ABC~*()]+)\\)*\\*\\(*([ABC~*()+]+)\\)\\+\\(*\\2\\)*", "$2");  //  (b)*(a) + (a) = a

        if((contarApertura(expr)-contarCerrado(expr))!=0){
            String[] operandos = expr.split("\\+");
            operandos = quitarParentesisNormal(operandos);
            expr="";
            for(String term: operandos){
                expr+=term+"+";
            }
            expr= expr.substring(0, expr.length()-1);
        }

        
        
        expr = expr.replaceAll("([ABC~+*()+]+)\\+\\(\\(\\~\\1\\)\\*([ABC+~*()+]+)\\)", "$1+$2");  // a + (~a)*b = a + b
        if(!expr.matches("\\(([ABC~+*()+]+)\\)\\+\\(([ABC+~*()+]+)\\)\\+([ABC+~*()+]+)")){
            expr = expr.replaceAll("([ABC~+*()+]+)\\+\\(([ABC+~*()+]+)\\*\\(\\~\\1\\)\\)", "$1+$2");  // a + b*(~a) = a + b
        }
        expr = expr.replaceAll("\\(([ABC~+*()+]+)\\*\\(\\~([ABC()+]+)\\)\\)\\+\\2", "$1+$2");  // b*(~a)+a = a + b
        expr = expr.replaceAll("\\(\\(\\~([ABC()+]+)\\)\\*\\(*([ABC~+*()+]+)\\)\\)\\+\\1", "$1+$2");  // (~a)*b+a = a + b
        expr = expr.replaceAll("([ABC~+*()+]+)\\*\\(*([ABC()+*~]+)\\)*\\+\\(\\~\\2\\)", "$1+~$2");//b*a+(~a)=~a+b
        expr = expr.replaceAll("([ABC~+*()+]+)\\*\\(*([ABC()+*~]+)\\)*\\+\\(\\~\\1\\)", "$1+~$2");//a*b+(~a)
        expr = expr.replaceAll("\\(*\\~\\(*([ABC+*]+)\\)*\\+\\(*\\1\\)*\\*\\(*([ABC+*~]+)\\)*", "~($1)+$2");//(~a)+a*b=~(a)+b
        expr = expr.replaceAll("\\(*\\~\\(([ABC+*~]+)\\)*\\+\\(*([ABC+~*]+)\\)*\\*\\(\\1\\)", "~($1)+$2");//(~a)+b*a=~(a)+b
        
        
        
        if(!expr.matches("\\(([ABC*+~()]+)\\)\\+\\(([ABC*+~()]+)\\)")){
            if(expr.matches("([ABC~]+)\\*\\(*([ABC~]+)\\)*\\+([ABC~(]+)\\)*")){
                expr = expr.replaceAll("([ABC~()+]+)\\*\\(([ABC~()]+)\\)*\\+([ABC~(]+)\\)*","$1*$2+$1*$3"); //A*(B+C) = A*B+A*C
            }
        }

        //Distributiva doble
        if(expr.matches("(\\([ABC*+~()]+\\))(\\+)+(\\([ABC*+~()]+\\))")){
            String[] operandos = expr.split("\\)\\+\\(");
            operandos = quitarParentesisNormal(operandos);
            int i = 0;
            for(String aux: operandos){
                operandos[i] = aux.replaceAll("\\(([ABC~()]+)\\+([ABC~()]+)\\)\\*([ABC~()+]+)","$1*$3+$2*$3");
                i++;
            }
            expr="";
            if((operandos.length%2)==0){
                for(i=0; i<operandos.length-1;i+=2){
                    expr+="("+operandos[i]+"+"+operandos[i+1]+")+";
                } 
            }else {
                for(String term: operandos){
                    expr+=term+"+";
                }
            }
            expr = "("+expr.substring(0, expr.length()-1)+")";
        }
        if(expr.matches("([ABC*+~\\(\\)]+)(\\+)+([ABC*+~\\(\\)]+)")){
            expr = "("+expr+")";
        }
        if(expr.charAt(0)=='(' && expr.charAt(expr.length()-1)==')'){
                if(!expr.contains(")*(")){
                    expr=expr.substring(1, expr.length()-1); 
                }
                return expr;
            }
        return expr;
    }
    
    //Método para asociar multiplicaciones
    public String asociarMultiplicaciones(String expr){
        if(expr.matches("([ABC~()]+)\\*([ABC~()]+)\\*([ABC+~()*]+)")){
            String[] terms;
            String regex = "([ABC~+*()]+)\\*([ABC~*+()]+)\\*(\\([ABC~*+()]+\\))";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(expr);
            terms = new String[matcher.groupCount()];
            
            for(int i=0; i<3; i++){
                terms[i]=expr.replaceAll(regex, "$"+(i+1));
            }
            if(!terms[0].equals(terms[1])){
                if(!terms[0].equals(terms[2])){
                    terms = quitarParentesisNormal(terms);
                    String [] sumas= terms[2].split("\\+");
                    sumas = quitarParentesisNormal(sumas);
                    expr="(";
                    for(String aux: sumas){
                        expr+=terms[1]+"*"+aux+"+";
                
                    }
                    expr= expr.substring(0,expr.length()-1);
                    expr+=")*"+terms[0];
                }
            } else {
                terms = expr.split("\\*");
                terms = quitarParentesisNormal(terms);
                    String [] sumas= terms[2].split("\\+");
                    sumas = quitarParentesisNormal(sumas);
                    expr="(";
                    for(String aux: sumas){
                        expr+=terms[1]+"*"+aux+"+";
                
                    }
                    expr= expr.substring(0,expr.length()-1);
                    expr+=")*"+terms[0];
            }
                        
        }
        
        return expr;
    }
    
    //Método para asociar sumas.
    public String asociarSumas(String expr){
        if(expr.matches("\\(*([ABC~*()]+)\\)*\\+\\(*([ABC~*()]+)\\)\\+\\(*([ABC~*+()]+)\\)*")){
            String[] terms;
            String regex = "\\(*([ABC~*()]+)\\)*\\+\\(*([ABC~*()]+)\\)\\+\\(*([ABC~*+()]+)\\)*";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(expr);
            expr = expr.replaceAll(regex, "($2+$3)+$1");
            if((contarApertura(expr)-contarCerrado(expr))!=0){
                String[] operandos = expr.split("\\+");
                operandos = quitarParentesisNormal(operandos);
                expr="";
                for(String term: operandos){
                    expr+=term+"+";
                }
                expr= expr.substring(0, expr.length()-1);
            }           
        }
        
        return expr;
    }
        
    //Método para balancear paréntesis de las expresiones que no van a Morgan.
    public String[] quitarParentesisNormal(String[] operandos){
        Node aux;
        int difCont=0;
        int i = 0;
        for(String term: operandos){
            difCont = contarApertura(term)-contarCerrado(term);
            if(difCont > 0){
                while(difCont!=0){
                    int vP = term.indexOf('(');
                    term = term.substring(0,vP)+term.substring(vP+1);
                    operandos[i] = term;
                    difCont--;
                }
            } else {
                int vP=0;
                StringBuilder termT = new StringBuilder(term);
                termT = termT.reverse();
                while (difCont!=0){
                    vP = termT.indexOf(")");
                    vP = term.length()-1-vP;
                    term = term.substring(0,vP)+term.substring(vP+1);
                    termT= new StringBuilder(term).reverse();
                    operandos[i] = term;
                    difCont++;
                }
            }
            i++;
        }
        return operandos;
    }

    //Método en el que obtenemos la expresión del árbol y aplicamos sus reglas básicas.
    public String simplificarBoolean(Node nodo){ //Llamo a esta funcion para obtener el string simplificado , se puede cambiar si lo crees necesario 
        ExpressionSimplifier simplificar = new ExpressionSimplifier();
        String expr = simplificar.impresionFinal(nodo);
        if(expr.charAt(0)=='(' && expr.charAt(expr.length()-1)==')'){
                expr=expr.substring(1, expr.length()-1); 
            }
        expr = aplicarReglasBasicas(expr,simplificar);
        return expr;
    }
    
}

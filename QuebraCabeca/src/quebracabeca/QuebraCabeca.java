package quebracabeca;

/**
 *
 * @author aluno
 */
public class QuebraCabeca {

    public static void main(String[] args) {
        
        Borda b1 = new Borda(true,false);
        Borda b2 = new Borda(false,true);
        Borda b3 = new Borda(true,false);
        Borda b4 = new Borda(true,false);
        
        Peca pecacentro1 = new PecaCentro(1,b1,b2,b3,b4);
        
        Peca pecacentro2 = new PecaCentro(1,b2,b1,b4,b3);
        
        
        
        if(pecacentro1.seConecta(pecacentro2)==true){
            System.out.println("Conectou");
        }else{
            System.out.println("Não conectou");
        }
        
        
    }
    
}

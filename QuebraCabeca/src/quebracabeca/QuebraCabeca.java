package quebracabeca;

/**
 *
 * @author aluno
 */
public class QuebraCabeca {

    public static void main(String[] args) {
        
        Tabuleiro tabuleiro1 = new Tabuleiro();
        
        Borda b1 = new Borda(true,false);
        Borda b2 = new Borda(false,true);
        Borda b3 = new Borda(true,false);
        Borda b4 = new Borda(true,false);
        
        Peca peca1 = new PecaCentro(b1,b2,b3,b4);
        Peca peca2 = new PecaCentro(b2,b1,b4,b3);
        Peca peca3 = new PecaCentro(b4,b1,b2,b3);
        Peca peca4 = new PecaCentro(b3,b4,b1,b2);
        Peca peca5 = new PecaCentro(b1,b2,b4,b3);
        Peca peca6 = new PecaCentro(b2,b3,b1,b4);
        Peca peca7 = new PecaCentro(b4,b2,b3,b1);
        Peca peca8 = new PecaCentro(b2,b1,b4,b4);
        Peca peca9 = new PecaCentro(b4,b2,b3,b1);
        
        if(peca1.Conectar(peca8,1)){
            System.out.println("Conectou");
            tabuleiro1.posicionarPeca(0, 0, peca1);
            tabuleiro1.posicionarPeca(0, 1, peca2);
        }else{
            System.out.println("Não conectou");
        }
        
//        if(peca2.Conectar(peca3, 0))
        
        
        
    }
    
}

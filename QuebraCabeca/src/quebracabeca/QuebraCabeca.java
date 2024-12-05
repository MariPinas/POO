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
        Borda b3 = new Borda(true,true);
        Borda b4 = new Borda(true,false);
        
        Peca peca1 = new PecaCentro(b1,b2,b2,b4);
        Peca peca2 = new PecaCentro(b2,b1,b3,b4);
        
        
        Peca peca3 = new PecaCentro(b2,b1,b3,b4);
        Peca peca4 = new PecaCentro(b1,b1,b1,b4);
        
        Peca peca5 = new PecaCentro(b1,b1,b1,b4);
        Peca peca6 = new PecaCentro(b2,b1,b2,b4);
        
        Peca peca7 = new PecaCentro(b1,b2,b1,b4);
        Peca peca8 = new PecaCentro(b2,b1,b2,b4);
        Peca peca9 = new PecaCentro(b1,b2,b1,b2);
        
        if(peca2.Conectar(peca1,1)){
            System.out.println("Conectou");
            tabuleiro1.posicionarPeca(0, 0, peca1);
            tabuleiro1.posicionarPeca(0, 1, peca2);
        }else{
            System.out.println("Não conectou");
        }
        
        if(peca2.Conectar(peca3, 1)){
            System.out.println("Conectou");
            tabuleiro1.posicionarPeca(0, 2, peca3);
        }else{
            System.out.println("Não conectou");
        }
        
        if(peca4.Conectar(peca1, 0)){
            System.out.println("Conectou");
            tabuleiro1.posicionarPeca(1, 0, peca4);
        }else{
            System.out.println("Não conectou");
        }
        
        if(peca5.Conectar(peca4, 1) && peca2.Conectar(peca5,3)){
            System.out.println("Conectou");
            tabuleiro1.posicionarPeca(1, 1, peca5);
        }else{
            System.out.println("Não conectou");
        }
        if(peca6.Conectar(peca5, 1) && peca3.Conectar(peca6,3)){
            System.out.println("Conectou");
            tabuleiro1.posicionarPeca(1, 2, peca6);
        }else{
            System.out.println("Não conectou");
        }
        if(peca7.Conectar(peca4, 0)){
            System.out.println("Conectou");
            tabuleiro1.posicionarPeca(2, 0, peca7);
        }else{
            System.out.println("Não conectou");
        }
        if(peca8.Conectar(peca7, 1) && peca5.Conectar(peca8, 2)){
            System.out.println("Conectou");
            tabuleiro1.posicionarPeca(2, 1, peca8);
        }else{
            System.out.println("Não conectou");
        }
        if(peca9.Conectar(peca8, 1)&& peca6.Conectar(peca9, 2)){
            System.out.println("Conectou");
            tabuleiro1.posicionarPeca(2, 1, peca8);
        }else{
            System.out.println("Não conectou");
        }
        
        
    }
    
}

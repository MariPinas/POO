package quebracabeca;

/**
 *
 * @author aluno
 */
public class QuebraCabeca {

    public static void main(String[] args) {

        Tabuleiro tabuleiro1 = new Tabuleiro();
        boolean todasConectadas = true;
        
        Borda b1 = new Borda(true, false);
        Borda b2 = new Borda(false, true);
        Borda b3 = new Borda(true, true);
        Borda b4 = new Borda(true, false);

        Peca peca1 = new PecaCentro(b3, b2, b3, b4);
        Peca peca2 = new PecaCentro(b3, b1, b2, b4);

        Peca peca3 = new PecaCentro(b3, b3, b2, b4);
        Peca peca4 = new PecaCentro(b1, b1, b1, b3);

        Peca peca5 = new PecaCentro(b1, b1, b1, b4);
        Peca peca6 = new PecaCentro(b2, b3, b2, b4);

        Peca peca7 = new PecaCentro(b1, b2, b3, b3);
        Peca peca8 = new PecaCentro(b2, b1, b3, b4);
        Peca peca9 = new PecaCentro(b1, b3, b3, b2);

        if (peca2.Conectar(peca1, 1)) {
            System.out.println("Conectou peca 1 com peca 2");
            tabuleiro1.posicionarPeca(0, 0, peca1);
            tabuleiro1.posicionarPeca(0, 1, peca2);
        } else {
            System.out.println("Não conectou peca 1 com peca 2");
            todasConectadas = false;  
        }

        if (peca2.Conectar(peca3, 3)) {
            System.out.println("Conectou peca 3 com peca 2");
            tabuleiro1.posicionarPeca(0, 2, peca3);
        } else {
            System.out.println("Não conectou peca 3 com peca 2");
            todasConectadas = false;
        }

        if (peca4.Conectar(peca1, 2)) {
            System.out.println("Conectou peca 4 com peca 1");
            tabuleiro1.posicionarPeca(1, 0, peca4);
        } else {
            System.out.println("Não conectou peca 4 com peca 1");
            todasConectadas = false;
        }

        if (peca5.Conectar(peca4, 1) && peca5.Conectar(peca2, 2)) {
            System.out.println("Conectou peca 4 com peca 5 e com peca 2");
            tabuleiro1.posicionarPeca(1, 1, peca5);
        } else {
            System.out.println("Não conectou peca 4 com peca 5 e/ou peca 2");
            todasConectadas = false;
        }

        if (peca5.Conectar(peca6, 3) && peca6.Conectar(peca3, 2)) {
            System.out.println("Conectou peca 5 com peca 6 e peca 3");
            tabuleiro1.posicionarPeca(1, 2, peca6);
        } else {
            System.out.println("Não conectou peca 5 com peca 6 e/ou peca 3");
            todasConectadas = false;
        }

        if (peca4.Conectar(peca7, 0)) {
            System.out.println("Conectou peca 7 com peca 4");
            tabuleiro1.posicionarPeca(2, 0, peca7);
        } else {
            System.out.println("Não conectou peca 7 com peca 4");
            todasConectadas = false;
        }

        if (peca8.Conectar(peca7, 1) && peca5.Conectar(peca8, 0)) {
            System.out.println("Conectou peca 7 com peca 8 e peca 5");
            tabuleiro1.posicionarPeca(2, 1, peca8);
        } else {
            System.out.println("Não conectou peca 7 com peca 8 e/ou peca 5");
            todasConectadas = false;
        }

        if (peca8.Conectar(peca9, 3) && peca6.Conectar(peca9, 0)) {
            System.out.println("Conectou peca 8 com peca 9 e peca 6");
            tabuleiro1.posicionarPeca(2, 2, peca9);
        } else {
            System.out.println("Não conectou peca 8 com peca 9 e/ou peca 6");
            todasConectadas = false;
        }

       
        if (todasConectadas) {
            System.out.println("Tabuleiro montado com sucesso!");
        } else {
            System.out.println("Falha ao montar o tabuleiro.");
        }
    }

}



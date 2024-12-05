
package quebracabeca;

/**
 *
 * @author aluno
 */
public class Tabuleiro {
    private Peca[][] tabuleiro = new Peca[3][3];  
    public void posicionarPeca(int linha, int coluna, Peca peca){
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                   tabuleiro[linha][coluna]= peca;
                }
            }
    }
}

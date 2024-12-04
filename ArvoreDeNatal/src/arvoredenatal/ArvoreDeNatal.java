package arvoredenatal;

/**
 *
 * @author maria
 */
public class ArvoreDeNatal {

    public static void main(String[] args) {
        // Criando o DAO
        DAOArvore arvoreDAO = new DAOArvore();

        // Criando algumas árvores
        DTOArvore arvoreEsquerda = new DTOArvore(1, "Árvore Esquerda", 5, "Esquerda");
        DTOArvore arvoreCentral = new DTOArvore(2, "Árvore Central", 7, "Central");
        DTOArvore arvoreDireita = new DTOArvore(3, "Árvore Direita", 4, "Direita");

        // Inserindo árvores no "banco de dados"
        arvoreDAO.inserirArvore(arvoreEsquerda);
        arvoreDAO.inserirArvore(arvoreCentral);
        arvoreDAO.inserirArvore(arvoreDireita);

        // Listando todas as árvores
        arvoreDAO.listarArvores();

        // Atualizando a profundidade de uma árvore
        arvoreDAO.atualizarProfundidadeArvore(1, 6);

        // Listando após atualização
        arvoreDAO.listarArvores();

        // Removendo uma árvore
        arvoreDAO.removerArvore(2);

        // Listando após remoção
        arvoreDAO.listarArvores();

        // Desenhando as árvores
        DesenhaArvore desenhaEsquerda = new DesenhaArvore(new ArvoreEsquerda(5));
        desenhaEsquerda.draw();

        DesenhaArvore desenhaCentral = new DesenhaArvore(new ArvoreCentralizada(5));
        desenhaCentral.draw();

        DesenhaArvore desenhaDireita = new DesenhaArvore(new ArvoreDireita(5));
        desenhaDireita.draw();
    }
    
}

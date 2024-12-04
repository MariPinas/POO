/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arvoredenatal;

/**
 *
 * @author maria
 */
import java.util.ArrayList;
import java.util.List;

public class DAOArvore {
    private List<DTOArvore> arvoreDB = new ArrayList<>();

    // C - Create: Inserir uma árvore na lista
    public void inserirArvore(DTOArvore arvore) {
        arvoreDB.add(arvore);
        System.out.println("Árvore inserida: " + arvore.getTipoArvore());
    }

    // R - Read: Buscar uma árvore pelo tipo
    public DTOArvore buscarArvorePorTipo(String tipoArvore) {
        for (DTOArvore arvore : arvoreDB) {
            if (arvore.getTipoArvore().equals(tipoArvore)) {
                return arvore;
            }
        }
        return null;
    }

    // U - Update: Atualizar a profundidade de uma árvore específica
    public void atualizarProfundidadeArvore(int id, int novaProfundidade) {
        for (DTOArvore arvore : arvoreDB) {
            if (arvore.getId() == id) {
                arvore.setProfundidade(novaProfundidade);
                System.out.println("Profundidade da árvore " + arvore.getTipoArvore() + " atualizada.");
                return;
            }
        }
        System.out.println("Árvore não encontrada.");
    }

    // D - Delete: Remover uma árvore pelo ID
    public void removerArvore(int id) {
        arvoreDB.removeIf(arvore -> arvore.getId() == id);
        System.out.println("Árvore removida.");
    }

    // Método para listar todas as árvores
    public void listarArvores() {
        for (DTOArvore arvore : arvoreDB) {
            System.out.println(arvore.getTipoArvore() + " - Profundidade: " + arvore.getProfundidade());
        }
    }
}


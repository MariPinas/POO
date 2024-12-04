/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arvoredenatal;

/**
 *
 * @author maria
 */
public class DesenhaArvore {
    private ArvoreNatal arvore;

    public DesenhaArvore(ArvoreNatal arvore) {
        this.arvore = arvore;
    }

    public void draw() {
        arvore.draw();
    }
}


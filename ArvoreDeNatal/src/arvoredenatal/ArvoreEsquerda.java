/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arvoredenatal;

/**
 *
 * @author maria
 */
public class ArvoreEsquerda implements ArvoreNatal {
    private int tamanho;

    public ArvoreEsquerda(int tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public void draw() {
        for (int i = 1; i <= tamanho; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}


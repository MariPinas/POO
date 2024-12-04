/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arvoredenatal;

/**
 *
 * @author maria
 */
public class ArvoreDireita implements ArvoreNatal {
    private int tamanho;

    public ArvoreDireita(int tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public void draw() {
        for (int i = 1; i <= tamanho; i++) {
            for (int j = 0; j < tamanho - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}


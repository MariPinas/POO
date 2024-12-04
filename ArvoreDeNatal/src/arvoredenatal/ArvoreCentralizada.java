/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arvoredenatal;

/**
 *
 * @author maria
 */
public class ArvoreCentralizada implements ArvoreNatal {
    private int tamanho;

    public ArvoreCentralizada(int tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public void draw() {
        for (int i = 1; i <= tamanho; i++) {
            for (int j = 0; j < tamanho - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < (2 * i - 1); k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}


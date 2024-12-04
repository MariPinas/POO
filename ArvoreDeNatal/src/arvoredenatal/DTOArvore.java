/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arvoredenatal;

/**
 *
 * @author maria
 */
public class DTOArvore {
    private int id;
    private String tipoArvore;
    private int profundidade;
    private String alinhamento;

    public DTOArvore(int id, String tipoArvore, int profundidade, String alinhamento) {
        this.id = id;
        this.tipoArvore = tipoArvore;
        this.profundidade = profundidade;
        this.alinhamento = alinhamento;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTipoArvore() { return tipoArvore; }
    public void setTipoArvore(String tipoArvore) { this.tipoArvore = tipoArvore; }

    public int getProfundidade() { return profundidade; }
    public void setProfundidade(int profundidade) { this.profundidade = profundidade; }

    public String getAlinhamento() { return alinhamento; }
    public void setAlinhamento(String alinhamento) { this.alinhamento = alinhamento; }
}



package pizzaria;

public abstract class Pizza {
    private int id;
    private int quantidade;
    private String tamanho;
    private String ingredientes;
    private float preco;
    
    public Pizza(){}
    public Pizza(int id, int q, String t, String i, float p){
        this.id=id;
        this.quantidade=q;
        this.tamanho=t;
        this.ingredientes=i;
        this.preco=p;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int q) {
        this.quantidade = q;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String t) {
        this.tamanho = t;
    }
    
    public String getIngredientes(){
        return ingredientes;
    }
    
    public void setIngredientes(String i){
        this.ingredientes=i;
    }
    
    public float getPreco(){
        return preco;
    }
    public void setPreco(float p){
        this.preco = p;
    }
    
}

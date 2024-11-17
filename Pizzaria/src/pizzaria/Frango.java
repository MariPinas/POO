package pizzaria;
public class Frango extends Pizza{
    protected String nome;
    
    public Frango(String nome, int id, int q, String t, String i, float p) {
        super(id, q, t, i, p);
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public void getPizza(Pizza p){
        System.out.println("==== Pizza de " + this.getNome() + " ====");
        super.getPizza(p);
        System.out.println("======== ======== ========");
    }
    
}

package modelviewcontroller;

public class View {

    String dados = "";
    Model model;

    public void setModel(Model model) {
        this.model = model;
    }

    public void MostrarDados() {
        System.out.println(dados);
    }
    
    public void update(){
        dados = model.getDados();
        MostrarDados();
    }
}

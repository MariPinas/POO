package modelviewcontroller;

public class View implements iView{

    String dados = "";
    Model model;

    public void setModel(Model model) {
        this.model = model;
    }

    public void MostrarDados() {
        System.out.println("A-"+dados);
    }
    
    public void update(){
        dados = model.getDados();
        MostrarDados();
    }
    
    public void atualizaDados(String dados){
        model.atualizarDados(dados);
    }
}

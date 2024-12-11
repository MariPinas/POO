package modelviewcontroller;

public class View2 implements iView{

    String dados = "";
    Model model;

    public void setModel(Model model) {
        this.model = model;
    }

    public void MostrarDados() {
        System.out.println("B-"+dados);
    }
    
    public void update(){
        dados = model.getDados();
        MostrarDados();
    }
    
    public void atualizaDados(String dados){
        model.atualizarDados(dados);
    }
}

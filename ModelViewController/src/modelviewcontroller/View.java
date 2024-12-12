package modelviewcontroller;

public class View implements iView{

    String dados = "";
    iModel model;

    @Override
    public void setModel(iModel model) {
        this.model = model;
    }

    public void MostrarDados() {
        System.out.println("A-"+dados);
    }
    
    @Override
    public void update(){
        dados = model.getDados();
        MostrarDados();
    }
    
    @Override
    public void atualizaDados(String dados){
        model.atualizarDados(dados);
    }
}

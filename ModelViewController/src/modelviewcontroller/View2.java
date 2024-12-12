package modelviewcontroller;

public class View2 implements iView{

    String dados = "";
    iModel model;

    @Override
    public void setModel(iModel model) {
        this.model = model;
    }

    public void MostrarDados() {
        System.out.println("B-"+dados);
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

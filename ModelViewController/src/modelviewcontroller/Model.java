package modelviewcontroller;

public class Model {
    String dados="";
    View view;
    public void setView(View view){
        this.view=view;
    }
    public void atualizarDados(String dado){
        this.dados=dado;
        view.update();
    }
    
    public String getDados(){
        return dados;
    }
}

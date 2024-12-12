
package modelviewcontroller;


public class Model2 implements iModel{
    String dados="";
    iView view;
    @Override
    public void setView(iView view){
        this.view=view;
    }
    @Override
    public void atualizarDados(String dado){
        this.dados=dado;
        view.update();
    }
    
    @Override
    public String getDados(){
        return dados;
    }
}

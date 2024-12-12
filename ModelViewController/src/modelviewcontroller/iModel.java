
package modelviewcontroller;

public interface iModel {
    public void setView(iView view);
    public void atualizarDados(String dados);
    public String getDados();
}

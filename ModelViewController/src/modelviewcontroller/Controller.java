package modelviewcontroller;

public class Controller {
    public void rotiar(iView view, iModel model){
        view.setModel(model);
        model.setView(view);
    }
}

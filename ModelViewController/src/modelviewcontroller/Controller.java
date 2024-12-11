package modelviewcontroller;

public class Controller {
    public void rotiar(iView view, Model model){
        view.setModel(model);
        model.setView(view);
    }
}

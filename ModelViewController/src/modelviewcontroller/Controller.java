package modelviewcontroller;

public class Controller {
    public void rotiar(View view, Model model){
        view.setModel(model);
        model.setView(view);
    }
}

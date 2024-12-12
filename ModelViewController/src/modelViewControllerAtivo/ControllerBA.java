package modelViewControllerAtivo;

public class ControllerBA {

    ViewBA view;
    ModelBA model;

    public void liga(ViewBA vb, ModelBA mb) {
        this.view = vb;
        this.model = mb;
        this.view.setController(this);
        this.model.setController(this);
    }

    public void sendMessageToModel(String data) {
        this.model.update(data);
    }

    public void sendMessageToView(String data) {
        this.view.update(data);
    }
}

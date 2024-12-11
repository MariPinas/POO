package modelviewcontroller;

public class ModelViewController {

    public static void main(String[] args) {
        Model model=new Model();
        View view = new View();
        Controller controller = new Controller();
        View2 view2 = new View2();
        
        controller.rotiar(view, model);
        
        model.atualizarDados("Hello World!");
    }
    
}

package modelviewcontroller;

public class ModelViewController {

    public static void main(String[] args) {
        Model model=new Model();
        View view = new View();
        
        Controller controller = new Controller();
        
        View2 view2 = new View2();
        Model2 model2 = new Model2();
        
        controller.rotiar(view2, model2);
        
        model2.atualizarDados("Hello World!");
    }
    
}

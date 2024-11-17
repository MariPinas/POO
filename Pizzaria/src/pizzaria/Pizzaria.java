package pizzaria;

import java.util.Scanner;

public class Pizzaria {

    public static void main(String[] args) {
        DAOPizza daoPizza = new DAOPizza();
        //create
       Pizza calabresa = daoPizza.create(new Calabresa("Calabreso", 1, 20, "Grande", "Calabresa e molho de tomate", 60));
     Pizza frango = daoPizza.create(new Frango("Frango", 2, 30, "Media", "Frango, catupiry e molho de tomate", 40));
     Pizza nutella = daoPizza.create(new Nutella("Nutella", 1, 20, "Pequena", "Nutella e morango", 60));
//     
        //printa tudas pizzas
        //System.out.println(daoPizza.getAll());
        //printa pizza especifica
        calabresa.getPizza(calabresa);
        frango.getPizza(frango);
        nutella.getPizza(nutella);
//       //delete
//       System.out.println();
//       Pizza pizzaSD=daoPizza.read(1);
//       
//       if(daoPizza.delete(pizzaSD))
//           System.out.println("Exclusao com sucesso");
//       else
//           System.out.println("Exclusao nao realizada");
//
//       //update
//       System.out.println();
//        Pizza pizzaUP=new Calabresa("Calabresinha",1,20,"Grande","Calabresa e molho de tomate", 60);
//       daoPizza.update(pizzaUP);
//       pizzaUP.getPizza(pizzaUP);

// =================================================================================
        DAOPedido daoPedido = new DAOPedido();
        
        Pedido pedido1 = daoPedido.create(new Pedido(1,1));
        System.out.println("Digite o Id da pizza que deseja adicionar: ");
        Scanner leitor = new Scanner(System.in);
        
        int idPizza = leitor.nextInt();
        pedido1.addPizza(daoPizza.getPizza(idPizza));
        
        pedido1.ExibirPedido(pedido1);
        
    }

}

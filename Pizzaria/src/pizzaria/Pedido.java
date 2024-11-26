package pizzaria;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private int idCliente;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public List<Pizza> getPizzasPedido() {
        return pizzasPedido;
    }

    public void setPizzasPedido(List<Pizza> pizzasPedido) {
        this.pizzasPedido = pizzasPedido;
    }

    private int idPedido;
    private List<Pizza> pizzasPedido = new ArrayList();

    public Pedido(int idPedido, int idCliente) {
        this.idPedido = idPedido;
        this.idCliente = idCliente;

    }

    public void ExibirPedido(Pedido p) {
        System.out.println("==== Exibicao do pedido de ID: " + this.idPedido + " ====");
        System.out.println("ID do Comprador: " + this.idCliente);

        for (Pizza i : pizzasPedido) {
            i.getPizza(i);
        }
        this.totalCompra();
        System.out.println("========================================================");
    }

    public boolean addPizza(Pizza pizza) {
        if (pizza == null) {
            return false;
        } else {
            pizzasPedido.add(pizza);
            return true;
        }
    }

    public void totalCompra() {
        double soma = 0;
        for (Pizza i : pizzasPedido) {
            double aux = i.getPreco();
            soma = soma + aux;
        }
        System.out.println("TOTAL DA COMPRA: " + soma);
    }

}

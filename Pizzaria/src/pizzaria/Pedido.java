package pizzaria;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private static int contadorId = 1;
    private Cliente cliente;
    private int idPedido;
    private List<Pizza> pizzasPedido = new ArrayList();

    public Cliente getIdCliente() {
        return cliente;
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

    public Pedido(Cliente cliente) {
        this.idPedido = contadorId++;
        this.cliente = cliente;

    }

    public void ExibirPedido() {
        System.out.println("==== Exibicao do pedido de ID: " + this.idPedido + " ====");
        System.out.println("Dados do Comprador: " + this.cliente);

        for (Pizza i : pizzasPedido) {
            i.getPizza(i);
        }
        System.out.println("TOTAL DA COMPRA: " + totalCompra());
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

    public double totalCompra() {
        double soma = 0;
        for (Pizza i : pizzasPedido) {
            double aux = i.getPreco();
            soma = soma + aux;
        }
        return soma;
    }

}

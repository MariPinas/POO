package pizzaria;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

public class DiaTrabalho {

    private static int contadorId = 1;
    private int id;
    private LocalDate dia;
    private List<Pedido> pedidos = new ArrayList();

    public DiaTrabalho(LocalDate dia) {
        this.id = contadorId++;
        this.dia = dia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public void ExibirDiaTrabalho(DiaTrabalho d) {
        System.out.println("==== Exibicao do dia de trabalho: " + d.dia + " ====");
        System.out.println("ID do dia de trabalho: " + d.id);
        double soma = 0;
        List <Pedido> aux1 = d.getPedidos();
        for (Pedido i : aux1) {
            i.ExibirPedido();
            double aux = i.totalCompra();
            soma = soma + aux;
        }
        System.out.println("Total bruto: " + soma);
    }
    

    public void ExibirDataTrabalho(DiaTrabalho d) {
        System.out.println("- " + this.dia + " ID: " + this.id);
    }

    public boolean addPedido(Pedido pedido) {
        if (pedido == null || pedidos.contains(pedido)) {
            return false;
        } else {
            pedidos.add(pedido);
            return true;
        }
    }

}

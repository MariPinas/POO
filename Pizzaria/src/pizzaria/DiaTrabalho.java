package pizzaria;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

public class DiaTrabalho {
    int id;
    private LocalDate dia;
    private List<Pedido> pedidos = new ArrayList();
    
    public DiaTrabalho(int id, LocalDate dia) {
        this.id = id;
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
    
    public void ExibirDiaTrabalho(DiaTrabalho d){
        System.out.println("==== Exibicao do dia de trabalho: " + this.dia + " ====");
        System.out.println("ID do dia de trabalho: " + this.id);

        for (Pedido i : pedidos) {
            i.ExibirPedido(i);
        }
    }
    
    public boolean addPedido(Pedido pedido) {
        if (pedido == null) {
            return false;
        } else {
            pedidos.add(pedido);
            return true;
        }
    }
    
}

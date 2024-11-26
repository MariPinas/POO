
package pizzaria;

import java.util.ArrayList;
import java.util.List;

public class DAOPedido {

    private List<Pedido> databasePedido = new ArrayList();

    public Pedido create(Pedido p) {
        databasePedido.add(p);

        return p;
    }

    public Pedido read(int id) {
        for (Pedido p : databasePedido) {
            if (p.getIdPedido() == id) {
                return p;
            }
        }
        return null;
    }
    
    public Pedido readIdCliente(int idCliente) {
        for (Pedido p : databasePedido) {
            if (p.getIdCliente() == idCliente) {
                return p;
            }
        }
        return null;
    }

    public boolean update(Pedido p) {
        Pedido existeP = read(p.getIdPedido());
        if (existeP != null) {
            existeP.setIdCliente(p.getIdCliente());
            return true;
        }
        return false;
    }

    public boolean delete(Pedido p) {
        Pedido existeP = read(p.getIdPedido());
        if (existeP != null) {
            databasePedido.remove(p);
            return true;
        }
        return false;
    }

    public void getAll() {

        for (Pedido i : databasePedido) {
            i.ExibirPedido(i);
        }

    }
}

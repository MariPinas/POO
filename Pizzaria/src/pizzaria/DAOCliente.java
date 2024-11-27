
package pizzaria;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maria
 */
public class DAOCliente {
    
    private List<Cliente> databaseClientes = new ArrayList();

    public Cliente create(Cliente c) {
        databaseClientes.add(c);
        return c;
    }

    public Cliente read(int id) {
        for (Cliente c : databaseClientes) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public boolean update(Cliente d) {
        Cliente existeP = read(d.getId());
        if (existeP != null) {
            existeP.setNome(d.getNome());
            return true;
        }
        return false;
    }

    public boolean delete(Cliente d) {
        Cliente existeP = read(d.getId());
        if (existeP != null) {
            databaseClientes.remove(d);
            return true;
        }
        return false;
    }

    
}

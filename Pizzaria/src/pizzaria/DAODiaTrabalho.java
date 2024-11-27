package pizzaria;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mariana
 */
public class DAODiaTrabalho {
    private static int contadorId = 1;
    private List<DiaTrabalho> databaseDiaTrabalho = new ArrayList();

    public DiaTrabalho create(DiaTrabalho d) {
        databaseDiaTrabalho.add(d);
        return d;
    }

    public DiaTrabalho read(int id) {
        for (DiaTrabalho d : databaseDiaTrabalho) {
            if (d.getId() == id) {
                return d;
            }
        }
        return null;
    }

    public boolean update(DiaTrabalho d) {
        DiaTrabalho existeP = read(d.getId());
        if (existeP != null) {
            existeP.setDia(d.getDia());
            existeP.setPedidos(d.getPedidos());
            return true;
        }
        return false;
    }

    public boolean delete(DiaTrabalho d) {
        DiaTrabalho existeP = read(d.getId());
        if (existeP != null) {
            databaseDiaTrabalho.remove(d);
            return true;
        }
        return false;
    }

    public void getAll() {

        for (DiaTrabalho i : databaseDiaTrabalho) {
            i.ExibirDiaTrabalho(i);
        }

    }
}

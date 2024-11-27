package pizzaria;

import java.util.ArrayList;
import java.util.List;

public class DAOPizza {

    private List<Pizza> databasePizza = new ArrayList();

    public Pizza create(Pizza p) {
        databasePizza.add(p);

        return p;
    }

    public Pizza read(int id) {
        for (Pizza p : databasePizza) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public boolean update(Pizza p) {
        Pizza existeP = read(p.getId());
        if (existeP != null) {
            existeP.setQuantidade(p.getQuantidade());
            existeP.setTamanho(p.getTamanho());
            existeP.setIngredientes(p.getIngredientes());
            existeP.setPreco(p.getPreco());
            return true;
        }
        return false;
    }

    public boolean delete(Pizza p) {
        Pizza existeP = read(p.getId());
        if (existeP != null) {
            databasePizza.remove(p);
            return true;
        }
        return false;
    }

    public void getAll() {
        
        for (Pizza p : databasePizza) {

            System.out.println("ID: " + p.getId());
            System.out.println("Tamanho: " + p.getTamanho());
            System.out.println("Ingredientes: " + p.getIngredientes());
            System.out.println("Quantidade em estoque: " + p.getQuantidade());
            System.out.println("Preco: " + p.getPreco());
        }
        
    }

    public Pizza getPizza(int id) {
        for (Pizza p : databasePizza) {
            if (p.getId() == id) {
                return p;
            }
        }
        System.out.println("Essa pizza nao existe");
        return null;
    }
}

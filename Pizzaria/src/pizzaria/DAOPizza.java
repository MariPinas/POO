package pizzaria;

import java.util.ArrayList;
import java.util.List;

public class DAOPizza {
    private List<Pizza> databasePizza=new ArrayList();
    
    public void create(Pizza p){
        databasePizza.add(p);
    }
    
    public Pizza read(int id){
        for(Pizza p:databasePizza){
            if(p.getId()==id)
                return p;
        }
        return null;
    }
    public boolean update(Pizza p){
        Pizza existeP=read(p.getId());
        if(existeP!=null){
            existeP.setQuantidade(p.getQuantidade());
            existeP.setIngredientes(p.getIngredientes());
            existeP.setTamanho(p.getTamanho());
            existeP.setPreco(p.getPreco());
            return true;
        }
        return false;
    }
    
    public boolean delete(Pizza p){
        Pizza existeP=read(p.getId());
        if(existeP!=null){
            databasePizza.remove(p);
            return true;
        }
        return false;
    }
    
    public String getAll(){
        String report="";
        for(Pizza p: databasePizza){
            report+=p.getId()+"\n";
            report+=p.getTamanho()+"\n";
            report+=p.getIngredientes()+"\n";  
            report+=p.getQuantidade()+"\n";
            report+=p.getPreco()+"\n";
        }
        return report;
    }
}

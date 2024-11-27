package pizzaria;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private static int contadorId = 1;
    private int id;
    private String nome;

    public Cliente(String nome) {
        this.id = contadorId++;
        this.nome = nome;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }
    
    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestaohospitalar;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aluno
 */
public class DAOMedico {
    private List<Medico> databaseMedicos = new ArrayList();

    public Medico create(Medico d) {
        databaseMedicos.add(d);
        return d;
    }

    public Medico read(int id) {
        for (Medico d : databaseMedicos) {
            if (d.getIdentidade() == id) {
                return d;
            }
        }
        return null;
    }

    public boolean update(Medico d) {
        Medico existeP = read(d.getIdentidade());
        if (existeP != null) {
            existeP.setCpf(d.getCpf());
            existeP.setEndereco(d.getEndereco());
            existeP.setNome(d.getNome());
            existeP.setTelefone(d.getTelefone());
            existeP.setCrm(d.getCrm());
            existeP.setCtps(d.getCtps());
            existeP.setEspecialidade(d.getEspecialidade());
            return true;
        }
        return false;
    }

    public boolean delete(Medico d) {
        Medico existeP = read(d.getIdentidade());
        if (existeP != null) {
            databaseMedicos.remove(d);
            return true;
        }
        return false;
    }

    public void getAll() {

        for (Medico i : databaseMedicos) {
            i.imprimir();
        }

    }
}

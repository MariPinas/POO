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
public class DAOPaciente {

    private List<Paciente> databasePacientes = new ArrayList();

    public Paciente create(Paciente d) {
        databasePacientes.add(d);
        return d;
    }

    public Paciente read(int id) {
        for (Paciente d : databasePacientes) {
            if (d.getIdentidade() == id) {
                return d;
            }
        }
        return null;
    }

    public boolean update(Paciente d) {
        Paciente existeP = read(d.getIdentidade());
        if (existeP != null) {
            existeP.setCpf(d.getCpf());
            existeP.setEndereco(d.getEndereco());
            existeP.setNome(d.getNome());
            existeP.setTelefone(d.getTelefone());
            existeP.setNomeConvenio(d.getNomeConvenio());
            existeP.setNumeroConvenio(d.getNumeroConvenio());
            return true;
        }
        return false;
    }

    public boolean delete(Paciente d) {
        Paciente existeP = read(d.getIdentidade());
        if (existeP != null) {
            databasePacientes.remove(d);
            return true;
        }
        return false;
    }

    public void getAll() {

        for (Paciente i : databasePacientes) {
            i.imprimir();
        }

    }

}

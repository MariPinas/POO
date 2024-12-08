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
public class DAOAtendimento {

    private List<Atendimento> databaseAtendimentos = new ArrayList();

    public Atendimento create(Atendimento d) {
        databaseAtendimentos.add(d);
        return d;
    }

    public Atendimento read(int id) {
        for (Atendimento d : databaseAtendimentos) {
            if (d.getId() == id) {
                return d;
            }
        }
        return null;
    }

    public boolean update(int idAt, String crmMedico) {
        Atendimento existeA = read(idAt);
        if (existeA != null) {
            Medico isMedico = existeA.getMedico();

            if (isMedico != null && isMedico.getCrm().equals(crmMedico)) {
                existeA.setStatus(existeA.getStatus());
                existeA.setDescricao(existeA.getDescricao());
                return true;
            } else {

                System.out.println("Somente o medico"+isMedico.getNome()+"que realizou o atendimento pode atualiza-lo.");
                return false;
            }
        }
        return false;
    }

    public boolean delete(Atendimento d) {
        Atendimento existeP = read(d.getId());
        if (existeP != null) {
            databaseAtendimentos.remove(d);
            return true;
        }
        return false;
    }

    public void getAll() {

        for (Atendimento i : databaseAtendimentos) {
            i.imprimir();
        }

    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestaohospitalar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class DAOMedico {

    private List<Medico> databaseMedicos = new ArrayList();

    public Medico create(Medico m) {
        databaseMedicos.add(m);
        return m;
    }

    public Medico read(String id) {
        for (Medico m : databaseMedicos) {
            if (m.getIdentidade().equals(id)) {
                return m;
            }
        }
        return null;
    }

    public boolean update() {
        Scanner scanner = new Scanner(System.in);
        String nome, id, cpf, end, tel, crm, esp, ctps;
        int resp;

        System.out.println("--==[Alteração de Médicos]==--");

        do {
            System.out.println("Digite o id do medico a alterar: ");
            id = scanner.nextLine();
            if (id.isEmpty()) {
                System.out.println("Idenficacao de medico invalida. Por favor, digite novamente.");
            }
        } while (id.isEmpty());

        Medico existeM = read(id);

        if (existeM != null) {
            System.out.println("-=[Dados]=-");
            System.out.println("Nome atual: " + existeM.getNome());
            System.out.println("Alterar? (1-sim/2-não");
            resp = scanner.nextInt();
            scanner.skip("\n");
            if (resp == 1) {
                System.out.println("Digite o novo nome: ");
                nome = scanner.nextLine();
                existeM.setNome(nome);
            }
            System.out.println("----------------------------------");
            System.out.println("Identidade atual: " + existeM.getIdentidade());
            System.out.println("Alterar? (1-sim/2-não");
            resp = scanner.nextInt();
            scanner.skip("\n");
            if (resp == 1) {
                System.out.println("Digite a nova identidade: ");
                id = scanner.nextLine();
                existeM.setIdentidade(id);
            }
            System.out.println("----------------------------------");
            System.out.println("C.P.F. atual: " + existeM.getCpf());
            System.out.println("Alterar? (1-sim/2-não");
            resp = scanner.nextInt();
            scanner.skip("\n");
            if (resp == 1) {
                System.out.println("Digite o novo C.P.F.: ");
                cpf = scanner.nextLine();
                existeM.setCpf(cpf);
            }
            System.out.println("----------------------------------");
            System.out.println("Endereço atual: " + existeM.getEndereco());
            System.out.println("Alterar? (1-sim/2-não");
            resp = scanner.nextInt();
            scanner.skip("\n");
            if (resp == 1) {
                System.out.println("Digite o novo Endereço: ");
                end = scanner.nextLine();
                existeM.setEndereco(end);
            }
            System.out.println("----------------------------------");
            System.out.println("Telefone atual: " + existeM.getTelefone());
            System.out.println("Alterar? (1-sim/2-não");
            resp = scanner.nextInt();
            scanner.skip("\n");
            if (resp == 1) {
                System.out.println("Digite o novo Telefone: ");
                tel = scanner.nextLine();
                existeM.setTelefone(tel);
            }
            System.out.println("----------------------------------");
            System.out.println("C.R.M. atual: " + existeM.getCrm());
            System.out.println("Alterar? (1-sim/2-não");
            resp = scanner.nextInt();
            scanner.skip("\n");
            if (resp == 1) {
                System.out.println("Digite o novo C.R.M.: ");
                crm = scanner.nextLine();
                existeM.setCrm(crm);
            }
            System.out.println("----------------------------------");
            System.out.println("Especialidade atual: " + existeM.getEspecialidade());
            System.out.println("Alterar? (1-sim/2-não");
            resp = scanner.nextInt();
            scanner.skip("\n");
            if (resp == 1) {
                System.out.println("Digite a nova Especialidade: ");
                esp = scanner.nextLine();
                existeM.setEspecialidade(esp);
            }
            System.out.println("----------------------------------");
            System.out.println("C.T.P.S. atual: " + existeM.getCtps());
            System.out.println("Alterar? (1-sim/2-não");
            resp = scanner.nextInt();
            scanner.skip("\n");
            if (resp == 1) {
                System.out.println("Digite a nova C.T.P.S.: ");
                ctps = scanner.nextLine();
                existeM.setCtps(ctps);
            }
            System.out.println("----------------------------------");

            System.out.println("Atualização realizada com sucesso.");

            return true;
        } else {
            System.out.println("Nao foi possivel atualizar - Medico nao existe");
            return false;
        }
    }

    public boolean delete(Medico d) {
        Medico existeM = read(d.getIdentidade());
        if (existeM != null) {
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

    public int getMedicoCount() {
        return databaseMedicos.size();
    }
}

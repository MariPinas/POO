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
public class DAOPaciente {

    private List<Paciente> databasePacientes = new ArrayList();

    public Paciente create(Paciente d) {
        databasePacientes.add(d);
        return d;
    }

    public Paciente read(String id) {
        for (Paciente d : databasePacientes) {
            if (d.getIdentidade().equals(id)) {
                return d;
            }
        }
        return null;
    }

    public boolean update() {
        Scanner scanner = new Scanner(System.in);
        String nome, id, cpf, end, tel, nomeConv, numConv;
        int resp;
        System.out.println("Digite o id do paciente a alterar: ");
        id = scanner.nextLine();
        Paciente existeP = read(id);
        
        if (existeP != null) {
            System.out.println("-=[Dados]=-");
            System.out.println("Nome atual: " + existeP.getNome());
            System.out.println("Alterar? (1-sim/2-não");
            resp = scanner.nextInt();
            scanner.nextLine();
            if (resp == 1) {
                System.out.println("Digite o novo nome: ");
                nome = scanner.nextLine();
                existeP.setNome(nome);
            }
            System.out.println("----------------------------------");
            System.out.println("Identidade atual: " + existeP.getIdentidade());
            System.out.println("Alterar? (1-sim/2-não");
            resp = scanner.nextInt();
            scanner.nextLine();
            if (resp == 1) {
                System.out.println("Digite a nova identidade: ");
                id = scanner.nextLine();
                existeP.setIdentidade(id);
            }
            System.out.println("----------------------------------");
            System.out.println("C.P.F. atual: " + existeP.getCpf());
            System.out.println("Alterar? (1-sim/2-não");
            resp = scanner.nextInt();
            scanner.nextLine();
            if (resp == 1) {
                System.out.println("Digite o novo C.P.F.: ");
                cpf = scanner.nextLine();
                existeP.setCpf(cpf);
            }
            System.out.println("----------------------------------");
            System.out.println("Endereço atual: " + existeP.getEndereco());
            System.out.println("Alterar? (1-sim/2-não");
            resp = scanner.nextInt();
            scanner.skip("\n");
            if (resp == 1) {
                System.out.println("Digite o novo Endereço: ");
                end = scanner.nextLine();
                existeP.setEndereco(end);
            }
            System.out.println("----------------------------------");
            System.out.println("Telefone atual: " + existeP.getTelefone());
            System.out.println("Alterar? (1-sim/2-não");
            resp = scanner.nextInt();
            scanner.skip("\n");
            if (resp == 1) {
                System.out.println("Digite o novo Telefone: ");
                tel = scanner.nextLine();
                existeP.setTelefone(tel);
            }
            System.out.println("----------------------------------");
            System.out.println("Nome do Convêncio atual: " + existeP.getNomeConvenio());
            System.out.println("Alterar? (1-sim/2-não");
            resp = scanner.nextInt();
            scanner.skip("\n");
            if (resp == 1) {
                System.out.println("Digite o novo Nome do Convênio: ");
                nomeConv = scanner.nextLine();
                existeP.setNomeConvenio(nomeConv);
            }
            System.out.println("----------------------------------");
            System.out.println("Número do Convêncio atual: " + existeP.getNumeroConvenio());
            System.out.println("Alterar? (1-sim/2-não");
            resp = scanner.nextInt();
            scanner.skip("\n");
            if (resp == 1) {
                System.out.println("Digite o novo Número do Convênio: ");
                numConv = scanner.nextLine();
                existeP.setNumeroConvenio(numConv);
            }
            System.out.println("----------------------------------");

            System.out.println("Atualização realizada com sucesso.");
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

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

    public boolean update() {
        Scanner scanner = new Scanner(System.in);
        String id, crm, descr;
        int resp, idAt;

        System.out.println("--==[Alteração de Atendimento]==--");
        System.out.println("Digite o id do atendimento a alterar? ");

        idAt = scanner.nextInt();
        scanner.nextLine();

        Atendimento existeA = read(idAt);
        if (existeA != null) {
            System.out.println("Digite o crm medico responsavel: ");
            crm = scanner.nextLine();

            Medico isMedico = existeA.getMedico();

            if (isMedico != null && isMedico.getCrm().equals(crm)) {
                System.out.println("-=[Dados do atendimento de " + existeA.getPaciente().getNome() + " ]=-");
                System.out.println("Estado atual: " + existeA.getStatus());
                System.out.println("Alterar? (1-sim/2-não");
                resp = scanner.nextInt();
                scanner.skip("\n");
                EstadoAtendimento[] estados = EstadoAtendimento.values();
                if (resp == 1) {
                    for (int i = 0; i < estados.length; i++) {
                        System.out.println(i + " - " + estados[i]);
                    }
                    int escolha;
                    System.out.print("Digite o numero correspondente ao novo estado desejado: ");
                    escolha = scanner.nextInt();
                    EstadoAtendimento estadoEscolhido = estados[escolha];
                    existeA.setStatus(estadoEscolhido);
                }
                System.out.println("----------------------------------");
                System.out.println("Descricao atual: " + existeA.getDescricao());
                System.out.println("Alterar? (1-sim/2-não");
                resp = scanner.nextInt();
                scanner.skip("\n");
                if (resp == 1) {
                    System.out.println("Digite a nova descricao: ");
                    descr = scanner.nextLine();
                    existeA.setDescricao(descr);
                }
                System.out.println("----------------------------------");
                return true;
            } else {
                System.out.println("!= ACESSO NEGADO !=");
                System.out.println("Somente o medico " + isMedico.getNome() + " que realizou o atendimento pode atualiza-lo.");
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

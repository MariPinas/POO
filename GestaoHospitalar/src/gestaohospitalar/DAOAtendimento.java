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

    public Atendimento create(Atendimento a) {
        databaseAtendimentos.add(a);
        return a;
    }

    public Atendimento read(int id) {
        for (Atendimento a : databaseAtendimentos) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }

    public boolean update() {
        Scanner scanner = new Scanner(System.in);
        String id, crm, descr, entrada;
        int resp, idAt;

        System.out.println("--==[Alteração de Atendimento]==--");
        do {
            System.out.println("Digite o id do atendimento a alterar? ");
            entrada = scanner.nextLine().trim();
            if (entrada.isEmpty() || !entrada.matches("\\d+")) { //dessa forma somente permite numeros
                System.out.println("\nid invalido. Por favor, digite um numero inteiro\n");
            }
        } while (entrada.isEmpty() || !entrada.matches("\\d+"));

        idAt = Integer.parseInt(entrada);
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
        } else {
            System.out.println("ID de atendimento nao encontrado - Nao foi possivel atualizar");
            return false;
        }

    }

    public boolean delete(Atendimento d) {
        Atendimento existeA = read(d.getId());
        if (existeA != null) {
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

    public int getAtendimentoCount() {
        return databaseAtendimentos.size();
    }
}

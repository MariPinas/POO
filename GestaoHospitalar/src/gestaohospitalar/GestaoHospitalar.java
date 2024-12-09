package gestaohospitalar;

import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class GestaoHospitalar {

    public static void main(String[] args) {
        DAOPaciente daoPaciente = new DAOPaciente();
        DAOMedico daoMedico = new DAOMedico();
        DAOAtendimento daoAtendimento = new DAOAtendimento();

        Scanner scanner = new Scanner(System.in);
        int opcao;
        boolean executando = true;
        while (executando) {

            System.out.println("\n====== MENU =======");
            System.out.println("[1] Menu Paciente");
            System.out.println("[2] Menu Medico");
            System.out.println("[3] Menu Atendimento");
            System.out.print("Escolha uma opcao: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    boolean noMenuPaciente = true;
                    while (noMenuPaciente) {
                        System.out.println("\n====== MENU PACIENTE =======");
                        System.out.println("[1] Cadastrar Paciente");
                        System.out.println("[2] Exibir Pacientes");
                        System.out.println("[3] Atualizar Paciente");
                        System.out.println("[4] Remover Paciente");
                        System.out.println("[5] Voltar ao menu de acoes");
                        System.out.print("Escolha uma opcao: ");
                        int opcaoPaciente = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcaoPaciente) {
                            case 1:
                                System.out.println("=== Cadastro de Paciente ===");
                                System.out.println("Digite o nome do paciente: ");
                                String nome = scanner.nextLine();
                                System.out.println("Digite o endereco do paciente: ");
                                String end = scanner.nextLine();
                                System.out.println("Digite o cpf do paciente: ");
                                String cpf = scanner.nextLine();
                                System.out.println("Digite o telefone do paciente: ");
                                String tel = scanner.nextLine();
                                System.out.println("Digite o nome do convenio do paciente: ");
                                String nomeConv = scanner.nextLine();
                                System.out.println("Digite o numero do convenio do paciente: ");
                                String numConv = scanner.nextLine();
                                System.out.println("Digite o id do paciente: ");
                                String id = scanner.nextLine();
                                

                                Paciente pacienteC = daoPaciente.create(new Paciente(nome, id, cpf, end, tel, nomeConv, numConv));
                                if (pacienteC != null) {
                                    System.out.println("\nPaciente cadastrado!");
                                }
                                break;
                            case 2:
                                System.out.println("\n=== Lista de pacientes ===");
                                daoPaciente.getAll();
                                break;
                            case 3:

                                daoPaciente.update();

                                break;
                            case 4:
                                System.out.println("\n=== Remover Paciente ===");
                                System.out.println("Digite o id do paciente a deletar: ");
                                String idDeletar = scanner.nextLine();

                                Paciente pacienteSD = daoPaciente.read(idDeletar);

                                if (daoPaciente.delete(pacienteSD)) {
                                    System.out.println("Exclusao com sucesso");
                                } else {
                                    System.out.println("Exclusao nao realizada");
                                }
                                break;
                            case 5:
                                noMenuPaciente = false;
                                break;
                            default:
                                System.out.println("Opcao invalida. Tente novamente.");
                        }
                    }
                    break;

                case 2:
                    boolean noMenuMedico = true;
                    while (noMenuMedico) {
                        System.out.println("\n====== MENU MEDICO =======");
                        System.out.println("[1] Cadastrar Medico");
                        System.out.println("[2] Exibir Medicos");
                        System.out.println("[3] Remover Medico");
                        System.out.println("[4] Atualizar Medico");
                        System.out.println("[5] Voltar ao menu de acoes");
                        System.out.print("Escolha uma opcao: ");
                        int opcaoPedido = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcaoPedido) {
                            case 1:
                                System.out.println("====Cadastrar Medico====");
                                System.out.println("Digite o nome do medico: ");
                                String nome = scanner.nextLine();
                                System.out.println("Digite o endereco do medico: ");
                                String end = scanner.nextLine();
                                System.out.println("Digite o cpf do medico: ");
                                String cpf = scanner.nextLine();
                                System.out.println("Digite o telefone do medico: ");
                                String tel = scanner.nextLine();
                                System.out.println("Digite a especialidade do medico: ");
                                String espe = scanner.nextLine();
                                System.out.println("Digite o CRM do medico: ");
                                String CRM = scanner.nextLine();
                                System.out.println("Digite o CPTS do medico: ");
                                String cpts = scanner.nextLine();
                                System.out.println("Digite o id do medico: ");
                                String id = scanner.nextLine();

                                Medico medicoC = daoMedico.create(new Medico(nome, id, cpf, end, tel, CRM, espe, cpts));
                                if (medicoC != null) {
                                    System.out.println("\nMedico cadastrado!");
                                }
                                break;
                            case 2:
                                // Exibir Pedidos
                                System.out.println("=== Exibir Todos Medicos ===");
                                daoMedico.getAll();
                                break;
                            case 3:
                                System.out.println("\n=== Remover Medico ===");
                                System.out.println("Digite o Id do medico a excluir: ");
                                String idExcluir = scanner.nextLine();
                                Medico medicoSD = daoMedico.read(idExcluir);

                                if (daoMedico.delete(medicoSD)) {
                                    System.out.println("Exclusao com sucesso");
                                } else {
                                    System.out.println("Exclusao nao realizada");
                                }
                                break;
                            case 4:
                                daoMedico.update();
                            case 5:
                                noMenuMedico = false;
                                break;
                            default:
                                System.out.println("Opcao invalida. Tente novamente.");
                        }
                    }
                    break;
                case 3:
                    boolean noMenuAtendimento = true;
                    while (noMenuAtendimento) {
                        System.out.println("\n====== MENU ATENDIMENTO =======");
                        System.out.println("[1] Realizar atendimento");
                        System.out.println("[2] Exibir lista de atendimentos");
                        System.out.println("[3] Remover Atendimento");
                        System.out.println("[4] Atualizar Atendimento (Somente medico responsavel)");
                        System.out.println("[5] Voltar ao menu de acoes");
                        System.out.print("Escolha uma opcao: ");
                        int opcaoAtendimento = scanner.nextInt();
                        scanner.nextLine();
                        
                        switch (opcaoAtendimento) {
                            case 1:
                                System.out.println("====Realizar Atendimento====");
                                System.out.println("ID MEDICO: ");
                                String idA = scanner.nextLine();
                                System.out.println("ID PACIENTE: ");
                                String id2 = scanner.nextLine();

                                Medico medicoA = daoMedico.read(idA);
                                Paciente pacienteA = daoPaciente.read(id2);
                                System.out.println("Escolha o estado inicial do atendimento:");
                                EstadoAtendimento[] estados = EstadoAtendimento.values();

                                for (int i = 0; i < estados.length; i++) {
                                    System.out.println(i + " - " + estados[i]);
                                }

                                int escolha;

                                System.out.print("Digite o numero correspondente ao estado desejado: ");
                                escolha = scanner.nextInt();
                                EstadoAtendimento estadoEscolhido = estados[escolha];

                                String cpf = scanner.nextLine();
                                System.out.println("Descricao: ");
                                String desc = scanner.nextLine();

                                Atendimento atendimentoC = daoAtendimento.create(new Atendimento(estadoEscolhido, medicoA, pacienteA, desc));
                                break;
                            case 2:
                                System.out.println("=== Exibir Todos Atendimentos ===");
                                daoAtendimento.getAll();
                                break;
                            case 3:
                                System.out.println("\n=== Remover Atendimento ===");
                                System.out.println("Digite o Id do atendimento a excluir: ");
                                int idExcluir = scanner.nextInt();
                                scanner.nextLine();
                                Atendimento atendimentoSD = daoAtendimento.read(idExcluir);

                                if (daoAtendimento.delete(atendimentoSD)) {
                                    System.out.println("Exclusao com sucesso");
                                } else {
                                    System.out.println("Exclusao nao realizada");
                                }
                                break;
                            case 4:
                                daoAtendimento.update();
                            case 5:
                                noMenuAtendimento = false;
                                break;
                            default:
                                System.out.println("Opcao invalida. Tente novamente.");
                        }
                    }
                    break;
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }
        }

        scanner.close();
    }
}

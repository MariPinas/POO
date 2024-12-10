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
            System.out.println("[4] Sair");
            System.out.print("Escolha uma opcao: ");

            String entrada = scanner.nextLine().trim();
            if (entrada.isEmpty() || !entrada.matches("\\d+")) { //dessa forma somente permite numeros
                System.out.println("\n\nEntrada invalida. Por favor, digite um numero inteiro");
                continue;
            }
            opcao = Integer.parseInt(entrada);
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
                        entrada = scanner.nextLine().trim();
                        if (entrada.isEmpty() || !entrada.matches("\\d+")) {
                            System.out.println("\n\nEntrada invalida. Por favor, digite um numero inteiro");
                            continue;
                        }
                        int opcaoPaciente = Integer.parseInt(entrada);

                        switch (opcaoPaciente) {
                            case 1:
                                System.out.println("=== Cadastro de Paciente ===");
                                String nome;
                                do {
                                    System.out.println("Digite o nome do paciente: ");
                                    nome = scanner.nextLine();
                                    if (nome.isEmpty()) {
                                        System.out.println("Nome invalido. Por favor, digite novamente.");
                                    }
                                } while (nome.isEmpty());

                                String endereco;
                                do {
                                    System.out.println("Digite o endereço do paciente: ");
                                    endereco = scanner.nextLine();
                                    if (nome.isEmpty()) {
                                        System.out.println("Endereco invalido. Por favor, digite novamente.");
                                    }
                                } while (endereco.isEmpty());

                                String cpf;
                                do {
                                    System.out.println("Digite o CPF do paciente (apenas numeros): ");
                                    cpf = scanner.nextLine();
                                    if (cpf.isEmpty()) {
                                        System.out.println("CPF invalido. Por favor, digite novamente.");
                                    }
                                } while (cpf.isEmpty());

                                String tel;
                                do {
                                    System.out.println("Digite o telefone do paciente (apenas numeros): ");
                                    tel = scanner.nextLine();
                                    if (tel.isEmpty()) {
                                        System.out.println("Telefone invalido. Por favor, digite novamente.");
                                    }
                                } while (tel.isEmpty());

                                String nomeConv;
                                do {
                                    System.out.println("Digite o nome do convenio do paciente: ");
                                    nomeConv = scanner.nextLine();
                                    if (nomeConv.isEmpty()) {
                                        System.out.println("Nome de convenio invalido. Por favor, digite novamente.");
                                    }
                                } while (nomeConv.isEmpty());

                                String numConv;
                                do {
                                    System.out.println("Digite o numero do convenio do paciente: ");
                                    numConv = scanner.nextLine();
                                    if (numConv.isEmpty()) {
                                        System.out.println("Numero de convenio invalido. Por favor, digite novamente.");
                                    }
                                } while (numConv.isEmpty());

                                String id;
                                do {
                                    System.out.println("Digite a identidade do paciente: ");
                                    id = scanner.nextLine();
                                    if (id.isEmpty()) {
                                        System.out.println("Identidade invalida. Por favor, digite novamente.");
                                    }
                                } while (id.isEmpty());

                                Paciente pacienteC = daoPaciente.create(new Paciente(nome, id, cpf, endereco, tel, nomeConv, numConv));
                                if (pacienteC != null) {
                                    System.out.println("\nPaciente cadastrado!");
                                } else {
                                    System.out.println("\nPaciente NAO cadastrado");
                                }
                                break;
                            case 2:
                                if (daoPaciente.getPacienteCount() == 0) {
                                    System.out.println("\nNao existem pacientes cadastrados !");
                                } else {
                                    System.out.println("\n=== Lista de pacientes ===");
                                    daoPaciente.getAll();
                                }
                                break;
                            case 3:
                                if (daoPaciente.getPacienteCount() == 0) {
                                    System.out.println("\nNao existem pacientes cadastrados !");
                                } else {
                                    daoPaciente.update();
                                }
                                break;
                            case 4:

                                if (daoPaciente.getPacienteCount() == 0) {
                                    System.out.println("Nao existem pacientes cadastrados !");
                                } else {
                                    System.out.println("\n=== Remover Paciente ===");
                                    System.out.println("Digite o id do paciente a deletar: ");
                                    String idDeletar = scanner.nextLine();

                                    Paciente pacienteSD = daoPaciente.read(idDeletar);
                                    if (pacienteSD != null) {
                                        if (daoPaciente.delete(pacienteSD)) {
                                            System.out.println("Exclusao com sucesso");
                                        }
                                    } else {
                                        System.out.println("Exclusao nao realizada - Paciente nao existe");
                                    }

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
                        entrada = scanner.nextLine().trim();
                        if (entrada.isEmpty() || !entrada.matches("\\d+")) {
                            System.out.println("\n\nEntrada invalida. Por favor, digite um numero inteiro");
                            continue;
                        }
                        int opcaoM = Integer.parseInt(entrada);
                        switch (opcaoM) {
                            case 1:
                                System.out.println("====Cadastrar Medico====");
                                String nome;
                                do {
                                    System.out.println("Digite o nome do medico: ");
                                    nome = scanner.nextLine();
                                    if (nome.isEmpty()) {
                                        System.out.println("Nome invalido. Por favor, digite novamente.");
                                    }
                                } while (nome.isEmpty());

                                String end;
                                do {
                                    System.out.println("Digite o endereco do medico: ");
                                    end = scanner.nextLine();
                                    if (end.isEmpty()) {
                                        System.out.println("Endereco invalido. Por favor, digite novamente.");
                                    }
                                } while (end.isEmpty());

                                String cpf;
                                do {
                                    System.out.println("Digite o CPF do medico: ");
                                    cpf = scanner.nextLine();
                                    if (cpf.isEmpty()) {
                                        System.out.println("CPF invalido. Por favor, digite novamente.");
                                    }
                                } while (cpf.isEmpty());

                                String tel;
                                do {
                                    System.out.println("Digite o telefone do medico: ");
                                    tel = scanner.nextLine();
                                    if (tel.isEmpty()) {
                                        System.out.println("Telefone invalido. Por favor, digite novamente.");
                                    }
                                } while (tel.isEmpty());

                                String esp;
                                do {
                                    System.out.println("Digite a especialidade do medico: ");
                                    esp = scanner.nextLine();
                                    if (esp.isEmpty()) {
                                        System.out.println("Especialidade invalida. Por favor, digite novamente.");
                                    }
                                } while (esp.isEmpty());

                                String crm;
                                do {
                                    System.out.println("Digite o CRM do medico: ");
                                    crm = scanner.nextLine();
                                    if (crm.isEmpty()) {
                                        System.out.println("CRM invalido. Por favor, digite novamente.");
                                    }
                                } while (crm.isEmpty());

                                String cpts;
                                do {
                                    System.out.println("Digite o CPTS do medico: ");
                                    cpts = scanner.nextLine();
                                    if (cpts.isEmpty()) {
                                        System.out.println("CPTS invalido. Por favor, digite novamente.");
                                    }
                                } while (cpts.isEmpty());

                                String id;
                                do {
                                    System.out.println("Digite o ID do medico: ");
                                    id = scanner.nextLine();
                                    if (id.isEmpty()) {
                                        System.out.println("ID invalido. Por favor, digite novamente.");
                                    }
                                } while (id.isEmpty());

                                Medico medicoC = daoMedico.create(new Medico(nome, id, cpf, end, tel, crm, esp, cpts));
                                if (medicoC != null) {
                                    System.out.println("\nMedico cadastrado!");
                                } else {
                                    System.out.println("\nMedico NAO cadastrado");
                                }
                                break;
                            case 2:

                                if (daoMedico.getMedicoCount() == 0) {
                                    System.out.println("\nNao existem medicos cadastrados !");
                                } else {
                                    System.out.println("=== Exibir Todos Medicos ===");
                                    daoMedico.getAll();
                                }
                                break;
                            case 3:

                                if (daoMedico.getMedicoCount() == 0) {
                                    System.out.println("Nao existem medicos cadastrados !");
                                } else {
                                    System.out.println("\n=== Remover Medico ===");
                                    String idExcluir;
                                    do {
                                        System.out.println("Digite o Id do medico a excluir: ");
                                        idExcluir = scanner.nextLine();
                                        if (idExcluir.isEmpty()) {
                                            System.out.println("Identidade invalida. Por favor, digite novamente.");
                                        }
                                    } while (idExcluir.isEmpty());
                                    Medico medicoSD = daoMedico.read(idExcluir);

                                    if (medicoSD != null) {
                                        if (daoMedico.delete(medicoSD)) {
                                            System.out.println("Exclusao com sucesso");
                                        }
                                    } else {
                                        System.out.println("Exclusao nao realizada - Medico nao existe");
                                    }
                                }
                                break;
                            case 4:
                                if (daoMedico.getMedicoCount() == 0) {
                                    System.out.println("\nNao existem medicos cadastrados !");
                                } else {
                                    daoMedico.update();
                                }
                                break;
                            case 5:
                                noMenuMedico = false;
                                break;
                            default:
                                System.out.println("\n\nOpcao invalida. Tente novamente.");
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
                        entrada = scanner.nextLine().trim();
                        if (entrada.isEmpty() || !entrada.matches("\\d+")) {
                            System.out.println("\n\nEntrada invalida. Por favor, digite um numero inteiro");
                            continue;
                        }
                        int opcaoAtendimento = Integer.parseInt(entrada);

                        switch (opcaoAtendimento) {
                            case 1:
                                if (daoPaciente.getPacienteCount() == 0 || daoMedico.getMedicoCount() == 0) {
                                    if (daoPaciente.getPacienteCount() == 0) {
                                        System.out.println("\nNao existe pacientes cadastrados!");
                                    } else {
                                        System.out.println("\nNao existe medicos cadastrados!");
                                    }
                                    continue;
                                }
                                System.out.println("====Realizar Atendimento====");
                                String idA;
                                do {
                                    System.out.println("ID MEDICO: ");
                                    idA = scanner.nextLine();
                                    if (idA.isEmpty()) {
                                        System.out.println("Idenficacao de medico invalida. Por favor, digite novamente.");
                                    }
                                } while (idA.isEmpty());

                                String id2;
                                do {
                                    System.out.println("ID PACIENTE: ");
                                    id2 = scanner.nextLine();
                                    if (id2.isEmpty()) {
                                        System.out.println("Idenficacao de paciente invalida. Por favor, digite novamente.");
                                    }
                                } while (id2.isEmpty());

                                Medico medicoA = daoMedico.read(idA);
                                Paciente pacienteA = daoPaciente.read(id2);
                                if (medicoA == null || pacienteA == null) {
                                    if (medicoA == null) {
                                        System.out.println("MEDICO COM ESTE ID NAO EXISTE");
                                        break;
                                    }
                                    if (pacienteA == null) {
                                        System.out.println("PACIENTE COM ESTE ID NAO EXISTE");
                                        break;
                                    }
                                }
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
                                if (atendimentoC != null) {
                                    System.out.println("\nAtendimento cadastrado!");
                                } else {
                                    System.out.println("\nAtendimento NAO cadastrado");
                                }
                                break;
                            case 2:
                                if (daoAtendimento.getAtendimentoCount() == 0) {
                                    System.out.println("\nNao foram realizados atendimentos !");
                                } else {
                                    System.out.println("=== Exibir Todos Atendimentos ===");
                                    daoAtendimento.getAll();
                                }

                                break;
                            case 3:
                                if (daoAtendimento.getAtendimentoCount() == 0) {
                                    System.out.println("\nNao foram realizados atendimentos !");
                                    continue;
                                } else {
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
                                }
                            case 4:
                                if (daoAtendimento.getAtendimentoCount() == 0) {
                                    System.out.println("\nNao existem atendimentos cadastrados !");
                                } else {
                                    daoAtendimento.update();
                                }
                                break;

                            case 5:
                                noMenuAtendimento = false;
                                break;
                            default:
                                System.out.println("\n\nOpcao invalida. Tente novamente.");
                        }
                    }
                    break;
                case 4:
                    executando = false;
                    break;
                default:
                    System.out.println("\n\nOpcao invalida. Tente novamente.");
            }
        }

        scanner.close();
    }
}

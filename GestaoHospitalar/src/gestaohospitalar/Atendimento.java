package gestaohospitalar;

/**
 *
 * @author aluno
 */
public class Atendimento {
    private int id;
    private EstadoAtendimento status;
    private Medico medico;
    private Paciente paciente;
    private String descricao;
    private static int contadorId = 1;

   
    public Atendimento(EstadoAtendimento status, Medico medico, Paciente paciente, String descricao) {
        this.id=contadorId++;
        this.status = status;
        this.medico = medico;
        this.paciente = paciente;
        this.descricao = descricao;
    }
    
     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public EstadoAtendimento getStatus() {
        return status;
    }

    public void setStatus(EstadoAtendimento status) {
        this.status = status;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
     public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void imprimir(){
        System.out.println("ID Atendimento: " + id);
        System.out.println("Nome Medico: " + medico.getNome());
        System.out.println("Nome Paciente: " + paciente.getNome());
        System.out.println("Status: " + status);
        System.out.println("Descricao do atendimento: " + descricao);
        System.out.println("=========================================");
    }
}

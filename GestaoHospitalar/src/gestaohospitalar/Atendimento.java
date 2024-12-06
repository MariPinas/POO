package gestaohospitalar;

/**
 *
 * @author aluno
 */
public class Atendimento {
    private EstadoAtendimento status;
    private Medico medico;
    private Paciente paciente;

    public Atendimento(EstadoAtendimento status, Medico medico, Paciente paciente) {
        this.status = status;
        this.medico = medico;
        this.paciente = paciente;
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
    
    
}

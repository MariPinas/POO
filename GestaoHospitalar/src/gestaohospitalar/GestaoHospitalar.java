package gestaohospitalar;

/**
 *
 * @author aluno
 */
public class GestaoHospitalar {

    public static void main(String[] args) {
        DAOPaciente daoPaciente = new DAOPaciente();
        DAOMedico daoMedico = new DAOMedico();
        DAOAtendimento daoAtendimento = new DAOAtendimento();

        Paciente paciente1 = new Paciente("Mariana", 4543265, "457167546-34", "endereco", "1197453489", "Azul", "12312");
        Medico medico1 = new Medico("Gabriel", 9876555, "456434567-89", "endereco 2", "1198765433", "1232", "Nefrologista", "12121");

        //create paciente
        daoPaciente.create(paciente1);
        daoPaciente.getAll();

        //read paciente
        Paciente paciente = daoPaciente.read(4543265);
        System.out.println("===========================");
        paciente.imprimir();

        //update paciente
        System.out.println();
        Paciente pacienteUP = new Paciente("Mariane", 4543265, "457167546-34", "endereco", "1197453489", "Azul", "12312");
        daoPaciente.update(pacienteUP);
        pacienteUP.imprimir();

        //delete paciente
        Paciente pacienteSD = daoPaciente.read(4543265);

        if (daoPaciente.delete(pacienteSD)) {
            System.out.println("Exclusao com sucesso");
        } else {
            System.out.println("Exclusao nao realizada");
        }

    }

}

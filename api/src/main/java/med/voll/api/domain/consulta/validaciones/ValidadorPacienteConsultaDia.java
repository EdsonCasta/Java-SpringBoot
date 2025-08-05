package med.voll.api.domain.consulta.validaciones;

import med.voll.api.domain.ValidacionException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DatosReservaConsulta;

public class ValidadorPacienteConsultaDia {

    private ConsultaRepository repository;

    public void validar(DatosReservaConsulta datos) {
        var primerHorario = datos.consultaFecha().withHour(7);
        var ultimoHorario = datos.consultaFecha().withHour(18);
        var pacienteTieneOtraConsultaEnElDia = repository.existsByPacienteIdAndFechaBetween(datos.idPaciente(), primerHorario, ultimoHorario);
        if (pacienteTieneOtraConsultaEnElDia) {
            throw new ValidacionException("Paciente ya tiene una consulta para ese dia");
        }
    }
}

package med.voll.api.domain.consulta.validaciones.reserva;

import med.voll.api.domain.ValidacionException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DatosReservaConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteConsultaDia implements ValidadorDeConsultas {

    @Autowired
    private ConsultaRepository repository;

    public void validar(DatosReservaConsulta datos) {
        var primerHorario = datos.consultaFecha().withHour(7);
        var ultimoHorario = datos.consultaFecha().withHour(18);
        var pacienteTieneOtraConsultaEnElDia = repository.existsByPacienteIdAndConsultaFechaBetween(datos.idPaciente(), primerHorario, ultimoHorario);
        if (pacienteTieneOtraConsultaEnElDia) {
            throw new ValidacionException("Paciente ya tiene una consulta para ese dia");
        }
    }
}

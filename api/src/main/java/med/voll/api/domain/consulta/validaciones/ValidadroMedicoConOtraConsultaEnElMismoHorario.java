package med.voll.api.domain.consulta.validaciones;

import med.voll.api.domain.ValidacionException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DatosReservaConsulta;

public class ValidadroMedicoConOtraConsultaEnElMismoHorario {

    private ConsultaRepository repository;

    public void validar(DatosReservaConsulta datos) {
        var medicoTieneOtraConsultaEnElMismoHorario = repository.existsByMedicoIdAndFecha(datos.idMedico(), datos.consultaFecha());
        if (medicoTieneOtraConsultaEnElMismoHorario) {
            throw new ValidacionException("Medico ya tiene consulta en esa misma fecha y hora");
        }
    }
}

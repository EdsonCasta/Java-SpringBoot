package med.voll.api.domain.consulta.validaciones;

import med.voll.api.domain.ValidacionException;
import med.voll.api.domain.consulta.DatosReservaConsulta;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidadorFueraHorarioConsultas implements ValidadorDeConsultas {

    public void validar(DatosReservaConsulta datos) {
        var fechaConsulta = datos.consultaFecha();
        var domingo = fechaConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var horarioAperturaClinica = fechaConsulta.getHour() < 7;
        var horarioCierreClinica = fechaConsulta.getHour() > 18;

        if (domingo || horarioAperturaClinica || horarioCierreClinica) {
            throw new ValidacionException("Horario seleccionado fuera del rango entre 7am a 6pm");
        }
    }
}

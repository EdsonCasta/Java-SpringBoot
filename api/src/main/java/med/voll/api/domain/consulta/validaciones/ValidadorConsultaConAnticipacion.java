package med.voll.api.domain.consulta.validaciones;

import med.voll.api.domain.ValidacionException;
import med.voll.api.domain.consulta.DatosReservaConsulta;

import java.time.Duration;
import java.time.LocalDateTime;

public class ValidadorConsultaConAnticipacion {

    public  void validar(DatosReservaConsulta datos) {
        var fechaConsulta = datos.consultaFecha();
        var ahora = LocalDateTime.now();
        var diferenciaEnMinutos = Duration.between(ahora, fechaConsulta).toMinutes();

        if (diferenciaEnMinutos < 30 ) {
            throw new ValidacionException("Horario seleccionado con menos a 30 min de anticipacion");
        }
    }
}

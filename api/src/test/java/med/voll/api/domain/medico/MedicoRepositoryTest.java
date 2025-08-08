package med.voll.api.domain.medico;

import jakarta.persistence.EntityManager;
import med.voll.api.domain.consulta.Consulta;
import med.voll.api.domain.direccion.DatosDireccion;
import med.voll.api.domain.paciente.DatosRegistroPaciente;
import med.voll.api.domain.paciente.Paciente;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class MedicoRepositoryTest {

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private EntityManager em;

    @Test
    @DisplayName("deberia devolver null cuando el medico buscado existe pero no en esa fecha")
    void elegirMedicoAleatorioDisponibleEnLaFechaEcenario1() {

        var lunesSiguienteALas10 = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.MONDAY)).atTime(10,0);

        var medico = registrarMedico("medico1", "medico@gmail.com", "12345", Especialidad.CARDIOLOGIA);
        var paciente = registrarPaciente("paciente1", "paciente@gmail.com", "1234662");
        registrarConsulta(medico, paciente, lunesSiguienteALas10);

        var medicoLibre = medicoRepository.elegirMedicoAleatorioDisponibleEnLaFecha(Especialidad.CARDIOLOGIA, lunesSiguienteALas10);

        assertThat(medicoLibre).isNull();
    }

    @Test
    @DisplayName("deberia devolver medico cuando el medico buscado esta disponible en esa fecha")
    void elegirMedicoAleatorioDisponibleEnLaFechaEcenario2() {

        var lunesSiguienteALas10 = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.MONDAY)).atTime(10,0);

        var medico = registrarMedico("medico1", "medico@gmail.com", "12345", Especialidad.CARDIOLOGIA);

        var medicoLibre = medicoRepository.elegirMedicoAleatorioDisponibleEnLaFecha(Especialidad.CARDIOLOGIA, lunesSiguienteALas10);

        assertThat(medicoLibre).isEqualTo(medico);
    }

    private void registrarConsulta(Medico medico, Paciente paciente, LocalDateTime fecha) {
        em.persist(new Consulta(null, medico, paciente, fecha));
    }

    private Paciente registrarPaciente(
            String nombre,
            String email,
            String documento
    ) {
        var paciente = new Paciente(DatosPaciente(nombre, email, documento));
        em.persist(paciente);
        return paciente;
    }

    private Medico registrarMedico(
            String nombre,
            String email,
            String documento,
            Especialidad especialidad
    ) {
        var medico = new Medico(DatosMedico(nombre, email, documento, especialidad));
        em.persist(medico);
        return medico;
    }

    private DatosRegistroMedico DatosMedico(String nombre, String email, String documento, Especialidad especialidad) {
        return new DatosRegistroMedico(
                nombre,
                documento,
                email,
                "3245678234",
                especialidad,
                datosDireccion()
        );
    }

    private DatosRegistroPaciente DatosPaciente(String nombre, String email, String documento) {
        return new DatosRegistroPaciente(
                nombre,
                email,
                "3164567654",
                documento,
                datosDireccion()
        );
    }

    private DatosDireccion datosDireccion() {
        return new DatosDireccion(
                "calle 102",
                "153",
                "30",
                "pinar",
                "Bogota",
                "Bogota DC"
        );
    }
}
package med.voll.api.domain.consulta;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    boolean existsByMedicoIdAndConsultaFecha(Long idMedico, LocalDateTime consultaFecha);

    boolean existsByPacienteIdAndConsultaFechaBetween(Long idPaciente, LocalDateTime primerHorario, LocalDateTime ultimoHorario);
}

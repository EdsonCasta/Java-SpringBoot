package med.voll.api.domain.paciente;

public record DatosListaPacientes(
        Long id,
        String nombre,
        String email,
        String documento
) {
    public DatosListaPacientes(Paciente paciente) {
        this(
                paciente.getId(),
                paciente.getNombre(),
                paciente.getEmail(),
                paciente.getDocumento()
        );
    }
}

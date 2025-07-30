package med.voll.api.paciente;

public record DatosListaPacientes(
        String nombre,
        String email,
        String documento
) {
    public DatosListaPacientes(Paciente paciente) {
        this(
                paciente.getNombre(),
                paciente.getEmail(),
                paciente.getDocumento()
        );
    }
}

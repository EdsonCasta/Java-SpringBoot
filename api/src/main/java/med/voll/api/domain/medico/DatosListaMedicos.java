package med.voll.api.domain.medico;

public record DatosListaMedicos(
        Long id,
        String nombre,
        String email,
        String documento,
        Especilidad especilidad
) {
    public DatosListaMedicos(Medico medico) {
        this(
                medico.getId(),
                medico.getNombre(),
                medico.getEmail(),
                medico.getDocumento(),
                medico.getEspecialidad()
        );
    }
}

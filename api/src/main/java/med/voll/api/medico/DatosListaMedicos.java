package med.voll.api.medico;

public record DatosListaMedicos(
        String nombre,
        String email,
        String documento,
        Especilidad especilidad
) {
    public DatosListaMedicos(Medico medico) {
        this(
                medico.getNombre(),
                medico.getEmail(),
                medico.getDocumento(),
                medico.getEspecialidad()
        );
    }
}

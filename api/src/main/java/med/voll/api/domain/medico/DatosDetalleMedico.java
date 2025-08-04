package med.voll.api.domain.medico;

import med.voll.api.domain.direccion.Direccion;

public record DatosDetalleMedico(
        Long id,
        String nombre,
        String documento,
        String email,
        String telefono,
        Especialidad especialidad,
        Direccion direccion
) {
    public DatosDetalleMedico(Medico medico) {
        this(
                medico.getId(),
                medico.getNombre(),
                medico.getDocumento(),
                medico.getEmail(),
                medico.getTelefono(),
                medico.getEspecialidad(),
                medico.getDireccion()
        );
    }
}

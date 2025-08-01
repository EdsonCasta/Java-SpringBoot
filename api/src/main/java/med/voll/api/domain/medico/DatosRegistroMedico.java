package med.voll.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.direccion.DatosDireccion;

public record DatosRegistroMedico(
        @NotBlank String nombre,
        @NotBlank @Pattern(regexp = "\\d{7,10}") String documento,
        @NotBlank @Email String email,
        @NotBlank String telefono,
        @NotNull Especilidad especialidad,
        @NotNull @Valid DatosDireccion direccion
) {
}

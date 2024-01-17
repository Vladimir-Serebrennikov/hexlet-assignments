package exercise.dto;

// BEGIN

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class GuestCreateDTO {
    @NotBlank
    private String name;

    @Email
    private String email;

    @Pattern(regexp = "\\+\\d{11,13}", message = "Phone number must start with '+' and have 11 to 13 digits.")
    private String phoneNumber;

    @Pattern(regexp = "\\d{4}", message = "Club card number must consist of exactly four digits.")
    private String clubCard;

    @Future(message = "Card has expired")
    private LocalDate cardValidUntil;
}
// END

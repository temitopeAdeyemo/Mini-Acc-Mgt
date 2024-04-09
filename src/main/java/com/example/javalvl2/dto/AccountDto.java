package com.example.javalvl2.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
public class AccountDto {
    private Long id;

    @NotNull(message = "Account name must not be null")
    @NotBlank(message = "Account name must not be empty.")
    private String accountHolderName;

    @NotNull(message = "Email Required.")
    @NotBlank(message = "email must not be empty.")
    @Email(message = "Invalid Email")
    private  String email;

    @Length(message = "Must be between 10 and 13 digits.", max = 13, min = 10)
    @NotBlank(message = "Phone required.")
//    @Pattern(regexp = "^\\d{10}$", message = "Phone number must be atleast 10 digits.") // Add pattern
    private  String phoneNumber;

//    @Min(message = "Min exceeded.", value = 10)
    private double balance;
}

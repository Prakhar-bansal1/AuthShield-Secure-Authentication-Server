package com.project.authshield_secure_authentication_server.Model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileUpdateRequest {
    @NotBlank(message = "email is required")
    @Email(message = "email must be a valid email address")
    private String email;

    @Size(max = 15, message = "Enter Phone number with country code")
    @Pattern(regexp = "^(\\+\\d{1,3}[-.\\s]?)?(\\(?\\d{1,4}\\)?[-.\\s]?){1,3}\\d{1,9}$", message = "phoneNumber contains invalid characters")
    private String phoneNumber;
}

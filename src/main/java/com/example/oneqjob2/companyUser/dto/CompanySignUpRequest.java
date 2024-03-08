package com.example.oneqjob2.companyUser.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanySignUpRequest {
    @NotBlank(message = "company name is required.")
    private String companyName;

    @NotBlank(message = "Invalid input for business number")
    private String businessNumber;

    private String companyLogoImgPileName;

    private String companyLogoImgUrl;

    @Email
    @NotBlank(message = "Invalid input for email")
    private String companyEmail;

    @NotBlank(message = "Invalid password format.")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$")
    private String companyPw1;

    @NotBlank(message = "Password is required.")
    private String companyPw2;
}

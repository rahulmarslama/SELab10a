package miu.rahul.pabapp.dto;

import java.time.LocalDate;


public record PatientDto(
        String patientid,
        String firstName,
        String lastName,
        String email,
        LocalDate birthdate,
        AddressDto address,
        int age
) {}
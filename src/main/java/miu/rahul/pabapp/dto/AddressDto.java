package miu.rahul.pabapp.dto;

public record AddressDto(
        String street,
        String city,
        String state,
        String zipcode,
        String country
) {}

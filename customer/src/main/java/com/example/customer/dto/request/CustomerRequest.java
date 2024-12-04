package com.example.customer.dto.request;

import com.example.customer.entity.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class CreateCustomerDto {

    String id;

    @NotNull(message = "Customer firstname is required")
    String firstname;

    @NotNull(message = "Customer firstname is required")
    String lastname;

    @NotNull(message = "Customer Email is required")
    @Email(message = "Customer Email is not a valid email address")
    String email;

    Address address;
}

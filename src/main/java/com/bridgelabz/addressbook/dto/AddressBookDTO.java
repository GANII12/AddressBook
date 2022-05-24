package com.bridgelabz.addressbook.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.ToString;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

public @ToString class AddressBookDTO {
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message = "name Invalid")
    public String name;

    @NotBlank(message = "State cannot be Empty")
    public String state;

    @NotBlank(message = "State cannot be Empty")
    public String city;

    public long pincode;

    public String address;

    public String number;
}

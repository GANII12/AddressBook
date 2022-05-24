package com.bridgelabz.addressbook.model;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Address_Book")
public @Data class AddressBookData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private int Id;
    @Column(name = "name")
    private String name;
    private String number;
    private String address;
    private String city;
    private Long pincode;
    private String state;
    public AddressBookData() {
    }

    public void updateAddressBookData(AddressBookDTO addressBookDTO) {
        this.name = addressBookDTO.name;
        this.state = addressBookDTO.state;
        this.number = addressBookDTO.number;
        this.city = addressBookDTO.city;
        this.pincode = addressBookDTO.pincode;
        this.address = addressBookDTO.address;
    }
    public AddressBookData( int id , AddressBookDTO addressBookDTO) {
        this.updateAddressBookData(addressBookDTO);
    }

    public AddressBookData(AddressBookDTO addressBookDTO) {
        this.updateAddressBookData(addressBookDTO);
    }

}

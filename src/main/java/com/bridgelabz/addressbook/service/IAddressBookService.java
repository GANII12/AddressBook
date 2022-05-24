package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.dto.ResponseDTO;
import com.bridgelabz.addressbook.model.AddressBookData;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IAddressBookService {
    ResponseEntity<ResponseDTO> getAddressBookData();

    String saveDataToRepo(AddressBookDTO addressBookDTO);

    ResponseEntity<ResponseDTO> getAddressBookDataById(Optional<String> id, String token);

    ResponseEntity<ResponseDTO>  createAddressBookData(AddressBookDTO addressBookDTO);

    ResponseEntity<ResponseDTO> updateAddressBookData(String token , AddressBookDTO addressBookDTO , String s);

    void deleteAddressBookData(String token);

    void deleteAll();

    List<AddressBookData> sortByName();
    List<AddressBookData> sortByCity();
    List<AddressBookData> sortByState();
}

package com.bridgelabz.addressbook.controllers;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.dto.ResponseDTO;
import com.bridgelabz.addressbook.exceptions.AddressBookException;
import com.bridgelabz.addressbook.model.AddressBookData;
import com.bridgelabz.addressbook.service.AddressBookService;
import com.bridgelabz.addressbook.service.IAddressBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("addressBook")
@Slf4j
public class AddressBookController {
    @Autowired
    private IAddressBookService addressBookService;

    private AddressBookData addressBookData;

    @GetMapping(value = {"","/","/get"})
    public ResponseEntity<ResponseDTO> getAddressBookData(){
        return addressBookService.getAddressBookData();
    }

    @GetMapping("/get/{token}")
    public ResponseEntity<ResponseDTO> getAddressBookData(@PathVariable Optional<String> id ,@RequestParam(name = "token") String token){
        return addressBookService.getAddressBookDataById(id,token);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addAddressBookData(@Valid @RequestBody AddressBookDTO addressBookDTO){
        return addressBookService.createAddressBookData(addressBookDTO);
    }

    @PutMapping("/update/{token}")
    public ResponseEntity<ResponseDTO> updateAddressBookData(@PathVariable String id ,@Valid @RequestBody AddressBookDTO addressBookDTO , @RequestParam(name = "token") String token){
        return addressBookService.updateAddressBookData(id,addressBookDTO,token);
    }

    @DeleteMapping("/delete/{token}")
    public ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable String token) throws AddressBookException {
        addressBookService.deleteAddressBookData(token);
        ResponseDTO respDTO = new ResponseDTO("Deleted Successfully" , "Deleted Id :",token);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }
    //delete all , sort by city,name,state
    @DeleteMapping("/deleteAll")
    public ResponseEntity<ResponseDTO> deleteAllData(){
        addressBookService.deleteAll();
        ResponseDTO responseDTO = new ResponseDTO("All Data Deleted Successfully");
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @GetMapping("/sortByState")
    public ResponseEntity<ResponseDTO> sortByState(){
        List<AddressBookData> contactList = null;
        contactList =addressBookService.sortByState();
        ResponseDTO responseDTO = new ResponseDTO("All Data Sorted Successfully for States",contactList);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @GetMapping("/sortByCity")
    public ResponseEntity<ResponseDTO> sortByCity(){
        List<AddressBookData> contactList = null;
        contactList =addressBookService.sortByCity();
        ResponseDTO responseDTO = new ResponseDTO("All Data Sorted Successfully for Cities",contactList);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @GetMapping("/sortByName")
    public ResponseEntity<ResponseDTO> sortByName(){
        List<AddressBookData> contactList = null;
        contactList =addressBookService.sortByName();
        ResponseDTO responseDTO = new ResponseDTO("All Data Sorted Successfully for Names",contactList);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

}

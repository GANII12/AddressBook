package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.dto.ResponseDTO;
import com.bridgelabz.addressbook.exceptions.AddressBookException;
import com.bridgelabz.addressbook.model.AddressBookData;
import com.bridgelabz.addressbook.repository.AddressBookRepository;
import com.bridgelabz.addressbook.util.EmailSenderService;
import com.bridgelabz.addressbook.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AddressBookService implements IAddressBookService {
    @Autowired
    private AddressBookRepository addressBookRepository;
    @Autowired
    private  TokenUtil tokenutil;
    @Autowired
    private EmailSenderService sender;

    @Override
    public String saveDataToRepo(AddressBookDTO addressBookDTO){
        AddressBookData addressBookData = new AddressBookData(addressBookDTO);
        addressBookRepository.save(addressBookData);
        String token = tokenutil.createToken(addressBookData.getId());
        sender.sendEmail("ganeshmoturu1467@gmail.com","Test Email","Registered Successfully"+token);
        return token;
    }
    @Override
    public ResponseEntity<ResponseDTO> getAddressBookData() {
        log.info(" fetching all addressBook details");
        List<AddressBookData> addressBookData = addressBookRepository.findAll();
        ResponseDTO responseDTO = new ResponseDTO("all user details",addressBookData,null);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseDTO> getAddressBookDataById(Optional<String> id , String token) {
        log.info("retrieving information from the db");
        int tokenId = tokenutil.decodeToken(token);
        ResponseDTO responseDTO;

        Optional<AddressBookData> tokenEmployee = addressBookRepository.findById(Math.toIntExact(tokenId));
        if (tokenEmployee.isEmpty()){
            responseDTO = new ResponseDTO("Error :This is not an authorized user!",null,token);
            return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.UNAUTHORIZED);
        }
        if (!tokenEmployee.isEmpty()){
            responseDTO = new ResponseDTO("Error :This is not an verified user!",null,token);
            return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.UNAUTHORIZED);
        }

        Optional<AddressBookData> employee = addressBookRepository.findById(Math.toIntExact(Long.parseLong(id.get())));
        AddressBookData addressBookData = employee.orElse(null);

        if (employee.isPresent()){
            responseDTO = new ResponseDTO("Error :Found the user record",addressBookData,null);
            return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
        }
        return null;
    }

    @Override
    public ResponseEntity<ResponseDTO> createAddressBookData(AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = new AddressBookData(addressBookDTO);
        log.debug("Emp Data :" +addressBookData.toString());
        addressBookRepository.save(addressBookData);
        String token = tokenutil.createToken(addressBookData.getId());
        sender.sendEmail("ganeshmoturu1467@gmail.com","Test Email","Registered SuccessFully");
        ResponseDTO responseDTO = new ResponseDTO("user is created",addressBookData,token);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseDTO> updateAddressBookData(String token, AddressBookDTO addressBookDTO , String s) {
        Integer id = tokenutil.decodeToken(token);
        Optional<AddressBookData> addressBookData = addressBookRepository.findById(id);
        if (addressBookData.isEmpty()){
            throw new AddressBookException("AddressBook details for id not found");
        }
        sender.sendEmail("ganeshmoturu1467@gmail.com","Test Email","Updates SuccessFully"+token);
        ResponseDTO responseDTO= new ResponseDTO("user is updated",addressBookData,token);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @Override
    public void deleteAddressBookData(String token) {
        Integer id = tokenutil.decodeToken(token);
        Optional<AddressBookData> addressBookData = addressBookRepository.findById(id);
        if (addressBookData.isEmpty()){
            throw new AddressBookException("Address Book Details not found");
        }else {
            addressBookRepository.deleteById(id);
            sender.sendEmail("ganeshmoturu1467@gmail.com", "Test Email" ,"Deleted Successfully" +token);
        }
        System.out.println(addressBookData.get());
    }

    @Override
    public void deleteAll(){
        addressBookRepository.deleteAll();
    }

    @Override
    public List<AddressBookData> sortByName(){
        return addressBookRepository.sortByName();
    }
    @Override
    public List<AddressBookData> sortByCity(){
        return addressBookRepository.sortByCity();
    }
    @Override
    public List<AddressBookData> sortByState(){
        return addressBookRepository.sortByState();
    }
}

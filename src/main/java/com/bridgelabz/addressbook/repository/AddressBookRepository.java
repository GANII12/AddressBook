package com.bridgelabz.addressbook.repository;

import com.bridgelabz.addressbook.model.AddressBookData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AddressBookRepository extends JpaRepository<AddressBookData,Integer> {
    @Query(value = "SELECT * FROM Address_Book ORDER BY city",nativeQuery = true)
    List<AddressBookData> sortByCity();
    @Query(value = "SELECT * FROM Address_Book ORDER BY name ",nativeQuery = true)
    List<AddressBookData> sortByName();
    @Query(value = "SELECT * FROM Address_Book ORDER BY state ",nativeQuery = true)
    List<AddressBookData> sortByState();
}

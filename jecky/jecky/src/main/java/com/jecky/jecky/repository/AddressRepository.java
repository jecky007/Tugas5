package com.jecky.jecky.repository;

import com.jecky.jecky.model.Address;
import com.jecky.jecky.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {
    Address findById(int id);
    List<Address> findByCityContaining(String search);
    List<Address> findByProvinceContaining(String search);
    List<Address> findByCountryContaining(String search);
    @Modifying
    @Query(value = "DELETE FROM address WHERE user_id = :id ", nativeQuery = true)
    Integer deleteById(@Param("id") int id);

}

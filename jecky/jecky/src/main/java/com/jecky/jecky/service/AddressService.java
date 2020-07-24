package com.jecky.jecky.service;

import com.jecky.jecky.model.Address;
import com.jecky.jecky.model.Book;
import com.jecky.jecky.model.User;
import com.jecky.jecky.repository.AddressRepository;
import com.jecky.jecky.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    UserRepository userRepository;

    public List<Address> getAllAddress(Integer pageNo, String sortKey) {
        return addressRepository.findAll();
    }

    public Map<String, Object> getAddressById(int userId) {
        Address result = addressRepository.findById(userId);
        Map<String, Object> resultMap = new HashMap<>();
        if (result != null) {
            resultMap.put("success", true);
            resultMap.put("record", result);
        } else {
            resultMap.put("success", false);
            resultMap.put("message", "data address tidak di temukan");
        }
        return resultMap;
    }

    public boolean deleteByAddressId(int addressId) {
        Address result = addressRepository.findById(addressId);

        if (result != null) {
            try {
                addressRepository.deleteById(addressId);
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }


    //get by type
    public List<Address> getAddressByType(String search, String type) {

        switch (type) {
            case "city":
                return addressRepository.findByCityContaining(search);
            case "province":
                return addressRepository.findByProvinceContaining(search);
            case "country":
                return addressRepository.findByCountryContaining(search);
            default:
                return null;
        }
    }

    public Map insertAddress(Address address) {
        Map<String, Object> mapResult = new HashMap<>();

        if (address != null) {

            try {
                addressRepository.save(address);
                mapResult.put("success", true);
                mapResult.put("message", "berhasil insert address");
            } catch (Exception e) {
                mapResult.put("success", false);
                mapResult.put("message", "gagal insert address: " + e.getMessage());
            }
        }
        return mapResult;
    }



    public boolean updateAddress(Address body) {
        Address userResult = addressRepository.findById(body.getId());

        if (userResult != null) {
            try {
//
                addressRepository.save(body);
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }

    }
}

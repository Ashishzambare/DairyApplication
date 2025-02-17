package com.dairyproject.DairyApplication.service.impl;

import com.dairyproject.DairyApplication.Apputil.PasswordEncrypter;
import com.dairyproject.DairyApplication.Apputil.Role;
import com.dairyproject.DairyApplication.Apputil.UsernameGenerator;
import com.dairyproject.DairyApplication.dto.OwnerRegistrationDetailsDto;
import com.dairyproject.DairyApplication.entity.OwnerRegistrationDetails;
import com.dairyproject.DairyApplication.repository.OwnerRegistrationDetailsRepository;
import com.dairyproject.DairyApplication.service.OwnerRegistrationDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Base64;
import java.util.UUID;

@Service
public class OwnerRegistrationDetailsServiceImpl implements OwnerRegistrationDetailsService {
    @Autowired
    OwnerRegistrationDetailsRepository ownerRegistrationDetailsRepository;
    @Autowired
    PasswordEncrypter passwordEncrypter;
    @Override
    public OwnerRegistrationDetails createOwnerOfDairy(OwnerRegistrationDetailsDto ownerRegistrationDetailsDto) {
        try {
            String name = ownerRegistrationDetailsDto.getFirstName();
            String generatedName = UsernameGenerator.generateUsername(name);
            //boolean numberExist=checkOwnermobileNumberexist(ownerRegistrationDetailsDto.getMobileNumber());
            //System.out.print(numberExist);
            //String checkOwnerMobileNumberExist = numberExist ? "Mobile number Already exist" : ownerRegistrationDetailsDto.getMobileNumber();
            OwnerRegistrationDetails ownerRegistrationdetail = OwnerRegistrationDetails.builder().ownerUniqueId(UUID.randomUUID().toString())
                    .address(ownerRegistrationDetailsDto.getAddress()).emailId(ownerRegistrationDetailsDto.getEmailId()).dateOfBirth(LocalDate.parse(ownerRegistrationDetailsDto.getDateOfBirth().toString()))
                    .photo(ownerRegistrationDetailsDto.getPhoto().getBytes(StandardCharsets.UTF_8)).district(ownerRegistrationDetailsDto.getDistrict()).taluka(ownerRegistrationDetailsDto.getTaluka())
                    .firstName(ownerRegistrationDetailsDto.getFirstName()).lastName(ownerRegistrationDetailsDto.getLastName())
                    .role(ownerRegistrationDetailsDto.getRole().equalsIgnoreCase("admin") ? String.valueOf(Role.ADMIN) : String.valueOf(Role.USER)).state(ownerRegistrationDetailsDto.getState()).gender(ownerRegistrationDetailsDto.getGender())
                    .userName(generatedName).mobileNumber(ownerRegistrationDetailsDto.getMobileNumber()).password(PasswordEncrypter.encryptPassword(ownerRegistrationDetailsDto.getPassword()))
                    .pincode(ownerRegistrationDetailsDto.getPincode()).status(PasswordEncrypter.STATUS_ACTIVE).build();
            return ownerRegistrationDetailsRepository.save(ownerRegistrationdetail);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public OwnerRegistrationDetails updateOwner(String uniqueId,OwnerRegistrationDetailsDto details) {
        OwnerRegistrationDetails owner=ownerRegistrationDetailsRepository.findByOwnerUniqueId(uniqueId);
        System.out.println(owner);
        if(  owner!=null){

            owner.setAddress(details.getAddress()!=null?details.getAddress():owner.getAddress());
            owner.setEmailId(details.getEmailId()!=null ?  details.getEmailId():owner.getEmailId() );
            owner.setMobileNumber(details.getMobileNumber()!=null ?   details.getMobileNumber():owner.getMobileNumber());
            owner.setDistrict(details.getDistrict()!=null?details.getDistrict():owner.getDistrict());
            owner.setGender(details.getGender()!=null?details.getGender():owner.getGender());
            owner.setTaluka(details.getTaluka()!=null?details.getTaluka():owner.getTaluka());
            owner.setDateOfBirth(details.getDateOfBirth()!=null?details.getDateOfBirth():owner.getDateOfBirth());
            owner.setFirstName(details.getFirstName()!=null?details.getFirstName():owner.getFirstName());
            owner.setLastName(details.getLastName()!=null?details.getLastName():owner.getLastName());
            owner.setPassword(details.getPassword()!=null? details.getPassword():owner.getPassword());
            owner.setPhoto(details.getPhoto()!=null?details.getPhoto().getBytes(StandardCharsets.UTF_8):owner.getPhoto());
            owner.setPincode(details.getPincode()!=null? details.getPincode():owner.getPincode());
            owner.setRole(String.valueOf( Role.ADMIN));
        }

        return ownerRegistrationDetailsRepository.save(owner);
    }

    @Override
    public String deleteOwner(String uniqueid) {
        OwnerRegistrationDetails owner=ownerRegistrationDetailsRepository.findByOwnerUniqueId(uniqueid);
        if(owner!=null){
            System.out.println(owner);
            ownerRegistrationDetailsRepository.delete(owner);
            return "Owner deleted successfully";
        }
        return "null";
    }

    @Override
    public OwnerRegistrationDetails getOwnerDetails(String id) {
        OwnerRegistrationDetails owner=ownerRegistrationDetailsRepository.findByOwnerUniqueId(id);
        return owner;
    }

    public boolean checkOwnermobileNumberexist(String mobileNumber) {
        OwnerRegistrationDetails owner=ownerRegistrationDetailsRepository.findByOwnermobileNumber(mobileNumber);
        return owner != null;
    }

    @Override
    public boolean checkEmailExist(String email) {
        OwnerRegistrationDetails checkemailExist=ownerRegistrationDetailsRepository.findByEmailId((email));
        return checkemailExist != null;
    }


}
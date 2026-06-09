package miu.rahul.pabapp.service.impl;

import miu.rahul.pabapp.dto.AddressDto;
import miu.rahul.pabapp.dto.PatientDto;
import miu.rahul.pabapp.model.Patient;
import miu.rahul.pabapp.repository.PatientRepository;
import miu.rahul.pabapp.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService
{
    private PatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository)
    {
        this.patientRepository = patientRepository;
    }

    public List<PatientDto> getAllPatients()
    {
        List<Patient> patients=  patientRepository.getPatients();

        List<PatientDto> patientDTOs = patients.stream()
                .map(p -> new PatientDto(
                        p.getPatientid(),
                        p.getFirstName(),
                        p.getLastName(),
                        p.getEmail(),
                        p.getBirthdate(),
                        p.getAddress() != null ? new AddressDto(
                                p.getAddress().getStreet(),
                                p.getAddress().getCity(),
                                p.getAddress().getState(),
                                p.getAddress().getZipcode(),
                                p.getAddress().getCountry()
                        ) : null,
                        p.getAge()
                ))
                .sorted(Comparator.comparingInt(PatientDto::age).reversed())
                .toList();

        return patientDTOs;
    }
}

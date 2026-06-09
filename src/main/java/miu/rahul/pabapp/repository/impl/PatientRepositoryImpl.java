package miu.rahul.pabapp.repository.impl;

import miu.rahul.pabapp.model.Address;
import miu.rahul.pabapp.model.Patient;
import miu.rahul.pabapp.repository.PatientRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Repository
public class PatientRepositoryImpl implements PatientRepository
{
    public List<Patient> getPatients()
    {
        Patient[] patients = {
                new Patient("1", "Daniel", "Agar", "dagar@m.as", LocalDate.of(1987, 1, 19), new Address("New York", "NY", "10001", "USA", "1 N Street")),
                new Patient("2", "Ana", "Smith", "amsith@te.edu", LocalDate.of(1948, 12, 5), null),
                new Patient("3", "Marcus", "Garvey", null, LocalDate.of(2001, 9, 18), new Address("New York", "NY", "10002", "USA", "4 East Ave")),
                new Patient("4", "Jeff", "Goldbloom", "jgold@es.co.za", LocalDate.of(1995, 2, 28), null),
                new Patient("5", "Mary", "Washington", null, LocalDate.of(1932, 5, 31), new Address("Burlington", "VT", "05401", "USA", "30 W Burlington"))
        };

        return Arrays.asList(patients);
    }
}

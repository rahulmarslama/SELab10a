package miu.rahul.pabapp;

import miu.rahul.pabapp.dto.PatientDto;
import miu.rahul.pabapp.model.Address;
import miu.rahul.pabapp.model.Patient;
import miu.rahul.pabapp.service.PatientService;
import miu.rahul.pabapp.util.JsonUtil;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class PabAppApplication {

    private static PatientService  patientService;

    @Autowired
    public PabAppApplication(PatientService patientService) {
        this.patientService = patientService;
    }


    public static void main(String[] args) throws JSONException {
        SpringApplication.run(PabAppApplication.class, args);

        List<PatientDto> patients = patientService.getAllPatients();

        System.out.println(JsonUtil.convertPatientObjectToJson(patients));
    }

}

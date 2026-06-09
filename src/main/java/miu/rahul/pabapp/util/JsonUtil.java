package miu.rahul.pabapp.util;

import miu.rahul.pabapp.dto.AddressDto;
import miu.rahul.pabapp.dto.PatientDto;
import miu.rahul.pabapp.model.Address;
import miu.rahul.pabapp.model.Patient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class JsonUtil
{
    public static String convertPatientObjectToJson(List<PatientDto> patients) throws JSONException {
        JSONArray patientsArray = new JSONArray();

        for (PatientDto p : patients) {
            JSONObject patientJson = new JSONObject();
            patientJson.put("patientid", p.patientid());
            patientJson.put("firstName", p.firstName());
            patientJson.put("lastName", p.lastName());
            patientJson.put("email", p.email() != null ? p.email() : JSONObject.NULL);
            patientJson.put("birthdate", p.birthdate().toString());
            patientJson.put("age", p.age());

            if (p.address() != null) {
                AddressDto a = p.address();
                JSONObject addressJson = new JSONObject();
                addressJson.put("street", a.street());
                addressJson.put("city", a.city());
                addressJson.put("state", a.state());
                addressJson.put("zipcode", a.zipcode());
                addressJson.put("country", a.country());
                patientJson.put("address", addressJson);
            } else {
                patientJson.put("address", JSONObject.NULL);
            }

            patientsArray.put(patientJson);
        }

        JSONObject root = new JSONObject();
        root.put("patients", patientsArray);

        return root.toString(2);
    }
}
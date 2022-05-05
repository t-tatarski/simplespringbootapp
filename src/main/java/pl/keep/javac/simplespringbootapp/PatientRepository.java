package pl.keep.javac.simplespringbootapp;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
public class PatientRepository {

    private  List<Patient> patients = new ArrayList<>();
    {
        patients.add(new Patient(1L,"jan","kowalski",new BigDecimal("3000")));
        patients.add(new Patient(2L,"piotr","nowak",new BigDecimal("4000")));
        patients.add(new Patient(3L,"bartosz","walaszek",new BigDecimal("2000")));
        patients.add(new Patient(4L,"wojciech","puczyk",new BigDecimal("5500")));
    }
    List<Patient>showAll(){
        return patients;
    }
    BigDecimal getAvgPrice(){
        BigDecimal result = patients.stream()
                .map(Patient::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return result.divide(BigDecimal.valueOf(patients.size()), RoundingMode.HALF_UP);
    }
}

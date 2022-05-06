package pl.keep.javac.simplespringbootapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PatientsController {

    private final PatientRepository patientRepository;
    private static final String COUN = "lw";
    public PatientsController(PatientRepository patientRepository1){
        this.patientRepository = patientRepository1;
    }
    @GetMapping("/")
    String home (Model model,HttpSession session){

        List<Patient> patientList = patientRepository.showAll();
        BigDecimal avgPrice = patientRepository.getAvgPrice();
        Integer countr = (Integer)session.getAttribute(COUN);
        if (countr != null){
            countr++;
        }else {
            countr=1;
        }
        String sids = session.getId();
        model.addAttribute("patients",patientList);
        model.addAttribute("avgPrice",avgPrice);
        session.setAttribute(COUN,countr);
        session.setAttribute("seid",sids);
        Long ct = session.getCreationTime();
        session.setAttribute("lct",ct);
        return "index";
    }

    @GetMapping("/api/patients")
    @ResponseBody
    List<Patient>getAllPatients(){
        List<Patient> patients = new ArrayList<>();
        patients.add(new Patient(1L,"tom","tatars",new BigDecimal("345")));
        patients.add(new Patient(2L,"jon","puczyk",new BigDecimal("456")));
        patients.add(new Patient(3L,"asz","walusz",new BigDecimal("567")));
        patients.add(new Patient(4L,"lui","kozior",new BigDecimal("789")));

        return patients;
    }

}

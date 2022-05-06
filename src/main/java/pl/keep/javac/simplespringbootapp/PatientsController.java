package pl.keep.javac.simplespringbootapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
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

        model.addAttribute("patients",patientList);
        model.addAttribute("avgPrice",avgPrice);
        session.setAttribute(COUN,countr);
        return "index";
    }
}

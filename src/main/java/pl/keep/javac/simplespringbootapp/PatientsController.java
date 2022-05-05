package pl.keep.javac.simplespringbootapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class PatientsController {

    private final PatientRepository patientRepository;

    public PatientsController(PatientRepository patientRepository1){
        this.patientRepository = patientRepository1;
    }
    @GetMapping("/")
    String home (Model model){
        List<Patient> patientList = patientRepository.showAll();
        BigDecimal avgPrice = patientRepository.getAvgPrice();
        model.addAttribute("patients",patientList);
        model.addAttribute("avgPrice",avgPrice);
        return "index";
    }
}

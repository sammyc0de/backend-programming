package syksy26.handlinglists.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import syksy26.handlinglists.domain.Student;

@Controller
public class StudentController {

  
    public static final List<Student> oppilaat = new ArrayList<>();

    static {
        oppilaat.add(new Student("Kate", "Cole"));
        oppilaat.add(new Student("Dan", "Brown"));
        oppilaat.add(new Student("Mike", "Mars"));
    }
  
    @GetMapping("/hello")
    public String showStudents(Model model) {
        model.addAttribute("students", oppilaat);
        return "studentList";
    }

}

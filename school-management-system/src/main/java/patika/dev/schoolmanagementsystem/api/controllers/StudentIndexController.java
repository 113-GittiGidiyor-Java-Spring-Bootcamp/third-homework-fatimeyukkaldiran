package patika.dev.schoolmanagementsystem.api.controllers;

        import lombok.RequiredArgsConstructor;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.validation.BindingResult;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.bind.annotation.PutMapping;
        import patika.dev.schoolmanagementsystem.dataAccess.abstracts.StudentDao;

        import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class StudentIndexController {


    private final StudentDao studentDao;

    @GetMapping("/index")
    public String showStudentsList(Model theModel){
        theModel.addAttribute("students", studentDao.findAll());
        return "index";
    }

   /* @GetMapping("/signup")
    public String showSignupPage(User user){
        return "adduser";
    }

    @PostMapping("/adduser")
    public String addUser(@Valid User user, BindingResult result, Model theModel){
        if(result.hasErrors()){
            return "adduser";
        }

        repository.save(user);
        return "redirect:/index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdatePage(@PathVariable int id, Model theModel){
        User user = repository.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid user id: " + id));
        theModel.addAttribute("user",user);
        return "updateuser";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable int id, @Valid User user,  BindingResult result, Model theModel){
        if(result.hasErrors()){
            return "updateuser";
        }

        repository.save(user);
        return "redirect:/index";
    }
*/
}

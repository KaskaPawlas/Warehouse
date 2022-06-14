package pl.pawlas.warehouse.error;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Error {

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String error500(){
        return "error/error500";
    }
}

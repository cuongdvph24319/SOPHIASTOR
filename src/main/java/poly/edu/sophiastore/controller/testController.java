package poly.edu.sophiastore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class testController {

    @RequestMapping("/1")
    public String index(){
        return "nhanVien/nhanVien";
    }
    @RequestMapping("/2")
    public String w2(){
        return "nhanVien/test";
    }
    @RequestMapping("/3")
    public String w3(){
        return "nhanVien/test";
    }
}

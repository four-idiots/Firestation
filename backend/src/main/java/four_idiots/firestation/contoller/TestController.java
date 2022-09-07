package four_idiots.firestation.contoller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
public class TestController {

    @GetMapping("/example/1")
    public String SomeAction(@RequestParam("tEst")String test) {
        log.info("test = " + test);
        String res = "";
        if (test.equals("1")) {
            res = "one";
        } else if (test.equals("2")) {
            res = "two";
        } else {
            res = "nothing";
        }
        return res;
    }


    @PostMapping("/example/2")
    public String PostAction(HttpServletRequest request) {
        String dd = request.getParameter("demo");
        log.info("input =" + dd);
        String rs = "";
        if(dd.equals("3")) {
            rs = "three";
        } else if(dd.equals("4")) {
            rs = "four";
        } else {
            rs = "nope";
        }
        return rs;
    }
}


package login.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OptionsController {

    @CrossOrigin
    @RequestMapping(value = "/api/login", method = RequestMethod.OPTIONS)
    public void handleOptionsRequest() {
        // No need to implement any logic in this method
    }
}

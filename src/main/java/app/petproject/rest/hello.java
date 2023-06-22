package app.petproject.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v")
@Tag(name = "User", description = "The User API")
public class hello {

    @GetMapping(path = "/hello")
    public String hello(){
        return "Hello World";

    }
}

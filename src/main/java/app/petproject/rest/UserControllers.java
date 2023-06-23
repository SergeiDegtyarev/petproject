package app.petproject.rest;

import app.petproject.dto.UserDto;
import app.petproject.entity.User;
import app.petproject.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.providers.ObjectMapperProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/")
@Tag(name="User controllers", description="Контроллеры для операций с профилями пользователей")
@RequiredArgsConstructor
public class UserControllers {
    @Autowired
    private UserService userService;
    @Autowired
    private ObjectMapper objectMapper = new ObjectMapper();


    @Operation(
            summary = "Получение пользователя по ID"
    )
    @GetMapping(path = "/user/{id}")
    public ResponseEntity<UserDto> findUser(@PathVariable ("id") Long id){
        var dto = userService.findUserById(id);
        return ResponseEntity.
                status(HttpStatus.OK).
                body(dto);
    }

    @Operation(
            summary = "Регистрация пользователя"
    )
    @PostMapping(path = "/user")
    public ResponseEntity <String> creatUser (@RequestBody UserDto request) {
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setAge(request.getAge());
        user.setGender(request.getGender());
        userService.creatUser(user);
        return ResponseEntity.ok("User created successfully");

    }

}

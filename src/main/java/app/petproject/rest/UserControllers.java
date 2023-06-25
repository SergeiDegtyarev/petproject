package app.petproject.rest;

import app.petproject.dto.UserDto;
import app.petproject.dto.enums.ProfileStatus;
import app.petproject.entity.User;
import app.petproject.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
@Tag(name="User controllers", description="Контроллеры для операций с профилями пользователей")
@RequiredArgsConstructor
public class UserControllers {
    @Autowired
    private UserService userService;
    @Autowired
    private ObjectMapper objectMapper = new ObjectMapper();


    @Operation(summary = "Получение пользователя по ID")
    @GetMapping(path = "/user/{id}")
    public ResponseEntity<User> findUser(@PathVariable ("id") Long id){
        var dto = userService.findUserById(id);
        return ResponseEntity.
                status(HttpStatus.OK).
                body(dto);
    }

    @Operation(summary = "Регистрация пользователя")
    @PostMapping(path = "/user")
    public ResponseEntity <String> creatUser (@RequestBody UserDto request) {
        if (request != null) {
            User user = new User();
            user.setFirstName(request.getFirstName());
            user.setLastName(request.getLastName());
            user.setEmail(request.getEmail());
            user.setAge(request.getAge());
            user.setGender(request.getGender());
            user.setStatus(ProfileStatus.ACTIVE);
            userService.creatUser(user);
            return ResponseEntity.ok("User created successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR");
        }
    }

    @Operation(summary = "Частичное обновление полей профиля")
    @PatchMapping("/user/{id}")
    public ResponseEntity<User> updateProfile(@PathVariable("id") Long id, @RequestBody UserDto request) {
        User existingUser = userService.findUserById(id);

        if (existingUser == null) {
            return ResponseEntity.notFound().build();
        }

        if (request.getFirstName() != null) {
            existingUser.setFirstName(request.getFirstName());
        }

        if (request.getLastName() != null) {
            existingUser.setLastName(request.getLastName());
        }

        if (request.getEmail() != null) {
            existingUser.setEmail(request.getEmail());
        }

        if (request.getAge() != null) {
            existingUser.setAge(request.getAge());
        }
        if (request.getGender() != null) {
            existingUser.setGender(request.getGender());
        }

        User updatedUser = userService.updateUser(existingUser);

        return ResponseEntity.ok(updatedUser);
    }


    @Operation(summary = "Перевод профиля в статус DELETED")
    @PutMapping  ("/user/{id}")
    public ResponseEntity<String> userStatusDeleted(@PathVariable("id") Long id) {
        var existingUser = userService.findUserById(id);

        if (existingUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR");
        } else {
            existingUser.setStatus(ProfileStatus.DELETED);
            User updatedUser = userService.updateUser(existingUser);
        }
        return ResponseEntity.ok("Success");
    }
}

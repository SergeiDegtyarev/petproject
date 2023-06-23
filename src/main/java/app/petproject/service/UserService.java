package app.petproject.service;


import app.petproject.dto.UserDto;
import app.petproject.entity.User;
import app.petproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserRepository repository;

    public UserDto findUserById(Long id){
        var user = repository.findUserById(id);
        UserDto dto = new UserDto(user.getFirstName(), user.getLastName(), user.getAge(), user.getGender());
        return dto;
    }
    public User creatUser(User user){
        return repository.save(user);
    }


}

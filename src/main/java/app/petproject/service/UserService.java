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

    public User findUserById(Long id){
        return repository.findUserById(id);
    }
    public User creatUser(User user){
        return repository.save(user);
    }
    public User updateUser(User user){
        return repository.save(user);
    }




}

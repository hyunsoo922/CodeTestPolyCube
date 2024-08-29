package kr.co.polycube.backendtest;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Users createUsers()
    {
        Users user = Users.builder()
                .name("아무개")
                .build();
        userRepository.saveAndFlush(user);
        return user;
    }

    public Users findUsers(Long id)
    {
        Users user = userRepository.findById(id).orElse(null);
        return user;
    }

    @Transactional
    public Users modifyUsers(Long id, String name)
    {
        Users user = userRepository.findById(id).orElse(null);
        user.setName(name);
        return user;
    }
}

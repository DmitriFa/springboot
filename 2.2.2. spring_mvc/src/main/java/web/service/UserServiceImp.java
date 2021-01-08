package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.repository.UserRepository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImp implements UserService {
 //  @PersistenceContext
  // private EntityManager em;

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserServiceImp() {
    }

    public void addUser(User user)  {
        userRepository.save(user);
    }

    public void removeUser(User user)  {
        userRepository.delete(user);
    }

    public void updateUser(User user)  {
        userRepository.save(user);
    }


    public List<User> getAllUsers()  {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(long id)  {
        User user = null;
        Optional<User> optional = userRepository.findById(id);
        if(optional.isPresent()){
            user = optional.get();
        }
        return user;
    }


    public boolean checkLastName(String lastName)  {
        return userRepository.existsDistinctByLastName(lastName);
    }

}

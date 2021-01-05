package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.repository.RoleRepository;
import web.repository.UserRepository;
import web.model.Role;
import web.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private RoleRepository roleRepository;

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public UserServiceImp() {
    }

    public void addUser(User user) throws Exception {
        userRepository.save(user);
    }

    public void removeUser(User user) throws Exception {
        userRepository.delete(user);
    }

    public void updateUser(User user) throws Exception {
        userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() throws Exception {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User getUserById(long id) throws Exception {
        return userRepository.getOne(id);
    }

    @Override
    @Transactional
    public boolean checkLastName(String lastName) throws Exception {
        return userRepository.existsDistinctByLastName(lastName);
    }

    @Override
    @Transactional
    public List<Role> getRolesByUserId(long id) {
        return (List<Role>) userRepository.getOne(id).getRoles();
    }

}

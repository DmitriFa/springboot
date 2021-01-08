package web.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.repository.UserRepository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;

@Service
@Transactional
public class UserDetailsServiceImp implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {

        this.userRepository = userRepository;
    }


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String lastName) throws UsernameNotFoundException {
        User user = null;
        try {
            user = userRepository.findUserByUsername(lastName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}

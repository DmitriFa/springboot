package web.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import web.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUsername(String lastName);

    boolean existsDistinctByLastName(String lastname);

 /*   void addUser(User user) throws  Exception;

    void removeUser(User user) throws Exception;

    void updateUser(User user) throws  Exception;

    List<User> getAllUsers() throws Exception;

    User getUserById(long id) throws  Exception;

    User getUserByName(String lastName) throws Exception;

    boolean checkLastName(String lastName)throws Exception;*/

}


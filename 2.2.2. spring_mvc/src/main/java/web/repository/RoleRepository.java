package web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.model.Role;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role,Long> {

  /*  void addRole(Role role) throws  Exception;

    void removeRole(Role role) throws Exception;

    void updateRole(Role role) throws  Exception;

    List<Role> getAllRoles() throws Exception;

    Role getRoleById(Long id) throws  Exception;*/

}

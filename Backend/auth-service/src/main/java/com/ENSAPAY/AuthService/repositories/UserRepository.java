package com.ENSAPAY.AuthService.repositories;

import com.ENSAPAY.AuthService.entities.Role;
import com.ENSAPAY.AuthService.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(exported = false)
public interface UserRepository extends JpaRepository<User,Long> {

    public User findByUserName(String username);
    public boolean existsByRoleAndId(Role role, Long id);
    public boolean existsByRoleAndUserName(Role role, String username);
    public void deleteByUserName( String userName);

    @Query("select u from User u where u.role=:role")
    public List<User> findAllByRole(@Param ( "role" ) Role role );

}

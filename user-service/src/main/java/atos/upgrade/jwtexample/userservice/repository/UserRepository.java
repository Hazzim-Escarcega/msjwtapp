package atos.upgrade.jwtexample.userservice.repository;

import atos.upgrade.jwtexample.userservice.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {

}

package nst.assaf.assafbackend.repository;

import java.util.Optional;
import nst.assaf.assafbackend.model.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminUserRepository extends JpaRepository<AdminUser, Long> {
    Optional<AdminUser> findByUsername(String username);
}

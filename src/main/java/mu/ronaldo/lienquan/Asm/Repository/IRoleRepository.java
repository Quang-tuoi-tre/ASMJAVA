package mu.ronaldo.lienquan.Asm.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mu.ronaldo.lienquan.Asm.model.Role;
import java.util.Optional;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
    Role findRoleById(Long id);
    Optional<Role> findByName(String name);

}

package mu.ronaldo.lienquan.Asm.Repository;

import mu.ronaldo.lienquan.Asm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{
    User findByUsername(String username);
}

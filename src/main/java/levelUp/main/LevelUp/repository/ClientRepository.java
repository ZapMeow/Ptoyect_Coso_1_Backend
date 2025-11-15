package levelUp.main.LevelUp.repository;

import levelUp.main.LevelUp.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByUsernameClient(String usernameClient);

}

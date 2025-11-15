package levelUp.main.LevelUp.service;

import levelUp.main.LevelUp.model.Client;
import levelUp.main.LevelUp.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client registerClient(String username, String password, String email, int age, boolean isPremium){
        Client client = Client.builder()
                        .usernameClient(username)
                .passwordClient(password)
                .emailClient(email)
                .ageClient(age)
                .premiumClient(isPremium)
                .build();

        return clientRepository.save(client);
    }

    public Optional<Client> findByUsername(String username){
        return clientRepository.findByUsernameClient(username);
    }

}

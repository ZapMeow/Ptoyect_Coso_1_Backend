package levelUp.main.LevelUp.service;


import levelUp.main.LevelUp.model.Client;
import levelUp.main.LevelUp.repository.ClientRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomClientDetailsServer implements UserDetailsService {

    private final ClientRepository clientRepository;

    public CustomClientDetailsServer(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Client client = clientRepository.findByUsernameClient(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found:" + username));

        return org.springframework.security.core.userdetails.User
                .withUsername(client.getUsernameClient())
                .password(client.getPasswordClient())
                .authorities("USER")
                .build();
    }
}

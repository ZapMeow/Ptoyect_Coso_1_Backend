package levelUp.main.LevelUp.controller;

import levelUp.main.LevelUp.model.Client;
import levelUp.main.LevelUp.service.ClientService;
import levelUp.main.LevelUp.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final ClientService clientService;

    public AuthController(AuthenticationManager authenticationManager, JwtService jwtService, ClientService clientService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.clientService = clientService;
    }

    @PostMapping("/register")
    public Map<String, String> register(@RequestBody Map<String, String> body) {
        String username = body.get("usernameClient");
        String password = body.get("passwordClient");
        String email = body.get("emailClient");
        int birthdate = Integer.parseInt(body.get("ageClient"));
        boolean isPremium = Boolean.parseBoolean(body.get("isPremiumClient"));
        if (username == null || password == null || username.isBlank() ||
                password.isBlank()) {
            throw new IllegalArgumentException("Username y password son requeridos");
        }
        clientService.registerClient(username, password, email, birthdate, isPremium);
        return Map.of("message", "Usuario registrado correctamente");
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> body) {
        String username = body.get("usernameClient");
        String password = body.get("passwordClient");
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));
        if (auth.isAuthenticated()) {
            String token = jwtService.generateToken(username);
            return Map.of("token", token);
        }
        throw new RuntimeException("Credenciales inválidas");
    }

}

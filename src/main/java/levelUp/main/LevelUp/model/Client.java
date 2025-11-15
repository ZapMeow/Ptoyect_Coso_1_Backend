package levelUp.main.LevelUp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "clients")
public class Client {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(name = "id_client")
    private long idClient;

    @Column(name = "username_client", length = 15, unique = true,  nullable = false)
    private String usernameClient;

    @Column(name = "password_client", length = 10, nullable = false)
    private String passwordClient;

    @Column(name = "email_client", length = 100, unique = true, nullable = false)
    private String emailClient;

    @Column(name = "age_client", nullable = false)
    private int ageClient;

    @Column(name = "premium_client", nullable = false)
    private Boolean premiumClient;

}

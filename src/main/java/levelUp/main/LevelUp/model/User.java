package levelUp.main.LevelUp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long idClient;

    @Column(length = 20)
    private String userName;

    @Column(length = 10, unique = true)
    private String passwordUser;

    @Column(length = 100, unique = true)
    private String emailUser;

    @Column(length = 2)
    private int ageUser;

}

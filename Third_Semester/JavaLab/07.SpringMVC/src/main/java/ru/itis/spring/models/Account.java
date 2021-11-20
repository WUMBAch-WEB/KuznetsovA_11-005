package ru.itis.spring.models;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String nickname;
    private String email;
    private String password;
    private String info;
    private Integer age;
    private State state;
    private String avatarUUID;
    private String confirmCode;

    public enum State{
        CONFIRMED, NOT_CONFIRMED
    }


}

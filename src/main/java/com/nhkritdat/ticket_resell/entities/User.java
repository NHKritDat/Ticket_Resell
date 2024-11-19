package com.nhkritdat.ticket_resell.entities;

import com.nhkritdat.ticket_resell.enums.UserRole;
import com.nhkritdat.ticket_resell.enums.UserStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Length(message = "USERNAME_MAX_LENGTH", max = 50)
    @NotBlank(message = "USERNAME_NOT_BLANK")
    @Column(nullable = false, unique = true, updatable = false, length = 50)
    private String username;

    @NotNull(message = "PASSWORD_NOT_NULL")
    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true, updatable = false)
    @Email(message = "EMAIL_FORMAT")
    @NotBlank(message = "EMAIL_NOT_BLANK")
    private String email;

    @NotNull(message = "ROLE_NOT_NULL")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, updatable = false, length = 6)
    private UserRole role = UserRole.MEMBER;

    @NotNull(message = "USER_STATUS_NOT_NULL")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private UserStatus status = UserStatus.UNVERIFIED;

    private String avatar = "";

    @Column(nullable = false)
    private float rating = 0;

    @Range(message = "REPUTATION_MIN_MAX", min = 0, max = 100)
    @Column(nullable = false)
    private int reputation = 100;

}
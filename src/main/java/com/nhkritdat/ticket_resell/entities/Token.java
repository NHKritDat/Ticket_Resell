package com.nhkritdat.ticket_resell.entities;

import com.nhkritdat.ticket_resell.enums.TokenStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "tokens")
public class Token {
    @Id
    @NotNull(message = "ID_TOKEN_NOT_NULL")
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @NotNull(message = "EXP_DATE_NOT_NULL")
    @Column(nullable = false, updatable = false)
    private Date expDate;

    @NotNull(message = "STATUS_NOT_NULL")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 8)
    private TokenStatus status;

}
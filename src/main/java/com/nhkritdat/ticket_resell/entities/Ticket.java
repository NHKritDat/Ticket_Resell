package com.nhkritdat.ticket_resell.entities;

import com.nhkritdat.ticket_resell.enums.TicketStatus;
import com.nhkritdat.ticket_resell.enums.TicketType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, updatable = false)
    private UUID id;

    @NotNull(message = "USER_NOT_NULL")
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false, updatable = false)
    private User user;

    @Length(message = "TITLE_MAX", max = 50)
    @NotBlank(message = "TITLE_NOT_BLANK")
    @Column(nullable = false, length = 50)
    private String title;

    @NotBlank(message = "IMAGE_NOT_BLANK")
    @Column(nullable = false)
    private String image;

    @Length(message = "DESCRIPTION_MAX", max = 500)
    @NotBlank(message = "DESCRIPTION_NOT_BLANK")
    @Column(nullable = false, length = 500)
    private String description;

    @NotNull(message = "EXP_DATE_NOT_NULL")
    @Column(nullable = false)
    private Date expDate;

    @NotNull(message = "TYPE_NOT_NULL")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 15)
    private TicketType type;

    @Column(nullable = false)
    private float unitPrice;

    @PositiveOrZero(message = "QUANTITY_NOT_NEGATIVE")
    @Column(nullable = false)
    private int quantity;

    @NotNull(message = "TICKET_STATUS_NOT_NULL")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 8)
    private TicketStatus status;

}

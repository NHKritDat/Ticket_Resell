package com.nhkritdat.ticket_resell.entities;

import com.nhkritdat.ticket_resell.enums.MembershipStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "memberships")
public class Membership {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @NotNull(message = "USER_NOT_NULL")
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false, updatable = false)
    private User user;

    @NotNull(message = "SUBSCRIPTION_NOT_NULL")
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false, updatable = false)
    private Subscription subscription;

    @Length(message = "ORDER_CODE_MAX", max = 50)
    @NotBlank(message = "ORDER_CODE_NOT_BLANK")
    @Column(nullable = false, updatable = false, length = 50)
    private String orderCode;

    @Length(message = "DESCRIPTION_LENGTH_MAX", max = 50)
    @NotBlank(message = "DESCRIPTION_NOT_BLANK")
    @Column(nullable = false, updatable = false, length = 50)
    private String description;

    @NotNull(message = "START_DATE_NOT_NULL")
    @Column(nullable = false, updatable = false)
    private Date startDate;

    @Column(nullable = false, updatable = false)
    @NotNull(message = "END_DATE_NOT_NULL")
    private Date endDate;

    @NotNull(message = "MEMBERSHIP_STATUS_NOT_NULL")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 8)
    private MembershipStatus status;

}
package com.nhkritdat.ticket_resell.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "subscriptions")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Length(message = "SUBSCRIPTION_NAME_MAX", max = 50)
    @NotBlank(message = "SUBSCRIPTION_NAME_NOT_BLANK")
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @PositiveOrZero(message = "SALE_LIMIT_NOT_NEGATIVE")
    @Column(nullable = false)
    private int saleLimit;

    @NotBlank(message = "DESCRIPTION_NOT_BLANK")
    @Length(message = "SUBSCRIPTION_DESCRIPTION_MAX", max = 500)
    @Column(nullable = false, length = 500)
    private String description;

    @PositiveOrZero(message = "POINT_REQUIRED_NOT_NEGATIVE")
    @Column(nullable = false)
    private int pointRequired;

    @PositiveOrZero(message = "PRICE_NOT_NEGATIVE")
    @Column(nullable = false)
    private double price;

}
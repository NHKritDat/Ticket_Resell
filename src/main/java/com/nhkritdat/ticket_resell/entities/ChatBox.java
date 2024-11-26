package com.nhkritdat.ticket_resell.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "chat_boxes")
public class ChatBox {
    @NotNull(message = "ID_NOT_NULL")
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private String id;

    @NotNull(message = "BUYER_NOT_NULL")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(nullable = false, updatable = false)
    private User buyer;

    @NotNull(message = "SELLER_NOT_NULL")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(nullable = false, updatable = false)
    private User seller;

    @NotNull(message = "TICKET_NOT_NULL")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(nullable = false, updatable = false)
    private Ticket ticket;

}
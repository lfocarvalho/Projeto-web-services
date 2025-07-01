package com.project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.Instant;
import java.util.Objects;
import com.project.entities.enums.PaymentStatus;

@Entity
public class Payment {
    @Id
    private Long id;
    private Instant moment;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status; // Novo campo de status

    private String method; // Ex: "Cartão de Crédito", "Boleto", etc.
    private Double amount; // Valor pago

    @OneToOne
    @MapsId
    @JsonIgnore
    private Order order;

    public Payment() {}

    public Payment(Long id, Instant moment, PaymentStatus status, String method, Double amount, Order order) {
        this.id = id;
        this.moment = moment;
        this.status = status;
        this.method = method;
        this.amount = amount;
        this.order = order;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Instant getMoment() { return moment; }
    public void setMoment(Instant moment) { this.moment = moment; }

    public PaymentStatus getStatus() { return status; }
    public void setStatus(PaymentStatus status) { this.status = status; }

    public String getMethod() { return method; }
    public void setMethod(String method) { this.method = method; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public Order getOrder() { return order; }
    public void setOrder(Order order) { this.order = order; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(id, payment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

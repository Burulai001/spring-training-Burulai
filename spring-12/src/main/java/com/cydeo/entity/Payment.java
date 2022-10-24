package com.cydeo.entity;

import com.cydeo.enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Data
@Table(name = "payments")

public class Payment {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @Column(columnDefinition = "DATE")
   private LocalDate createDate;

   private BigDecimal amount;

   @Enumerated(EnumType.STRING)
   private Status status;

   @OneToOne
   @JoinColumn(name = "payment detail id")
   private PaymentDetail paymentDetail;

    public Payment(LocalDate createDate, BigDecimal amount, Status status) {
        this.createDate = createDate;
        this.amount = amount;
        this.status = status;
    }
}

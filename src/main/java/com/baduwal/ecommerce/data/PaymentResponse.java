package com.baduwal.ecommerce.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class PaymentResponse {
    private final  double amount;
    private final  int id;
    private final PaymentStatus status;
}

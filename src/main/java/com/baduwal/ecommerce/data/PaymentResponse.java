package com.baduwal.ecommerce.data;

import com.baduwal.ecommerce.data.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PaymentResponse {
    private final  double amount;
    private final  int id;
    private final PaymentStatus status;
}

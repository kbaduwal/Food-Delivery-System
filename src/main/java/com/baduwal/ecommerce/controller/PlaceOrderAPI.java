package com.baduwal.ecommerce.controller;

import com.baduwal.ecommerce.data.PaymentResponse;
import com.baduwal.ecommerce.data.PaymentStatus;
import com.baduwal.ecommerce.entity.User;
import com.baduwal.ecommerce.factory.PaymentManagerFactory;
import com.baduwal.ecommerce.managers.OrderManager;
import com.baduwal.ecommerce.managers.PaymentManager;
import com.baduwal.ecommerce.managers.UserManager;

import java.util.Map;

public class PlaceOrderAPI {

    private final UserManager userManager = new UserManager();
    private final OrderManager orderManager = new OrderManager();

    public Order placeOrder(String userToken, Map<String, String> paymentInfo, String paymentMode){
        if (userToken == null || userToken.length() == 0) {
            throw new IllegalArgumentException("Params missing");
        }

        User user = userManager.getUserByToken(userToken);
        if (user == null) {
            throw new IllegalArgumentException("userToken invalid");
        }

        PaymentManager paymentManager = PaymentManagerFactory.getPaymentManager(paymentMode,paymentInfo);
        PaymentResponse paymentResponse = paymentManager.executePayment();
        if (paymentResponse == null || paymentResponse.getStatus()==null ||paymentResponse.getStatus().equals(PaymentStatus.FAILED)) {
            throw new RuntimeException("Payment failed");
        }

        return orderManager.placeOrder(user);

    }
}

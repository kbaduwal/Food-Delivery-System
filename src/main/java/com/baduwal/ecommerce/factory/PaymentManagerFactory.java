package com.baduwal.ecommerce.factory;

import com.baduwal.ecommerce.managers.CardBasedPaymentManager;
import com.baduwal.ecommerce.managers.NetBankingPaymentManager;
import com.baduwal.ecommerce.managers.PaymentManager;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

import java.util.Map;

public class PaymentManagerFactory {
    private PaymentManagerFactory() {}

    public static PaymentManager getPaymentManager(String paymentMode, Map<String, String> paymentInfo ) {

        PaymentManager paymentManager = null;
        if (paymentMode.equals("NetBanking")) { //Make it enums
            paymentManager = getNetBankingPaymentManager(paymentInfo);
        }else if(paymentMode.equals("CardBasedPaymentManager")) {
            paymentManager = getCardBasedPaymentManager(paymentInfo);
        }else {
            throw new RuntimeException("Invalid paymentMode");
        }

        return paymentManager;
    }

    private static PaymentManager getNetBankingPaymentManager(Map<String, String> paymentInfo ) {
        return new NetBankingPaymentManager(paymentInfo.get("bankName"),paymentInfo.get("userName"),
                paymentInfo.get("passWord"),paymentInfo.get("pin"),
                Double.parseDouble(paymentInfo.get("amount")));
    }

    private static PaymentManager getCardBasedPaymentManager(Map<String, String> paymentInfo ) {
        return new CardBasedPaymentManager(paymentInfo.get("bankName"),paymentInfo.get("cardNumber")
                ,paymentInfo.get("pin"),Double.parseDouble(paymentInfo.get("amount")));
    }

}

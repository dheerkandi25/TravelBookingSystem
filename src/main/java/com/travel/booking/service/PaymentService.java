//package com.travel.booking.service;
//
//import com.travel.booking.dto.Payment;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class PaymentService {
//    List<Payment> paymentList = new ArrayList<>();
//    public void addPayment(Payment payment) {
//        paymentList.add(payment);
//    }
//    public List<Payment> getAllPayments() {
//        return paymentList;
//    }
//    public Payment getPaymentById(String id) {
//        for (Payment payment : paymentList) {
//            if (payment.getId().equals(id)) {
//                return payment;
//            }
//        }
//        return null;
//    }
//    public void updatePayment(String id, Payment updatedPayment) {
//        for (int i = 0; i < paymentList.size(); i++) {
//            if (paymentList.get(i).getId().equals(id)) {
//                paymentList.set(i, updatedPayment);
//                return;
//            }
//        }
//    }
//    public void deletePayment(String id) {
//        paymentList.removeIf(payment -> payment.getId().equals(id));
//    }
//    public List<Payment> getPaymentsByUserId(String userId) {
//        List<Payment> userPayments = new ArrayList<>();
//        for (Payment payment : paymentList) {
//            if (payment.getUserId().equals(userId)) {
//                userPayments.add(payment);
//            }
//        }
//        return userPayments;
//    }
//    public List<Payment> getPaymentsByBookingId(String bookingId) {
//        List<Payment> bookingPayments = new ArrayList<>();
//        for (Payment payment : paymentList) {
//            if (payment.getBookingId().equals(bookingId)) {
//                bookingPayments.add(payment);
//            }
//        }
//        return bookingPayments;
//    }
//
//    public void processPayment(String userId, String flightId) {
//        // Simulate payment processing logic
//        Payment payment = new Payment();
//        payment.setUserId(userId);
//        payment.setFlightId(flightId);
//        payment.setAmount(100.0); // Example amount
//        payment.setStatus("Processed");
//        addPayment(payment);
//
//        // Log the payment processing
//        System.out.println("Payment processed for user: " + userId + " for flight: " + flightId);
//    }
//}

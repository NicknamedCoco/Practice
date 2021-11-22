package world.keyi.service;
import world.keyi.entities.Payment;

public interface PaymentService {
    public int insert(Payment payment);
    public Payment queryById(Long id);
}

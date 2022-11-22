package exercise.interfaces;

import exercise.TransactionStatus;

public interface Transaction {
    int getId();
    TransactionStatus getStatus();
    String getFrom();
    String getTo();
    double getAmount();

    void setId(int id);
    void setStatus(TransactionStatus status);
    void setFrom(String from);
    void setTo(String to);
    void setAmount(double amount);
}

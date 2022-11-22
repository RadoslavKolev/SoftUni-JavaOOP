package exercise;

import exercise.interfaces.Chainblock;
import exercise.interfaces.Transaction;

import java.util.*;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock {
    private final Map<Integer, Transaction> transactionMap;

    public ChainblockImpl() {
        this.transactionMap = new LinkedHashMap<>();
    }

    public int getCount() {
        return this.transactionMap.size();
    }

    public void add(Transaction transaction) {
        this.transactionMap.putIfAbsent(transaction.getId(), transaction);
    }

    public boolean contains(Transaction transaction) {
        return this.transactionMap.containsKey(transaction.getId());
    }

    public boolean contains(int id) {
        return this.transactionMap.containsKey(id);
    }

    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        checkIfTransactionExists(id);
        this.transactionMap.get(id).setStatus(newStatus);
    }

    public void removeTransactionById(int id) {
        checkIfTransactionExists(id);
        this.transactionMap.remove(id);
    }

    public Transaction getById(int id) {
        checkIfTransactionExists(id);
        return this.transactionMap.get(id);
    }

    private void checkIfTransactionExists(int id) {
        if (!this.transactionMap.containsKey(id)) {
            throw new IllegalArgumentException("No such transaction in the blockchain");
        }
    }

    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        List<Transaction> filteredTransactions = getFilteredTransactions(status);

        checkIfTransactionWithGivenStatusExists(filteredTransactions);

        return filteredTransactions.stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());
    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        List<Transaction> filteredTransactions = getFilteredTransactions(status);

        checkIfTransactionWithGivenStatusExists(filteredTransactions);

        return filteredTransactions.stream()
                .sorted(Comparator.comparing(Transaction::getAmount))
                .map(Transaction::getFrom)
                .collect(Collectors.toList());
    }

    private List<Transaction> getFilteredTransactions(TransactionStatus status) {
        return this.transactionMap.values().stream()
                .filter(s -> s.getStatus().equals(status)).toList();
    }

    private static void checkIfTransactionWithGivenStatusExists(List<Transaction> filteredTransactions) {
        if (filteredTransactions.isEmpty()) {
            throw new IllegalArgumentException("There aren't any transaction with that status");
        }
    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        List<Transaction> filteredTransactions = getFilteredTransactions(status);

        checkIfTransactionWithGivenStatusExists(filteredTransactions);

        return filteredTransactions.stream()
                .sorted(Comparator.comparing(Transaction::getAmount))
                .map(Transaction::getTo)
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        return null;
    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        return null;
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        return null;
    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        return null;
    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        return null;
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        return null;
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        return null;
    }

    public Iterator<Transaction> iterator() {
        return null;
    }
}

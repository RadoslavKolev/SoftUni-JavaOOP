package exercise;

import exercise.interfaces.Chainblock;
import exercise.interfaces.Transaction;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static exercise.TransactionStatus.*;
import static org.junit.Assert.*;

public class ChainblockImplTest {
    private Chainblock blockchain;

    @Before
    public void setUp() {
        this.blockchain = new ChainblockImpl();
        addTransactions(5);
    }

    private void addTransactions(int count) {
        for (int i = 1; i <= count; i++) {
            this.blockchain.add(
                new TransactionImpl(
                        i,
                        SUCCESSFUL,
                        "Sender " + i,
                        "Receiver " + i,
                        100.00 + i
                )
            );
        }
    }

    // 1.1. Test if add() adds transaction successfully to the blockchain
    @Test
    public void test_Add_ShouldAddTransaction_ToTheBlockchain() {
        int initialTransactions = this.blockchain.getCount();

        Transaction transaction = new TransactionImpl(
                6, SUCCESSFUL, "Sender 6", "Receiver 6", 300.50
        );

        this.blockchain.add(transaction);

        assertEquals(initialTransactions + 1, this.blockchain.getCount());
        assertTrue(this.blockchain.contains(transaction));
    }

    // 1.2. Test if add() doesn't add transaction with existing ID
    @Test
    public void test_Add_ShouldNotAddTransaction_WithExistingId() {
        int initialTransactions = this.blockchain.getCount();

        Transaction transaction = new TransactionImpl(
                1, SUCCESSFUL, "Sender 6", "Receiver 6", 300.50
        );

        this.blockchain.add(transaction);

        assertEquals(initialTransactions, this.blockchain.getCount());
    }

    // 2.1. Test if contains(Transaction) returns true if it finds the transaction
    @Test
    public void test_Contains_ShouldReturnTrue_WhenPassingExistingTransaction() {
        Transaction expected = new TransactionImpl(3, SUCCESSFUL, "Sender 3", "Receiver 3", 103.00);
        boolean isThere = this.blockchain.contains(expected);
        assertTrue(isThere);
    }

    // 2.2. Test if contains(Transaction) returns false if it doesn't find the transaction
    @Test
    public void test_Contains_ShouldReturnFalse_WhenPassingNonExistingTransaction() {
        Transaction expected = new TransactionImpl(6, SUCCESSFUL, "Sender 6", "Receiver 6", 300.50);
        boolean isThere = this.blockchain.contains(expected);
        assertFalse(isThere);
    }

    // 3.1. Test if contains(id) returns true if it finds the transaction with the given id
    @Test
    public void test_Contains_ShouldReturnTrue_WhenPassingExistingId() {
        int expectedId = 3;
        boolean isThere = this.blockchain.contains(expectedId);
        assertTrue(isThere);
    }

    // 3.2. Test if contains(id) returns false if it doesn't find the transaction with the given id
    @Test
    public void test_Contains_ShouldReturnFalse_WhenPassingNonExistingId() {
        int expectedId = 10;
        boolean isThere = this.blockchain.contains(expectedId);
        assertFalse(isThere);
    }

    // 4.1 Test if getById() returns the correct transaction if it exists
    @Test
    public void test_GetById_ShouldReturn_TheCorrectTransaction() {
        int transactionId = 2;
        Transaction transaction = this.blockchain.getById(transactionId);
        assertEquals(transactionId, transaction.getId());
    }

    // 4.2.Test if getById() will throw an exception if transaction doesn't exist
    @Test(expected = IllegalArgumentException.class)
    public void test_GetById_ThrowsException_WhenNoSuchTransactionExists() {
        this.blockchain.getById(10);
    }

    // 5.1. Test if changeTransactionStatus() changes the status of the transaction with the given id
    @Test
    public void test_ChangeTransactionStatus_ChangesTheStatus_OfTheTransaction_WithTheGivenId() {
        int transactionId = 2;

        this.blockchain.changeTransactionStatus(transactionId, ABORTED);
        Transaction transaction = this.blockchain.getById(transactionId);

        assertEquals(ABORTED, transaction.getStatus());
    }

    // 5.2. Test if changeTransactionStatus() throws exception when no such transaction exists
    @Test(expected = IllegalArgumentException.class)
    public void test_ChangeTransactionStatus_ThrowsException_WhenNoSuchTransactionExists() {
        this.blockchain.changeTransactionStatus(10, ABORTED);
    }

    // 6.1. Test if removeTransactionById() removes the correct transaction
    @Test
    public void test_RemoveTransactionById_RemovesTheCorrectTransaction() {
        int initialTransactions = this.blockchain.getCount();
        int transactionId = 2;

        this.blockchain.removeTransactionById(transactionId);

        assertEquals( initialTransactions - 1, this.blockchain.getCount());
        assertFalse(this.blockchain.contains(transactionId));
    }

    // 6.2. Test if removeTransactionById() throws an exception when no such transaction exists
    @Test(expected = IllegalArgumentException.class)
    public void test_RemoveTransactionById_ThrowsException_WhenNoSuchIdExists() {
        this.blockchain.removeTransactionById(10);
    }

    // 7.1. Test if getByTransactionStatus() will return the correct transactions
    @Test
    public void test_GetByTransactionStatus_ShouldReturnTheCorrectTransactions() {
        addAdditionalTransactions();

        Iterable<Transaction> iterable = this.blockchain.getByTransactionStatus(FAILED);
        List<Transaction> transactions = convertIterableTransactionsToList(iterable);

        assertEquals(2, transactions.size());

        for (Transaction transaction : transactions) {
            assertEquals(FAILED, transaction.getStatus());
        }
    }

    // 7.2. Test if getByTransactionStatus() will throw an exception if no such transaction with the given status is found
    @Test(expected = IllegalArgumentException.class)
    public void test_GetByTransactionStatus_ThrowsException_WhenNoSuchTransaction_WithTheGivenStatus_IsFound() {
        addAdditionalTransactions();
        this.blockchain.getByTransactionStatus(UNAUTHORIZED);
    }

    // 8.1. Test if getAllSendersWithTransactionStatus() will return the correct senders
    @Test
    public void test_GetAllSendersWithTransactionStatus_ReturnsTheCorrectSenders() {
        addAdditionalTransactions();

        Iterable<String> iterable = this.blockchain.getAllSendersWithTransactionStatus(FAILED);
        List<String> senders = convertIterableStringsToList(iterable);

        assertEquals(2, senders.size());
    }

    private void addAdditionalTransactions() {
        this.blockchain.add(new TransactionImpl(6, ABORTED, "Sender 6", "Receiver 6", 25.00));
        this.blockchain.add(new TransactionImpl(7, FAILED, "Sender 7", "Receiver 7", 27.00));
        this.blockchain.add(new TransactionImpl(8, FAILED, "Sender 8", "Receiver 8", 29.00));
    }

    private List<Transaction> convertIterableTransactionsToList(Iterable<Transaction> iterable) {
        assertNotNull(iterable);
        List<Transaction> list = new ArrayList<>();
        iterable.forEach(list::add);
        return list;
    }

    private List<String> convertIterableStringsToList(Iterable<String> iterable) {
        assertNotNull(iterable);
        List<String> list = new ArrayList<>();
        iterable.forEach(list::add);
        return list;
    }


}
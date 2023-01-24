package com.malcev.TransactionApplication.controllers;

import com.malcev.TransactionApplication.models.Transaction;
import com.malcev.TransactionApplication.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/transactions")
public class TransactionsController {
    private final TransactionService transactionService;

    @Autowired
    public TransactionsController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/{userId}/average")
    public String showPageWithAverageAmountAndSortedCustomersTransactionsPerThatDays(@PathVariable String userId, Model model) {
        //вернет отсортированный список средних значений по полю amount для транзакций текущего пользователя,
        //сгруппировав данные по дню, а в рамках дня по MCC коду со следующими условиями:
        //MCC коды, встречаются в выборке более чем 60000 раз;
        return null;
    }

    @PostMapping("/{userId}/new-custom")
    public String addNewTransactionForCustomerTransactions(@PathVariable Long userId, Model model) {
        //страница с формой для создания новой транзакции с заполнением данных руками
        return null;
    }

    @PostMapping("/{userId}/new-csv")
    public String addCsvFileWithTransactionForCustomer(@PathVariable Long userId, Model model) {
        //страница с формой для создания новой транзакции с заполнением данных руками
        return null;
    }

    @DeleteMapping("/{userId}/delete")
    public String deleteTransaction(@PathVariable String userId) {
        //страница с формой для удаления новой транзакции с заполнением данных руками
        return null;
    }
}

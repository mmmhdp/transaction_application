package com.malcev.TransactionApplication.controllers;

import com.malcev.TransactionApplication.models.Transaction;
import com.malcev.TransactionApplication.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("session/{customerId}/transactions")
public class TransactionsController {
    private final TransactionService transactionService;

    @Autowired
    public TransactionsController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/average")
    public String showPageWithAverageAmountAndSortedCustomersTransactionsPerThatDays(Model model, @PathVariable String customerId) {
        //вернет отсортированный список средних значений по полю amount для транзакций текущего пользователя,
        //сгруппировав данные по дню, а в рамках дня по MCC коду со следующими условиями:
        //MCC коды, встречаются в выборке более чем 60000 раз;
        return null;
    }

    @GetMapping("/all")
    public String showAllCustomerTransactions(Model model, @PathVariable String customerId){
        model.addAttribute("transactionsList",
                transactionService.getAllTransactionsForCustomerByCustomerId(customerId));
        return "transactions/all";
    }
    @PostMapping("/new")
    public String addNewTransactionForCustomerTransactions(Model model, @PathVariable String customerId) {
        //страница с формой для создания новой транзакции с заполнением данных руками
        return null;
    }
    @PostMapping("/new-csv")
    public String addCsvFileWithTransactionForCustomer(Model model, @PathVariable String customerId) {
        //страница с формой для создания новой транзакции с заполнением данных руками
        return null;
    }

    @DeleteMapping("/delete")
    public String deleteTransaction(@PathVariable String customerId) {
        //страница с формой для удаления новой транзакции с заполнением данных руками
        return null;
    }
}

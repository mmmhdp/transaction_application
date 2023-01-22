package com.malcev.TransactionApplication.transaction;

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

    @GetMapping("/{id}")
    public String showPageWithAllCustomersTransactions(@PathVariable Long id, Model model){
        //вернет список транзакций пользователя за всё время
        return null;
    }
    @GetMapping("/{id}/average")
    public String showPageWithAverageAmountAndSortedCustomersTransactionsPerThatDays(@PathVariable String id, Model model){
        //вернет отсортированный список средних значений по полю amount для транзакций текущего пользователя,
        //сгруппировав данные по дню, а в рамках дня по MCC коду со следующими условиями:
        //MCC коды, встречаются в выборке более чем 60000 раз;
        return null;
    }
    @PostMapping("/{id}/new-custom")
    public String addNewTransactionForCustomerTransactions(@PathVariable Long id, Model model){
        //страница с формой для создания новой транзакции с заполнением данных руками
        return null;
    }

    @PostMapping("/{id}/new-csv")
    public String addCsvFileWithTransactionForCustomer(@PathVariable Long id, Model model){
        //страница с формой для создания новой транзакции с заполнением данных руками
        return null;
    }

    @DeleteMapping("/{id}/delete")
    public String deleteTransaction(@PathVariable String id){
        //страница с формой для удаления новой транзакции с заполнением данных руками
        return null;
    }

}

package com.malcev.TransactionApplication.controllers;

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
        model.addAttribute("list", transactionService.getAvgResultsWithSpecificParameters());
        return "transactions/average";
    }

    @GetMapping("/all")
    public String showAllCustomerTransactions(Model model, @PathVariable String customerId){
        model.addAttribute("transactionsList",
                transactionService.getAllTransactionsForCustomerByCustomerId(customerId));
        return "transactions/all";
    }
}

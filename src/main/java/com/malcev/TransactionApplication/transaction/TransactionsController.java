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
    public String startedPage(@PathVariable Long id, Model model){
        //вернем список транзакций пользователя
        return null;
    }
}

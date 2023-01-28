package com.malcev.TransactionApplication.controllers;

import com.malcev.TransactionApplication.models.CsvGenerators.CsvFileGenerator;
import com.malcev.TransactionApplication.service.TransactionService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("session/{customerId}/transactions")
public class TransactionsController {
    private final TransactionService transactionService;
    private final CsvFileGenerator csvFileGenerator;

    @Autowired
    public TransactionsController(TransactionService transactionService, CsvFileGenerator csvFileGenerator) {
        this.transactionService = transactionService;
        this.csvFileGenerator = csvFileGenerator;
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
    @GetMapping("/export-to-csv")
    public void exportIntoCSV(HttpServletResponse response, @PathVariable String customerId) throws IOException {
        response.setContentType("text/csv");
        response.addHeader("Content-Disposition", "attachment; filename=\"myTransactions.csv\"");
        csvFileGenerator.writeTransactionsToCsv(
                transactionService.getAllTransactionsForCustomerByCustomerId(customerId),
                response.getWriter()
        );
    }
}

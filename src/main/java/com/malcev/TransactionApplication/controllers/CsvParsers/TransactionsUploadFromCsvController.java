package com.malcev.TransactionApplication.controllers.CsvParsers;

import com.malcev.TransactionApplication.models.Transaction;
import com.malcev.TransactionApplication.service.TransactionService;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@Controller
@RequestMapping("session/{customerId}/transactions/new-csv")
public class TransactionsUploadFromCsvController {
    private final TransactionService transactionService;

    public TransactionsUploadFromCsvController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public String showPageWithCsvFileWithTransactionForCustomer(@PathVariable String customerId, Model model){
        model.addAttribute("customerId", customerId);
        return "transactions/parse-transactions-from-csv";
    }
    @PostMapping
    public String addCsvFileWithTransactionForCustomer(@RequestParam ("file") MultipartFile file, Model model, @PathVariable String customerId) {

        if (file.isEmpty()){

        }else{

            try(Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))){
                CsvToBean<Transaction> csvToBean = new CsvToBeanBuilder(reader)
                        .withType(Transaction.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();
                List<Transaction> transactionsList = csvToBean.parse();
                for (Transaction trToSave: transactionsList){
                    transactionService.saveTransactionToCustomersTransactionsList(trToSave, customerId);
                }

            } catch (IOException ex) {
                model.addAttribute("message","Произошла ошибка во время считывания файла");
            }
        }

        return "redirect:/session/{customerId}";
    }
}

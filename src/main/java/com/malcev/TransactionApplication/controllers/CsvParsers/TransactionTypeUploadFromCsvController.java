package com.malcev.TransactionApplication.controllers.CsvParsers;

import com.malcev.TransactionApplication.models.TransactionType;
import com.malcev.TransactionApplication.service.TransactionTypeService;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
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
@RequestMapping("session/{customerId}/transaction-type/new-csv")
public class TransactionTypeUploadFromCsvController {

    private final TransactionTypeService transactionTypeService;

    public TransactionTypeUploadFromCsvController(TransactionTypeService transactionTypeService) {
        this.transactionTypeService = transactionTypeService;
    }

    @GetMapping
    public String showPageWithCsvFileWithTransactionTypesForCustomer(@PathVariable String customerId, Model model){
        model.addAttribute("customerId", customerId);
        return "transaction-types/parse-transaction-types-from-csv";
    }
    @PostMapping
    public String addCsvFileWithTransactionTypesForCustomer(@RequestParam("file") MultipartFile file, Model model, @PathVariable String customerId) {

        if (file.isEmpty()){

        }else{

            try(Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))){
                CsvToBean<TransactionType> csvToBean = new CsvToBeanBuilder(reader)
                        .withType(TransactionType.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();
                List<TransactionType> transactionTypeList = csvToBean.parse();
                for (TransactionType transactionType: transactionTypeList){
                    transactionTypeService.saveTransactionType(transactionType);
                }

            } catch (IOException ex) {
                model.addAttribute("message","Произошла ошибка во время считывания файла");
            }
        }

        return "redirect:/session/{customerId}";
    }
}

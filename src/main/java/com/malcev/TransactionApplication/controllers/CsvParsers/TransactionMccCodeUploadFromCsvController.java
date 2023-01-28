package com.malcev.TransactionApplication.controllers.CsvParsers;

import com.malcev.TransactionApplication.models.TransactionMccCode;
import com.malcev.TransactionApplication.service.TransactionMccCodeService;
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
@RequestMapping("session/{customerId}/mcc-code/new-csv")
public class TransactionMccCodeUploadFromCsvController {
    private final TransactionMccCodeService transactionMccCodeService;

    public TransactionMccCodeUploadFromCsvController(TransactionMccCodeService transactionMccCodeService) {
        this.transactionMccCodeService = transactionMccCodeService;
    }

    @GetMapping
    public String showPageWithCsvFileWithMccCodesForCustomer(@PathVariable String customerId, Model model){
        model.addAttribute("customerId", customerId);
        return "mcc-codes/parse-mcc-codes-from-csv";
    }
    @PostMapping
    public String addCsvFileWithMccCodesForCustomer(@RequestParam("file") MultipartFile file, Model model, @PathVariable String customerId) {

        if (file.isEmpty()){

        }else{

            try(Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))){
                CsvToBean<TransactionMccCode> csvToBean = new CsvToBeanBuilder(reader)
                        .withType(TransactionMccCode.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();
                List<TransactionMccCode> transactionMccCodesList = csvToBean.parse();
                for (TransactionMccCode mccCode: transactionMccCodesList){
                    transactionMccCodeService.saveMccCode(mccCode);
                }

            } catch (IOException ex) {
                model.addAttribute("message","Произошла ошибка во время считывания файла");
            }
        }

        return "redirect:/session/{customerId}";
    }
}

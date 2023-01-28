package com.malcev.TransactionApplication.controllers.CsvParsers;

import com.malcev.TransactionApplication.models.GenderTrain;
import com.malcev.TransactionApplication.service.GenderTrainService;
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
@RequestMapping("session/{customerId}/genders/new-csv")
public class GenderTrainUploadFromCsvController {
    private final GenderTrainService genderTrainService;

    public GenderTrainUploadFromCsvController(GenderTrainService genderTrainService) {
        this.genderTrainService = genderTrainService;
    }
    @GetMapping
    public String showPageWithCsvFileWithGendersForCustomer(@PathVariable String customerId, Model model){
        model.addAttribute("customerId", customerId);
        return "genders/parse-genders-from-csv";
    }
    @PostMapping
    public String addCsvFileWithGendersForCustomer(@RequestParam("file") MultipartFile file, Model model, @PathVariable String customerId) {

        if (file.isEmpty()){

        }else{

            try(Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))){
                CsvToBean<GenderTrain> csvToBean = new CsvToBeanBuilder(reader)
                        .withType(GenderTrain.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();
                List<GenderTrain> genderTrainList = csvToBean.parse();
                for (GenderTrain genderTrain: genderTrainList){
                    genderTrainService.saveGenderTrain(genderTrain);
                }

            } catch (IOException ex) {
                model.addAttribute("message","Произошла ошибка во время считывания файла");
            }
        }

        return "redirect:/session/{customerId}";
    }
}

package com.malcev.TransactionApplication.models.CsvGenerators;

import com.malcev.TransactionApplication.models.Transaction;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Component;
@Component
public class CsvFileGenerator {
    public void writeTransactionsToCsv(List<Transaction> transactionList, Writer writer) {
        try {

            CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT);
            for (Transaction transaction : transactionList) {
                printer.printRecord(
                        transaction.getTrCustomerId(),
                        transaction.getTrDatetime(),
                        transaction.getTrMssCodeType(),
                        transaction.getTrType(),
                        transaction.getTrAmount(),
                        transaction.getTrTerminalId()
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

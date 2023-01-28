package com.malcev.TransactionApplication.repository.DTO;

import com.malcev.TransactionApplication.models.DTO.TransactionAvgDayResultsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TransactionAvgDayResultsDtoRepository extends JpaRepository<TransactionAvgDayResultsDto, Long> {
    @Query(value =
            "select avg(transaction.public.transaction.tr_amount) as avg_amount,\n" +
                    "       tr_mss_code_type as mss_code,\n" +
                    "       count(tr_mss_code_type) as mss_code_counter,\n" +
                    "       substr(tr_datetime, 1,2) as day,\n" +
                    "       tr_customer_id as id\n" +
                    "from transaction.public.transaction\n" +
                    "group by substr(tr_datetime, 1,2), transaction.tr_mss_code_type, tr_customer_id\n" +
                    "having count(transaction.public.transaction.tr_mss_code_type)>1 and tr_customer_id = ?1\n" +
                    "order by substr(tr_datetime, 1,2), transaction.tr_mss_code_type",
            nativeQuery = true)
    public List<TransactionAvgDayResultsDto> findAllForCustomerByCustomerId(Long customerId);
}

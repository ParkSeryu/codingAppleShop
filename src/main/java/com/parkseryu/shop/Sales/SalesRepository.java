package com.parkseryu.shop.Sales;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {

    @Query(value = "SELECT s FROM Sales s JOIN FETCH s.member")
    List<Sales> customFindAll();


}

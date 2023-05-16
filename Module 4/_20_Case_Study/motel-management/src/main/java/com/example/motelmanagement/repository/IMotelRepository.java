package com.example.motelmanagement.repository;

import com.example.motelmanagement.entity.Motel;
import com.example.motelmanagement.entity.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IMotelRepository extends JpaRepository<Motel, String> {
    @Query("select m from Motel m where m.isDeleted = false")
    Iterable<Motel> findAvailableMotels();

    @Query("select m from Motel m where m.isDeleted = false and lower(m.customerName) like lower(concat('%', :keyword, '%')) ")
    Iterable<Motel> searchByCustomerNameContainingIgnoreCase(String keyword);

    @Query("select m from Motel m where m.isDeleted = false and m.payment = :payment")
    Iterable<Motel> searchAvailableMotelsByPaymentMethod(Payment payment);

    @Query("select m from Motel m where m.isDeleted = false and m.id in :ids")
    Iterable<Motel> findAvailableMotelsByIdIn(String[] ids);
}

package com.example.jumia.Repository;

import com.example.jumia.Entity.customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<customer,Integer> {

    customer findById(int id);
}

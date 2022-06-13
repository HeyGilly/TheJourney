package com.journey.journeybookshelf.repo;

import com.journey.journeybookshelf.models.AllBookTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AllBookTableRepo extends JpaRepository<AllBookTable, Long> {

    List<AllBookTable> findAll();


//    @Query("SELECT p FROM AllBookTable p WHERE CONCAT(p.author, ' ', p.isbn, ' ', p.title, ' ', p.genre) LIKE %?1%")
//    public List<AllBookTable> search(String keyword);


}
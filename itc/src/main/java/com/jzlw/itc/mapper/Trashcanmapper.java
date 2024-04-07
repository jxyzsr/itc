package com.jzlw.itc.mapper;

import com.jzlw.itc.domain.Trashcan;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface Trashcanmapper {
    List<Trashcan> selecttrashcan();
}

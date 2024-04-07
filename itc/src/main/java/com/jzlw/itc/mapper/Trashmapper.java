package com.jzlw.itc.mapper;

import com.jzlw.itc.domain.Trash;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Trashmapper {
    List<Trash> selecttrash();
}

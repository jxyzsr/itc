package com.jzlw.itc.service.impl;

import com.jzlw.itc.domain.Trash;
import com.jzlw.itc.mapper.Trashmapper;
import com.jzlw.itc.service.ITrashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrashServiceimpl implements ITrashService {
    @Autowired
    private Trashmapper mapper;

    @Override
    public List<Trash> selecttrash() {
        return mapper.selecttrash();
    }
}

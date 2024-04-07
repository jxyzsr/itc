package com.jzlw.itc.service.impl;

import com.jzlw.itc.domain.Trashcan;
import com.jzlw.itc.mapper.Trashcanmapper;
import com.jzlw.itc.service.ITrashcanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrashcanServiceimpl implements ITrashcanService {
    @Autowired
    private Trashcanmapper mapper;

    @Override
    public List<Trashcan> selecttrashcan() {
        return mapper.selecttrashcan();
    }
}

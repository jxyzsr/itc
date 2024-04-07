package com.jzlw.itc.service.impl;

import com.jzlw.itc.mapper.Collectionvmapper;
import com.jzlw.itc.service.ICollectionvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectionvServiceimpl implements ICollectionvService {
    @Autowired
    private Collectionvmapper mapper;
    @Override
    public void insertacollectionv(Integer userid, Integer videoid) {
        mapper.insertacollectionv(userid,videoid);
    }

    @Override
    public void deleteacollectionv(Integer userid, Integer videoid) {
        mapper.deleteacollectionv(userid,videoid);
    }

    @Override
    public void decollvforv(Integer videoid) {
        mapper.decollvforv(videoid);
    }
}

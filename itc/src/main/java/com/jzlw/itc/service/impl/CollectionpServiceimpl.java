package com.jzlw.itc.service.impl;

import com.jzlw.itc.mapper.Collectionpmapper;
import com.jzlw.itc.service.ICollectionpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectionpServiceimpl implements ICollectionpService {
    @Autowired
    private Collectionpmapper mapper;
    @Override
    public void insertacollectionp(Integer userid, Integer postsid) {
        mapper.insertacollectionp(userid,postsid);
    }

    @Override
    public void deleteacollectionp(Integer userid, Integer postsid) {
        mapper.deleteacollectionp(userid,postsid);
    }

    @Override
    public void decollpforp(Integer postsid) {
        mapper.decollpforp(postsid);
    }
}

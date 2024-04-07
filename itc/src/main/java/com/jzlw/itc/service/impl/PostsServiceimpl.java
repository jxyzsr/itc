package com.jzlw.itc.service.impl;

import com.jzlw.itc.domain.Posts;
import com.jzlw.itc.mapper.Postsmapper;
import com.jzlw.itc.service.IPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostsServiceimpl implements IPostsService {
    @Autowired
    private Postsmapper mapper;
    @Override
    public void insertaposts(Posts posts) {
        mapper.insertaposts(posts);
    }

    @Override
    public void deleteaposts(Integer id, Integer userid) {
        mapper.deleteaposts(id,userid);
    }

    @Override
    public List<Posts> selectposts() {
        return mapper.selectposts();
    }

    @Override
    public Posts findByid(Integer id) {
        return mapper.findByid(id);
    }

    @Override
    public void padddNumgood(Integer id) {
        mapper.padddNumgood(id);
    }

    @Override
    public void pdeleteNumgood(Integer id) {
        mapper.pdeleteNumgood(id);
    }

    @Override
    public void padddNumcollection(Integer id) {
        mapper.padddNumcollection(id);
    }

    @Override
    public void pdeleteNumcollection(Integer id) {
        mapper.pdeleteNumcollection(id);
    }
}

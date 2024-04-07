package com.jzlw.itc.service.impl;

import com.jzlw.itc.domain.Comment;
import com.jzlw.itc.mapper.Commentmapper;
import com.jzlw.itc.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentServiceimpl implements ICommentService {

    @Autowired
    private Commentmapper mapper;
    @Override
    public void insertacomment(Comment comment) {
        mapper.insertacomment(comment);
    }

    @Override
    public void deleteacommment(String content,String type,Integer itid, Integer userid) {
        mapper.deleteacommment(content,type,itid,userid);
    }

    @Override
    public List<Comment> selectcommentbyid(Integer itid, String type) {
        return mapper.selectcommentbyid(itid,type);
    }

    @Override
    public void deleteacommmentfordeleted(String type, Integer itid) {
        mapper.deleteacommmentfordeleted(type,itid);
    }
}

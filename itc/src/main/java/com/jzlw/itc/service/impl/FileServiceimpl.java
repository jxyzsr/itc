package com.jzlw.itc.service.impl;

import com.jzlw.itc.domain.FileEntity;
import com.jzlw.itc.mapper.Filemapper;
import com.jzlw.itc.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceimpl implements IFileService {
    @Autowired
    private Filemapper filemapper;
    public void saveFile(FileEntity entity) {
        filemapper.saveFile(entity);
    }

    public FileEntity findByid(long id) {
        return filemapper.findByid(id);
    }

    @Override
    public void updatecover(String title,String cover,String titleAlter) {
        filemapper.updatecover(title,cover, titleAlter);
    }

    @Override
    public List<FileEntity> selectvideo() {
        return filemapper.selectvideo();
    }

    @Override
    public void vadddNumgood(long id) {
        filemapper.vadddNumgood(id);
    }

    @Override
    public void vdeleteNumgood(long id) {
        filemapper.vdeleteNumgood(id);
    }

    @Override
    public void vadddNumcollection(long id) {
        filemapper.vadddNumcollection(id);
    }

    @Override
    public void vdeleteNumcollection(long id) {
        filemapper.vdeleteNumcollection(id);
    }

    @Override
    public void deletevideo(long id, Integer userid) {
        filemapper.deletevideo(id,userid);
    }
}

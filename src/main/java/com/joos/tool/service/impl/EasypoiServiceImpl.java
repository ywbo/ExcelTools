package com.joos.tool.service.impl;

import com.joos.tool.dao.EasypoiDao;
import com.joos.tool.entity.StudentEntity;
import com.joos.tool.entity.TeacherEntity;
import com.joos.tool.service.EasypoiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName EasypoiServiceImpl
 * @Description TODO
 * @Author yuwb
 * @Date 2020-03-12 13:30
 */
@Service
public class EasypoiServiceImpl implements EasypoiService {

    @Autowired
    private EasypoiDao poiDao;

    @Override
    public List<StudentEntity> findUserAll() {
        return poiDao.findUserAll();
    }

    @Override
    public List<TeacherEntity> findTeachAll() {
        return poiDao.findTeachAll();
    }
}

package com.joos.tool.dao;

import com.joos.tool.entity.StudentEntity;
import com.joos.tool.entity.TeacherEntity;

import java.util.List;

public interface EasypoiDao {

    public List<StudentEntity> findUserAll();

    public List<TeacherEntity> findTeachAll();

}

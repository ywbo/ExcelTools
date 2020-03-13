package com.joos.tool.service;

import com.joos.tool.entity.StudentEntity;
import com.joos.tool.entity.TeacherEntity;

import java.util.List;

public interface EasypoiService {

    List<StudentEntity> findUserAll();

    List<TeacherEntity> findTeachAll();
}

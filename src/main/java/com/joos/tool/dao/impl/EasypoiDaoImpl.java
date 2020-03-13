package com.joos.tool.dao.impl;

import com.joos.tool.dao.EasypoiDao;
import com.joos.tool.entity.StudentEntity;
import com.joos.tool.entity.TeacherEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * @ClassName EasypoiDaoImpl
 * @Description TODO
 * @Author yuwb
 * @Date 2020-03-12 13:59
 */
@Repository
public class EasypoiDaoImpl implements EasypoiDao {

    @Autowired
    private EntityManagerFactory entityManager;

    @Override
    public List<StudentEntity> findUserAll() {
        Session session=entityManager.unwrap(SessionFactory.class).openSession();
        String sql = "SELECT * FROM student";
        NativeQuery query=session.createSQLQuery(sql);
        query.addEntity(StudentEntity.class);
        List<StudentEntity> list = query.list();
        if(list.size()>0 && null != list){
            return list;
        }
        return null;
    }

    @Override
    public List<TeacherEntity> findTeachAll() {
        Session session=entityManager.unwrap(SessionFactory.class).openSession();
        String sql = "SELECT * FROM teach";
        NativeQuery query=session.createSQLQuery(sql);
        query.addEntity(TeacherEntity.class);
        List<TeacherEntity> list = query.list();
        if(list.size()>0 && null != list){
            return list;
        }
        return null;
    }
}

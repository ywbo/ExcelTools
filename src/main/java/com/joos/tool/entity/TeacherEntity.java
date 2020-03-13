package com.joos.tool.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ClassName TeacherEntity
 * @Description TODO
 * @Author yuwb
 * @Date 2020-03-12 10:09
 */
@Data
@Entity
@Table(name = "teach", schema = "skystar")
@ExcelTarget("teacherEntity")
public class TeacherEntity implements java.io.Serializable {

    @Id
    private String id;
    /*
    *//** name *//*
    @Excel(name = "主讲老师_major,代课老师_absent", orderNum = "1", isImportField = "true_major,true_absent")
    private String name;
    */
    /** num *//*
    @Excel(name = "序号", orderNum = "1")
    private int num;*/

    /** banji */
    @Excel(name = "班级", orderNum = "2")
    private String banji;

    /** userInfo */
    @Excel(name = "学生信息", orderNum = "3")
    private StudentEntity userInfo;

}

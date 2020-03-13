package com.joos.tool.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @ClassName StudentEntity
 * @Description TODO
 * @Author yuwb
 * @Date 2020-03-12 10:10
 */
@Data
@Entity
@Table(name = "student", schema = "skystar")
public class StudentEntity implements java.io.Serializable {
    /**
     * id
     */
    @Id
    private String id;
    /**
     * 学生姓名
     */
    @Excel(name = "学生姓名", height = 20, width = 30, isImportField = "true_st")
    private String name;
    /**
     * 学生性别
     */
    @Excel(name = "学生性别", replace = { "男_1", "女_2" })
    private String sex;

    @Excel(name = "年龄", width = 20)
    private int age;

    /*@Excel(name = "出生日期", databaseFormat = "yyyyMMddHHmmss", format = "yyyy-MM-dd", isImportField = "true_st", width = 20)
    private Date birthday;

    @Excel(name = "进校日期", databaseFormat = "yyyyMMddHHmmss", format = "yyyy-MM-dd")
    private Date registrationDate;*/

}

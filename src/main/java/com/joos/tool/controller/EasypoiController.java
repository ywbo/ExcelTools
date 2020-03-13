package com.joos.tool.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import com.joos.tool.entity.StudentEntity;
import com.joos.tool.entity.TeacherEntity;
import com.joos.tool.service.EasypoiService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ClassName EasypoiController
 * @Description 模板多shhet导出
 * @Author yuwb
 * @Date 2020-03-12 11:27
 */
@Controller
@RequestMapping(value = "/easypoi")
public class EasypoiController {

    @Autowired
    private EasypoiService poiService;

    /**
     * 使用easypoi导出文件
     * 单sheet / 多sheet
     * @param response
     * @return
     */
    @RequestMapping(value="/export")
    @ResponseBody
    public String exportExcelTest(HttpServletResponse response){
        // 获取workbook对象
        // 单sheet或多sheet 只需要更改此处即可
        Workbook workbook = exportMoreSheetByTemplate() ;
        // 判断数据
        if(workbook == null) {
            return "fail";
        }
        // 设置excel的文件名称
        String excelName = "MyExcel" ;
        // 重置响应对象
        response.reset();
        // 当前日期，用于导出文件名称
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String dateStr = "["+excelName+"-"+sdf.format(new Date())+"]";
        // 指定下载的文件名--设置响应头
        response.setHeader("Content-Disposition", "attachment;filename=" +dateStr+".xls");
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        // 写出数据输出流到页面
        try {
            OutputStream output = response.getOutputStream();
            BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);
            workbook.write(bufferedOutPut);
            bufferedOutPut.flush();
            bufferedOutPut.close();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }

    /**
     * 模版多sheet导出示例
     * @return
     */
    public Workbook exportMoreSheetByTemplate(){
        // 查询数据
        List<StudentEntity> userList = new ArrayList<StudentEntity>();
        // 学生信息
        List<StudentEntity> userAll = poiService.findUserAll();
        StudentEntity user = new StudentEntity();
        if (userAll != null && userAll.size() > 0){
            for (int i = 0; i < userAll.size(); i++){
                user = userAll.get(i);
                userList.add(user);
            }

        }

        // sheet1内容
        // 班级信息
        List<TeacherEntity> teachList = new ArrayList<TeacherEntity>();
        List<TeacherEntity> teachAll = poiService.findTeachAll();
        List<StudentEntity> users = poiService.findUserAll();
        TeacherEntity teach = new TeacherEntity();
        if (teachAll != null && teachAll.size()>0 && users != null && users.size()>0){
            for (int i = 0; i < teachAll.size(); i++){
                teach.setUserInfo(users.get(i));
                teach = teachAll.get(i);
                teachList.add(teach);
            }

        }

        // 存放数据map
        Map<String,Object> map1 = new HashMap<String, Object>();
        map1.put("list",teachList);

        // sheet2内容
        map1.put("lists",userList);


        /*StudentEntity user1 = new StudentEntity();
        user1.setName("上官婉儿");
        user1.setSex("女");
        user1.setAge(20);
        StudentEntity user2 = new StudentEntity();
        user2.setName("福格雷斯");
        user2.setSex("男");
        user2.setAge(17);
        StudentEntity user3 = new StudentEntity();
        user3.setName("貂蝉");
        user3.setSex("女");
        user3.setAge(34);
        StudentEntity user4 = new StudentEntity();
        user4.setName("仲达");
        user4.setSex("男");
        user4.setAge(40);*/

        // sheet1内容
        /*TeacherEntity teach1 = new TeacherEntity();
        teach1.setBanji("信科");
        teach1.setUserInfo(user1);
        TeacherEntity teach2 = new TeacherEntity();
        teach2.setBanji("生工");
        teach2.setUserInfo(user2);
        TeacherEntity teach3 = new TeacherEntity();
        teach3.setBanji("化工");
        teach3.setUserInfo(user3);
        TeacherEntity teach4 = new TeacherEntity();
        teach4.setBanji("软件");
        teach4.setUserInfo(user4);
        list.add(teach1);
        list.add(teach2);
        list.add(teach3);
        list.add(teach4);*/
        /*// 存放数据map
        Map<String,Object> map1 = new HashMap<String, Object>() ;
        map1.put("list",list) ;*/
        // sheet2内容
       /* List<StudentEntity> userList = new ArrayList<StudentEntity>() ;
        userList.add(user1) ;
        userList.add(user2) ;
        userList.add(user3) ;
        userList.add(user4) ;
        map1.put("lists",userList) ;*/

        // 设置导出配置
        // 获取导出excel指定模版
        TemplateExportParams params = new TemplateExportParams("templates/moresheet.xlsx",true);
        // 设置sheetName，若不设置该参数，则使用得原本得sheet名称
        String[] sheetNameArray = {"班级信息","学生信息"} ;
        params.setSheetName(sheetNameArray);

        // 导出excel
        return ExcelExportUtil.exportExcel(params, map1);
    }
}

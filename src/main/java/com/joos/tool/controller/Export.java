package com.joos.tool.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Export
 * @Description 单sheet导出
 * @Author yuwb
 * @Date 2020-03-12 11:01
 */
@RestController
public class Export {
    private static final Logger logger = LoggerFactory.getLogger(Export.class);
    /**
     * 下载月度奖金表格
     *
     * @param response
     */
    @RequestMapping(value = "/exportBonus")
    public void exportBonus2(HttpServletRequest servletRequest, HttpServletResponse response) {
        try {
            TemplateExportParams params = new TemplateExportParams("templates/提成表2.xlsx");
            Map<String, Object> map = new HashMap<String, Object>();
            List<Map<String, String>> listMap = new ArrayList<Map<String, String>>();

//================================ 以下是 mock 数据 ===================================//
            map.put("year", "2020");
            map.put("month", "03");
            Map<String, String> lm = new HashMap<String, String>();
            lm.put("userName", "孟德");
            lm.put("storeNum", "10");
            lm.put("awardAmount", "1200");
            lm.put("saleAwardAmount", "300");
            lm.put("engineerAwardAmount", "900");
            listMap.add(lm);
            Map<String, String> lm2 = new HashMap<String, String>();
            lm2.put("userName", "玄德");
            lm2.put("storeNum", "12");
            lm2.put("awardAmount", "1800");
            lm2.put("saleAwardAmount", "800");
            lm2.put("engineerAwardAmount", "1000");
            listMap.add(lm2);
            map.put("maplist", listMap);
//================================ 以上是 mock 数据 ===================================//

            //设置sheet名
            params.setSheetName("提成表");
            Workbook workbook = ExcelExportUtil.exportExcel(params, map);
            export(servletRequest, response, workbook,  "2020年03月奖金汇总表");
        } catch (Exception e) {
            logger.error("下载月度奖金表格异常=" + e.getMessage());
        }
    }
    /**
     * export导出请求头设置
     * 防止乱码
     * @param response
     * @param workbook
     * @param fileName
     * @throws Exception
     */
    private static void export(HttpServletRequest servletRequest, HttpServletResponse response, Workbook workbook, String fileName) throws Exception {
        response.reset();
        response.setContentType("application/x-msdownload");
        response.setHeader("Content-disposition", "attachment; filename=" + new String(fileName.getBytes("utf-8"), "iso8859-1") + ".xls");
        ServletOutputStream outStream = null;
        try {
            outStream = response.getOutputStream();
            workbook.write(outStream);
        } finally {
            outStream.close();
        }
    }
}
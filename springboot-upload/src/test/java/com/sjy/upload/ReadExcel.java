package com.sjy.upload;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ReadExcel {
    public static void main(String[] args) {
        ReadExcel obj = new ReadExcel();
        // 此处为我创建Excel路径：E:/zhanhj/studysrc/jxl下
        File file = new File("C:\\Users\\admin\\Desktop\\xxxx.xls");
        HashSet hashSet = obj.readExcel(file);
        for (Object o : hashSet) {
            System.out.println(o.toString());
        }
    }
    // 去读Excel的方法readExcel，该方法的入口参数为一个File对象
    public HashSet readExcel(File file) {
        try {
            // 创建输入流，读取Excel
            InputStream is = new FileInputStream(file.getAbsolutePath());
            // jxl提供的Workbook类
            Workbook wb = Workbook.getWorkbook(is);
            HashSet<String> strings = new HashSet<>();
            HashSet<String> strings1 = new HashSet<>();
            // Excel的页签数量
            int sheet_size = wb.getNumberOfSheets();
            for (int index = 0; index < 1; index++) {
                List<List> outerList=new ArrayList<List>();
                // 每个页签创建一个Sheet对象
                Sheet sheet = wb.getSheet(index);
                // sheet.getRows()返回该页的总行数
                for (int i = 0; i < sheet.getRows(); i++) {
                    List innerList=new ArrayList();
                    // sheet.getColumns()返回该页的总列数
                    for (int j = 0; j < sheet.getColumns(); j++) {
                        String cellinfo = sheet.getCell(j, i).getContents();
                        if(cellinfo.isEmpty()){
                            continue;
                        }
                        if (strings.contains(cellinfo)) {
                            strings1.add(cellinfo);
                           // System.out.println(cellinfo);
                        }
                        strings.add(cellinfo);
                        //innerList.add(cellinfo);
                    }
                }
                return strings1;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
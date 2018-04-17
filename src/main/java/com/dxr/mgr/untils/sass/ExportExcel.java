package com.dxr.mgr.untils.sass;

import com.dxr.mgr.common.saas.annotation.UserExcel;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by dongyang.wang on 2018/4/3 0003 .
 */
public class ExportExcel {

    public static <T>void createExcel(List<T> dataList) {

        try {
            // 输出流
            OutputStream os = new FileOutputStream("D:/exportexcel_"
                    + System.currentTimeMillis() + ".xlsx");
            // 工作区
            XSSFWorkbook wb = new XSSFWorkbook();
            String sheetName = "User";
            XSSFSheet sheet = wb.createSheet(sheetName);

            boolean flag = true;
            int lineNum= dataList.size();
            int rowNum = 0;
            Field[] fs = null;
            Object obj = null;
            for(int i = 0 ; i < lineNum ; i++) {
                obj = dataList.get(i);
                if(flag) {
                    Class objClass = obj.getClass();
                    fs = objClass.getDeclaredFields();
                    rowNum = fs.length;
                    //生成第一行
                    XSSFRow row1 = sheet.createRow(1);
                    int a = 0;
                    for (int j = 0; j < rowNum; j++) {

                        Field field = fs[j];
                        UserExcel UserExcel = field.getAnnotation(UserExcel.class);
                        if(!field.isAnnotationPresent(UserExcel.class)){
                            row1.createCell(j-a).setCellValue(field.getName());
                        }else if(UserExcel.flag()){
                            row1.createCell(j-a).setCellValue(UserExcel.name());
                        }else{
                            a++;
                        }
//                        System.out.println(fs[j].getName());
                    }
                    flag = false;
                }
                // 生成一行
                XSSFRow row = sheet.createRow(i+2);
                // 给这一行的每一列赋值
                int a = 0;
                for (int j = 0; j < rowNum; j++) {

                    Object obj1 = null;
                    obj1 = invokeGet(obj, fs[j].getName());
                    if (!fs[j].isAnnotationPresent(UserExcel.class)) {
                        row.createCell(j-a).setCellValue(obj1.toString());
                    }else if(fs[j].getAnnotation(UserExcel.class).flag()){
                        row.createCell(j-a).setCellValue(obj1.toString());
                    }else{
                        a++;
                    }
                }
            }
            // 写文件
            wb.write(os);
            // 关闭输出流
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * java反射bean的get方法
     *
     * @param objectClass
     * @param fieldName
     * @return
     */
    @SuppressWarnings("unchecked")
    public static Method getGetMethod(Class objectClass, String fieldName) {
        StringBuffer sb = new StringBuffer();
        sb.append("get");
        sb.append(fieldName.substring(0, 1).toUpperCase());
        sb.append(fieldName.substring(1));
        try {
            return objectClass.getMethod(sb.toString());
        } catch (Exception e) {
            return null;
        }
    }
    /**
     * 执行get方法
     *
     * @param o 执行对象
     * @param fieldName 属性
     */
    public static Object invokeGet(Object o, String fieldName) {
        Method method = getGetMethod(o.getClass(), fieldName);
        try {
            return method.invoke(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}

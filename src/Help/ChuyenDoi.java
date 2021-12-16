/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Help;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author admin
 */
public class ChuyenDoi {
    //Chuyển đổi date--String
    static DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    //chuyển Date -> String
    public static String LayNgayString(Date date){
        return dateFormat.format(date);
    }

    //chuyển String -> Date
    public static Date LayNgayDate(String ngay){
        try {
            return dateFormat.parse(ngay);
        } catch (ParseException ex) {
            System.out.println("Lỗi chuyển ngày");
            return null;
        }
    }

    //chuyển định dạng từ số Double thành String dạng có ,(vd 1,000,000)
    public static String SoString(double so){
        return NumberFormat.getNumberInstance().format(so);
    }
    
    //chuyển định dạng String (1,000,111) thành số Double
    public static double SoDouble(String so){
        try {
            return NumberFormat.getNumberInstance().parse(so).doubleValue();
        } catch (ParseException ex) {
            return 0;
        }
    }
    
    //Làm tròn số Double
    public static double lamTronSoDouble(double number, int khoangLamTron) {

        double result = khoangLamTron;
        if (number % khoangLamTron == 0) {
            return (int) number;
        }
        if (number % khoangLamTron != 0) {
            int division = (int) ((number / khoangLamTron) + 1);
            result = division * khoangLamTron;
        }
        return result;
    }
    
    //chuyển đổi chữ đầu thành hoa
    public static String doiTen(String ten){
	//cắt string thành mảng qua các dấu Space
	String[] arr = ten.split(" ");
	//dùng vòng lặp duyệt các từ và thay thế từ đầu tiên!
	String stringfromclient1 = "";
	for (String x : arr) {
		stringfromclient1 = stringfromclient1 + (x.substring(0, 1).toUpperCase() + x.substring(1));
		stringfromclient1 = stringfromclient1 + " ";
	}
        return stringfromclient1;
    }
    
}

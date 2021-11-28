/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Help;

import java.awt.Desktop;
import java.awt.Frame;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Administrator
 */
public class XuatExcel {
    
    public static void xuat(JTable table){
        try{
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.showSaveDialog(new Frame());
            File saveFile = jFileChooser.getSelectedFile();
           
            if(saveFile != null){
                saveFile = new File(saveFile.toString()+".xlsx");
                Workbook wb = new XSSFWorkbook();
                Sheet sheet = wb.createSheet("customer");

                Row rowCol = sheet.createRow(0);
                for(int i=0;i<table.getColumnCount();i++){
                    Cell cell = rowCol.createCell(i);
                    cell.setCellValue(table.getColumnName(i));
                }
               
                for(int j=0;j<table.getRowCount();j++){
                    Row row = sheet.createRow(j+1);
                    for(int k=0;k<table.getColumnCount();k++){
                        Cell cell = row.createCell(k);
                        if(table.getValueAt(j, k)!=null){
                            cell.setCellValue(table.getValueAt(j, k).toString());
                        }
                    }
                }
                FileOutputStream out = new FileOutputStream(new File(saveFile.toString()));
                wb.write(out);
                wb.close();
                out.close();
                int clickLuu = JOptionPane.showConfirmDialog(new Frame(),"Bạn có muốn mở file vừa xuất ?", "Thông báo",JOptionPane.YES_NO_OPTION);
                if (clickLuu == JOptionPane.YES_OPTION) {
                    openFile(saveFile.toString());
                }

           }else{
               JOptionPane.showMessageDialog(null,"Lỗi xuất file");
           }
       }catch(FileNotFoundException e){
           System.out.println(e);
       }catch(IOException io){
           System.out.println(io);
       }
    }
    
    public static void openFile(String file){
        try{
            File path = new File(file);
            Desktop.getDesktop().open(path);
        }catch(IOException ioe){
            System.out.println(ioe);
        }
    }
        
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moteur;

import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 *
 * @author alain
 */
public class Moteur {
    
    public Moteur(){
    
    }
    
    public void table_excel(javax.swing.JTable jTableExcel, Component parent) throws IOException, BiffException{
                String path = opening(parent);
                String ch = "";

                if(path!=null){                
                    File f = new File(path);
                    Workbook wb = Workbook.getWorkbook(f);
                    Sheet s = wb.getSheet(0);
                    int row = s.getRows();
                    int col = s.getColumns();
                    String titre[]= new String[col];
                    Object objt[][] = new Object[row][col+1];
                    for(int i = 0; i<row; i++){
                        ch ="";
                        for(int j = 0; j<col; j++){              
                            Cell c = s.getCell(j,i);      
                            ch = ch + "`"+c.getContents()+"`,"; 
                            if(i == 0) {
                                
                                titre[j] = c.getContents();
                            }else{
                                objt[i-1][j]=c.getContents();
                                objt[i-1][j]=c.getContents();
                                objt[i-1][j]=c.getContents();
                                objt[i-1][j]=c.getContents();
                                objt[i-1][j]=c.getContents();
                                objt[i-1][j]=c.getContents();
                                objt[i-1][j]=c.getContents();
                                objt[i-1][j]=c.getContents();
                                objt[i-1][j]=c.getContents();
                            }

                       }
                }
                    jTableExcel.setModel(new DefaultTableModel(objt,titre));
                }
              

    }
    public String opening(Component parent){
            
            String filePath = null  ;
            // Create a JFileChooser Object
            final JFileChooser fc = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Current-ChannelUserTransactionReport", "xls");
            fc.addChoosableFileFilter(filter);
            fc.setFileFilter(filter);
            try {
                fc.setCurrentDirectory(new java.io.File("D:"));
            } catch (Exception e) {
                System.out.println(e.toString());
            }       
            // Open JFileChooser Dialog
            int returnVal = fc.showOpenDialog(parent);
            // Check if user opens file
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                filePath = file.getAbsolutePath();              
            }
       return filePath;
    }
    public String calcul_diff_Heur(String hd,String hf) throws ParseException{
            int res = 0;
            int min = 0;

            String m = null;
            String h = null;

            Date dHD = new SimpleDateFormat("hh:mm").parse(hd); 
            Date dHF = new SimpleDateFormat("hh:mm").parse(hf); 
            res = dHF.getHours() - dHD.getHours();
            min = dHF.getMinutes() - dHD.getMinutes();
            if(res>0){
                res = res ;
            }else{
                res = res * (-1);
            }

            if(min>0){
                min = min ;
            }else{
                min = min * (-1);
            }
            if(String.valueOf(res).toString().length() ==1){
                 h="0"+res;
            }else{
                 h=""+res;
            }
            if(String.valueOf(min).toString().length() ==1){
                 m="0"+min;
            }else{
                m=""+min;
            }

            return(h+":"+m);
    }
    
    
    public boolean compareTo(String source, String cible){
        return source.equalsIgnoreCase(cible);
    }
    
}

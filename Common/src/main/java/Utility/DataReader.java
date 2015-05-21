package Utility;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


/**
 * Created by HP on 5/17/2015.
 */
public class DataReader {

    int numberOFrows, numberOfcol;

    public String[][] fileReader(String path) throws IOException {
        String[][] data={};
        File file=new File(path);
        FileInputStream fis=new FileInputStream(file);
        HSSFWorkbook wb=new HSSFWorkbook(fis);
        HSSFSheet sheet=wb.getSheetAt(0);
        numberOFrows=sheet.getLastRowNum();
        numberOfcol=sheet.getRow(0).getLastCellNum();
        data=new String[numberOFrows+1][numberOfcol+1];

        for(int i=1;i<data.length;i++){
            HSSFRow row=sheet.getRow(i);
            for (int j=0;j<numberOfcol;j++){
                HSSFCell cell=row.getCell(j);
                String cellData=getCellValue(cell);
                data[i][j]=cellData;
            }
        }

        return data;
    }

    public String getCellValue(HSSFCell cell){
        Object value=null;

        int dataType=cell.getCellType();

        switch(dataType){
            case HSSFCell.CELL_TYPE_BOOLEAN:
                value=cell.getBooleanCellValue();
                break;
            case HSSFCell.CELL_TYPE_STRING:
                value=cell.getStringCellValue();
                break;
            case HSSFCell.CELL_TYPE_NUMERIC:
                value=cell.getNumericCellValue();
                break;
        }
        return value.toString();
    }
}

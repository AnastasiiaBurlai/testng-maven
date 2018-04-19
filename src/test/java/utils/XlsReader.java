package utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class XlsReader {

    public static String[][] read(Sheet sheet, int startColumn, int endColumn) {
        int rows = sheet.getPhysicalNumberOfRows();
        int numberOfParameters = endColumn - startColumn;
        String[][] returnValue = new String[rows][numberOfParameters];
        for (int i = 0; i < rows; i++) {
            Row row = sheet.getRow(i);
            int jj = 0;
            for (int j = startColumn; j < endColumn; j++) {
                int cellType;
                try {
                    cellType = row.getCell(j).getCellType();
                } catch (NullPointerException ex) {
                    returnValue[i][jj] = "";
                    continue;
                }
                String str;
                switch (cellType) {
                    case Cell.CELL_TYPE_NUMERIC:
                        if (DateUtil.isCellDateFormatted(row.getCell(j))) {
                            returnValue[i][jj] = String.valueOf(row.getCell(j)
                                    .getDateCellValue());
                        } else {
                            returnValue[i][jj] = String.valueOf(row.getCell(j)
                                    .getNumericCellValue());
                            returnValue[i][jj] = returnValue[i][jj]
                                    .replaceAll(".0", "");
                        }
                        break;

                    case Cell.CELL_TYPE_STRING:
                        str = row.getCell(j).getStringCellValue().trim();
                        returnValue[i][jj] = str;
                        break;

                    case Cell.CELL_TYPE_BOOLEAN:
                        returnValue[i][jj] = Boolean.toString(row.getCell(j)
                                .getBooleanCellValue());
                        break;

                    default:
                        returnValue[i][jj] = "";
                }
                jj++;
            }
        }
        return returnValue;
    }
}

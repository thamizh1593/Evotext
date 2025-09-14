package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "logindata")
	public String[][] dataProvider() throws IOException {

		String path = System.getProperty("user.dir") + "\\testdata\\SignInTestData.xlsx";
		ExcelUtility xlutil = new ExcelUtility(path);

		int totalRow = xlutil.getRowCount("sheet1");
		int totalCol = xlutil.getCellCount("sheet1", 1);

		String login[][] = new String[totalRow][totalCol];
		for (int i = 1; i <= totalRow; i++) {
			for (int j = 0; j < totalCol; j++) {
				login[i - 1][j] = xlutil.getCellData("sheet1", i, j);
			}
		}

		return login;
	}

	@DataProvider(name = "AddClassData")
	public String[][] addClassData() throws IOException {

		String path = System.getProperty("user.dir") + "\\testdata\\AddClassData.xlsx";
		ExcelUtility xlutil = new ExcelUtility(path);
		int totalRow = xlutil.getRowCount("sheet1");
		int totalCol = xlutil.getCellCount("sheet1", 1);

		String[][] AddClass = new String[totalRow][totalCol];

		for (int i = 1; i <= totalRow; i++) {
			for (int j = 0; j < totalCol; j++) {
				AddClass[i - 1][j] = xlutil.getCellData("sheet1", i, j);
			}
		}

		return AddClass;

	}

}

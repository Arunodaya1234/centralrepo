package execution;

import java.io.IOException;

import excellUtility.WriteExcellSheet;
import loginData.LoginTest;

public class ExecuteTestCases {

	public static void main(String[] args) throws IOException {
		LoginTest test=new LoginTest();
		test.loginSetUp();
		WriteExcellSheet writeSheet=new WriteExcellSheet();
		writeSheet.setCellData("PASS", 1, 2);
		writeSheet.setCellData("PASS", 2, 2);
	}

}

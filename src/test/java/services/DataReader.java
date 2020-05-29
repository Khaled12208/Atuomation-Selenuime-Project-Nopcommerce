package services;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DataReader {

    /************************
     * Getting Data from JAson File
     *****************************/
    @SuppressWarnings("unchecked")
    public HashMap<String, Object> regestrationData() throws IOException, ParseException {
	String FilePath = System.getProperty("user.dir") + "\\Data\\UserRegestration.json";
	HashMap<String, Object> hm = new HashMap<String, Object>();
	FileReader reader = new FileReader(FilePath);
	JSONParser parser = new JSONParser();
	Object obj = parser.parse(reader);
	JSONArray array = new JSONArray();
	array.add(obj);

	for (Object json : array) {
	    JSONObject prep = (JSONObject) json;
	    hm.put("firsrname", prep.get("firsrname"));
	    hm.put("lastnem", prep.get("lastnem"));
	    hm.put("gender", prep.get("gender"));
	    hm.put("Day", prep.get("Day"));
	    hm.put("Month", prep.get("Month"));
	    hm.put("Year", prep.get("Year"));
	    hm.put("E-Mail", prep.get("E-Mail"));
	    hm.put("Pass", prep.get("Pass"));
	    hm.put("company", prep.get("company"));
	}

	return hm;

    }

    /************************
     * Getting Data Excel JAson File
     *****************************/

    public HashMap<String, String> logindata() throws IOException {
	String FilePath = System.getProperty("user.dir") + "\\Data\\UserLogin.xlsx";
	FileInputStream reader = new FileInputStream(FilePath);
	@SuppressWarnings("resource")
	XSSFWorkbook workbook = new XSSFWorkbook(reader);
	int numSheet = workbook.getNumberOfSheets();
	XSSFSheet sheet = null;
	HashMap<String, String> data = new HashMap<String, String>();
	for (int i = 0; i < numSheet; i++) {

	    if (workbook.getSheetName(i).equals("Sheet1")) {

		sheet = workbook.getSheetAt(i);
		break;

	    }

	}

	Iterator<Row> rowIterator = sheet.iterator();

	while (rowIterator.hasNext()) {
	    rowIterator.next();
	    Row nex = rowIterator.next();
	    data.put("E-mail", nex.getCell(0).getStringCellValue());
	    int numric = (int) nex.getCell(1).getNumericCellValue();
	    String pass = Integer.toString(numric);
	    data.put("password", pass);

	}

	return data;
    }

    /************************
     * Getting Data base server
     *****************************/

    public List<Object> DataBase_providor() throws SQLException {
	String host = "localhost";
	String port = "3306";
	String database = "nopcommerce";

	// Creat a connection
	Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, "root",
		"khaled");
	// create path for this connection
	Statement s = con.createStatement();
	// excute queries
	ResultSet result = s.executeQuery("Select * from product order by id asc;");

	List<Object> data = new ArrayList<Object>();
	while (result.next()) {

	    data.add(result.getString("name"));
	}

	return data;
    }

}

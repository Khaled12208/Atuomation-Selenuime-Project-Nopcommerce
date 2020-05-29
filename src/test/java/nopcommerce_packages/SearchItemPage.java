package nopcommerce_packages;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.HomePage;
import services.DataReader;

public class SearchItemPage extends TestBase {

    /***** Contractor variables to init the driver *********************/

    public SearchItemPage() throws IOException {
	// this.driver = Browser_Init();
    }

    @Test(dataProvider = "database")
    public void search_database(String Search) throws InterruptedException {
	HomePage op = new HomePage(driver.get());
	op.Search(Search);

    }

    @Test
    public void search_AutoSuggestion() throws InterruptedException {
	String Search = "cam";
	HomePage op = new HomePage(driver.get());
	op.AutoSug_Search(Search);

    }

    @DataProvider(name = "database")
    public Object[] database() throws SQLException {

	/*
	 * This Method is used to get the data from dabase connector and provide it to
	 * test function
	 */
	DataReader database = new DataReader();
	List<Object> list = database.DataBase_providor();
	Object[] search = new Object[list.size() + 1];
	search = list.toArray();

	return search;
    }

}

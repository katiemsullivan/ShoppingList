import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListItemDAO {

	ArrayList<ListItem> arrayList = new ArrayList<ListItem>();
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;

	public ListItemDAO() {

		makeConnection();


	}

	public String getCurrentList() {

		String str = "";
		
		return str;
	}

	public String getCurrentListFromStore(String s) {
		String str = "";
		
		return str;
	}

	public void insertNewItem(ListItem i) {
		makeConnection();

		
	}

	public void deleteItem(ListItem i) {
		makeConnection();

		
	}

	public void makeConnection() {
		String url = "jdbc:mysql://127.0.0.1:3306/shopping";
		String user = "root";
		String password = "password";

		try {

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection made");

		} catch (Exception ex) {
			Logger lgr = Logger.getLogger(ListItemDAO.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			System.out.println("Sql Exception");

		}

	}
}

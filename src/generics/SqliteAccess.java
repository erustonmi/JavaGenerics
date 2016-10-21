package generics;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SqliteAccess implements DataAccess {

	private Connection connection = null;
	ResultSet resultSet = null;
	Statement statement = null;
	SqliteAccess(String url)
	{
		try
		{
			connection = DriverManager.getConnection("jdbc:sqlite:" + url);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Override
	public double getValue(int date) {
		// TODO Auto-generated method stub
		try
		{
			Class.forName("org.sqlite.JDBC"); 
			statement = connection.createStatement();
			String sql = "SELECT value FROM pricing WHERE security='IBM' AND date=" + date;
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				System.out.println(resultSet.getDouble(0));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public void setValue(int date, double v) {
		// TODO Auto-generated method stub

	}

	@Override
	public byte[] getBuffer(int basisDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBuffer(int basisDate, byte[] Buffer) {
		// TODO Auto-generated method stub

	}

}

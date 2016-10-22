package generics;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqliteAccess implements DataAccess {

	private int commitSize = 100;
	private int pendingCount = 0;
	private Connection connection = null;
	ResultSet resultSet = null;
	Statement statement = null;
	SqliteAccess(String url)
	{
		try
		{
			connection = DriverManager.getConnection("jdbc:sqlite:" + url);
			connection.setAutoCommit(false);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Override
	public double getValue(String id, int date, int field) {
		// TODO Auto-generated method stub
		double v = 0;
		try
		{
//			Class.forName("org.sqlite.JDBC"); 
			statement = connection.createStatement();
			String sql = "SELECT value FROM pricing WHERE security='" +
			              id + "' AND date=" + date + " AND field=" + field;
			resultSet = statement.executeQuery(sql);
			if(resultSet.next())
			{
				v = resultSet.getDouble(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return v;
	}

	@Override
	public void setValue(String id, int date, int field, double v) {
		// TODO Auto-generated method stub
		try
		{
//			Class.forName("org.sqlite.JDBC"); 
			statement = connection.createStatement();
			String sql = "INSERT OR REPLACE INTO pricing VALUES('" + id +
			              "'," + date + "," + field + "," + v + ")";
			statement.execute(sql);
			++pendingCount;
			if(pendingCount >= commitSize)
			{
				commit();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
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
	@Override
	public void setCommitSize(int n) {
		// TODO Auto-generated method stub
		commitSize = n;
	}
	@Override
	public int getCommitSize() {
		// TODO Auto-generated method stub
		return commitSize;
	}
	@Override
	public void commit() {
		// TODO Auto-generated method stub
		try
		{
			connection.commit();
			pendingCount = 0;
		}
		catch (SQLException se)
		{
			System.err.println(se);
		}
	}

}

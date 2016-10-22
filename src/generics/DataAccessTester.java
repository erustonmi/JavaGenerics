package generics;

public class DataAccessTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SqliteAccess da = null;
		da = new SqliteAccess("C:\\Users\\Ming\\Desktop\\sqlite\\TESTDB");
		String sec = "IBM";
		for(int dt = 20161001; dt < 20161022; ++dt)
		{
			System.out.println(sec + " " + dt + ": "+ da.getValue(sec, dt, 4));
		}
	}
}

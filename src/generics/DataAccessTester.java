package generics;

public class DataAccessTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("here1");
		SqliteAccess da = null;
		System.out.println("here2");
		da = new SqliteAccess("C:\\Users\\Ming\\Desktop\\sqlite\\TESTDB");
		System.out.println("here3");
		System.out.println("getData returns " + da.getValue(20161018));
	}

}

package generics;

public class DataAccessTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("here1");
		Db2Access da = null;
		System.out.println("here2");
		da = new Db2Access();
		System.out.println("here3");
		System.out.println("getData returns " + da.getData(20161018));
	}

}

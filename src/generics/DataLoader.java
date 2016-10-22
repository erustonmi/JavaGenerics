package generics;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DataLoader {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		final SqliteAccess da = new SqliteAccess("C:\\Users\\Ming\\Desktop\\sqlite\\TESTDB");
		da.setCommitSize(3000);
		Path p = Paths.get("C:\\Users\\Ming\\Downloads\\lnkd.csv");
		Stream<String> f = Files.lines(p).skip(1);
		f.forEach(l->{
			String[] arr = l.split("\\s+");
			System.out.println("loading row[" + arr[0] + "]");
			try{da.setValue("LNKD", Integer.valueOf(arr[0]), 1, Double.valueOf(arr[1]));} catch(Exception e) {};
			try{da.setValue("LNKD", Integer.valueOf(arr[0]), 2, Double.valueOf(arr[2]));} catch(Exception e) {};
			try{da.setValue("LNKD", Integer.valueOf(arr[0]), 3, Double.valueOf(arr[3]));} catch(Exception e) {};
			try{da.setValue("LNKD", Integer.valueOf(arr[0]), 4, Double.valueOf(arr[4]));} catch(Exception e) {};
			try{da.setValue("LNKD", Integer.valueOf(arr[0]), 5, Double.valueOf(arr[5]));} catch(Exception e) {};
		});
		da.commit();
	}
}

package generics;

public interface DataAccess {
	double getValue(String id, int date, int field);
	void setValue(String id, int date, int field, double v);
	byte[] getBuffer(int basisDate);
	void setBuffer(int basisDate, byte[] Buffer);
	void setCommitSize(int n);
	int getCommitSize();
	void commit();
}

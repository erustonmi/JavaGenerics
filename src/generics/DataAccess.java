package generics;

public interface DataAccess {
	double getValue(int date);
	void setValue(int date, double v);
	byte[] getBuffer(int basisDate);
	void setBuffer(int basisDate, byte[] Buffer);
}

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class DataReader implements IDataReader {
	
	private Scanner scanner;
	@Override
	public DataRecord getDataRecord() {
		DataRecord dr = new DataRecord();
		dr.setC(scanner.nextDouble());
		dr.setMn(scanner.nextDouble());
		dr.setP(scanner.nextDouble());
		dr.setS(scanner.nextDouble());
		dr.setSi(scanner.nextDouble());
		dr.setCu(scanner.nextDouble());
		dr.setNi(scanner.nextDouble());
		dr.setCr(scanner.nextDouble());
		dr.setMo(scanner.nextDouble());
		dr.setNb(scanner.nextDouble());
		dr.setV(scanner.nextDouble());
		dr.setTi(scanner.nextDouble());
		dr.setAl(scanner.nextDouble());
		dr.setN(scanner.nextDouble());
		dr.setH5(scanner.nextDouble());
		dr.setH12(scanner.nextDouble());
		dr.setGt(scanner.nextDouble());
		dr.setClassName(scanner.nextLine().trim());
		return dr;
	}
	public DataReader() {
		try {
			scanner = new Scanner (new BufferedReader(new FileReader("data.txt")));
			scanner.useDelimiter(" ");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public boolean hasNext() {
		return scanner.hasNext();
	}
}
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {
	
	public static void main(String[] args) {
		//чтение данных
		ArrayList<ArrayList<Double>> elements = new ArrayList<ArrayList<Double>>();
		for (int i = 0; i <= 16; i++)
			elements.add(new ArrayList<Double>());
		ArrayList<String> valueClassName = new ArrayList<String>();
		DataReader dreader = new DataReader();
		DataRecord dr = new DataRecord();
		while (dreader.hasNext())
		{
			dr = dreader.getDataRecord();
			elements.get(0).add(dr.getC());
			elements.get(1).add(dr.getMn());
			elements.get(2).add(dr.getP());
			elements.get(3).add(dr.getS());
			elements.get(4).add(dr.getSi());
			elements.get(5).add(dr.getCu());
			elements.get(6).add(dr.getNi());
			elements.get(7).add(dr.getCr());
			elements.get(8).add(dr.getMo());
			elements.get(9).add(dr.getNb());
			elements.get(10).add(dr.getV());
			elements.get(11).add(dr.getTi());
			elements.get(12).add(dr.getAl());
			elements.get(13).add(dr.getN());
			elements.get(14).add(dr.getH5());
			elements.get(15).add(dr.getH12());
			elements.get(16).add(dr.getGt());
			valueClassName.add(dr.getClassName());
		}
		ArrayList<FrequencyTable> tables = new ArrayList<FrequencyTable>();
		for (ArrayList<Double> element : elements)
			tables.add(new FrequencyTable(element, valueClassName));
		//нахождение правила с наименьшей ошибкой
		int minError = tables.get(0).getError();
		int predictorNum = 0;
		int error;
		for (int i = 1; i <= 16; i++) {
			error = tables.get(i).getError();
			if (error<minError) {
				minError = error;
				predictorNum = i;
			}
		}
		String predictor = new String();
		switch (predictorNum) {
		case 0: predictor = "C"; break;
		case 1: predictor = "Mn"; break;
		case 2: predictor = "P"; break;
		case 3: predictor = "S"; break;
		case 4: predictor = "Si"; break;
		case 5: predictor = "Cu"; break;
		case 6: predictor = "Ni"; break;
		case 7: predictor = "Cr"; break;
		case 8: predictor = "Mo"; break;
		case 9: predictor = "Nb"; break;
		case 10: predictor = "V"; break;
		case 11: predictor = "Ti"; break;
		case 12: predictor = "Al"; break;
		case 13: predictor = "N"; break;
		case 14: predictor = "H5"; break;
		case 15: predictor = "H12"; break;
		case 16: predictor = "Gt"; break;
		default: break;
		}
		//запись результата в файл
		try {
			PrintWriter out = new PrintWriter(new File("result.txt"));
			out.println("Низкий");
			out.println(predictor + " = " + tables.get(predictorNum).getClass1());
			out.println("Высокий");
			out.print(predictor + " = " + tables.get(predictorNum).getClass2());
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
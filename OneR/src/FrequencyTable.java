import java.util.ArrayList;

public class FrequencyTable {
	//значения
	private ArrayList<Double> value = new ArrayList<Double>();
	//кол-ва значений низкого класса
	private ArrayList<Integer> class1 = new ArrayList<Integer>();
	//кол-ва значений высокого класса
	private ArrayList<Integer> class2 = new ArrayList<Integer>();
	
	public FrequencyTable (ArrayList<Double> elementValues, ArrayList<String> elementClasses) {
		for (int i = 0; i < elementValues.size(); i++)
		{
			int index = value.indexOf(elementValues.get(i));
			if (index == -1)
			{
				value.add(elementValues.get(i));
				class1.add(0);
				class2.add(0);
				index = value.size()-1;
			}
			if(elementClasses.get(i).equals("Низкий"))
				class1.set(index, class1.get(index) + 1);
			else
				class2.set(index, class2.get(index) + 1);
		}
	}
	//общая ошибка предсказания
	public int getError() {
		int error = 0;
		for (int i = 0; i < value.size(); i++)
			error += Math.min(class1.get(i), class2.get(i));
		return error;
	}
	//список значений низкого класса
	public ArrayList<Double> getClass1() {
		ArrayList<Double> list = new ArrayList<Double>();
		for (int i = 0; i < value.size(); i++)
			if (class1.get(i) >= class2.get(i))
				list.add(value.get(i));
		return list;
	}
	//список значений высокого класса
	public ArrayList<Double> getClass2() {
		ArrayList<Double> list = new ArrayList<Double>();
		for (int i = 0; i < value.size(); i++)
			if (class1.get(i) < class2.get(i))
				list.add(value.get(i));
		return list;
	}
}
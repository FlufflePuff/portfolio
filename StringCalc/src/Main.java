import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		//ввод выражения
		System.out.print("Введите выражение: ");
		Scanner scanner = new Scanner(System.in);
		String expression = scanner.nextLine();
		scanner.close();
		//шаблон для проверки на правильность ввода
		Pattern patternErr = Pattern.compile("[^\\d\\.\\s\\+\\-\\*/]|(\\D\\.)|(\\.\\D)|(^\\s*\\D)|(\\D\\s*$)|([\\+\\-\\*/]\\s*[\\+\\-\\*/])|(\\d\\s+\\d)");
		Matcher matcherErr = patternErr.matcher(expression);
		//проверка правильности ввода
		if (matcherErr.find()) {
			System.out.print("Некорректный ввод");
		}
		else {
			//списки операторов и операндов
			ArrayList<Double> digits = new ArrayList<Double>();
			ArrayList<String> operators = new ArrayList<String>();
			//заполнение списка операндов
			Pattern patternD = Pattern.compile("\\d+(\\.\\d+)?");
			Matcher matcherD = patternD.matcher(expression);
			while (matcherD.find())
				digits.add(Double.parseDouble(matcherD.group()));
			//заполнение списка операторов
			Pattern patternOp = Pattern.compile("[\\+\\-\\*/]");
			Matcher matcherOp = patternOp.matcher(expression);
			while (matcherOp.find())
				operators.add(matcherOp.group());
			//вычисление выражения
			for (int i = 0; i < operators.size(); i++)
				if (operators.get(i).equals("*"))
				{
					digits.set(i, digits.get(i) * digits.get(i+1));
					operators.remove(i);
					digits.remove(i+1);
					i--;
				}
				else 
				if (operators.get(i).equals("/")) 
				{
					digits.set(i, digits.get(i) / digits.get(i+1));
					operators.remove(i);
					digits.remove(i+1);
					i--;
				}
			for (int i = 0; i < operators.size(); i++)
				if (operators.get(i).equals("+"))
				{
					digits.set(i, digits.get(i) + digits.get(i+1));
					operators.remove(i);
					digits.remove(i+1);
					i--;
				}
				else
				if (operators.get(i).equals("-"))
				{
					digits.set(i, digits.get(i) - digits.get(i+1));
					operators.remove(i);
					digits.remove(i+1);
					i--;
				}
			//вывод результата
			System.out.print("Результат: " + digits.get(0));
		}
	}

}

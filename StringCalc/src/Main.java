import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		//���� ���������
		System.out.print("������� ���������: ");
		Scanner scanner = new Scanner(System.in);
		String expression = scanner.nextLine();
		scanner.close();
		//������ ��� �������� �� ������������ �����
		Pattern patternErr = Pattern.compile("[^\\d\\.\\s\\+\\-\\*/]|(\\D\\.)|(\\.\\D)|(^\\s*\\D)|(\\D\\s*$)|([\\+\\-\\*/]\\s*[\\+\\-\\*/])|(\\d\\s+\\d)");
		Matcher matcherErr = patternErr.matcher(expression);
		//�������� ������������ �����
		if (matcherErr.find()) {
			System.out.print("������������ ����");
		}
		else {
			//������ ���������� � ���������
			ArrayList<Double> digits = new ArrayList<Double>();
			ArrayList<String> operators = new ArrayList<String>();
			//���������� ������ ���������
			Pattern patternD = Pattern.compile("\\d+(\\.\\d+)?");
			Matcher matcherD = patternD.matcher(expression);
			while (matcherD.find())
				digits.add(Double.parseDouble(matcherD.group()));
			//���������� ������ ����������
			Pattern patternOp = Pattern.compile("[\\+\\-\\*/]");
			Matcher matcherOp = patternOp.matcher(expression);
			while (matcherOp.find())
				operators.add(matcherOp.group());
			//���������� ���������
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
			//����� ����������
			System.out.print("���������: " + digits.get(0));
		}
	}

}

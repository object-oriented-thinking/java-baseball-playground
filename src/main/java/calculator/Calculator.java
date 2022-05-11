package calculator;


import java.util.Scanner;

public class Calculator {
    public int calculate(String value){
        String[] values=value.split(" ");
        int result=Integer.valueOf(values[0]);

        for(int i=1;i<values.length;i++){
            if(i%2==0){
                int number = Integer.parseInt(values[i]);
                if(values[i-1].equals("+")) result +=number;
                else if(values[i-1].equals("-")) result -=number;
                else if(values[i-1].equals("/")) result /=number;
                else if(values[i-1].equals("*")) result *=number;
            }
        }
        return result;
    }

    public static void main(String[] args) {
       Calculator calculator  = new Calculator();
       Scanner scanner = new Scanner(System.in);
       String value = scanner.nextLine();

        System.out.println(calculator.calculate(value));
    }
}

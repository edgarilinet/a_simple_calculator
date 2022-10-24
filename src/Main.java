import java.util.InputMismatchException;
import java.util.Scanner;

/*      -Калькулятор считывает число.
        -После этого считывает операцию, которую необходимо выполнить. Давайте ограничимся простыми операциями: сложение, вычитание, умножение и деление.
        -Считывает второй операнд.
        -После выполнения операции калькулятор выводит получившееся значение.
        -Настоящий калькулятор выполняет операцию, например, складывает 2 и 3, и после этого получившийся результат становится первым операндом для новой операции.
            То есть на экран калькулятора будет выведено 5, а после этого вы можете вводить новую операцию.
        -Как только пользователь вводит символ C предыдущие вычисления сбрасываются, результат обнуляется и весь процесс начинается сначала.
        -Добавьте кнопку выключения. При вводе команды s программа должна завершать свою работу.
        */
public class Main {
    public static void main(String[] args) {
        boolean infinity = false;
        while (!infinity) {
            float operandA = 0f, operandB = 0f, result = 0f; //объявление всех переменных (при бесконечном цикле надо сбросить старые значения
            char operator = '=';
            System.out.println("""
                    Hi, I'm a simple calculator. 
                                      INSTRUCTIONS:
                                    - To turn off the calculator, enter "s" in the body of the operator\s
                                    - In order not to perform calculations with the previous result, enter "c" in the operator field
                    Enter what you need to count.\s
                    First, enter the first operand"""); // описание и инструкции на английском так как мой компилятор не поддерживает русские буквы (гуглом пользовался :с)
            operandA = vvodChisel();
            while (operator != 'c') { // для выхода из режима счета по предыдущему
                System.out.println("Now enter the action sign");
                operator = vvodOperator();
                if (operator == 's') System.exit(1); // для выключения программы
                if (operator != 'c') { // для того чтобы не делать лишних действий
                    System.out.println("now lead the second operand");
                    operandB = vvodChisel();
                    result = math(operandA, operandB, operator, result);
                    System.out.println(operandA + " " + operator + " " + operandB + " = " + result);
                    operandA = result;
                }
            }
        }
    }
//    ввод чисел + проверка ввода
    public static float vvodChisel(){
        float number = 0f;
        Scanner sc = new Scanner(System.in);
        try { // проверка ввода (чтобы число было числом)
            number = sc.nextFloat();
        } catch (InputMismatchException exc){
            System.out.println("input error, enter a number");
            number = vvodChisel();
        }
        return number;
    }
//    ввод знака плюс проверка ввода знака
    public static char vvodOperator(){
        char operator;
        Scanner sc = new Scanner(System.in);
        operator = sc.next().charAt(0); // проверка знака и выключения
        if (!(operator == '+' | operator == '-' | operator =='*' | operator =='/' | operator == 'c'| operator == 's')){
            System.out.println("input error, enter a operator ( + | - | * | / ) - ");
            operator = vvodOperator();
        }
        return operator;
    }
//    блок математики
    public static float math (float operandA, float operandB, char operator, float result){
        switch (operator){
            case ('+') -> result = operandA + operandB;
            case ('-') -> result = operandA - operandB;
            case ('*') -> result = operandA * operandB;
            case ('/') -> result = operandA / operandB;
        }
        return result;
    }
}
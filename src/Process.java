import java.util.Scanner;

public class Process {
    static Scanner scanner = new Scanner(System.in);
    public static void process(){
        double[] massive = new double[3];
        boolean flag = false;
        int j = 0;
        for (int i = 0; ; i++) {
            menu();
            int validation = validation();
            switch (validation) {
                case 0:
                    exit();
                    return;
                case 1:
                    flag = true;
                    massive[j] = calculation();
                    j++;
                    if(j == massive.length ) {
                        j = 0;
                    };
                    break;
                case 2:
                    if (flag == true) {
                        System.out.println("История операций:");
                        for (int y = 0; y < massive.length; y++) {
                            System.out.println(massive[y]);
                        }
                    } else System.out.println("История операций пуста");
                    break;
            }
        }

    }

    public static void menu(){
        System.out.println("Чтобы произвести математическую операцию, введите 1.");
        System.out.println("Чтобы посмотреть историю операций, введите 2.");
        System.out.println("Для выхода из калькулятора введите 0.");
    }

    public static double calculation (){
        double number1 = getNum1();
        double number2 = getNum2();
        String operation = getOperation();
        double result = result(number1, number2, operation);
        System.out.println("Результат: " + result);
        return result;
    }
//Чтение и проверка введенного числа на определение операции + возвращаем
    public static int validation(){
        int number;
        while (true) {
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                if (number >= 0 && number < 3) {
                    return number;
                }
            }
            else
                scanner.next();
            System.out.println("Ввели некорректные данные. Введите 0, 1 либо 2:");
        }
    }
//Читаем и проверяем первое число + возвращаем
    private static double getNum1(){
        System.out.println("Введите первое число:");
        double number;
        while (true) {
            if (scanner.hasNextDouble()){
                number = scanner.nextDouble();
                return number;
            }
            else
                scanner.next();
            System.out.println("Ввели некорректные данные. Введите первое число:");
        }
    }
//Читаем и проверяем второе число + возвращаем
    private static double getNum2(){
        System.out.println("Введите второе число:");
        double number;
        while (true) {
            if (scanner.hasNextDouble()){
                number = scanner.nextDouble();
                return number;
            }
            else
                scanner.next();
            System.out.println("Ввели некорректные данные. Введите второе число:");
        }
    }
//Читаем и проверяем введенную операцию + возвращаем
    private static String getOperation(){
        System.out.println("Введите операцию");
        String operation;
        while (true) {
            if (scanner.hasNext()){
                operation = scanner.next();
                return operation;
            }
            else
                scanner.nextDouble();
            System.out.println("Ввели некорректные данные. Введите число:");
        }
    }
//Считаем и возвращаем результат
    public static double result (double number1, double number2, String operation){
        double result;
        switch (operation){
            case "+" :
                result = number1 + number2;
                break;
            case "-" :
                result = number1 - number2;
                break;
            case "*" :
                result = number1 * number2;
                break;
            case "/" :
                result = number1 / number2;
                break;
            default:
                System.out.println("Ввелие некорректные данные. Введите операцию:");
                result = result(number1, number2, getOperation());
        }
        return result;
    }

    public static void exit(){
        System.out.println("Вы вышли из калькулятора.");
    }
}



import java.util.Scanner;

/**
 * Created by Admin on 16.03.2016.
 */
public class Main {
    static  Field field;
    static int  s = 0;
    public static void main(String [] args){
        field = new Field();
        field.playerData();
        for(int  i = 0; i<=8 ; i++){
            System.out.print(" "+field.getPlayerOne().getBalls(i)+" |");
        }
        System.out.println();
        System.out.println("-------------------------------------");
        for(int  i = 0; i<=8 ; i++){
            System.out.print(" "+field.getPlayerTwo().getBalls(i)+" |");
        }
        System.out.println();
        System.out.println("Казна");
        System.out.println("Первый игрок :" + field.getPlayerBoxOne());
        System.out.println("Второй игрок :" + field.getPlayerBoxTwo());

        while (true) {
            s++;
            Scanner sc = new Scanner(System.in);
            System.out.println();
            System.out.println("Введите целое число: ");
            if (sc.hasNextInt()) { // возвращает истинну если с потока ввода можно считать целое число
                System.out.println(s);
                if(s%2 == 0)
                    field.mainLogicGame(field.getPlayerTwo(), sc.nextInt());
                else if(s%2 == 1)
                    field.mainLogicGame(field.getPlayerOne(), sc.nextInt());
                for(int  i = 0; i<=8 ; i++){
                    System.out.print(" "+field.getPlayerOne().getBalls(i)+" |");
                }
                System.out.println();
                System.out.println("-------------------------------------");
                for(int  i = 0; i<=8 ; i++){
                    System.out.print(" "+field.getPlayerTwo().getBalls(i)+" |");
                }
                System.out.println();
                System.out.println("Казна");
                System.out.println("Первый игрок :" + field.getPlayerBoxOne());
                System.out.println("Второй игрок :" + field.getPlayerBoxTwo());
            } else {
                System.out.println("Вы ввели не целое число");
            }
        }
    }

}



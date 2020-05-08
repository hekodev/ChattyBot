import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

class Bot{
    protected String botName = "Alicia";
    protected int birthYear = Calendar.getInstance().get(Calendar.YEAR);
    protected String ownerName;
    private int ownerAge;

    public Bot(){
        present();
    }

    public Bot(String botName){
        this.botName = botName;
        present();
    }


    public Bot(String botName, int birthYear){
        this.botName = botName;
        this.birthYear = birthYear;
        present();
    }

    public void present(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(String.format("Welcome ! I'm your new personal assistant, %s.",getBotName()));
        System.out.println(String.format("I was created in %s.",getBirthYear()));
        System.out.println("Please, remind me your name:");
        setOwnerName(scanner.nextLine());
        System.out.println(String.format("What a great name you have, %s!",ownerName));
        System.out.println("Let me guess your age.");
        System.out.println("Enter remainders of dividing your age by 3, 5 and 7.");
        int[] array = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        initializeOwnerAge(array);
        System.out.println(String.format("Your age is %s; that's a good time to start programming!",getOwnerAge()));
    }

    public String getBotName(){
        return botName;
    }

    public int getBirthYear(){
        return birthYear;
    }

    public void setBotName(String botName){
        this.botName = botName;
    }

    public void setBirthYear(int birthYear){
        this.birthYear = birthYear;
    }

    public String getOwnerName(){
        return this.ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public int getOwnerAge(){
        return ownerAge;
    }

    public void setOwnerAge(int ownerAge){
        this.ownerAge = ownerAge;
    }

    public void initializeOwnerAge(int[] remainders){
        setOwnerAge((remainders[0] * 70 + remainders[1] * 21 + remainders[2] * 15) % 105);
    }

}

public class Main {

    public static void main(String[] args) {
        new Bot();
    }
}
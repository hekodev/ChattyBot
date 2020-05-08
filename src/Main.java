import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

class Bot{
    protected String botName = "Alicia";
    protected int birthYear = Calendar.getInstance().get(Calendar.YEAR);
    protected String ownerName;
    private int ownerAge;
    final static Scanner scanner = new Scanner(System.in);
    static boolean wrongAnswer = false;

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
        System.out.println(String.format("Welcome ! I'm your new personal assistant, %s.",getBotName()));
        System.out.println(String.format("I was created in %s.",getBirthYear()));
        setOwnerName();
        initializeOwnerAge();
        count();
        test();
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

    public void setOwnerName() {
        System.out.println("Please, remind me your name:");
        this.ownerName = scanner.nextLine();
        System.out.println(String.format("What a great name you have, %s!",getOwnerName()));
    }

    public int getOwnerAge(){
        return ownerAge;
    }

    public void setOwnerAge(int ownerAge){
        this.ownerAge = ownerAge;
    }

    public void initializeOwnerAge(){
        System.out.println("Let me guess your age.");
        System.out.println("Enter remainders of dividing your age by 3, 5 and 7.");
        int[] remainders = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        setOwnerAge((remainders[0] * 70 + remainders[1] * 21 + remainders[2] * 15) % 105);
        System.out.println(String.format("Oh wow I see, you are %s years old, that's a great!",getOwnerAge()));
    }

    public void count(){
        System.out.println("Now I will prove to you that I can count to any number you want. Enter a number:");
        String answer = scanner.nextLine();
        int count=0;
        try{
            count = Integer.parseInt(answer);
            if(count<0){
                System.out.println("Please enter a valid positive number:");
                count();
            }
        } catch (NumberFormatException e){
            System.out.println("Please enter a valid positive number:");
            count();
        } finally {
            for(int i=0; i<=count;i++){
                System.out.println(i+"!");
            }
        }
    }

    public void test(){
        if(!wrongAnswer) {
            System.out.println("Now, Let's test your Octopus knowledge.");
            System.out.println("How many hearts does an octopus have? :D");
            System.out.println("1. One");
            System.out.println("2. Two");
            System.out.println("3. Three");
            System.out.println("4. Four");
        }
        String answer = scanner.nextLine();
        if(answer.equals("3")){
            System.out.println("Congratulations! Here's more information:\n");
            String s = String.join("\n"
                    , "Octopuses have three hearts: one pumps blood around the body; the other two pump blood to the gills."
                    , "The reason for this impressive cardiac hardware probably comes down to the unusual composition of their blood."
                    , "\n"
                    , "Unlike vertebrates that have iron-rich haemoglobin packed into red blood cells, octopuses"
                    , "– along with some tarantulas, scorpions and horseshoe crabs –"
                    , "have copper-rich haemocyanin dissolved directly in their blood (this means their blood is blue!)."
                    , "\n"
                    , "Haemocyanin is less efficient than haemoglobin as an oxygen transporter."
                    , "The three hearts help to compensate for this by pumping blood at higher pressure around the body to supply the octopuses’ active lifestyle."
                    , "\n"
                    , "Have a nice day !"
            );
            System.out.println(s);
        } else{
            wrongAnswer=true;
            System.out.println("Please, try again:");
            test();
        }
    }
}

public class Main {

    public static void main(String[] args) {
        new Bot();
    }
}
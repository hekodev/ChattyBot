import java.util.Calendar;

class Bot{
    protected String botName = "Alicia";
    protected int birthYear = Calendar.getInstance().get(Calendar.YEAR);;

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
        System.out.println(String.format("Welcome ! I'm your new personal assistant, %s",getBotName()));
        System.out.println(String.format("I was created in %s",getBirthYear()));
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
}

public class Main {

    public static void main(String[] args) {
        Bot mybot = new Bot();
    }
}

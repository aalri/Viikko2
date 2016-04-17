package ohtu;

public class Submission {
    private String student_number;
    private int hours;
    private boolean a1;
    private boolean a2;
    private boolean a3;
    private boolean a4;
    private boolean a5;
    private boolean a6;
    private boolean a7;
    private boolean a8;
    private boolean a9;
    private boolean a10;
    private boolean a11;
    private boolean a12;
    private boolean a13;
    private boolean a14;
    private boolean a15;
    private boolean a16;
    private boolean a17;
    private boolean a18;
    private boolean a19;
    private boolean a20;
    private boolean a21;
    private int week;

    public int getHours() {
        return hours;
    }

    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    @Override
    public String toString() {
        return "viikko  "+ week +  ": tehtyjä tehtäviä yhteensä: " + sumAmountCompleted() + ", aikaa kului " + hours + " tuntia, tehdyt tehtävät " + nameMade();
    }
    
    private String nameMade() {
        String tasks = "";
        if (a1)tasks = tasks + " 1";
        if (a2)tasks = tasks + " 2";
        if (a3)tasks = tasks + " 3";
        if (a4)tasks = tasks + " 4";
        if (a5)tasks = tasks + " 5";
        if (a6)tasks = tasks + " 6";
        if (a7)tasks = tasks + " 7";
        if (a8)tasks = tasks + " 8";
        if (a9)tasks = tasks + " 9";
        if (a10)tasks = tasks + " 10";
        if (a11)tasks = tasks + " 11";
        if (a12)tasks = tasks + " 12";
        if (a13)tasks = tasks + " 13";
        if (a14)tasks = tasks + " 14";
        if (a15)tasks = tasks + " 15";
        if (a16)tasks = tasks + " 16";
        if (a17)tasks = tasks + " 17";
        if (a18)tasks = tasks + " 18";
        if (a19)tasks = tasks + " 19";
        if (a20)tasks = tasks + " 20";
        if (a21)tasks = tasks + " 21";
        return tasks;
    } 
    
    public int sumAmountCompleted() {
        int amount = 0;
        if (a1)amount++;
        if (a2)amount++;
        if (a3)amount++;
        if (a4)amount++;
        if (a5)amount++;
        if (a6)amount++;
        if (a7)amount++;
        if (a8)amount++;
        if (a9)amount++;
        if (a10)amount++;
        if (a11)amount++;
        if (a12)amount++;
        if (a13)amount++;
        if (a14)amount++;
        if (a15)amount++;
        if (a16)amount++;
        if (a17)amount++;
        if (a18)amount++;
        if (a19)amount++;
        if (a20)amount++;
        if (a21)amount++;

        return amount;
    }
    
}
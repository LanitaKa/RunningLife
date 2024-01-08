import java.util.Random;
import java.util.Scanner;

public class Person {
    String gender;
    int budget;
    int iq;
    int lifeExpectancy;
    String profession;
    boolean isMarried;


    Person(){
        Random random = new Random();
        this.gender = getGender();
        this.budget = getBudget();
        this.iq = getIq();
        this.lifeExpectancy = getLifeExpectancy();
        this.profession = "";
        this.isMarried = false;
    }

    private String getGender(){
        Random random = new Random();
        int randomNumber = random.nextInt(2);
        if (randomNumber == 0 ) {
            this.gender = "Man";
        } else this.gender = "Woman";
        return this.gender;
    }

    private int getBudget(){
        return (int) (100000 + Math.random() * 30000);
    }

    private int getIq(){
        return (int) (70 + Math.random() * 80);
    }

    private int getLifeExpectancy(){
        Random random = new Random();
        if (this.gender.equals("Man")) {
            this.lifeExpectancy = random.nextInt(26) + 65;
        } else {
            this.lifeExpectancy = random.nextInt(26) + 70;
        }
        return this.lifeExpectancy;
    }

    public void runLife(){
        int age = 0;
        System.out.println("Food and clothing are the major expenses for a child under the age of 6");
        pause();

        while (this.budget > 0 || age < this.lifeExpectancy * 12){
            age++;

            this.budget -= new Random().nextInt(10)+50;
            int year = age / 12;
            int month = age % 12;
            if (month == 0) {
                System.out.println("Happy birthday! You are  " + year +  " years old");
            } else {
                System.out.println("You are " + year +  " years and " + month +" months old");
            }

            if (age == 6*12){
                System.out.println();
                System.out.println("Food, clothing, and education are the major expenses of a school child");
                pause();
            }

            if (age == 18*12){
                System.out.println();
                System.out.println("Food, clothing, education, and house rent are the major expenses of a student. But a student works to earn a little money");
                System.out.println();
                professionChoice();
                pause();
            }


            if (age == 25*12){
                System.out.println();
                System.out.println("Food, clothing, vacations and renting a house are the basic expenses of every adult. Every person earns some money to support his or her life");
                System.out.println();
                setProfession();
                pause();
            }

            if (age == 60*12){
                System.out.println();
                System.out.println("A person has gone on a well-deserved vacation. He receives a pension.  Food, clothing, recreation and renting a house are the main expenses");
                pause();
            }

            if (age <= (6*12)){
                preschooler();
            }

            if (age > (6*12) &&  age <= (18*12) ){
                schooler();
            }

            if (age > (18*12) &&  age <= (25*12) ){
                student();
            }

            if (age >= (25*12) && !this.isMarried && age % 12 == 0 && age < (60*12)){
                this.isMarried = tryToGetMarried();
            }

            if (age > (25*12) &&  age <= (60*12) ){
                adult();
            }

            if (age > (60*12)){
                pensioner();
            }

            if (age % 13 == 0 && age > (18*12)){
                surprises();
            }

            if (this.budget <= 0) {
                System.out.println();
                System.out.println("You are bankrupt. Life is over");
                break;
            }
            if (age > this.lifeExpectancy * 12) {
                System.out.println();
                System.out.println("The limit of life expectancy has been reached. You've lived " + year + " years. Life is over");
                break;
            }
        }
    }

    public void preschooler(){
        int foodExpense = new Random().nextInt(25)+90;
        int clothingExpense = new Random().nextInt(25)+20;
        int expense = foodExpense + clothingExpense;

        this.budget -= expense;
        System.out.println("Food expense: " + foodExpense +  " Clothing expenses: " + clothingExpense);
        System.out.println("Expense: " + expense +  " Budget: " + this.budget);
    }

    public void schooler(){
        int foodExpense = new Random().nextInt(80)+160;
        int clothingExpense = new Random().nextInt(25)+20;
        int educationExpense = new Random().nextInt(80)+160;
        int expense = foodExpense + clothingExpense + educationExpense;

        this.budget -= expense;
        System.out.println("Food expense: " + foodExpense +  " Clothing expenses: " + clothingExpense + " Education expenses: " + educationExpense);
        System.out.println("Expense: " + expense +  " Budget: " + this.budget);
    }

    public void student(){
        int foodExpense = new Random().nextInt(80)+260;
        int clothingExpense = new Random().nextInt(50)+50;
        int educationExpense;
        if (this.iq <= 90) {
            educationExpense = new Random().nextInt(40)+130;
        } else if ((this.iq > 90 && this.iq <=110)) {
            educationExpense = new Random().nextInt(100)+250;
        } else {
            educationExpense = new Random().nextInt(100)+450;
        }
        int homeExpense = new Random().nextInt(100)+200;

        int expense = foodExpense + clothingExpense + educationExpense + homeExpense;

        int salary = new Random().nextInt(400)+800;

        this.budget = this.budget - expense + salary;
        System.out.println("Food expense: " + foodExpense +  " Clothing expenses: " + clothingExpense + " Education expenses: " + educationExpense + " Home expenses: " + homeExpense);
        System.out.println("Expense: " + expense + " Salary: " + salary +  " Budget: " + this.budget);
    }

    public void adult(){
        int foodExpense = new Random().nextInt(80)+260;
        int clothingExpense = new Random().nextInt(40)+80;
        int homeExpense = new Random().nextInt(100)+250;
        int restExpense = new Random().nextInt(200)+200;
        int salary;
        if (this.iq <= 90) {
            salary = new Random().nextInt(400)+1400;
        } else if ((this.iq > 90 && this.iq <=110)) {
            salary = new Random().nextInt(600)+1800;
        } else {
            salary = new Random().nextInt(1000)+2600;
        }

        int expense = foodExpense + clothingExpense + restExpense + homeExpense;

        this.budget = this.budget - expense + salary;
        System.out.println("Food expense: " + foodExpense +  " Clothing expenses: " + clothingExpense + " Home expenses: " + homeExpense + " Rest expense: " + restExpense);
        System.out.println("Expense: " + expense + " Salary: " + salary +  " Budget: " + this.budget);
    }

    public void pensioner(){
        int foodExpense = new Random().nextInt(80)+260;
        int clothingExpense = new Random().nextInt(20)+40;
        int homeExpense = new Random().nextInt(100)+250;
        int restExpense = new Random().nextInt(200)+100;
        int pension;
        if (this.iq <= 90) {
            pension = new Random().nextInt(400)+600;
        } else if ((this.iq > 90 && this.iq <=110)) {
            pension = new Random().nextInt(600)+1000;
        } else {
            pension = new Random().nextInt(1000)+1500;
        }

        int expense = foodExpense + clothingExpense + restExpense + homeExpense;

        this.budget = this.budget - expense + pension;
        System.out.println("Food expense: " + foodExpense +  " Clothing expenses: " + clothingExpense + " Home expenses: " + homeExpense + " Rest expense: " + restExpense);
        System.out.println("Expense: " + expense + " Pension: " + pension +  " Budget: " + this.budget);
    }

    public void pause(){
        Scanner scanner = new Scanner(System.in);
        System.out.println ();
        System.out.println ("Press ENTER to continue");
        scanner.nextLine();
    }

    public void professionChoice(){
        String[] lowPofession = {"worker", "waiter", "salesman", "driver"};
        String[] middlePofession = {"engineer", "accountant", "lawyer", "teacher"};
        String[] highPofession = {"programmer", "scientist", "doctor", "judge"};
        Random random = new Random();

        if (this.iq <= 90) {
            int randomIndex = random.nextInt(lowPofession.length);
            this.profession = lowPofession[randomIndex];
        } else if ((this.iq > 90 && this.iq <=110)) {
            int randomIndex = random.nextInt(middlePofession.length);
            this.profession = middlePofession[randomIndex];
        } else {
            int randomIndex = random.nextInt(highPofession.length);
            this.profession = highPofession[randomIndex];
        }
        System.out.println ("You have been competitively selected for further training in your specialty: " + this.profession);
    }

    public void setProfession(){
        System.out.println ("Congratulations! You've graduated with a degree in specialization. Your specialty: " + this.profession);
    }

   public boolean tryToGetMarried(){
        Scanner scanner = new Scanner(System.in);
        System.out.println ();
        System.out.println ("Do you want to marry/get married? (yes/no)");
        String answer = scanner.next().toLowerCase();

        if (answer.equals("yes")){
            int weddingExpense = new Random().nextInt(500)+1000;
            int changeLifeExpectancy = new Random().nextInt(5)+2;
            System.out.println("Congratulations! You got married/remarried!");
            System.out.println("Your wedding expenses totaled: " + weddingExpense);
            this.budget -= weddingExpense;
            System.out.println("Budget: " + this.budget);
            this.lifeExpectancy += changeLifeExpectancy;
            return true;
        }
        else {
            System.out.println("You refused to marry/get married. Maybe next time?");
            System.out.println();
            return false;
        }
    }

   public void surprises(){
       int surpriseNumber = new Random().nextInt(2000);
       int plusYears = new Random().nextInt(10);
       System.out.println(surpriseNumber);
       if (surpriseNumber % 100 == 0) {
           System.out.println("You died in an automobile accident");
           this.lifeExpectancy = 0;
       }
       if (surpriseNumber % 51 == 0) {
           System.out.println("You've become an addict. It decreases the length of your life.");
           pause();
           this.lifeExpectancy -= 30;
       }
       if (surpriseNumber % 33 == 0) {
           System.out.println("You abuse alcohol. It shortens your lifespan.");
           pause();
           this.lifeExpectancy -= 20;
       }

       if (surpriseNumber % 47 == 0) {
           System.out.println("You smoke. It shortens your lifespan.");
           pause();
           this.lifeExpectancy -= 10;
       }

       if (surpriseNumber % 52 == 0) {
           System.out.println("Doing yoga. You'll live longer.");
           this.lifeExpectancy = this.lifeExpectancy + plusYears;
       }
       if (surpriseNumber % 17 == 0) {
           System.out.println("You eat right. You'll live longer.");
           pause();
           this.lifeExpectancy = this.lifeExpectancy + plusYears;
       }
       if (surpriseNumber % 24 == 0) {
           System.out.println("You exercise. You'll live longer.");
           pause();
           this.lifeExpectancy = this.lifeExpectancy + plusYears;
       }

       if (surpriseNumber % 29 == 0) {
           System.out.println("You get hardened. You'll live longer.");
           pause();
           this.lifeExpectancy = this.lifeExpectancy + plusYears;
       }
   }







}

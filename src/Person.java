import java.util.Random;
import java.util.Scanner;

public class Person {
    String gender;
    int budget;
    int iq;
    int lifeExpectancy;
    String profession;


    Person(){
        Random random = new Random();
        this.gender = getGender();
        this.budget = getBudget();
        this.iq = getIq();
        this.lifeExpectancy = getLifeExpectancy();
        this.profession = "";
    }

    private String getGender(){
        Random random = new Random();
        int randomNumber = random.nextInt(2);
        if (randomNumber == 0 ) {
            gender = "Man";
        } else gender = "Woman";
        return gender;
    }

    private int getBudget(){
        return (int) (100000 + Math.random() * 30000);
    }

    private int getIq(){
        return (int) (70 + Math.random() * 80);
    }

    private int getLifeExpectancy(){
        Random random = new Random();
        if (gender.equals("Man")) {
            lifeExpectancy = random.nextInt(26) + 65;
        } else {
            lifeExpectancy = random.nextInt(26) + 70;
        }
        return lifeExpectancy;
    }

    public void runLife(){
        int age = 0;
        System.out.println("Food and clothing are the major expenses for a child under the age of 6");
        pause();

        while (budget > 0 || age < lifeExpectancy * 12){
            age++;

            budget -= new Random().nextInt(10)+50;
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
                profession();
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

            if (age > (25*12) &&  age <= (60*12) ){
                adult();
            }

            if (age > (60*12)){
                pensioner();
            }

            if (budget <= 0) {
                System.out.println();
                System.out.println("You are bankrupt. Life is over");
                break;
            }
            if (age > lifeExpectancy * 12) {
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

        budget = budget - expense;
        System.out.println("Food expense: " + foodExpense +  " Clothing expenses: " + clothingExpense);
        System.out.println("Expense: " + expense +  " Budget: " + budget);
    }

    public void schooler(){
        int foodExpense = new Random().nextInt(80)+160;
        int clothingExpense = new Random().nextInt(25)+20;
        int educationExpense = new Random().nextInt(80)+160;
        int expense = foodExpense + clothingExpense + educationExpense;

        budget = budget - expense;
        System.out.println("Food expense: " + foodExpense +  " Clothing expenses: " + clothingExpense + " Education expenses: " + educationExpense);
        System.out.println("Expense: " + expense +  " Budget: " + budget);
    }

    public void student(){
        int foodExpense = new Random().nextInt(80)+260;
        int clothingExpense = new Random().nextInt(50)+50;
        int educationExpense;
        if (iq <= 90) {
            educationExpense = new Random().nextInt(40)+130;
        } else if ((iq > 90 && iq <=110)) {
            educationExpense = new Random().nextInt(100)+250;
        } else {
            educationExpense = new Random().nextInt(100)+450;
        }
        int homeExpense = new Random().nextInt(100)+200;

        int expense = foodExpense + clothingExpense + educationExpense + homeExpense;

        int salary = new Random().nextInt(400)+800;

        budget = budget - expense + salary;
        System.out.println("Food expense: " + foodExpense +  " Clothing expenses: " + clothingExpense + " Education expenses: " + educationExpense + " Home expenses: " + homeExpense);
        System.out.println("Expense: " + expense + " Salary: " + salary +  " Budget: " + budget);
    }

    public void adult(){
        int foodExpense = new Random().nextInt(80)+260;
        int clothingExpense = new Random().nextInt(40)+80;
        int homeExpense = new Random().nextInt(100)+250;
        int restExpense = new Random().nextInt(200)+200;
        int salary;
        if (iq <= 90) {
            salary = new Random().nextInt(400)+1400;
        } else if ((iq > 90 && iq <=110)) {
            salary = new Random().nextInt(600)+1800;
        } else {
            salary = new Random().nextInt(1000)+2600;
        }

        int expense = foodExpense + clothingExpense + restExpense + homeExpense;

        budget = budget - expense + salary;
        System.out.println("Food expense: " + foodExpense +  " Clothing expenses: " + clothingExpense + " Home expenses: " + homeExpense + " Rest expense: " + restExpense);
        System.out.println("Expense: " + expense + " Salary: " + salary +  " Budget: " + budget);
    }

    public void pensioner(){
        int foodExpense = new Random().nextInt(80)+260;
        int clothingExpense = new Random().nextInt(20)+40;
        int homeExpense = new Random().nextInt(100)+250;
        int restExpense = new Random().nextInt(200)+100;
        int pension;
        if (iq <= 90) {
            pension = new Random().nextInt(400)+600;
        } else if ((iq > 90 && iq <=110)) {
            pension = new Random().nextInt(600)+1000;
        } else {
            pension = new Random().nextInt(1000)+1500;
        }

        int expense = foodExpense + clothingExpense + restExpense + homeExpense;

        budget = budget - expense + pension;
        System.out.println("Food expense: " + foodExpense +  " Clothing expenses: " + clothingExpense + " Home expenses: " + homeExpense + " Rest expense: " + restExpense);
        System.out.println("Expense: " + expense + " Pension: " + pension +  " Budget: " + budget);
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

        if (iq <= 90) {
            int randomIndex = random.nextInt(lowPofession.length);
            this.profession = lowPofession[randomIndex];
        } else if ((iq > 90 && iq <=110)) {
            int randomIndex = random.nextInt(middlePofession.length);
            this.profession = middlePofession[randomIndex];
        } else {
            int randomIndex = random.nextInt(highPofession.length);
            this.profession = highPofession[randomIndex];
        }
        System.out.println ("You have been competitively selected for further training in your specialty: " + this.profession);
    }

    public void profession(){
        System.out.println ("Congratulations! You've graduated with a degree in specialization. Your specialty: " + this.profession);
    }



}

import java.util.*;

class Management extends Admin
{
    Scanner sc=new Scanner(System.in);

    double dailyIncome=0;

    ArrayList<Person> defenceStaff = new ArrayList<>();
    ArrayList<Person> medicalStaff = new ArrayList<>();
    ArrayList<Person> atcStaff = new ArrayList<>();

    Person getPersonDetails()
    {
        System.out.print("Enter Name: ");
        String name=sc.next();

        System.out.print("Enter Post: ");
        String post=sc.next();

        System.out.print("Enter Age: ");
        int age=sc.nextInt();

        System.out.print("Enter Mobile: ");
        long mobile=sc.nextLong();

        sc.nextLine();
        System.out.print("Enter Address: ");
        String address=sc.nextLine();

        return new Person(name,post,age,mobile,address);
    }

    void addDefenceStaff()
    {
        defenceStaff.add(getPersonDetails());
        System.out.println("Defence Staff Added");
    }

    void showDefenceStaff()
    {
        for(Person p:defenceStaff)
        {
            p.display();
        }
    }

    void addMedicalStaff()
    {
        medicalStaff.add(getPersonDetails());
        System.out.println("Medical Staff Added...");
    }

    void showMedicalStaff()
    {
        for(Person p:medicalStaff)
        {
            p.display();
        }
    }

    void addATCStaff()
    {
        atcStaff.add(getPersonDetails());
        System.out.println("ATC Staff Added...");
    }

    void showATCStaff()
    {
        for(Person p:atcStaff)
        {
            p.display();
        }
    }

    void addDailyIncome()
    {
        System.out.print("Enter Today's Income: ₹");
        dailyIncome+=sc.nextDouble();
        System.out.println("Income Added");
    }

    void showTotalIncome()
    {
        System.out.println("Total Income: ₹"+dailyIncome);
    }

    void managementMenu()
    {
        int choice;

        do
        {
            System.out.println("----- MANAGEMENT MENU -----");

            System.out.println("1. Hire Staff");
            System.out.println("2. Fire Staff");
            System.out.println("3. View All Staff");
            System.out.println("4. Make Flight Schedule");
            System.out.println("5. Add Defence Staff");
            System.out.println("6. View Defence Unit");
            System.out.println("7. Add Medical Staff");
            System.out.println("8. View Medical Unit");
            System.out.println("9. Add ATC Staff");
            System.out.println("10. View ATC Unit");
            System.out.println("11. Add Daily Income");
            System.out.println("12. Show Total Income");
            System.out.println("0. Exit");

            System.out.print("Enter Choice: ");
            choice=sc.nextInt();

            switch(choice)
            {
                case 1:
                {
                    Hire_Staff();
                    break;
                }

                case 2:
                {
                    Fire_Staff();
                    break;
                }

                case 3:
                {
                    StaffMembers();
                    break;
                }

                case 4:
                {
                    SetFlightSchedule();
                    break;
                }

                case 5:
                {
                    addDefenceStaff();
                    break;
                }

                case 6:
                {
                    showDefenceStaff();
                    break;
                }

                case 7:
                {
                    addMedicalStaff();
                    break;
                }

                case 8:
                {
                    showMedicalStaff();
                    break;
                }

                case 9:
                {
                    addATCStaff();
                    break;
                }

                case 10:
                {
                    showATCStaff();
                    break;
                }

                case 11:
                {
                    addDailyIncome();
                    break;
                }

                case 12:
                {
                    showTotalIncome();
                    break;
                }

                case 0:
                {
                    System.out.println("Exiting");
                    break;
                }

                default:
                {
                    System.out.println("Invalid Choice");
                    break;
                }
            }

        } while(choice!=0);
    }
}
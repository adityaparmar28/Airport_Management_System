import java.util.*;

class Admin extends Staff
{
    Scanner sc=new Scanner(System.in);
    static Staff[] staffList=new Staff[10];
    static int StaffCount=0;
    static Flight[] flights=new Flight[10];
    static int flightCount=0;

    void AdminMenu()
    {
        int ch;

        do
        {
            System.out.println("1. Hire Staff");
            System.out.println("2. Fire Staff");
            System.out.println("3. View Staff Members");
            System.out.println("4. Make Flight Schedule");
            System.out.println("5. View Flight Schedule");
            System.out.println("0. Exit");

            System.out.println("Enter which activity you want to do???");
            ch = sc.nextInt();

            switch (ch)
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
                    ViewFlights();
                    break;
                }

                case 0:
                {
                    System.out.println("Exiting...");
                }
            }

        }while (ch!=0);
    }

    void Hire_Staff()
    {
        if (StaffCount >= staffList.length)
        {
            System.out.println("Staff Limit Reached");
            return;
        }

        System.out.print("Enter Admin Verification Code: ");
        int code = sc.nextInt();

        if (code == 1234)
        {
            System.out.println("Admin Verified..");

            Staff s = new Staff();

            System.out.print("Enter Staff ID: ");
            String id = sc.next();
            for(int i=0; i<StaffCount; i++)
            {
                if(staffList[i].StaffID.equals(id))
                {
                    System.out.println("Staff ID Already Exists.");
                    return;
                }
            }
            s.StaffID = id;

            System.out.print("Enter Employee Name: ");
            s.SMember_name = sc.next();

            System.out.print("Enter Employee Role: ");
            s.Role = sc.next();

            staffList[StaffCount++] = s;
            System.out.println("Employee Hired Successfully..!!");
        }
        else
        {
            System.out.println("Admin Verification Failed..!!");
        }
    }

    void Fire_Staff()
    {
        System.out.print("Enter Staff ID to fire: ");
        String id = sc.next();

        for(int i=0; i<StaffCount; i++)
        {
            if(staffList[i].StaffID.equals(id))
            {
                for(int j=i; j<StaffCount-1; j++)
                {
                    staffList[j] = staffList[j+1];
                }

                staffList[StaffCount-1] = null;
                StaffCount--;

                System.out.println("Staff Fired Successfully..!!");

                return;
            }
        }
        System.out.println("Staff Not Found..!!");
    }

    void StaffMembers()
    {
        for(int i=0;i<StaffCount;i++)
        {
            System.out.println((i+1)+". "+staffList[i].SMember_name+" | ID: "+staffList[i].StaffID+" | Role: "+staffList[i].Role);
        }
    }

    void SetFlightSchedule()
    {
        if(flightCount >= flights.length)
        {
            System.out.println("Flight Schedule Full.");
            return;
        }

        System.out.print("Enter Flight Number: ");
        String fno = sc.next();
        for(int i=0; i<flightCount; i++)
        {
            if(flights[i].flightNo.equalsIgnoreCase(fno))
            {
                System.out.println("Flight Number Already Exists.");
                return;
            }
        }

        System.out.print("Origin: ");
        String ori=sc.next();

        System.out.print("Destination: ");
        String des=sc.next();

        System.out.print("Date(DD-MM-YYYY): ");
        String date=sc.next();

        System.out.print("Time(HH:MM): ");
        String time=sc.next();

        System.out.print("Status: ");
        String status=sc.next();

        Flight f=new Flight(fno,ori,des,date,time,status);
        flights[flightCount++]=f;

        System.out.println("Flight Scheduled Successfully....");
    }

    void ViewFlights()
    {
        if(flightCount==0)
        {
            System.out.println("No Flights Scheduled.");
            return;
        }

        for(int i=0; i<flightCount; i++)
        {
            Flight f = flights[i];

            System.out.println("-------------------------");
            System.out.println("Flight No : " + f.flightNo);
            System.out.println("Origin    : " + f.origin);
            System.out.println("Destination : " + f.destination);
            System.out.println("Date      : " + f.date);
            System.out.println("Time      : " + f.time);
            System.out.println("Status    : " + f.status);
        }
    }
}
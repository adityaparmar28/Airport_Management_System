import java.util.*;

class Passenger
{
    Scanner sc=new Scanner(System.in);

    String FName;
    String Surname;
    String email;
    String Address;
    String dob;
    String LStatus;
    long m_no;
    int Total_Passenger;
    double weight;
    String refNo;

    static Passenger[] Booked_Tickets=new Passenger[100];
    static Passenger[] Cancelled_Tickets=new Passenger[100];

    static int Booked_Count=0;
    static int Cancelled_Count=0;

    String flightNo;
    String origin;
    String destination;
    String date;
    String time;

    void PassengerMenu()
    {
        int ch1;

        do
        {
            System.out.println("------------------------------------");
            System.out.println("-----| SERVICES FOR PASSENGER |-----");
            System.out.println("------------------------------------");
            System.out.println("1. Flight Schedule.");
            System.out.println("2. Flight Ticket Booking.");
            System.out.println("3. Flight Ticket Cancellation.");
            System.out.println("4. Flight Status.");
            System.out.println("5. Luggage Status.");
            System.out.println("6. User Profile.");
            System.out.println("7. Logout");

            System.out.print("Enter Service Option: ");
            ch1 = sc.nextInt();

            switch (ch1)
            {
                case 1:
                {
                    Flight_Schedule();
                    break;
                }

                case 2:
                {
                    Ticket_Booking();
                    break;
                }

                case 3:
                {
                    Ticket_Cancellation();
                    break;
                }

                case 4:
                {
                    F_Status();
                    break;
                }

                case 5:
                {
                    Luggage_Status();
                    break;
                }

                case 6:
                {
                    User_Profile();
                    break;
                }

                case 7:
                {
                    Logout();
                    break;
                }

                default:
                {
                    System.out.println("Enter Valid Service..!!");
                }
            }
        }while (ch1!=7);
    }

    void Flight_Schedule()
    {
        if (Admin.flightCount == 0)
        {
            System.out.println("No Flights Scheduled Yet..!!");
            return;
        }

        System.out.println("-----| AVAILABLE FLIGHTS |-----");

        for (int i = 0; i < Admin.flightCount; i++)
        {
            Flight f = Admin.flights[i];

            System.out.println("------------------------------");
            System.out.println("Flight No: " + f.flightNo);
            System.out.println("From: " + f.origin);
            System.out.println("To: " + f.destination);
            System.out.println("Date: " + f.date);
            System.out.println("Time: " + f.time);
            System.out.println("Status: " + f.status);
        }
    }

    void Trip(Flight selectedFlight,int t)
    {
        System.out.print("Enter Destination: ");
        String Destination=sc.next();

        System.out.print("Enter Origin: ");
        String Origin=sc.next();

        System.out.print("Enter Departure Date(DD-MM-YYYY): ");
        String Departure=sc.next()+"-"+sc.next()+"-"+sc.next();

        sc.nextLine();
        System.out.print("Enter Return Date(DD-MM-YYYY): ");
        String Return=sc.next()+"-"+sc.next()+"-"+sc.next();
        sc.nextLine();

        System.out.print("Adult: ");
        int adult=sc.nextInt();

        System.out.print("Children: ");
        int child=sc.nextInt();

        Total_Passenger=adult+child;

        for (int i = 0; i < Total_Passenger; i++)
        {
            Booked_Tickets[Booked_Count] = new Passenger();

            System.out.println("PASSENGER " + (i + 1));

            System.out.print("First Name: ");
            Booked_Tickets[Booked_Count].FName = sc.next();

            System.out.print("Surname: ");
            Booked_Tickets[Booked_Count].Surname = sc.next();

            System.out.print("DOB: ");
            Booked_Tickets[Booked_Count].dob = sc.next();

            System.out.print("Mobile: ");
            Booked_Tickets[Booked_Count].m_no = sc.nextLong();

            System.out.print("Email: ");
            Booked_Tickets[Booked_Count].email = sc.next();

            sc.nextLine();
            System.out.print("Address: ");
            Booked_Tickets[Booked_Count].Address = sc.nextLine();

            System.out.print("Luggage Weight: ");
            Booked_Tickets[Booked_Count].weight = sc.nextDouble();

            Booked_Tickets[Booked_Count].LStatus=(Booked_Tickets[Booked_Count].weight<=15)?"Checked-In":"Not Allowed";

            Booked_Tickets[Booked_Count].refNo = "AAI" + (1000 + Booked_Count);

            Booked_Count++;
        }

        System.out.println("Ticket Successfully Booked..!!");

        Ticket_Details();
    }

    void Trip(Flight selectedFlight,char t)
    {
        System.out.print("Enter Destination: ");
        String Destination=sc.next();

        System.out.print("Enter Origin: ");
        String Origin=sc.next();

        System.out.print("Enter Departure Date(DD-MM-YYYY): ");
        String Departure=sc.next()+"-"+sc.next()+"-"+sc.next();
        sc.nextLine();

        System.out.print("Adult: ");
        int adult=sc.nextInt();

        System.out.print("Children: ");
        int child=sc.nextInt();

        Total_Passenger=adult+child;

        for (int i = 0; i < Total_Passenger; i++)
        {
            Booked_Tickets[Booked_Count] = new Passenger();

            Booked_Tickets[Booked_Count].flightNo=selectedFlight.flightNo;
            Booked_Tickets[Booked_Count].origin=selectedFlight.origin;
            Booked_Tickets[Booked_Count].destination=selectedFlight.destination;
            Booked_Tickets[Booked_Count].date=selectedFlight.date;
            Booked_Tickets[Booked_Count].time=selectedFlight.time;

            System.out.println("PASSENGER " + (i + 1));

            System.out.print("First Name: ");
            Booked_Tickets[Booked_Count].FName = sc.next();

            System.out.print("Surname: ");
            Booked_Tickets[Booked_Count].Surname = sc.next();

            System.out.print("DOB: ");
            Booked_Tickets[Booked_Count].dob = sc.next();

            System.out.print("Mobile: ");
            Booked_Tickets[Booked_Count].m_no = sc.nextLong();

            System.out.print("Email: ");
            Booked_Tickets[Booked_Count].email = sc.next();

            sc.nextLine();
            System.out.print("Address: ");
            Booked_Tickets[Booked_Count].Address = sc.nextLine();

            System.out.print("Luggage Weight: ");
            Booked_Tickets[Booked_Count].weight = sc.nextDouble();

            Booked_Tickets[Booked_Count].LStatus=(Booked_Tickets[Booked_Count].weight<=15)?"Checked-In":"Not Allowed";

            Booked_Tickets[Booked_Count].refNo = "AAI" + (1000 + Booked_Count);

            Booked_Count++;
        }

        System.out.println("Ticket Successfully Booked..!!");

        Ticket_Details();
    }

    void Trip_Type(Flight selectedFlight)
    {
        System.out.println("1. ROUND TRIP");
        System.out.println("2. ONE WAY TRIP");
        System.out.print("Enter Trip way: ");
        int CHT = sc.nextInt();

        switch (CHT)
        {
            case 1:
            {
                //Trip(0);
                Trip(selectedFlight,0);
                break;
            }
            case 2:
            {
                //Trip('O');
                Trip(selectedFlight,'O');
                break;
            }

            default:
            {
                System.out.println("Invalid Trip Choice..!!");
                break;
            }
        }
    }

    void Ticket_Booking()
    {
        if(Admin.flightCount==0)
        {
            System.out.println("No Flight Available.");
            return;
        }

        System.out.println("Choose Class:");
        System.out.println("1. First Class 2. Business Class 3. Premium Economy 4. Economy");
        int chT=sc.nextInt();

        System.out.println("AVAILABLE FLIGHTS |----");

        for(int i=0;i<Admin.flightCount;i++)
        {
            Flight f=Admin.flights[i];

            System.out.println((i+1)+". " +f.flightNo+" | " +f.origin+" -> " +f.destination+" | " +f.date+" | " +f.time);
        }

        System.out.print("Select Flight: ");
        int flightChoice=sc.nextInt();

        if(flightChoice<1 || flightChoice>Admin.flightCount)
        {
            System.out.println("Invalid Flight.");
            return;
        }

        Flight selectedFlight=Admin.flights[flightChoice-1];
        Trip_Type(selectedFlight);
    }

    void Ticket_Details()
    {
        for(int i=Booked_Count-Total_Passenger;i<Booked_Count;i++)
        {
            Passenger p = Booked_Tickets[i];
            System.out.println("| PASSENGER "+(i+1)+" |");
            System.out.println("-----------------------");
            System.out.println("| TICKET DETAILS |");
            System.out.println("Ticket Reference number: "+p.refNo);

            System.out.println("Flight Number : "+p.flightNo);
            System.out.println("Origin        : "+p.origin);
            System.out.println("Destination   : "+p.destination);
            System.out.println("Date          : "+p.date);
            System.out.println("Time          : "+p.time);

            System.out.println("| PASSENGER DETAILS |");
            System.out.println("Full Name: "+p.FName+" "+p.Surname);
            System.out.println("Date of Birth: "+p.dob);
            System.out.println("Mobile Number: "+p.m_no);
            System.out.println("Email ID: "+p.email);
            System.out.println("Address: "+p.Address);
            System.out.println("Luggage Weight: "+p.weight+" KG");
            System.out.println("Luggage Status: "+p.LStatus);
            System.out.println("=======================================");
        }
    }

    void Ticket_Cancellation()
    {
        System.out.print("Enter Booked Ticket Reference number: ");
        String Ref_num1=sc.next();

        for (int i = 0; i < Booked_Count; i++)
        {
            if (Booked_Tickets[i]!=null && Booked_Tickets[i].refNo.equals(Ref_num1))
            {
                Cancelled_Tickets[Cancelled_Count++]=Booked_Tickets[i];

                for(int j=i;j<Booked_Count-1;j++)
                {
                    Booked_Tickets[j]=Booked_Tickets[j+1];
                }

                Booked_Tickets[Booked_Count-1]=null;
                Booked_Count--;

                System.out.println("Ticket Cancelled Successfully");
                return;
            }
        }

        System.out.println("Invalid Ticket Reference Number");
    }

    void F_Status()
    {
        System.out.print("Enter Ticket Reference Number: ");
        String Ref_num1=sc.next();

        for (Passenger p: Booked_Tickets)
        {
            if(p!=null && p.refNo.equals(Ref_num1))
            {
                System.out.println("| FLIGHT STATUS |-----");
                for(int i=0;i<Admin.flightCount;i++)
                {
                    Flight f=Admin.flights[i];

                    if(f.flightNo.equals(p.flightNo))
                    {
                        System.out.println("Flight : "+f.flightNo);
                        System.out.println("Status : "+f.status);
                        System.out.println("Gate   : G"+(10+i));
                        return;
                    }
                }

                return;
            }
        }

        System.out.println("Invalid Reference Number");
    }

    void Luggage_Status()
    {
        System.out.print("Enter Ticket Reference Number: ");
        String Ref_num1=sc.next();

        for(Passenger p:Booked_Tickets)
        {
            if(p!=null && p.refNo.equals(Ref_num1))
            {
                System.out.println("Luggage Weight: "+p.weight+" KG");
                System.out.println("Status: "+p.LStatus);

                return;
            }
        }

        System.out.println("Ticket Not Found");
    }

    void User_Profile()
    {
        System.out.print("Enter Your Email: ");
        String mail = sc.next();

        for(Passenger p:Booked_Tickets)
        {
            if(p!=null && p.email.equals(mail))
            {
                System.out.println("Account ID: "+p.email);
                System.out.println("Name: "+p.FName+" "+p.Surname);
                System.out.println("DOB: "+p.dob);
                System.out.println("Mobile: "+p.m_no);
                System.out.println("Address: "+p.Address);

                return;
            }
        }

        System.out.println("Profile Not Found");
    }

    void Logout()
    {
        System.out.println("Logged Out");
    }
}
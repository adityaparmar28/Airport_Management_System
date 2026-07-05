import java.util.*;

class AirportManagementSystem
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

        Management mg=new Management();
        Passenger psg=new Passenger();
        LoginPage lp=new LoginPage();

        int role;

        do
        {
            System.out.println("----- AIRPORT MANAGEMENT SYSTEM -----");
            System.out.println("1. Passenger");
            System.out.println("2. Staff");
            System.out.println("3. Admin");
            System.out.println("4. Management");
            System.out.println("0. Exit");
            System.out.println("Select Role:");
            role=sc.nextInt();

            switch(role)
            {
                case 1:
                {
                    System.out.println("1. Sign Up");
                    System.out.println("2. Login");

                    int op=sc.nextInt();

                    switch(op)
                    {
                        case 1:
                        {
                            lp.userSignUp();

                            if(lp.userlogin())
                            {
                                psg.PassengerMenu();
                            }

                            break;
                        }

                        case 2:
                        {
                            if(lp.userlogin())
                            {
                                psg.PassengerMenu();
                            }

                            break;
                        }

                        default:
                        {
                            System.out.println("Invalid Choice");
                        }
                    }

                    break;
                }

                case 2:
                {
                    Staff s = new Staff();
                    s.StaffMenu();
                    break;
                }

                case 3:
                {
                    mg.AdminMenu();
                    break;
                }

                case 4:
                {
                    mg.managementMenu();
                    break;
                }

                case 0:
                {
                    System.out.println("Exiting System");
                    break;
                }

                default:
                {
                    System.out.println("Invalid Choice");
                    break;
                }
            }

        }while(role!=0);
    }
}

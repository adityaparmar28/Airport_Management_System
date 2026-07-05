import java.util.*;

class LoginPage
{
    Scanner sc=new Scanner(System.in);

    //>>>Variables assignation...

    String name;
    int dob;
    long m_no;
    String surname;
    String email;
    String UID;
    String passwd;
    String passwd1;
    String UID1;
    int atp=3;
    boolean status;
    boolean SDob=false;
    boolean Sm_no=false;
    String dobS;
    String m_noS;

    static LoginPage users[] = new LoginPage[100];
    static int userCount = 0;


    void DOB()
    {
        boolean born1=false; //for birth loop
        while(!born1)
        {

            while (!SDob)
            {
                System.out.print("ENTER YOUR DOB(DDMMYYYY): ");
                try
                {
                    dob = sc.nextInt();
                }
                catch (Exception e)
                {
                    System.out.println("Invalid DOB..!!");
                    sc.next();
                    continue;
                }

                dobS = String.valueOf(dob);
                if(dobS.charAt(0)==0 || dobS.length()==7)
                {
                    SDob=true;
                }
                else if(dobS.length() == 8 )
                {
                    SDob = true;
                }
                else
                {
                    System.out.println("Invalid DOB....");
                    System.out.println("DOB must be 8 Digits..!!");
                }
            }

            //>>>DOB validation for DD | MM | YYYY...

            int DD; //Date
            int MM; //Month
            int YYYY; //Year

            DD = dob / 1000000; //First 2 digits
            MM = (dob / 10000) % 100; //Middle 2 digits
            YYYY = dob % 10000; //Last 4 digits

            if (DD > 0 && DD < 32)
            {
                if (MM > 0 && MM < 13)
                {
                    if (YYYY <= 2026)
                    {
                        born1 = true;
                        return;
                    }
                    else
                    {
                        System.out.println("Invalid Year of Birth(YYYY).");
                        System.out.println("Try Again...");
                        SDob = false;
                    }
                }
                else
                {
                    System.out.println("Invalid Month of Birth(MM).");
                    System.out.println("Try Again...");
                    SDob = false;
                }
            }
            else
            {
                System.out.println("Invalid Date of Birth(DD).");
                System.out.println("Try Again...");
                SDob = false;
            }
        }
    }

    void M_NO()
    {
        boolean b=true;
        while(b)
        {
            System.out.print("ENTER YOUR MOBILE NUMBER: ");
            m_no=sc.nextLong();

            if(m_no>6000000000L && m_no<9999999999L)
            {
                b=false;
                break;
            }
            else
            {
                System.out.println("Enter Valid Mobile number..!!");
                System.out.println("Try Again....");
            }
        }

        m_noS=String.valueOf(m_no);

        while(!Sm_no)
        {
            if(m_noS.length()==10)
            {
                Sm_no=true;
            }
            else
            {
                System.out.println("Invalid Mobile Number....");
                System.out.println("Mobile number must be 10 Digits..!!");
            }
        }
    }

    void userSignUp()
    {
        System.out.print("Enter Your Name: ");
        name=sc.next();
        name=name.toUpperCase();

        System.out.print("Enter Your Surname: ");
        surname=sc.next();
        surname=surname.toUpperCase();

        System.out.print("Enter Your Email: ");
        email=sc.next();
        for(int i=0;i<userCount;i++)
        {
            if(users[i].email.equalsIgnoreCase(email))
            {
                System.out.println("Email Already Registered.");
                return;
            }
        }

        DOB();

        M_NO();
        for(int i=0;i<userCount;i++)
        {
            if(users[i].m_no==m_no)
            {
                System.out.println("Mobile Number Already Registered.");
                return;
            }
        }

        assign();
    }

    void UID_pass()
    {
        dobS=String.valueOf(dob);
        m_noS=String.valueOf(m_no);

        String dob4S=dobS.substring(dobS.length()-4);
        String m_no4S=m_noS.substring(m_noS.length()-4);

        int[] I_P=new int[8];
        int index=0;

        for(int i=0;i<4;i++) I_P[index++]=dob4S.charAt(i)-'0';
        for(int j=0;j<4;j++) I_P[index++]=m_no4S.charAt(j)-'0';

        Arrays.sort(I_P);

        UID="";
        for(int i=0;i<userCount;i++)
        {
            if(users[i].UID.equals(UID))
            {
                UID = UID + (userCount+1);
                break;
            }
        }
        for(int d: I_P)
        {
            UID+=d;
        }

        String name4f=name.substring(0,4);
        String ID4L=UID.substring(UID.length()-4);

        passwd=name4f+"@"+ID4L;

        System.out.println("YOUR USERID: "+UID);
        System.out.println("YOUR ID PASSWORD: "+passwd);
    }

    void assign()
    {
        System.out.println("--------------------------------------------------");
        System.out.println("-----| USER DETAILS |-----");
        System.out.println("Full Name: "+name+" "+surname);
        System.out.println("Mobile Number: "+m_no);
        System.out.println("Email ID: "+email);

        UID_pass();
        users[userCount++] = this;
        System.out.println("--------------------------------------------------");
    }

    boolean userlogin()
    {
        atp = 3;

        System.out.print("ENTER YOUR USERID: ");
        UID1 = sc.next();

        System.out.print("ENTER USER PASSWORD: ");
        passwd1 = sc.next();

        return IP_Auth();
    }

    boolean IP_Auth()
    {
        while(atp > 0)
        {
            for(int i=0; i<userCount; i++)
            {
                if(users[i].UID.equals(UID1) && users[i].passwd.equals(passwd1))
                {
                    System.out.println("------| YOU ARE SUCCESSFULLY LOGGED ON |------");
                    return true;
                }
            }

            atp--;

            if(atp > 0)
            {
                System.out.println("------| USER LOGIN FAILED |------");
                System.out.println("Attempt Left: " + atp);

                System.out.print("ENTER YOUR USERID: ");
                UID1 = sc.next();

                System.out.print("ENTER USER PASSWORD: ");
                passwd1 = sc.next();
            }
        }

        System.out.println("------| USER LOGIN BLOCKED |------");
        return false;
    }
}
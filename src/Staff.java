/*
 * Copyright 2026 MR. ADITYA PARMAR
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import java.util.*;

class Staff
{
    Scanner sc=new Scanner(System.in);
    String StaffID;
    String SMember_name;
    String Role;

    void StaffMenu()
    {
        int Staff_Ch;

        do
        {
            System.out.println("    STAFF MENU |----");

            System.out.println("1. Assign Boarding Pass");
            System.out.println("2. Passenger Details");
            System.out.println("3. Luggage Status");
            System.out.println("4. Flight Status");
            System.out.println("5. All Passengers");
            System.out.println("0. Exit");

            System.out.print("What do you want???: ");
            Staff_Ch = sc.nextInt();

            switch (Staff_Ch)
            {
                case 1:
                {
                    Boarding_Pass();
                    break;
                }

                case 2:
                {
                    Passenger_Details();
                    break;
                }

                case 3:
                {
                    Luggage_Status();
                    break;
                }

                case 4:
                {
                    Flight_Status();
                    break;
                }

                case 5:
                {
                    All_Passengers();
                    break;
                }

                case 0:
                {
                    System.out.println("Exiting....");
                    break;
                }

                default:
                {
                    System.out.println("Enter Valid Activity..!!");
                }
            }
        }while (Staff_Ch!=0);
    }

    void Boarding_Pass()
    {
        System.out.print("Enter Passenger Email: ");
        String email=sc.next();

        for(int i=0;i<Passenger.Booked_Count;i++)
        {
            Passenger p=Passenger.Booked_Tickets[i];

            if(p!=null && p.email.equalsIgnoreCase(email))
            {
                System.out.println("==================================");
                System.out.println("        BOARDING PASS");
                System.out.println("==================================");
                System.out.println("Passenger   : "+p.FName+" "+p.Surname);
                System.out.println("Flight No   : "+p.flightNo);
                System.out.println("Origin      : "+p.origin);
                System.out.println("Destination : "+p.destination);
                System.out.println("Date        : "+p.date);
                System.out.println("Time        : "+p.time);
                System.out.println("Gate        : G"+(10+i));
                System.out.println("Seat No     : A"+(i+1));
                System.out.println("Reference   : "+p.refNo);
                System.out.println("==================================");

                return;
            }
        }

        System.out.println("Passenger Not Found....");
    }

    void Passenger_Details()
    {
        System.out.print("Enter Passenger Email: ");
        String email = sc.next();

        for (Passenger p:Passenger.Booked_Tickets)
        {
            if(p!=null && p.email.equals(email))
            {
                System.out.println("Name: "+p.FName+" "+p.Surname);
                System.out.println("DOB: "+p.dob);
                System.out.println("Mobile: "+p.m_no);
                System.out.println("Address: "+p.Address);
                System.out.println("Flight Number : "+p.flightNo);
                System.out.println("Origin        : "+p.origin);
                System.out.println("Destination   : "+p.destination);

                return;
            }
        }

        System.out.println("Passenger Not Found");
    }

    void Luggage_Status()
    {
        System.out.print("Enter Passenger Email: ");
        String email = sc.next();

        for (Passenger p:Passenger.Booked_Tickets)
        {
            if(p!=null && p.email.equals(email))
            {
                System.out.println("Passenger : "+p.FName+" "+p.Surname);
                System.out.println("Flight No : "+p.flightNo);
                System.out.println("Weight: "+p.weight+" KG");
                System.out.println("Status: "+p.LStatus);

                return;
            }
        }

        System.out.println("Passenger Not Found");
    }

    void Flight_Status()
    {
        if(Admin.flightCount==0)
        {
            System.out.println("No Flights Scheduled.");
            return;
        }

        for(int i=0;i<Admin.flightCount;i++)
        {
            Flight f=Admin.flights[i];

            System.out.println("--------------------------------");
            System.out.println("Flight No : "+f.flightNo);
            System.out.println("Origin    : "+f.origin);
            System.out.println("Destination : "+f.destination);
            System.out.println("Date      : "+f.date);
            System.out.println("Time      : "+f.time);
            System.out.println("Status    : "+f.status);
            System.out.println("Gate      : G"+(10+i));
        }
    }

    void All_Passengers()
    {
        if(Passenger.Booked_Count==0)
        {
            System.out.println("No Passenger Found.");
            return;
        }

        for(int i=0;i<Passenger.Booked_Count;i++)
        {
            Passenger p=Passenger.Booked_Tickets[i];

            if(p!=null)
            {
                System.out.println("--------------------------------");
                System.out.println("Passenger : "+p.FName+" "+p.Surname);
                System.out.println("Email     : "+p.email);
                System.out.println("Flight No : "+p.flightNo);
                System.out.println("Reference : "+p.refNo);
            }
        }
    }
}
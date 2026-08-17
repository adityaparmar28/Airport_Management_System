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

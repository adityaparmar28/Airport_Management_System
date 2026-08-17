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
class Person
{
    String name;
    String post;
    String address;
    int age;
    long mobile;

    Person(String name,String post,int age,long mobile,String address)
    {
        this.name=name;
        this.post=post;
        this.age=age;
        this.mobile=mobile;
        this.address=address;
    }

    void display()
    {
        System.out.println("Name: "+name+" | Post: "+post+" | Age: "+age+" | Mobile: "+mobile+" | Address: "+address);
    }
}
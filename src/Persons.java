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
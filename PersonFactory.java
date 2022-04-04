package dp;

class Person
{
    public int id;
    public String name;

    public Person(int id, String name)
    {
        this.id = id;
        this.name = name;
    }
}

class PersonFactory
{
    private static int count = 0;
    public Person createPerson(String name)
    {
        return new Person(count++, name);
    }
}

package br.com.martinsgms.atividade.pessoa;

public class Pessoa
{
    private String name;
    private int age;

    public Pessoa(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    @Override
    public String toString()
    {
        return "Name: " + this.name + " – age: " + this.age;
    }
}

package java8;

import static util.Utils.waiting;

public class CloneSolutionDemo
{


    public static void main(String[] args) throws CloneNotSupportedException
    {

        GoodBoy jack = new GoodBoy("Jack");
        GoodGirl jil = new GoodGirl("Jil");

        jack.married(jil);
        System.out.println("Jack is married to Jil");
        System.out.println(jack);
        waiting();

        System.out.println("Now Jack marries Julie, Alex marries Jil");
        GoodBoy alex = (GoodBoy) jack.clone();
        jack.getMarriedGoodGirl().setName("Julie");

        alex.setName("Alex");

        System.out.println(jack);
        System.out.println(alex);
        waiting();

        System.out.println("Jose  marries IndianGirl Alia, John marries IndianGirl Mia");
        GoodBoy jose = new GoodBoy("Jose");
        GoodIndianGirl alia = new GoodIndianGirl("Alia");
        jose.married(alia);

        GoodBoy john = (GoodBoy) jose.clone();
        john.setName("John");
        john.getMarriedGoodGirl().setName("Mia");

        System.out.println(jose);
        System.out.println(john);
    }

}


class GoodBoy implements Cloneable
{
    private static int uniqueId;


    private int id;
    private String name;

    private GoodGirl married;

    // initialization block
    {
        id = ++uniqueId;
    }

    public GoodBoy(String theName)
    {
        this.name = theName;
    }

    public GoodBoy(String theName, GoodGirl marriedGoodGirl)
    {
        this.name = theName;
        this.married = marriedGoodGirl;
    }

    public GoodBoy(GoodBoy boy) throws CloneNotSupportedException
    {

        GoodGirl newGoodGirl = null;
        GoodGirl marriedGoodGirl = boy.getMarriedGoodGirl();
        newGoodGirl =  (GoodGirl) marriedGoodGirl.clone();


        this.name = boy.getName();
        this.married(newGoodGirl);

    }


    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public GoodGirl getMarriedGoodGirl()
    {
        return married;
    }


    public void married(GoodGirl theGoodGirl)
    {
        this.married = theGoodGirl;
    }

    @Override
    public String toString()
    {
        return String.format("%s is married %s, boy id: %d", name, married, id);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        GoodBoy goodBoy = new GoodBoy(this);
        return goodBoy;
    }
}

class GoodGirl implements Cloneable
{
    private String name;

    public GoodGirl(String theName)
    {
        this.name = theName;
    }

    public String getName()
    {
        return name;
    }

    // copy Constructor
    public GoodGirl(GoodGirl girl)
    {
        this.name = girl.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return String.format("%s, and she is %s. girl hashcode: %d ", name, getClass().getSimpleName(), hashCode());
    }


    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
}


class GoodIndianGirl extends GoodGirl
{

    public GoodIndianGirl(String theName)
    {
        super(theName);
    }

    public GoodIndianGirl(GoodGirl girl)
    {
        super(girl);
    }

    @Override
    public String toString()
    {
        return String.format("%s, and she is %s. hashcode: %d ", getName(), getClass().getSimpleName(), hashCode());
    }

    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        return new GoodIndianGirl(this);
    }
}


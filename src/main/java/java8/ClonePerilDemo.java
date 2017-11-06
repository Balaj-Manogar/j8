package java8;

import static util.Utils.waiting;

/**
 * Perils of clone
 * 1. Clone supports only shallow copy, not deep copy
 * 2. Clone will not call constructor while cloning an object
 */
public class ClonePerilDemo
{

    public static void main(String[] args) throws CloneNotSupportedException
    {
        Boy jack = new Boy("Jack");
        Girl jil = new Girl("Jil");
        // now Jack is going to marry Jil
        jack.married(jil);

        // Jil divorced Jack and going to marry John
        Boy john = (Boy) jack.clone();
        john.setName("John");


        System.out.println("------------------------------------------");
        System.out.println("\t Shallow copy demo");
        System.out.println("------------------------------------------");

        // Now Jack and John both share Jil, Oh they are sharing that's not good, it's shallow copy
        System.out.println(jack);// Jack is married Jil, and she is Girl. hashcode: ######

        System.out.println("Jil doesn't like Jack , will marry John");
        waiting();

        System.out.println(john);// John is married Jil, and she is Girl. hashcode: ######
        waiting();
        // Jil finds her name wih jack, so she changes her name to Jil John
        System.out.println("\n####\t Jil finds her name wih jack, so she changes her name to Jil John......");
        jil.setName("Jil John");
        System.out.println(jack);
        System.out.println(john);
        waiting();
        System.out.println("####\t Clone Peril #1: Clone supports only shallow copy, not deep copy \nShe cannot able to " +
                "change the reference from Jack");

        waiting();
        // ------------------------------------------------
        // Alex wants to marry an Indian girl Mia, and we are checking polymorphism in java
        Girl mia = new IndianGirl("Mia");
        Boy alex = new Boy("Alex");
        alex.married(mia);

        //  Mia divorced Alex and going to marry Dhruv
        Boy dhruv = (Boy) alex.clone();
        dhruv.setName("Dhruv");

        System.out.println("------------------------------------------");
        System.out.println("\t Clone Supports polymorphism");
        System.out.println("------------------------------------------");


        // Even though clone gives shallow copy it supports polymorphism
        System.out.println(alex);// Alex is married Mia, and she is IndianGirl. hashcode: #####
        System.out.println(dhruv);// Dhruv is married Mia, and she is IndianGirl. hashcode: ######

        waiting();
        System.out.println("\n####\t Clone Peril #2: Clone will not call constructor while cloning an object \n Check the " +
                "boy id it is not changed while cloning");
    }

}

class Boy implements Cloneable
{
    private static int uniqueId;


    private int id;
    private String name;

    private Girl married;

    // initialization block
    {
        id = ++uniqueId;
    }

    public Boy(String theName)
    {
        this.name = theName;
    }

    public Boy(String theName, Girl marriedGirl)
    {
        this.name = theName;
        this.married = marriedGirl;
    }

    public Boy(Boy boy)
    {

        Girl newGirl = null;
        Girl marriedGirl = boy.getMarriedGirl();
        newGirl = new Girl(marriedGirl);
        /*if (marriedGirl instanceof IndianGirl)
        {
            newGirl = new IndianGirl((IndianGirl)marriedGirl);
        }
        else
        {
            newGirl = new Girl(marriedGirl);
        }*/

        this.name = boy.getName();
        this.married(newGirl);

    }


    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Girl getMarriedGirl()
    {
        return married;
    }


    public void married(Girl theGirl)
    {
        this.married = theGirl;
    }

    @Override
    public String toString()
    {
        return String.format("%s is married %s, boy id: %d", name, married, id);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
}

class Girl implements Cloneable
{
    private String name;

    public Girl(String theName)
    {
        this.name = theName;
    }

    public String getName()
    {
        return name;
    }

    // copy Constructor
    public Girl(Girl girl)
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


class IndianGirl extends Girl
{

    public IndianGirl(String theName)
    {
        super(theName);
    }

    public IndianGirl(Girl girl)
    {
        super(girl);
    }

    @Override
    public String toString()
    {
        return String.format("%s, and she is %s. hashcode: %d ", getName(), getClass().getSimpleName(), hashCode());
    }
}

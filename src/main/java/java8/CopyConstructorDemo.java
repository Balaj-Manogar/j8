package java8;

/**
 * Copy Constructor Peril:
 * 1. Copy Constructor Pattern doesn't support Runtime Polymorphism( new doesn't Support RT polymorphism).
 * 2. If we want to provide support(RT polymorphism), It's against SOLID(open for extension, but closed for
 * modification).
 */
public class CopyConstructorDemo
{

    public static void main(String[] args)
    {
        Boy jack = new Boy("Jack");
        Girl jil = new Girl("Jil");
        // now Jack is going to marry Jil
        jack.married(jil);

        Boy john = new Boy(jack);
        john.setName("John");


        System.out.println("------------------------------------------");
        System.out.println("\t Deep copy demo");
        System.out.println("------------------------------------------");

        System.out.println(jack);// Jack is married Jil, and she is Girl. hashcode: ######
        System.out.println(john);// John is married Jil, and she is Girl. hashcode: ######

        // Jil finds her name wih jack, so she changes her name to Jil John
        System.out.println("\n####\t Jil finds her name wih jack, so she changes her name to Jil John......");
        jil.setName("Jil John");
        System.out.println(jack);
        System.out.println(john);

        System.out.println("\n####\t And Jack wants to marry Alia, changes her girl name to Alia......");
        jack.getMarriedGirl().setName("Alia");
        System.out.println(jack);
        System.out.println(john);
        System.out.println("#### Now both were happy!!!!!");

        System.out.println();
        System.out.println("### Alex Marries Indian girl Mia");
        Girl mia = new IndianGirl("Mia");
        Boy alex = new Boy("Alex");
        alex.married(mia);
        System.out.println(alex);

        System.out.println("###\t Alex friend Jose  wants to marry Mia's friend Lia, bcos he likes India");
        Boy jose = new Boy(alex);
        jose.setName("Jose");
        jose.getMarriedGirl().setName("Lia");
        System.out.println(alex);
        System.out.println(jose);
        System.out.println("###\t Oh God, after marriage Lia forgot India, and became a Girl");

        System.out.println("### Copy Constructor Pattern Peril #1: \n Copy Constructor Pattern doesn't support " +
                "Runtime Polymorphism( new doesn't Support RT polymorphism) and check the code.");
        System.out.println("### \t Uncomment the Commented lines in the Boy Constructor to see Peril #2 \n If we want to provide support(RT polymorphism), It's against SOLID(open for extension, but closed for\n" +
                "  modification).");

    }
}

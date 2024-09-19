import java.util.ArrayList; 
/**
 * Write a description of class Seminario5_S3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Seminario5_S3
{
   public int factorialFor(int number){
       if(number>=0){
           int factorial = 1;
           for (int i = 2; i <= number; i++){
               factorial *= i;
           }
           return factorial;
       }
       return -1;
   }
   
   public int factorialWhile(int number){
       if(number>=0){
           int factorial = 1;
           int i = number;
           while (i >= 2){
               factorial *= i;
               i--;
           }
           return factorial;
       }
       return -1;
   }
   
   public ArrayList<Person>  youngPeople(ArrayList<Person> persons){
       ArrayList<Person> childrens = new ArrayList <Person>();
       for (Person person : persons){
           if (person.getAge() < Person.ADULT_AGE){
               childrens.add(person);
           }
       }
       return childrens;
    }
}

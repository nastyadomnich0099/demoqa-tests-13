package tests;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;

public class TestData {
   Faker fakerRu = new Faker(new Locale("ru"));
   Faker fakerEn = new Faker(new Locale("en"));

   String firstName = fakerRu.address().firstName();
   String lastName = fakerRu.name().lastName();
   String email = fakerEn.internet().emailAddress();
   String gender = getGender();
   String phone = String.valueOf(fakerRu.number().randomNumber(10, true));
   String subject = "Maths";
   String hobby = "Reading";
   String address = fakerRu.address().fullAddress();
   String state = "Uttar Pradesh";
   String city = "Merrut";
   String day = "10";
   String month = "August";
   String year = String.valueOf(fakerRu.number().numberBetween(1999, 2022));

   String dateOfBirth = day + " " + month + "," + year;


   public static String getGender() {
      String[] gender = new String[] {"Male","Female","Other"};
      Random ran = new Random();
      return gender[ran.nextInt(gender.length)]; //The nextInt() is used to get the next random integer value from this random number generator’s sequence.
   }

}
package docs;


import org.junit.jupiter.api.*;

public class JUnit5Examples {
    @BeforeAll
  static void beforeAll(){
      System.out.println("==== Smth before all tests");
    }

    @BeforeEach
   void beforeEach(){
        System.out.println("==== Smth before each tests");
    }


    @Test
    void firstTest(){
        System.out.println("======= Started First Test");
    }

    @Test
    void secondTest(){
        System.out.println("========= Started second Test");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("==== Smth after all tests");
    }

    @AfterEach
    void afterEach(){
        System.out.println("==== Smth after all tests");
    }

}

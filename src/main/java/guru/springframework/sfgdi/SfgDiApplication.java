package guru.springframework.sfgdi;

import guru.springframework.sfgdi.controllers.*;
import guru.springframework.sfgdi.examplebeans.FakeDataSource;
import guru.springframework.sfgdi.examplebeans.FakeJMSBroker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class SfgDiApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

        FakeDataSource fakeDataSource = (FakeDataSource)ctx.getBean(FakeDataSource.class) ;
        System.out.println("Username is :" + fakeDataSource.getUser());

        FakeJMSBroker fakeJMSBroker = ctx.getBean(FakeJMSBroker.class);
        System.out.println(fakeJMSBroker.getUsername());

        I18nController i18nController = (I18nController) ctx.getBean("i18nController");
        System.out.println(i18nController.sayHello());

        MyController myController = (MyController) ctx.getBean("myController");
       // String greeting = myController.sayHello();
        System.out.println("----------- Primary Bean");
        System.out.println(myController.getGreeting());

        System.out.println("---------- Property");

        PropertyInjectedController propertyInjectedController =
                (PropertyInjectedController)ctx.getBean("propertyInjectedController");
        System.out.println(propertyInjectedController.getGreeting());

        System.out.println("---------- Setter");

        SetterInjectedController setterInjectedController =
                (SetterInjectedController)ctx.getBean("setterInjectedController");
        System.out.println(setterInjectedController.getGreeting());

        System.out.println("---------- Constructor");

        ConstructorInjectedController constructorInjectedController =
                (ConstructorInjectedController)ctx.getBean("constructorInjectedController");
        System.out.println(constructorInjectedController.getGreeting());

    }

}

package main.java.com.solvd.database.services.designpatterns.factories;

import main.java.com.solvd.database.services.designpatterns.factories.classfactories.ContactInformationFactory;
import main.java.com.solvd.database.services.designpatterns.factories.classfactories.IClassFactory;
import main.java.com.solvd.database.services.designpatterns.factories.classfactories.OperatingSystemFactory;
import main.java.com.solvd.database.services.designpatterns.factories.classfactories.UserFactory;

public abstract class AbstractDaoClassesFactory {
    public static IClassFactory createFactory(String type){
        IClassFactory result;
        switch (type){
            case "user":
                result = new UserFactory();
                break;
            case "contact information":
                result = new ContactInformationFactory();
                break;
            case "operating system":
                result = new OperatingSystemFactory();
                break;
            default:
                throw new RuntimeException("Unable to find a needed factory");
        }
        return result;
    }
}

/*
package Ajava;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflect {


    public static Car initByd() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        Class<Car> aClass = (Class<Car>)contextClassLoader.loadClass("Ajava.Car");
        Constructor constructor = aClass.getDeclaredConstructor((Class[]) null);
        Car car=(Car)constructor.newInstance();
        Class<Car> carClass = Car.class;
        Method[] methods = carClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        Constructor<?>[] constructors = carClass.getConstructors();
        for(Constructor c:constructors){
            System.out.println(c);
        }
        Field[] fields = carClass.getFields();
        for(Field c:fields){
            System.out.println(c+"--------------");
        }

        Method sss = carClass.getMethod("sss");
        sss.invoke(car);

        System.out.println(methods);
        Method setColor = aClass.getMethod("setColor", String.class);
        setColor.invoke(car,"sjy++++++++++++++");
        Method setBrand = aClass.getMethod("setBrand", String.class);
        setBrand.invoke(car,"sjy----------------");
        Method setMaxSpeed = aClass.getMethod("setMaxSpeed", int.class);
        setMaxSpeed.invoke(car,1);

        return car;
    }
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {


        Car car = initByd();
        car.sss();

    }

}
*/

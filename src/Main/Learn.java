package Main;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Learn {

    public static void function20180525()
    {
        //错误
        //Plate<Fruit> p1 = new Plate<Apple>(new Apple());
        //System.out.println(p1.get().Say());

        Plate<? extends Fruit> p1 = new Plate<Apple>(new Apple());
        System.out.println(p1.get().Say());
        //错误
        //p1.set(new Apple());

        Plate<? super Apple> p2 = new Plate<Object>(new Object());
        System.out.println(p2.get());

        Plate<? super Apple> p3 = new Plate<Fruit>(new Fruit());
        System.out.println(p2.get());

        List<Apple> l = new ArrayList<Apple>();
        l.add(new Apple());
        l.add(new Apple());
        List<? extends Fruit> l1 = l;

        List<Fruit> l2 = new ArrayList<Fruit>();
        l2.add(new Fruit());
        l2.add(new Fruit());
        List<? super Fruit> l3 = l2;
        //请注意下面这个。
        l3.set(3,new Apple());

        System.out.println(l3.size());
    }


    public static void function20180526() throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        Class clazz = Class.forName("Main.Fruit");
        Fruit fru = new Fruit();

        Object object = clazz.newInstance();


    }


    public static void function20180528 () throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class clazz = Class.forName("Main.Fruit");
        Fruit newf = (Fruit)clazz.newInstance();

        Method[] ms = newf.getClass().getMethods();
        for(Method m : ms)
        {

            System.out.println("方法名称："+m.getName());
            System.out.println("Return Type："+m.getReturnType());
            System.out.println("===================================");

            m.invoke(newf);
        }
        ms[0].invoke(newf);

    }

}

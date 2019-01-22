package Noted.zhang8_IOStream.装饰类;

/*
    装饰设计模式：对一组对象的功能进行增强时，就可以使用该模式进行问题的解决。
    装饰和继承都能实现一样的特点：进行功能的扩展增强，但是装饰比继承灵活，装饰的特点：装饰类和被装饰类
    都必须所属同一个接口或者父类。

 */
class Person {
    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println("吃饭");
    }
}

/*
装饰类,为了增强Person类而存在
 */
class NewPerson {
    private Person person;                      //不同点

    public NewPerson(Person person) {
        this.person = person;
    }

    public void eat() {
        System.out.println("喝着小酒");
        person.eat();                           //不同点
        System.out.println("吃着下酒菜");
    }
}

/*
普通继承类
 */
class NewPerson2 extends Person {
    public NewPerson2() {
    }

    public NewPerson2(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println("喝着小酒");
        super.eat();
        System.out.println("吃着下酒菜");
    }
}
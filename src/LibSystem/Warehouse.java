package LibSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Warehouse {
    private static ArrayList<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        initBooks();
        showBook();
        Warehouse w = new Warehouse();
        w.addBook();
    }

    public static void initBooks(){
        String[] name = "java疯狂讲义,python入门,java web从入门到精通,mysql基础,java核心技术".split(",");
        String[] id = "s100,s101,s102,s103,s104".split(",");
        String[] price = "45,34,45,32,89".split(",");
        String[] num = "10,10,10,10,10".split(",");
        for(int i = 0; i < name.length; i++){
            books.add(new Book(name[i],id[i],price[i],num[i]));
        }
    }

    public static void showBook(){
        System.out.println("书名\t\t\tid\t价格\t数量\t");
        for (Book book : books) {
            System.out.println(book.getName()+"\t"+book.getId()+"\t"+book.getPrice()+"\t"+book.getNum());
        }
    }

    public void addBook(){
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("您要进行的操作是:1.添加一种书籍;2.删除一种书籍;3.修改书籍信息;4.结束添加并返回上一层");
            String s = sc.next();
            switch (s){
                case "1":
                    addNewBook();
                    break;
                case "2":
                    removeBook();
                    break;
                case "3":
                    changeBook();
                    break;
                case "4":
                    break;
                default:
                    break;
            }

        }
    }

    private void addNewBook() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入书名:");
        String name = sc.next();
        System.out.println("请输入id:");//id重复为处理
        String id = sc.next();
        System.out.println("请输入价格:");
        String price = sc.next();
        System.out.println("请输入数量:");
        String num = sc.next();
        Book book = new Book(name, id, price, num);
        books.add(book);
        System.out.println(book);
    }

    private void removeBook(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入删除的书的id:");
        String id = sc.next();
        for (int i = 0; i < books.size(); i ++) {
            if (id.equals(books.get(i).getId())){
                System.out.println("删除"+books.remove(i).getName()+"成功");
                break;
            }else {
                System.out.println("该id不存在,删除失败");
            }
        }
    }

    private void changeBook(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要修改的书籍的id");
        String id = sc.next();
        for (Book book : books) {
            if(id.equals(book.getId())){
                System.out.println("书籍信息:"+book);
                while (true){
                    System.out.println("1.修改书名;2.修改价格;3.修改数量;4.退出");
                    String key = sc.next();
                    switch (key){
                        case  "1":
                            System.out.println("请输入书名:");
                            String name = sc.next();
                            book.setName(name);
                        case "2":
                            System.out.println("请输入价格:");
                            String price = sc.next();
                            book.setName(price);
                        case "3":
                            System.out.println("请输入数量:");
                            String num = sc.next();
                            book.setName(num);
                        case "4":
                            break;
                        default:break;
                    }

                }
            }
        }
    }
}

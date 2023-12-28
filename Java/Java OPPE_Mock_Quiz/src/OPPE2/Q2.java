package OPPE2;

class Author implements Cloneable{
    String name;
    int age;

    public Author(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString(){
        return "Author: " + name + ", age: " + age; 
    }
    public Author clone() {
        try {
            return (Author)super.clone();
        } catch (CloneNotSupportedException Ex){
            return null;
        }
    }
}
class Book implements Cloneable{
    Author author;
    String title;

    public Book(String title, Author author) {
        this.title = title;
        this.author = author;
    }
    public Book clone() {
        try {
            Book b = (Book)super.clone();
            b.author = author.clone();
            return b;
        } catch (CloneNotSupportedException Ex){
            return null;
        }
    }
}
public class Q2 {
    public static void main(String[] args) {
        Book b = new Book("Life of Pi", new Author("Anand", 50));
        Book b1 = b.clone();
        b1.author.age = 51;
        System.out.println(b1.author);
        System.out.println(b.author);
    }
}

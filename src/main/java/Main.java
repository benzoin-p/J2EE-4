import Service.Bisearch;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("Application.xml");
        Bisearch bisearch = (Bisearch) ctx.getBean("bisearch");
        Scanner scan = new Scanner(System.in);
        int[] a= new int[200000];
        bisearch.setArray(a);
        System.out.println("������200000�������(����ʾ100��)");
        bisearch.dispArray(a);
        System.out.print("������Ҫ���ҵ���k:");
        int k=scan.nextInt();
        int i = bisearch.search(a,0,a.length-1,k);
        bisearch.check(i,k);
    }
}

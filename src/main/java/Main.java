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
        System.out.println("已生成200000个随机数(仅显示100个)");
        bisearch.dispArray(a);
        System.out.print("请输入要查找的数k:");
        int k=scan.nextInt();
        int i = bisearch.search(a,0,a.length-1,k);
        bisearch.check(i,k);
    }
}

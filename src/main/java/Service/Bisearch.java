package Service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

@Component("bisearch")
public class Bisearch
{
    //只是快速排序和二分查找
    public int search(int[] a,int p,int q,int k)
    {
        Arrays.sort(a);
        if(a==null||q<p)
        {
            return -1;
        }
        int mid=(p+q)/2;

        if(q-p==1||q==p)
        {
            if(k==a[q])
            {
                return q;
            }
            else if(k==a[p])
            {
                return p;
            }
            else
            {
                return -1;
            }
        }

        if(k<a[mid])
        {
            return search(a,p,mid,k);
        }
        else if(k>a[mid])
        {
            return search(a,mid,q,k);
        }
        else if(k==a[mid])
        {
            return mid;
        }
        else
        {
            return -1;
        }
    }

    public void setArray(int[] a)
    {
        Random rand = new Random();
        for(int i=0;i<200000;i++)
        {
            a[i]= rand.nextInt(10000000);
            for(int j=0;j<i;)
            {
                if(a[i]==a[j])
                {
                    a[i]=rand.nextInt(10000000);
                    continue;
                }
                j++;
            }
        }
    }

    public void dispArray(int[] a)
    {
        for(int i=0;i<100;i=i+10)
        {
            for(int j=i;j<i+10;j++)
            {
                System.out.print(a[j] + " ");
            }
            System.out.println();
        }
    }

    public void check(int i,int k)
    {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(i!=-1)
        {
            System.out.println(k+":"+i);
        }
        else
        {
            System.out.println("查找不到该数");
        }
    }



}

package aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component("logging")
@Aspect
public class Logging {

    long[] startTime = new long[2];
    long[] endTime = new long[2];

    @Pointcut("execution(public int Service.Bisearch.search(..))")
    public void pointcut1(){}
    @Pointcut("execution(public void Service.Bisearch.check(..))")
    public void pointcut2(){}

    @Before("pointcut1()")
    public void beforeSearch() {startTime[0] = System.currentTimeMillis();}

    @After("pointcut1()")
    public void afterSearch()
    {
        endTime[0] = System.currentTimeMillis();
        System.out.println("执行搜索的时间为"+(endTime[0]-startTime[0])+"毫秒");
    }

    @Before("pointcut2()")
    public void beforeCheck() {startTime[1] = System.currentTimeMillis();}

    @After("pointcut2()")
    public void afterCheck()
    {
        endTime[1] = System.currentTimeMillis();
        System.out.println("执行检查的时间为"+(endTime[1]-startTime[1])+"毫秒");
    }
}

package club.banyuan.myblog.myProxy;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogProxy {
    private Logger logger = LoggerFactory.getLogger(LogProxy.class);

    @Pointcut("@annotation(club.banyuan.myblog.annotation.LoggerAnnotation)")
    public void myProxy() {

    }

    @Before(value = "myProxy()")
    public void before(JoinPoint joinPoint) {
        logger.info("进入：{}",joinPoint.getSignature().getName());
        Object [] object=joinPoint.getArgs();
        for (Object ob:object) {
            logger.info("入参：{}",ob);
        }
    }

    @AfterReturning(value = "myProxy()",returning = "result")
    public void after(JoinPoint joinPoint,Object result){
            logger.info("返回值：{}",result);
    }
}

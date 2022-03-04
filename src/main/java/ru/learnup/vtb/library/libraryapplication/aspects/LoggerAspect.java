package ru.learnup.vtb.library.libraryapplication.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerAspect {

    @Pointcut("execution(* ru.learnup.vtb.library.libraryapplication.services.BookService.* (..))")
    public void bookServiceLog(){}

    @AfterReturning("bookServiceLog()")
    public void afterSuccess(JoinPoint point) {
        print("Завершилась работа метода " + point.getSignature().getName());
    }

    @AfterThrowing("bookServiceLog()")
    public void afterError(JoinPoint point) {
        print("Метод " + point.getSignature().getName() + "() завершился с ошибкой");
    }

    @Before("bookServiceLog()")
    public void before(JoinPoint point) {
        print("Готовимся к выполнению метода " + point.getSignature().getName());
    }

    public void print(String msg) {
        System.out.println(msg);
    }
}

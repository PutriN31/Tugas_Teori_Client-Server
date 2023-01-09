/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programmerzamannow.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import programmerzamannow.spring.core.data.Foo;

/**
 *
 * @author putri
 */
public class DuplicateTest {

    @Test
    void testDuplicate(){
        ApplicationContext context = new AnnotationConfigApplicationContext(DuplicateConfiguration.class);
        
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class, () -> {
            Foo foo = context.getBean(Foo.class);
        });
        
    }
    
    @Test
    void getBean() {
        ApplicationContext context = new AnnotationConfigApplicationContext(DuplicateConfiguration.class);
        
        Foo foo1 = context.getBean("foo1", Foo.class);
        Foo foo2 = context.getBean("foo2", Foo.class);
        Object foo3 = null;
        
       Assertions.assertSame(foo1, foo3);
        Object foo4 = null;
        Assertions.assertSame(foo2, foo4);
        
        Assertions.assertNotSame(foo1, foo2);
        Assertions.assertNotSame(foo3, foo4);
    }
}

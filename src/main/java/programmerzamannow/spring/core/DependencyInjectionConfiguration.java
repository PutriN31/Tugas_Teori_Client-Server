/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programmerzamannow.spring.core;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import programmerzamannow.spring.core.data.Bar;
import programmerzamannow.spring.core.data.Foo;
import programmerzamannow.spring.core.data.FooBar;

/**
 *
 * @author Vandi
 */

@Configuration
public class DependencyInjectionConfiguration {
    
    @Primary
    @Bean
    public Foo fooFirst(){
        return new Foo();
    }
    
    @Bean
    public Foo fooSecond(){
        return new Foo();
    }
    
    @Bean
    public Bar bar(){
        return new Bar();
    }
    
    @Bean
    public FooBar fooBar(@Qualifier("fooSecond") Foo foo, Bar bar){
        return new FooBar(foo, bar);
    }
}

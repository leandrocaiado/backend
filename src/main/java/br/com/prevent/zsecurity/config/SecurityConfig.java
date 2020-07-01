package br.com.prevent.zsecurity.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
 
 
/*
 Classe serve para definir as configuracoes do SpringSecurity no projeto. Definição de:
    - Quais uri's sao de livre acesso.
    - Quais uri's precisam de autorizacao para ser acessada.
*/
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity( securedEnabled = true, jsr250Enabled = true, prePostEnabled = true )
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 
 
    @Autowired
    private Environment coletorDeVariveisDeAmbiente; 
    

 

 
    //--
   
    @Override
    protected void configure(HttpSecurity http) throws Exception {
 
 
        http.cors().and().csrf().disable()        
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
        .authorizeRequests()        
                            .antMatchers("/swagger*/**")              .permitAll()
                            .antMatchers("/api/PREVENT/**"  )              .permitAll()
 
  
                      .and()                                    
                            .csrf().disable();                                                            //Desabilitando o csrf. Disabilita o recurso de CSRF (Cross-site request forgery), que eh uma protecao de segurança via tokens utilizados em formularios, mas que nao se faz necessario para um modelo de APIs. Tem haver com colocar mais seguranca contra SQLInjections.
 
                            http.headers().cacheControl();                                                //Adiciona recursos de cache padrao do Spring para as requisicoes, que ajudam a otimizar as requisicoes com cache de alguns recursos no lado do cliente.
    }        
 
}
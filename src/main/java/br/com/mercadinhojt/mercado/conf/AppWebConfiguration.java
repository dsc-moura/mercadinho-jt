
package br.com.mercadinhojt.mercado.conf;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.mercadinhojt.loja.interfaces.IPreencheListaComboDAO;
import br.com.mercadinhojt.loja.interfaces.IProdutoDAO;
import br.com.mercadinhojt.loja.interfaces.IUsuarioDAO;
import br.com.mercadinhojt.mercado.controllers.HomeController;
import br.com.mercadinhojt.mercado.daos.PreencheListaComboDAOImpl;
import br.com.mercadinhojt.mercado.daos.ProdutoDAOImpl;
import br.com.mercadinhojt.mercado.daos.UsuarioDAOImpl;
import br.com.mercadinhojt.mercado.infra.FileSaver;

import com.google.common.cache.CacheBuilder;


@EnableWebMvc
@ComponentScan(basePackageClasses={HomeController.class, ProdutoDAOImpl.class, FileSaver.class})
@EnableCaching
public class AppWebConfiguration extends WebMvcConfigurerAdapter{

	
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");		
		return resolver;
	}
	
	// CONFIGURAÇÃO DE MENSAGENS DE ERRO
	@Bean
	public MessageSource messageSource(){
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("/WEB-INF/messagens");
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setCacheSeconds(1);
		return messageSource;
	}
	
	// CONFIGURAÇÃO DO FORMATO DE DATAS
	@Bean
	public FormattingConversionService mvcConversionService(){
		DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
		DateFormatterRegistrar registrar = new DateFormatterRegistrar();
		registrar.setFormatter(new DateFormatter("dd/MM/yyyy"));
		registrar.registerFormatters(conversionService);
		
		return conversionService;
	}
		
	// CONFIGURAÇÃO PARA PEGAR ARQUIVOS COMO IMAGENS 
	
	@Bean
	public MultipartResolver multipartResolver(){
		return new StandardServletMultipartResolver();
	}
	
	// CONFIGURAÇÃO DO CACHE
	@Bean
	public CacheManager cacheManager(){
		CacheBuilder<Object,Object> builder = CacheBuilder.newBuilder().maximumSize(100).expireAfterAccess(5, TimeUnit.MINUTES);
		GuavaCacheManager manager = new GuavaCacheManager();
		manager.setCacheBuilder(builder);		
		
		return manager;
			
	}
	
	// CONFIGURAÇÃO DO JSON
	public ViewResolver contentNegotiationViewResolver(ContentNegotiationManager manager){
		List<ViewResolver> viewResolvers = new ArrayList<>();
		viewResolvers.add(internalResourceViewResolver());
		viewResolvers.add(new JsonViewResolver());
		
		ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
		resolver.setViewResolvers(viewResolvers);
		resolver.setContentNegotiationManager(manager);
		
		return resolver;
	}
	
	// CONFIGURAÇÃO PARA PEAR OS ARQUIVOS CSS, JS
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
		configurer.enable();
	}	
	
	@Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://localhost:1433;"+"databaseName=MEJT0000");
        dataSource.setUsername("");
        dataSource.setPassword("");
         
        return dataSource;
    }
     
    @Bean
    public IUsuarioDAO getUsuariotDAO() {
        return new UsuarioDAOImpl(getDataSource());
    }
    
    @Bean
    public IProdutoDAO getProdutoDAO() {
        return new ProdutoDAOImpl(getDataSource());
    }
    
    @Bean
    public IPreencheListaComboDAO getPreencherComboDAO() {
        return new PreencheListaComboDAOImpl(getDataSource());
    }
}

package com.bdqn;

import java.io.IOException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration  //此注解表示这个类是一个配置文件，.xml
@MapperScan("com.bdqn.dao") //扫描持久化接口，映射文件关联。
public class MybatisCongif{
	@Bean  //此注解作用在方法前，会根据方法的返回类型创建一个Bean，存储在IOC容器中。
	@ConditionalOnMissingBean//有条件的创建bean对象，如果IOC容器中有则不创建，没有则创建对象。
	public SqlSessionFactoryBean getSqlSessionFactoryBean(DataSource dataSource) {
		//创建SqlSession工厂对象
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		//设置数据源相关属性
		sqlSessionFactory.setDataSource(dataSource);
		//加载MyBites主配置文件
		sqlSessionFactory.setConfigLocation(
				new PathMatchingResourcePatternResolver()
				.getResource("classpath:mybatis-config.xml"));
		//别名映射 
		sqlSessionFactory.setTypeAliasesPackage("com.bdqn.entity");
		// 配置mapper的扫描，找到所有的mapper.xml映射文件
        Resource[] resources;
		try {
			resources = new PathMatchingResourcePatternResolver()
			        .getResources("classpath:mapping/*.xml");
			sqlSessionFactory.setMapperLocations(resources);
		} catch (IOException e) {
		}        
		return sqlSessionFactory;
	}
}

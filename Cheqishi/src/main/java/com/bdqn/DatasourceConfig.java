package com.bdqn;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.jolbox.bonecp.BoneCPDataSource;

@Configuration
//加载连接数据库属性文件
@PropertySource(value= {"classpath:jdbc.properties"},ignoreResourceNotFound=true)
public class DatasourceConfig {
	@Value("${url}")
	String url;
	@Value("${driverClassName}")
	String driverClassName;
	@Value("${usernames}")
	String username;
	@Value("${password}")
	String password;

	@Bean(destroyMethod="close")
	public DataSource dataSource() {
		BoneCPDataSource boneCPDataSource = new BoneCPDataSource();
		// 数据库驱动
		boneCPDataSource.setDriverClass(driverClassName);
		// 相应驱动的jdbcUrl
		boneCPDataSource.setJdbcUrl(url);
		// 数据库的用户名
		boneCPDataSource.setUsername(username);
		// 数据库的密码
		boneCPDataSource.setPassword(password);
		// 检查数据库连接池中空闲连接的间隔时间，单位是分，默认值：240，如果要取消则设置为0
		boneCPDataSource.setIdleConnectionTestPeriodInMinutes(60);
		// 连接池中未使用的链接最大存活时间，单位是分，默认值：60，如果要永远存活设置为0
		boneCPDataSource.setIdleMaxAgeInMinutes(30);
		// 每个分区最大的连接数
		boneCPDataSource.setMaxConnectionsPerPartition(100);
		// 每个分区最小的连接数
		boneCPDataSource.setMinConnectionsPerPartition(5);
		
		return boneCPDataSource;
	}
}

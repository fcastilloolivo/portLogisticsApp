package com.portlogistics.config;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages="com.portlogistics.model.dao")
public class MyBatisConfig {

    @Bean
    public DataSource dataSource() {

        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(org.firebirdsql.jdbc.FBDriver.class);
        dataSource.setUsername("SYSDBA");
        //dataSource.setUrl("jdbc:firebirdsql:localhost:/Users/cvfrans/Documents/workSpace/wsp_res/BD/ADMPORTLOG.FDB");
        dataSource.setUrl("jdbc:firebirdsql:localhost:D:/Sistemas/Database/ADMPORTLOG.FDB");
        dataSource.setPassword("serverbd");

        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:com/portlogistics/model/dao/mybatis/maps/*.xml"));
        //sqlSessionFactoryBean.setMapperLocations(resolver.getResources("com.concretepage.demo.model.dao.mybatis.maps.*.xml"));

        //sqlSessionFactoryBean.setMapperLocations(new Resource[] { new ClassPathResource("com/portlogistics/model/dao/mybatis/maps/*.xml") });
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }


}

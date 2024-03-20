package com.lmj.config;

import cn.smallbun.screw.core.Configuration;
import cn.smallbun.screw.core.engine.EngineConfig;
import cn.smallbun.screw.core.engine.EngineFileType;
import cn.smallbun.screw.core.engine.EngineTemplateType;
import cn.smallbun.screw.core.execute.DocumentationExecute;
import cn.smallbun.screw.core.process.ProcessConfig;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import org.junit.Test;

import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.util.ArrayList;
//数据库生成文档，mysql驱动需要8.0
@SpringBootTest
public class DatebaseDocDemoApplicationTests {

    @Test
public     void generateDBDoc(){
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
        hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/blog?serverTimezone=UTC");
        hikariConfig.setUsername("root");
        hikariConfig.setPassword("123456");
        // 设置可以获取remark信息
        hikariConfig.addDataSourceProperty("useInformationSchema","true");
        hikariConfig.setMinimumIdle(2);
        hikariConfig.setMaximumPoolSize(5);
        DataSource dataSource = new HikariDataSource(hikariConfig);
        // 生成配置
        EngineConfig engineConfig = EngineConfig.builder()
                // 生成文件路径
                .fileOutputDir("C:\\Users\\璀璨的SUN\\Desktop\\xxq毕业设计")
                // 打开目录 设置为true执行完代码后会自动打开对应路径文件夹
                .openOutputDir(true)
                // 文件类型,支持三种类型
//                .fileType(EngineFileType.HTML)
                .fileType(EngineFileType.WORD)
                // 生成模板实现
                .produceType(EngineTemplateType.freemarker).build();
        // 忽略表,这些表不会在文档中生成
        ArrayList<String> ignoreTableName = new ArrayList<>();
        ignoreTableName.add("test_xxx");
        // 忽略表前缀,这些表不会在文档中生成
        ArrayList<String> ignorePrefix = new ArrayList<>();
        ignorePrefix.add("test_");
        // 忽略表后缀,这些表不会在文档中生成
        ArrayList<String> ignoreSuffix = new ArrayList<>();
        ignoreSuffix.add("_test");
        ProcessConfig processConfig = ProcessConfig.builder()
                // 忽略表名
                .ignoreTableName(ignoreTableName)
                // 忽略表前缀
                .ignoreTablePrefix(ignorePrefix)
                // 忽略表后缀
                .ignoreTableSuffix(ignoreSuffix).build();
        // 配置
        Configuration config = Configuration.builder()
                // 版本
                .version("1.0.0")
                // 描述
                .description("数据库说明文档")
                // 数据源
                .dataSource(dataSource)
                // 生成配置
                .engineConfig(engineConfig)
                // 生成配置
                .produceConfig(processConfig).build();
        // 执行生成
        new DocumentationExecute(config).execute();
    }

}



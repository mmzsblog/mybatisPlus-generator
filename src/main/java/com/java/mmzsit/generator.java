package com.java.mmzsit;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.lang.reflect.Field;

/**
 * @author ：mmzsit
 * @description：MyBatisplus自动化构建工具
 * @date ：2019/6/14 14:45
 */

public class generator {
    public static void main(String[] args) throws Exception {
        AutoGenerator mpg = new AutoGenerator();
        String outputDir = "D:\\WorkspaceGit\\mybatisPlus-generator\\src\\main\\java";

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(outputDir);
        gc.setFileOverride(true);
        gc.setActiveRecord(true);
        gc.setEnableCache(true);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(true);// XML columList
        gc.setAuthor("mmzsit");

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("I%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceName("I%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");
        mpg.setGlobalConfig(gc);

        // 数据源配置mysql
//        DataSourceConfig dsc = new DataSourceConfig();
//        dsc.setDbType(DbType.MYSQL);
//        dsc.setDriverName("com.mysql.jdbc.Driver");
//        dsc.setUrl("jdbc:mysql://118.24.19.22:3306/itresources?useUnicode=true&amp;characterEncoding=UTF-8&amp;generateSimpleParameterMetadata=true");
//        dsc.setUsername("root");
//        dsc.setPassword("123456");
//        mpg.setDataSource(dsc);
        // 数据源配置oracle
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.ORACLE);
        dsc.setDriverName("oracle.jdbc.OracleDriver");
        dsc.setUrl("jdbc:oracle:thin:@localhost:1521/ORCL");
        dsc.setUsername("mmzsit");
        dsc.setPassword("mmzsit");
        mpg.setDataSource(dsc);


        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        strategy.setInclude(new String[]{"TESTDATAS"}); // 需要生成的表
//        strategy.setExclude(new String[]{"order"}); // 排除生成的表
        Field field = strategy.getClass().getDeclaredField("logicDeleteFieldName");
        field.setAccessible(true);
        field.set(strategy, "logic_del");
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.java.mmzsit");
//        pc.setModuleName("dc");
        mpg.setPackageInfo(pc);

        // 执行生成
        mpg.execute();
        System.out.println("自动构建完成！");
    }

}

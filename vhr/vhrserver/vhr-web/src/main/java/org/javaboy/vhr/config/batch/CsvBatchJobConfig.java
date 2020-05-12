//package org.javaboy.vhr.config.batch;
//
//import org.javaboy.vhr.model.Hr;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepScope;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.batch.item.file.mapping.DefaultLineMapper;
//import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//
//import javax.sql.DataSource;
//
///**
// * @作者 cerebrumWeaver
// * @日期 2020/3/16 14:11
// */
//@Configuration
//public class CsvBatchJobConfig {
//    @Autowired
//    JobBuilderFactory jobBuilderFactory;
//    @Autowired
//    StepBuilderFactory stepBuilderFactory;
//    @Autowired
//    DataSource dataSource;
//    @Bean
//    @StepScope
//    FlatFileItemReader<Hr> itemReader(){
//        FlatFileItemReader<Hr> reader = new FlatFileItemReader<>();
//        reader.setLinesToSkip(1);
//        reader.setResource(new ClassPathResource("data.csv"));
//        reader.setLineMapper(new DefaultLineMapper<Hr>(){{
//            setLineTokenizer(new DelimitedLineTokenizer(){{
//                setNames("id", "");
//            }});
//        }});
//    }
//}

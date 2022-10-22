package com.example;

import com.example.entity.User;
import com.example.dao.impl.UserRepository;
import com.example.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableCaching
public class ResumeDbAppJpaSpringApplication {



    public static void main(String[] args) {

        SpringApplication.run(ResumeDbAppJpaSpringApplication.class, args);

    }
//    @Autowired
//    @Qualifier ("userDao1")
//    private UserDaoInter userDao;
//    @Bean
//    public CommandLineRunner runner(){
//        CommandLineRunner clr=new CommandLineRunner() {
//            @Override
//            public void run(String... args) throws Exception {
////                List<User>list=userDao.getAll(null,null,null);
////                System.out.println(list);
//                userDao.updateUser(null);
//
//            }
//        };
//       return clr;
//    }
@Autowired
private UserServiceInter userService;
@Autowired
private UserRepository userRepository;
    @Bean
    public CommandLineRunner runner(){
        CommandLineRunner clr=new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
//                List<User>list=userRepository.findAll();
//                System.out.println(list);
//                System.out.println("------");
//                list=userRepository.findAll(Sort.by(Sort.Order.desc("id")));
//                System.out.println(list);
//                User u=userRepository.findById(7).get;
//                System.out.println(u);
//                User u=userRepository.findByName("Nihad");
//                User u2=userRepository.findByNameAndSurname("Nihad","Esgerli");
//                User u3=userRepository.findById(7);
//                System.out.println(u);
//                System.out.println(u2);
//                System.out.println(u3);
//                User u3=userRepository.findByEmail("esgerlinihad7@gmail.com ");
//                System.out.println(u3);
//                List<User>list=userRepository.findAll();
//                System.out.println(list);
                for(int i=0 ;i<10;i++){
                    userRepository.getAll(null,null,null);
                }



            }
        };
        return clr;
    }

}

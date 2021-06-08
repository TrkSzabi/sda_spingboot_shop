package com.sda.trkszabi.webshop;

import com.sda.trkszabi.webshop.model.Account;
import com.sda.trkszabi.webshop.model.Customer;
import com.sda.trkszabi.webshop.repository.AccountRepository;
import com.sda.trkszabi.webshop.service.CustomerService;
import com.sda.trkszabi.webshop.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.sda.trkszabi.webshop.repository")
@EntityScan(basePackages = "com.sda.trkszabi.webshop.model")
public class WebShopApplication implements CommandLineRunner {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private MailService mailService;
    @Autowired
    private AccountRepository accountRepository;

    public static void main(String[] args) {
        SpringApplication.run(WebShopApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.refresh();

        // here we have the context --- now write your code
        Account account1 = new Account();
        account1.setId(1L);
        Customer customer1 = new Customer();
        customer1.setId(1L);

        customerService.addCustomer(account1,customer1);

        customerService.getCustomerAccounts().forEach(System.out::println);

        mailService.sendMail("traian.gradinaru@gmail.com",
                "client@example.com",
                "Mock mail subject example",
                "Mock mail body example");

        // accountRepository.findAllByIsClosed(true).forEach(System.out::println);
        accountRepository.findAllByBillingAddressIsContaining("Center").forEach(System.out::println);
    }
}

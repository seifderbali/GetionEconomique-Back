package tn.esprit.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import tn.esprit.entities.User;
import tn.esprit.repositories.UserRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

@Slf4j
@Service
public class UserService implements IUserService{

    @Autowired
    UserRepository userReposiory;


    @Override
    public List<User> retreiveAllUsers() {
        List<User> listUsers = new ArrayList<User>();
        try {
            listUsers = (List<User>) userReposiory.findAll();
            for(User u : listUsers)
            {
              //  u.setEntiteSI(null);
                log.info("user = "+u);
            }}
        catch(Exception e)
        {
            log.info("error = "+e);
        }

        return listUsers;
    }

    @Override
    public User addUser(User u) {
        try
        {
            if(userReposiory.findByMail(u.getMail())==null) {
            userReposiory.save(u);
                sendmail(u);
            }
        }
        catch(Exception e)
        {
            log.info("error = "+e);
        }
        return u;
    }

    @Override
    public void deleteUser(long id) {
        try{
            	//Long idl = Long.parseLong(id);
                userReposiory.deleteById(id);
        }
        catch(Exception e)
        {
            log.info("error = "+e);
        }
    }

    @Override
    public User updateUser(User u) {
        try
        {
            userReposiory.save(u);
        }
        catch(Exception e)
        {
            log.info("error = "+e);
        }
        return u;
    }

    @Override
    public User retrieveUser(long id) {
        User u = new User();
        try{
            u = userReposiory.findUserById(id);
        }
        catch(Exception e)
        {
            log.info("error = "+e);
        }
        return u ;
    }

    @Override
    public String retrieveUserRole(long id) {
        User u = new User();
        u= userReposiory.findById(id).get();
        return u.getRole().toString();
    }

    @Override
    public List<User> searchUser(String keyword) {
        List<User> listUsers = new ArrayList<User>();
        try {
            listUsers = (List<User>) userReposiory.search(keyword);
            for(User u : listUsers)
            {
                log.info("user = "+u);
            }}
        catch(Exception e)
        {
            log.info("error = "+e);
        }

        return listUsers;
    }

    @Override
    public User DoLogin(String  mail, String mdp) {

        User u  = new User();
        Date d = new Date();

        //String year = d.toString().substring(d.toString().length() - 2);


        if(userReposiory.findByMail(mail)==null)
        {


            System.out.println("Verifier votre Mail");
        }




        if (userReposiory.DoLogin(mail, mdp) != null) {



            u = userReposiory.DoLogin(mail, mdp);



        }else {
            if (userReposiory.findByMail(mail) != null) {
                u = userReposiory.findByMail(mail);
                u.setToken("PASSWD");
            } else {
                u.setToken("UNKNOWN");

            }

        }
        return u;
    }

    private JavaMailSender javaMailSender;

    public void EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
    public void sendmail(User u)
    {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("seifderbali.biat@gmail.com");
        mailSender.setPassword("qtaujafsdxszxxcs");

        Properties properties = new Properties();
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");

        mailSender.setJavaMailProperties(properties);
        String from = mailSender.getUsername();
        String to = u.getMail();

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from);
        message.setTo(to);
        message.setSubject("Welcome To BIAT Platform");
        message.setText("Dear " + u.getName()+" "+u.getLastname() + ",\n\nThank you for joining our application. Here are your login credentials:\nUsername: " + u.getMail() + "\nPassword: " + u.getPassword() + "\n\nBest regards,\nThe team");

        mailSender.send(message);

    }

}

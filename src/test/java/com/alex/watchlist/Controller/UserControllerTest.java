package com.alex.watchlist.Controller;

import com.alex.watchlist.model.User;
import com.alex.watchlist.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;
import java.util.List;
@ActiveProfiles("test")
@SpringBootTest
@RunWith(SpringRunner.class)

public class UserControllerTest {

    @MockBean
    private UserRepository userRepository;

    @BeforeEach
    public void setUp()  {
        List<User> users = List.of(
                new User("test", "test@mail.com", "test123"),
                new User("test2", "test2@mail.com", "test123")
        );
        when(userRepository.findAll()).thenReturn(users);
    }

    @Test
    public void getAllUsersTest()
    {
        // act
        List<User> users = userRepository.findAll();
        // assert
        Assertions.assertEquals(users.get(0).getUsername(),"test");
        Assertions.assertEquals(users.get(1).getUsername(),"test2");
    }

   /* @Test
    public void getUserTest()
    {
        // act
        User user = userRepository.findByUsername("test2").orElseThrow();

        // assert
        Assertions.assertEquals(user.getUsername(),"test2");
        Assertions.assertEquals(user.getEmail(),"test2@mail.com");
    }
*/
    @Test
    public void updateUserTest()
    {
        User user = new User("test3", "test3@mail.com", "alexR20");

        // act
        List<User> users = userRepository.findAll();

        users.get(0).setUsername(user.getUsername());
        users.get(0).setEmail(user.getEmail());

        // assert
        Assertions.assertEquals(users.get(0).getUsername(),"test3");
        Assertions.assertEquals(users.get(0).getEmail(),"test3@mail.com");
    }


}
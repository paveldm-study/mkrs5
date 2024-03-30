package org.dpa.mkrs5.respository;

import org.dpa.mkrs5.repository.UserRepository;
import org.dpa.mkrs5.repository.entities.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class UserRepositoryTest {

  @Autowired private UserRepository userRepository;

  @Before
  public void setUp() throws Exception {

    User candidate1 =
            User.builder()
            .id(10L)
            .userName("Jack Alison")
            .build();

    User candidate2 =
            User.builder()
            .id(11L)
            .userName("Jane Jackson")
            .build();

    userRepository.save(user1);
    userRepository.save(user2);
  }

  @Test
  public void testFindUserByName() {
    String userName = "Alice Smithson";
    List<User> userList = userRepository.findAll();

    assertEquals(5, userList.size());
    boolean allLastNamesMatched = userList.stream().allMatch(user -> user.getUserName().equals(userName));
    assertTrue(allLastNamesMatched);
  }

  @Test
  public void shouldReturnAllUsers() {
    List<User> users = userRepository.findAll();

    assertNotNull(users);
  }
}

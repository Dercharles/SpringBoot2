package startTest;

import com.yang.Start;
import com.yang.user.entity.UserEntity;
import com.yang.user.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by yangp on 2017/11/15.
 */
public class userServiceTest extends StartTest {

    @Autowired
    private UserService userService;

    @Test
    public void userTest(){
        UserEntity userEntity =userService.findOne(3l);
        Assert.assertEquals(new Long(43),userEntity.getAge());
    }
}

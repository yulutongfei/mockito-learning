package com.sunxu.mockito.lesson03;

import com.sunxu.mockito.AccountDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

/**
 * @author 孙许
 * @version 1.0
 * @date 2021/11/3 07:00
 */
@RunWith(MockitoJUnitRunner.class)
public class MockByRunnerTest {

    @Test
    public void testMock() {
        AccountDao accountDao = mock(AccountDao.class);
        accountDao.findAccount("x", "x");
    }
}

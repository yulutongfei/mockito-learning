package com.sunxu.mockito.lesson03;

import com.sunxu.mockito.AccountDao;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

/**
 * @author 孙许
 * @version 1.0
 * @date 2021/11/3 07:14
 */
public class MockByRuleTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void testMock() {
        AccountDao accountDao = Mockito.mock(AccountDao.class);
        accountDao.findAccount("x", "x");
    }
}

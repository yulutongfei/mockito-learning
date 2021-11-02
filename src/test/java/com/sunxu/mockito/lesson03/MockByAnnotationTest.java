package com.sunxu.mockito.lesson03;

import com.sunxu.mockito.AccountDao;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * @author 孙许
 * @version 1.0
 * @date 2021/11/3 07:09
 */
public class MockByAnnotationTest {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    private AccountDao accountDao;

    @Test
    public void testMock() {
        accountDao.findAccount("x", "x");
    }
}

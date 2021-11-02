package com.sunxu.mockito.quickstart;

import com.sunxu.mockito.Account;
import com.sunxu.mockito.AccountDao;
import com.sunxu.mockito.AccountLoginController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author 孙许
 * @version 1.0
 * @date 2021/11/3 06:26
 */
@RunWith(MockitoJUnitRunner.class)
public class AccountLoginControllerTest {

    private AccountDao accountDao;

    private HttpServletRequest request;

    private AccountLoginController accountLoginController;

    @Before
    public void setUp() {
        this.accountDao = mock(AccountDao.class);
        this.request = mock(HttpServletRequest.class);
        this.accountLoginController = new AccountLoginController(accountDao);
    }

    @Test
    public void testLoginSuccess() {
        final Account account = new Account();
        when(request.getParameter("username")).thenReturn("alex");
        when(request.getParameter("password")).thenReturn("123456");
        when(accountDao.findAccount(anyString(), anyString())).thenReturn(account);
        String result = accountLoginController.login(request);
        assertThat(result, equalTo("/index"));
    }

    @Test
    public void testLoginFailure() {
        when(request.getParameter("username")).thenReturn("alex");
        when(request.getParameter("password")).thenReturn("123456");
        when(accountDao.findAccount(anyString(), anyString()))
                .thenThrow(UnsupportedOperationException.class);
        String result = accountLoginController.login(request);
        assertThat(result, equalTo("/505"));
    }

    @Test
    public void testLogin505() {
        when(request.getParameter("username")).thenReturn("alex");
        when(request.getParameter("password")).thenReturn("123456");
        when(accountDao.findAccount(anyString(), anyString())).thenReturn(null);
        String result = accountLoginController.login(request);
        assertThat(result, equalTo("/login"));
    }
}
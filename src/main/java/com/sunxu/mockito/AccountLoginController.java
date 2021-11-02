package com.sunxu.mockito;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 孙许
 * @version 1.0
 * @date 2021/11/2 17:38
 */
public class AccountLoginController {

    private final AccountDao accountDao;

    public AccountLoginController(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public String login(HttpServletRequest request) {
        final String userName = request.getParameter("username");
        final String password = request.getParameter("password");

        try {
            Account account = accountDao.findAccount(userName, password);
            if (account == null) {
                return "/login";
            }
            return "/index";
        } catch (Exception e) {
            return "/505";
        }
    }
}

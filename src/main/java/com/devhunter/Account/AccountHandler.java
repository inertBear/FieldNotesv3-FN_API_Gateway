package com.devhunter.Account;

import org.jboss.logging.Logger;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

/**
 * Handles Account Requests
 */
@ApplicationScoped
public class AccountHandler {
    private static final Logger logger = Logger.getLogger(AccountHandler.class);

    @Inject
    AccountService service;

    /**
     * use the AccountService to attempt a login
     * 
     * @param username
     * @param plaintextPassword
     * @return
     */
    public boolean tryLogin(String username, String plaintextPassword) {
        try {
            service.tryLogin(new AccountEntity(username, plaintextPassword));
            logger.info("Login Success!");
            return true;
        } catch (Exception e) {
            logger.error("Login Failed: " + e.getMessage());
            return false;
        }
    }

    /**
     * use the AccountService to attempt to create a new account
     * 
     * @param username
     * @param password
     * @return
     */
    public boolean addUser(String username, String password) {
        try {
            service.addNewAccount(new AccountEntity(username, password));
            logger.info("Add User Success!");
            return true;
        } catch (Exception e) {
            logger.error("Add User Failed: " + e.getMessage());
            return false;
        }
    }
}
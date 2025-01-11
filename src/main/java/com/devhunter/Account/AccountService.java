package com.devhunter.Account;

import java.util.List;

import io.quarkus.mongodb.panache.PanacheMongoEntityBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AccountService {

    /**
     * Add a new account
     * 
     * @param account
     * @throws Exception
     */
    public void addNewAccount(AccountEntity account) throws Exception {
        List<PanacheMongoEntityBase> list = AccountEntity.list("username", account.getUsername());
        if (list.isEmpty()) {
            account.persist();
        } else {
            throw new Exception("User [" + account.getUsername() + "] already exists");
        }
    }

    /**
     * delete and existing account
     * 
     * @param account
     * @throws Exception
     */
    public void deleteAccount(AccountEntity account) throws Exception {
        List<PanacheMongoEntityBase> list = AccountEntity.list("username", account.getUsername());
        if (!list.isEmpty()) {
            account.delete();
        } else {
            throw new Exception("User [" + account.getUsername() + "] does not exist");
        }
    }

    /**
     * update an existing account's password
     * 
     * @param account
     * @param newPassword
     * @throws Exception
     */
    public void updatePassword(AccountEntity account, String newPassword) throws Exception {
        List<PanacheMongoEntityBase> list = AccountEntity.list("username", account.getUsername());
        if (list.isEmpty()) {
            AccountEntity.update("password", newPassword).where("username", account.getUsername());
        } else {
            throw new Exception("No User [" + account.getUsername() + "]");
        }
    }

    /**
     * attempt to access an application with a pre-exisiting account
     * 
     * @param account
     * @throws Exception
     */
    public void tryLogin(AccountEntity account) throws Exception {
        // FIXME: encrypt passwords & use proper password management
        List<PanacheMongoEntityBase> list = AccountEntity.list("username = ?1 and password = ?2", account.getUsername(),
                account.getPassword());
        if (list.isEmpty()) {
            // failed login
            throw new Exception("Incorrect username or password [" + account.getUsername() + "]");
        }
    }
}

package com.devhunter.Account;

import org.bson.codecs.pojo.annotations.BsonProperty;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

/**
 * Represents a user account
 */
@MongoEntity(collection = "login")
public class AccountEntity extends PanacheMongoEntity {

    @BsonProperty("username")
    private String username;
    @BsonProperty("password")
    private String plaintext_password;

    public AccountEntity() {

    }

    public AccountEntity(String username, String plaintext_password) {
        this.username = username;
        this.plaintext_password = plaintext_password;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.plaintext_password;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((username == null) ? 0 : username.hashCode());
        result = prime * result + ((plaintext_password == null) ? 0 : plaintext_password.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AccountEntity other = (AccountEntity) obj;
        if (username == null) {
            if (other.username != null)
                return false;
        } else if (!username.equals(other.username))
            return false;
        if (plaintext_password == null) {
            if (other.plaintext_password != null)
                return false;
        } else if (!plaintext_password.equals(other.plaintext_password))
            return false;
        return true;
    }

}

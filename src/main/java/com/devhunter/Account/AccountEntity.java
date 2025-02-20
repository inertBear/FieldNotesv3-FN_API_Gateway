package com.devhunter.Account;

import org.bson.codecs.pojo.annotations.BsonProperty;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

/**
 * Represents a user account in Mongo DB
 */
@MongoEntity(collection = "login")
public class AccountEntity extends PanacheMongoEntity {

    @BsonProperty("username")
    private String username;
    @BsonProperty("plaintextPassword")
    private String plaintextPassword;

    public AccountEntity() {

    }

    public AccountEntity(String username, String plaintextPassword) {
        this.username = username;
        this.plaintextPassword = plaintextPassword;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPlaintextPassword() {
        return this.plaintextPassword;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((username == null) ? 0 : username.hashCode());
        result = prime * result + ((plaintextPassword == null) ? 0 : plaintextPassword.hashCode());
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
        if (plaintextPassword == null) {
            if (other.plaintextPassword != null)
                return false;
        } else if (!plaintextPassword.equals(other.plaintextPassword))
            return false;
        return true;
    }
}

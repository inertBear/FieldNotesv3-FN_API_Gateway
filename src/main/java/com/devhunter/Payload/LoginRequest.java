package com.devhunter.Payload;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Defines the interface for a login request
 */
@JsonPropertyOrder({ "username", "plaintextPassword" })
public class LoginRequest {

    private String username;
    private String plaintextPassword;

    public LoginRequest(String username, String plaintextPassword) {
        this.username = username;
        this.plaintextPassword = plaintextPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPlaintextPassword() {
        return plaintextPassword;
    }

    public void setPlaintextPassword(String plaintextPassword) {
        this.plaintextPassword = plaintextPassword;
    }

    /**
     * represent this object as a JSON String
     * 
     * @return
     */
    public String toJsonString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
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
        LoginRequest other = (LoginRequest) obj;
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

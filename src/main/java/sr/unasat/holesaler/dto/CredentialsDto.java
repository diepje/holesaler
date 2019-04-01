package sr.unasat.holesaler.dto;

import sr.unasat.holesaler.designPatterns.builder.CredentialsDtoPlan;

public class CredentialsDto implements CredentialsDtoPlan {

    String username;

    String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

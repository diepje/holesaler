package sr.unasat.holesaler.designPatterns.builder;

import sr.unasat.holesaler.dto.CredentialsDto;

public class EmployeeCredentialsBuilder implements CredentialsDtoBuilder {

    private CredentialsDto credentialsDto;
    private String username;
    private String password;

    public EmployeeCredentialsBuilder(String username, String password) {
        credentialsDto = new CredentialsDto();
        this.username = username;
        this.password = password;
    }

    public void buildUsername() {
        credentialsDto.setUsername(username);
    }

    public void buildPassword() {
        credentialsDto.setPassword(password);
    }

    public CredentialsDto getCredentialsDto() {
        return credentialsDto;
    }
}

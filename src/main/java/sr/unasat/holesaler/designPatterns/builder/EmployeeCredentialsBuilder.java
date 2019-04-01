package sr.unasat.holesaler.designPatterns.builder;

import sr.unasat.holesaler.dto.CredentialsDto;
import sr.unasat.holesaler.entity.Employee;

public class EmployeeCredentialsBuilder implements CredentialsDtoBuilder {

    private CredentialsDto credentialsDto;

    public EmployeeCredentialsBuilder() {
        credentialsDto = new CredentialsDto();
    }

    public void buildUsername(String username) {
        credentialsDto.setUsername(username);
    }

    public void buildPassword(String password) {
        credentialsDto.setPassword(password);
    }

    public CredentialsDto getCredentialsDto() {
        return credentialsDto;
    }
}

package sr.unasat.holesaler.designPatterns.builder;

import sr.unasat.holesaler.dto.CredentialsDto;

public interface CredentialsDtoBuilder {
    void buildUsername(String username);

    void buildPassword(String password);

    CredentialsDto getCredentialsDto();
}

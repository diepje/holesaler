package sr.unasat.holesaler.designPatterns.builder;

import sr.unasat.holesaler.dto.CredentialsDto;

public interface CredentialsDtoBuilder {

    void buildUsername();

    void buildPassword();

    CredentialsDto getCredentialsDto();
}

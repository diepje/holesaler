package sr.unasat.holesaler.designPatterns.builder;

import sr.unasat.holesaler.dto.CredentialsDto;

public class CredentialsEngineer {

    private CredentialsDtoBuilder credentialsDtoBuilder;

    public CredentialsEngineer(CredentialsDtoBuilder credentialsDtoBuilder) {
        this.credentialsDtoBuilder = credentialsDtoBuilder;
    }

    public CredentialsDto getCredentialsDto() {
        return credentialsDtoBuilder.getCredentialsDto();
    }

    public void createCredentials() {
        credentialsDtoBuilder.buildPassword("password");
        credentialsDtoBuilder.buildUsername("username");
    }

}

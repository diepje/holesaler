package sr.unasat.holesaler;

import sr.unasat.holesaler.designPatterns.builder.CredentialsDtoBuilder;
import sr.unasat.holesaler.designPatterns.builder.CredentialsEngineer;
import sr.unasat.holesaler.designPatterns.builder.EmployeeCredentialsBuilder;
import sr.unasat.holesaler.dto.CredentialsDto;

public class AppTest {

    public static void main(String[] args) {
        CredentialsDtoBuilder mario = new EmployeeCredentialsBuilder("mario", "mario");
        CredentialsEngineer credentialsEngineer = new CredentialsEngineer(mario);
        credentialsEngineer.createCredentials();
        CredentialsDto marioCredentials = credentialsEngineer.getCredentialsDto();
        System.out.println(marioCredentials.getPassword());
        System.out.println(marioCredentials.getUsername());

    }

}

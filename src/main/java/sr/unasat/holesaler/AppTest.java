package sr.unasat.holesaler;

import sr.unasat.holesaler.designPatterns.builder.CredentialsDtoBuilder;
import sr.unasat.holesaler.designPatterns.builder.CredentialsEngineer;
import sr.unasat.holesaler.designPatterns.builder.EmployeeCredentialsBuilder;

public class AppTest {

    public static void main(String[] args) {
        CredentialsDtoBuilder mario = new EmployeeCredentialsBuilder();
        CredentialsEngineer credentialsEngineer = new CredentialsEngineer(mario);
        credentialsEngineer.
    }

}

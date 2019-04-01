package sr.unasat.holesaler.designPatterns.serviceFactory;

import sr.unasat.holesaler.entity.Credentials;

public interface Service {
    boolean login(Credentials credentials, Credentials loginCredentials);
}

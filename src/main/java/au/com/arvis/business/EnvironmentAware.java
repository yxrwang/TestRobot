package au.com.arvis.business;

import au.com.arvis.model.Position;


public interface EnvironmentAware {

    boolean isSafe(Position position);
}

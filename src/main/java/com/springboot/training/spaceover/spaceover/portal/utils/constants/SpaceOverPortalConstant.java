package com.springboot.training.spaceover.spaceover.portal.utils.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SpaceOverPortalConstant {

    /**
     * Messages
     */
    public static final String EXTERNAL_SERVICE_INVOKE_ERROR_MSG = "Error while invoking {} :: {}";


    /**
     * Miscellaneous
     */
    public static final String FRONT_SLASH_DELIMITER = "/";
    public static final String COLON_WHITE_SPACE_DELIMITER = ", ";
    public static final String WHITE_SPACE_DELIMITER = " ";
    public static final String SEMI_COLON_DELIMITER = ";";
    public static final String SPACE_MISSION_API_DESCRIPTION = "A public Restful Api that allows to manage the various space mission resources.";
    public static final String ISO_3166_1_ALPHA_2_REGEX = "^[A-Z]{2}$";
    public static final String EMPTY_OR_BLANK_STRING_REGEX = "^(?!\\s*$).+";
    public static final String APPLICATION_JSON_PATCH = "application/json-patch+json";
    public static final String MISSIONS = "missions";
    public static final String CREWMEMBERS = "crewmembers";
    public static final String SPACE_MISSIONS = "space missions";
    public static final String SPACE_MISSION = "space mission";
    public static final String SPACESHIPS = "spaceships";
    public static final String SPACESHIP = "spaceship";


}

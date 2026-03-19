package com.sanat.auth_app.helpers;

import java.util.UUID;

public class UserHelper {
    public static UUID UUIDParser(String uuid){
        return UUID.fromString(uuid);
    }
}

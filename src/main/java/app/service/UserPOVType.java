package app.service;

public enum UserPOVType {
    OWNER, VIEWER;

    public static UserPOVType getBy(String name){
        for (UserPOVType type : UserPOVType.values()){
            if (type.name().equalsIgnoreCase(name)){
                return type;
            }
        }
        throw new RuntimeException("Could not find user pov type");
    }
}

package util;

public enum Role {
    BASE(0),
    STAFF(1),
    MANAGER(2),
    DIRECTOR(3);

    private final int value;

    Role(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Role fromValue(int value) {
        for (Role role : values()) {
            if (role.value == value) {
                return role;
            }
        }

        throw new IllegalArgumentException("No Role with value " + value);
    }
}

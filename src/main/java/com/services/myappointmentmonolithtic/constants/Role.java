package com.services.myappointmentmonolithtic.constants;

public enum Role {
    ADMIN(1),
    EMPLOYEE(2),
    CLIENT(3),
    GUEST(4);

    private int codeRole;

    Role(int codeRole) {
        this.codeRole = codeRole;
    }

    public int getCodeRole() {
        return codeRole;
    }
}

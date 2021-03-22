package com.services.myappointmentmonolithtic.constants;

public enum Service {
    MASSAGE("Massage", 1800000),
    MANICURE("Manicure", 7200000),
    PEDICURE("Pedicure", 7200000),
    HAIRCUT("Haircut", 3600000),
    HAIR_COLORING("Hair coloring", 10800000),
    EYELASH_EXTENSION("Eyelash extension", 3600000),
    SOLARIUM("Solarium", 900000),
    EYEBROW_TATTOO("Eyebrow tattoo", 7200000);
    private String serviceName;
    private long duration;

    Service(String serviceName, long duration) {
        this.serviceName = serviceName;
        this.duration = duration;
    }

    public String getServiceName() {
        return serviceName;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }
}

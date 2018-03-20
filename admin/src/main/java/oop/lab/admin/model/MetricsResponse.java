package oop.lab.admin.model;

public class MetricsResponse {
    private boolean isOk;

    public MetricsResponse(boolean isOk) {
        this.isOk = isOk;
    }

    public boolean isOk() {
        return isOk;
    }
}

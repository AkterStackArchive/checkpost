package io.checkpost.constant

enum Status {

    INACTIVE(0),
    ACTIVE(1);

    private Integer value;
    private Status(Integer val) {
        this.value = val
    }

    public Integer value() {
        return value;
    }
}

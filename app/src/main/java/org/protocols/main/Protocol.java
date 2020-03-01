package org.protocols.main;

class Protocol {
    private int id;

    private String name;

    public Protocol(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

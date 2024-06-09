package ru.job4j.ood.isp;

public class VoiceDeviceMessage implements VoiceMessage, Output {
    @Override
    public byte[] voice() {
        return new byte[0];
    }

    @Override
    public void in(String data) {

    }

    @Override
    public void connect() {

    }

    @Override
    public void send() {

    }

    @Override
    public String toAddress() {
        return "";
    }

    @Override
    public String fromAddress() {
        return "";
    }

    @Override
    public void output() {

    }
}

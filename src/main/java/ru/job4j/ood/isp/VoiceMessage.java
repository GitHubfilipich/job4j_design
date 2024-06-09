package ru.job4j.ood.isp;

public interface VoiceMessage extends Message, Input, Internet {
    byte[] voice();
}

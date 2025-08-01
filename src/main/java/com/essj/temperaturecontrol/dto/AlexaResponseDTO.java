package com.essj.temperaturecontrol.dto;

public record AlexaResponseDTO(String version, Response response) {

    public static AlexaResponseDTO buildSpeech(String texto) {
        return new AlexaResponseDTO("1.0", new Response(new OutputSpeech("PlainText", texto), true));
    }

    public record Response(OutputSpeech outputSpeech, boolean shouldEndSession) {}
    public record OutputSpeech(String type, String text) {}
}
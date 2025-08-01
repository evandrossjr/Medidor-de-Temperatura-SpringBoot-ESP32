package com.essj.temperaturecontrol.dto;


import java.util.Map;

public class AlexaRequestDTO {
    private String version;
    private Session session;
    private AlexaRequest request;

    // Getters e setters
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public AlexaRequest getRequest() {
        return request;
    }

    public void setRequest(AlexaRequest request) {
        this.request = request;
    }

    // ====== Inner Classes ======

    public static class Session {
        private boolean isNew;
        private String sessionId;
        private Application application;

        public boolean isNew() {
            return isNew;
        }

        public void setNew(boolean aNew) {
            isNew = aNew;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public Application getApplication() {
            return application;
        }

        public void setApplication(Application application) {
            this.application = application;
        }
    }

    public static class Application {
        private String applicationId;

        public String getApplicationId() {
            return applicationId;
        }

        public void setApplicationId(String applicationId) {
            this.applicationId = applicationId;
        }
    }

    public static class AlexaRequest {
        private String type;
        private String requestId;
        private String locale;
        private String timestamp;
        private Intent intent;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getRequestId() {
            return requestId;
        }

        public void setRequestId(String requestId) {
            this.requestId = requestId;
        }

        public String getLocale() {
            return locale;
        }

        public void setLocale(String locale) {
            this.locale = locale;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public Intent getIntent() {
            return intent;
        }

        public void setIntent(Intent intent) {
            this.intent = intent;
        }
    }

    public static class Intent {
        private String name;
        private Map<String, Slot> slots;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Map<String, Slot> getSlots() {
            return slots;
        }

        public void setSlots(Map<String, Slot> slots) {
            this.slots = slots;
        }
    }

    public static class Slot {
        private String name;
        private String value;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}


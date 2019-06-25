package io.uetunited.oneheed.model.facebook;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Picture {
    private Data data;
    private String id;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public class Data {
        private int height;
        private int width;
        private String url;

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
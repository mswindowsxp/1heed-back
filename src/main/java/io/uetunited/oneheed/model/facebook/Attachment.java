package io.uetunited.oneheed.model.facebook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Attachment {
    private String id;
    private String name;
    private Long size;
    @JsonProperty("mime_type")
    private String mimeType;
    @JsonProperty("image_data")
    private ImageData imageData;
    @JsonProperty("file_url")
    private String fileUrl;

    @Getter
    @Setter
    public class VideoData {
        private Integer width;
        private Integer height;
        private Long length;
        @JsonProperty("video_type")
        private Integer videoType;
        private String url;
        @JsonProperty("preview_url")
        private String previewUrl;
        private Integer rotation;
    }

    @Getter
    @Setter
    public class ImageData {
        private Integer width;
        private Integer height;
        @JsonProperty("max_width")
        private Integer maxWidth;
        @JsonProperty("max_height")
        private Integer maxHeight;
        private String url;
        @JsonProperty("preview_url")
        private String previewUrl;
        @JsonProperty("image_type")
        private Integer imageType;
        @JsonProperty("render_as_sticker")
        private Boolean renderAsSticker;
    }
}

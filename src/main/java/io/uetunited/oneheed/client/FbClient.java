package io.uetunited.oneheed.client;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.uetunited.oneheed.exception.ConnectException;
import io.uetunited.oneheed.exception.InvalidResponseException;
import io.uetunited.oneheed.model.FacebookDataResponse;
import io.uetunited.oneheed.model.PageAccount;
import io.uetunited.oneheed.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
@Slf4j
public class FbClient {
    @Autowired
    OkHttpClient.Builder builder;

    @Autowired
    ObjectMapper mapper;

    @Value("${facebook.graph.url}")
    String graphApiUrl;

    @Value("${facebook.graph.pages}")
    String graphApiPageUrl;

    public UserInfo getUserInfo(String accessToken) throws ConnectException, InvalidResponseException {
        OkHttpClient client = builder.build();

        String url = String.format(graphApiUrl, accessToken);

        Request req = new Request.Builder().url(url).get().build();

        try {
            Response res = client.newCall(req).execute();
            if (res.code() != 200){
                log.info("Request not success {}", res);
                throw new InvalidResponseException("Request not success");
            }
            if (res.body() == null) {
                log.info("Response doesn't have body {}", res);
                throw new InvalidResponseException("Could not read body of response");
            }
            InputStream json = res.body().byteStream();
            UserInfo user = mapper.readValue(json, UserInfo.class);
            res.close();
            return user;
        } catch (JsonParseException | JsonMappingException e) {
            log.info("Could not deserialize response", e);
            throw new InvalidResponseException("Could not deserialize response", e);
        } catch (IOException e) {
            log.info("Could not connect to FB Graph API", e);
            throw new ConnectException("Failed to connect to FB Graph API", e);
        }
    }

    public List<PageAccount> getPages(String accessToken) throws ConnectException, InvalidResponseException {
        OkHttpClient client = builder.build();

        String url = String.format(graphApiPageUrl, accessToken);

        Request req = new Request.Builder().url(url).get().build();

        try {
            Response res = client.newCall(req).execute();
            if (res.code() != 200){
                log.info("Request not success {}", res);
                throw new InvalidResponseException("Request not success");
            }
            if (res.body() == null) {
                log.info("Response doesn't have body {}", res);
                throw new InvalidResponseException("Could not read body of response");
            }
            String json = res.body().string();
            log.info(json);
//            InputStream json = res.body().byteStream();
            FacebookDataResponse<PageAccount> pages = mapper.readValue(json, new TypeReference<FacebookDataResponse<PageAccount>>(){});
            res.close();
            return pages.getData();
        } catch (JsonParseException | JsonMappingException e) {
            log.info("Could not deserialize response", e);
            throw new InvalidResponseException("Could not deserialize response", e);
        } catch (IOException e) {
            log.info("Could not connect to FB Graph API", e);
            throw new ConnectException("Failed to connect to FB Graph API", e);
        }
    }
}
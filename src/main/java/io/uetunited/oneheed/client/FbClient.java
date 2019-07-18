package io.uetunited.oneheed.client;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.uetunited.oneheed.exception.ConnectException;
import io.uetunited.oneheed.exception.InvalidResponseException;
import io.uetunited.oneheed.model.facebook.AccessToken;
import io.uetunited.oneheed.model.facebook.Conversation;
import io.uetunited.oneheed.model.facebook.FacebookDataObject;
import io.uetunited.oneheed.model.facebook.MessageDetail;
import io.uetunited.oneheed.model.facebook.UserData;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class FbClient {
    @Autowired
    OkHttpClient.Builder builder;

    @Autowired
    ObjectMapper mapper;

    @Value("${facebook.app.id}")
    String appId;

    @Value("${facebook.app.secret}")
    String appSecret;

    @Value("${facebook.graph.url}")
    String graphApiUrl;

    @Value("${facebook.graph.pages}")
    String graphApiPageUrl;

    @Value("${facebook.graph.exchange.token}")
    String getLongLiveTokenUrl;

    @Value("${facebook.graph.subscribe.page}")
    String subscribePageUrl;

    @Value("${facebook.graph.get.conversation}")
    String getPageConversationUrl;

    @Value("${facebook.graph.get.conversation.detail}")
    String getPageConversationDetail;
    
    @Value("${facebook.graph.get.message.detail}")
    String getPageMessageDetail;
    
    public MessageDetail getMessageDetail(String messageId, String accessToken) throws InvalidResponseException, ConnectException  {
        OkHttpClient client = builder.build();

        String url = String.format(getPageMessageDetail, messageId, accessToken);

        Request req = new Request.Builder().url(url).get().build();

        return executeAndReturnResult(client, req, MessageDetail.class, null, true).get();
    }

    public UserData getUserInfo(String accessToken) throws ConnectException, InvalidResponseException {
        OkHttpClient client = builder.build();

        String url = String.format(graphApiUrl, accessToken);

        Request req = new Request.Builder().url(url).get().build();

        return executeAndReturnResult(client, req, UserData.class, null, true).get();
    }

    public AccessToken getLongLiveToken(String accessToken) throws ConnectException, InvalidResponseException {
        OkHttpClient client = builder.build();

        String url = String.format(getLongLiveTokenUrl, appId, appSecret, accessToken);

        Request req = new Request.Builder().url(url).get().build();

        return executeAndReturnResult(client, req, AccessToken.class, null, true).get();
    }

    public void subscribeToPage(String pageId, String pageAccessToken) throws ConnectException, InvalidResponseException {
        OkHttpClient client = builder.build();

        String url = String.format(subscribePageUrl, pageId, pageAccessToken);

        Request req = new Request.Builder().url(url).post(RequestBody.create(MediaType.get("application/json"), "")).build();

        executeAndReturnResult(client, req, null, null, false);
    }

    public FacebookDataObject<Conversation> getRecentConversation(String pageId, String pageAccessToken) throws InvalidResponseException, ConnectException {

        OkHttpClient client = builder.build();

        String url = String.format(getPageConversationUrl, pageId, pageAccessToken);

        Request req = new Request.Builder().url(url).get().build();

        return (FacebookDataObject<Conversation>) executeAndReturnResult(client, req, null, new TypeReference<FacebookDataObject<Conversation>>() {
        }, true).get();
    }

    private <T> Optional<T> executeAndReturnResult(OkHttpClient client, Request request, Class<T> type, TypeReference typeRef, boolean needReturnValue) throws InvalidResponseException, ConnectException {
        try {
            Response res = client.newCall(request).execute();
            if (res.code() != 200) {
                log.info("Request not success {}", res);
                throw new InvalidResponseException("Request not success");
            }
            if (needReturnValue) {
                if (type != null) {
                    return Optional.of(mapper.readValue(res.body().byteStream(), type));
                } else {
                    return Optional.of(mapper.readValue(res.body().byteStream(), typeRef));
                }
            } else {
                return Optional.empty();
            }
        } catch (JsonParseException | JsonMappingException e) {
            log.info("Could not deserialize response", e);
            throw new InvalidResponseException("Could not deserialize response", e);
        } catch (IOException e) {
            log.info("Could not connect to FB Graph API", e);
            throw new ConnectException("Failed to connect to FB Graph API", e);
        }
    }
}

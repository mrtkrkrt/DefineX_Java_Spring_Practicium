package com.muratkarakurt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

@Component
public class RestTemplateErrorHandler implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return response.getStatusCode().is4xxClientError() || response.getStatusCode().is5xxServerError();
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        if (response.getStatusCode().is5xxServerError()) {
            if (response.getStatusCode() == HttpStatus.BAD_REQUEST) {
                throw new LocationNotFoundException("Service is currently unavailable");
            }
        } else if (response.getStatusCode().is4xxClientError()) {
            if (response.getStatusCode() == HttpStatus.FORBIDDEN) {
                throw new InvalidApiKeyException("Invalid Api Key");
            }
        }

    }


}

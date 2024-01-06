package com.video.management.service.client;

import com.video.management.service.exception.ExternalServiceNotAvailableException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.stereotype.Component;

@Component
public class OmdbErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {
        return new ExternalServiceNotAvailableException();
    }
}
package org.zalando.riptide.opentracing.span;

import io.opentracing.tag.StringTag;
import io.opentracing.tag.Tag;
import org.apiguardian.api.API;

import static org.apiguardian.api.API.Status.EXPERIMENTAL;
import static org.springframework.http.HttpHeaders.WARNING;
import static org.zalando.riptide.opentracing.span.HttpSpanTagger.tagging;

@API(status = EXPERIMENTAL)
public final class HttpWarningSpanDecorator extends ForwardingSpanDecorator {

    private static final Tag<String> HTTP_WARNING =
            new StringTag("http.warning");

    public HttpWarningSpanDecorator() {
        super(new HttpResponseHeaderSpanDecorator(
                tagging(HTTP_WARNING, WARNING)));
    }

}

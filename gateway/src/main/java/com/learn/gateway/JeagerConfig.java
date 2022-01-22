package com.learn.gateway;

import io.jaegertracing.Configuration;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class JeagerConfig {

    @Bean
    public io.opentracing.Tracer initTracer() {
        Configuration.SamplerConfiguration samplerConfig = new Configuration.SamplerConfiguration()
                .withType("const").withParam(1);

        return Configuration.fromEnv("gateway")
                .withSampler(samplerConfig).getTracer();
    }
}

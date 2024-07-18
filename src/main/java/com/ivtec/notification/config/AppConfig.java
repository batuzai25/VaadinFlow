package com.ivtec.notification.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ivtec.notification.utils.TranslationProvider;
import com.vaadin.flow.i18n.I18NProvider;

@Configuration
public class AppConfig {
    @Bean
    public I18NProvider i18nProvider() {
        return new TranslationProvider();
    }
}
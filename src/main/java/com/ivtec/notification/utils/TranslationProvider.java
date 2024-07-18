package com.ivtec.notification.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.vaadin.flow.i18n.I18NProvider;


public class TranslationProvider implements I18NProvider {
    private final Locale localeES = new Locale("es", "ES");
    private final Locale localeEN = new Locale("en", "US");
    private final List<Locale> providedLocales = Arrays.asList(localeES, localeEN);

    @Override
    public List<Locale> getProvidedLocales() {
        return providedLocales;
    }

    @Override
    public String getTranslation(String key, Locale locale, Object... params) {
    	
          String baseName;
        
        if (key.startsWith("label.")) {
            baseName = "labels";
        } else if (key.startsWith("error.")) {
            baseName = "errors";
        } else if (key.startsWith("value.")) {
            baseName = "values";
        } else {
            baseName = "messages";  // Default
        }
    	
    	
        ResourceBundle bundle = ResourceBundle.getBundle(baseName, locale);
        return bundle.getString(key);
    }
}
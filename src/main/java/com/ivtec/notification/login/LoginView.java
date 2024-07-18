package com.ivtec.notification.login;

import java.util.Locale;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.i18n.I18NProvider;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Paragraph;

@Route("notificaciones/login")
@CssImport("./styles.css")
public class LoginView extends VerticalLayout {
	
	private I18NProvider i18nProvider;
	
    public LoginView(I18NProvider i18nProvider) {
     
        
        Locale userLocale = VaadinSession.getCurrent().getLocale();
        UI.getCurrent().setLocale(userLocale);
       
        Div container = new Div();
        container.addClassName("my-custom-style");
        
        // Barra naranja con logo
        Div orangeBar = new Div();
        orangeBar.addClassName("orange-bar");
        Div logo = new Div();
        logo.addClassName("logo");
        logo.setText("ebt");
        orangeBar.add(logo);
        container.add(orangeBar);
        
        Div content = new Div();
        content.addClassName("content");
        
        // Título
        H1 title = new H1(i18nProvider.getTranslation("message.title", UI.getCurrent().getLocale()));
        title.addClassName("centered-title");
        
        content.add(title);
       
        
        
        Button spanishButton = new Button(i18nProvider.getTranslation("label.otherLanguage", UI.getCurrent().getLocale()));
        spanishButton.addClickListener(e -> changeLocale(new Locale("es", "ES")));
        spanishButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE); // Estilo de enlace


        Button englishButton = new Button(i18nProvider.getTranslation("label.currentLanguage", UI.getCurrent().getLocale()));
        englishButton.addClickListener(e -> changeLocale(Locale.US));
        englishButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);

        Div languageOptions = new Div(spanishButton, new Div(new Text(" | ")), englishButton);
        languageOptions.addClassName("language-options");
        
        content.add(languageOptions);
        
        
        // Campos de usuario y contraseña
        TextField usernameField = new TextField(i18nProvider.getTranslation("label.username", UI.getCurrent().getLocale()));
        usernameField.addClassName("text-field");
        content.add(usernameField);
        
        PasswordField passwordField = new PasswordField(i18nProvider.getTranslation("label.password", UI.getCurrent().getLocale()));
        passwordField.addClassName("password-field");
        content.add(passwordField);
        
        // Botón de iniciar sesión
        Button loginButton = new Button("Iniciar Sesión");
        loginButton.addClassName("button");
        content.add(loginButton);
        
        Div links = new Div();
        links.addClassName("links");
        Anchor forgotUser = new Anchor("#", "¿Olvidó su usuario?");
        Anchor forgotPassword = new Anchor("#", "¿Olvidó su contraseña?");
        links.add(forgotUser, forgotPassword);
        content.add(links);

        // Sección de nuevo usuario
        Div newUserSection = new Div();
        newUserSection.addClassName("new-user-section");
        Paragraph newUserText = new Paragraph("¿Nuevo usuario?");
        Anchor registerLink = new Anchor("#", "HAGA CLIC AQUÍ PARA REGISTRARSE");
        registerLink.addClassName("register-button");
        newUserSection.add(newUserText, registerLink);
        content.add(newUserSection);
        
        content.add(links);
        
        container.add(content);
        add(container);
        
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
    }
    
    
    private void changeLocale(Locale locale) {
    	 VaadinSession.getCurrent().setLocale(locale);
    	 UI.getCurrent().getPage().reload();
    }
}
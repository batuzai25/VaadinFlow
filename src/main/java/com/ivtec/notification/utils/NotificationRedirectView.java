package com.ivtec.notification.utils;

import com.ivtec.notification.login.LoginView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@Route("notificaciones")
public class NotificationRedirectView extends VerticalLayout implements BeforeEnterObserver {
    
	public NotificationRedirectView() {
        // Agregar un mensaje o contenido visual opcional
        Div message = new Div();
        message.setText("Redireccionando a la página de inicio de sesión...");
        add(message);
        add(new RouterLink("Ir a Login", LoginView.class));
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        // Redireccionar a la ruta específica
        event.forwardTo(LoginView.class);
    }
}
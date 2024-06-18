package com.example.demo;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import io.github.public_ui.kolibriVaadinAdapter.KolBreadcrumb;
import io.github.public_ui.kolibriVaadinAdapter.KolButton;

/**
 * The main view contains a button and a click listener.
 */
@Route("")
public class MainView extends VerticalLayout {
	public MainView() {
		this.setMaxWidth("100%");

		// Use TextField for standard text input
		TextField textField = new TextField("Your name");

		// Button click listeners can be defined as lambda expressions
		GreetService greetService = new GreetService();
		Button button = new Button("Say hello", e -> {
			add(new Paragraph(greetService.greet(textField.getValue())));
		});

		// Theme variants give you predefined extra styles for components.
		// Example: Primary button is more prominent look.
		button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

		// You can specify keyboard shortcuts for buttons.
		// Example: Pressing enter in this view clicks the Button.
		button.addClickShortcut(Key.ENTER);

		// Use custom CSS classes to apply styling. This is defined in shared-styles.css.
		addClassName("centered-content");

		add(textField, button);

		var kolButton = new KolButton();
		kolButton.setLabel("KolButton here");
		add(kolButton);


		var kolBreadcrumb = new KolBreadcrumb();
		kolBreadcrumb.setLabel("KolBreadcrumb here");
		kolBreadcrumb.setLinks("[{ '_label': 'Startseite', '_href': '#/back-page' }, { '_label': 'Unterseite der Startseite mit sehr langem Link-Test', '_href': '#/back-page' }, { '_label': 'Unterseite der Unterseite', '_href': '#/back-page' }]");
		add(kolBreadcrumb);
	}
}

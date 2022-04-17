package com.digitalcode.i18n.web;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("locale")
public class LocaleDemoController {

	private final MessageSource messageSource;

	public LocaleDemoController(MessageSource messageSource) {

		this.messageSource = messageSource;
	}

	@GetMapping
	public String sayHello() {
		return messageSource.getMessage("common.hello", null, LocaleContextHolder.getLocale());
	}

	@GetMapping("with-header")
	public String sayHelloWithHeader(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
		return messageSource.getMessage("common.hello", null, LocaleContextHolder.getLocale());

	}

}

package com.ware.token.warehouse.web.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.openkoala.framework.i18n.I18NManager;

public class I18nTag extends SimpleTagSupport {

	private String key;
	private String locale;

	public void setKey(String key) {
		this.key = key;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public void doTag() throws JspException, IOException {
		String message = null;

		HttpServletRequest request = (HttpServletRequest) ((PageContext) getJspContext()).getRequest();

		try {
			if (this.locale == null) {
				this.locale = (String) request.getSession().getAttribute("locale");
			}
			if (this.locale == null) {
				message = I18NManager.getMessage(this.key, request.getLocale().toString());
			} else {
				message = I18NManager.getMessage(this.key, this.locale);
			}
		} catch (Exception e) {
			message = this.key;
			e.printStackTrace();
		}

		getJspContext().getOut().write(message);
	}
}

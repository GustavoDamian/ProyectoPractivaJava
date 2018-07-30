
package com.todo1.hulkstore.web.controlador;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;


/**
 * Clase Controlador Base
 * 
 * @author Gustavo Damian mgdamian
 * 
 */

public class ControladorBase {

	@ManagedProperty(name = "request", value = "#{request}")
	private HttpServletRequest request;

	@ManagedProperty(name = "session", value = "#{session}")
	private HttpSession session;



	/**
	 * @return
	 */
	protected HttpServletRequest getHttpRequest() {
		return (HttpServletRequest) getCurrentInstance().getExternalContext().getRequest();
	}

	/**
	 * @return
	 */
	protected HttpServletResponse getHttpResponse() {
		return (HttpServletResponse) getCurrentInstance().getExternalContext().getResponse();
	}

	/**
	 * @return
	 */
	protected HttpSession getHttpSession() {
		return (HttpSession) getCurrentInstance().getExternalContext().getSession(false);
	}

	public ExternalContext getExternalContext() {
		return getCurrentInstance().getExternalContext();
	}

	public FacesContext getCurrentInstance() {
		return FacesContext.getCurrentInstance();
	}

	public String getNombreServlet(String nombre) {
		return getExternalContext().getRequestContextPath() + nombre;
	}

	@SuppressWarnings("rawtypes")
	public Map getParametrosRequest() {
		return getCurrentInstance().getExternalContext().getRequestParameterMap();
	}

	/**
	 * 
	 * @param summary
	 * @param detail
	 */
	protected void addErrorMessage(final String summary, final String detail) {
		final FacesMessage errorMessage = new FacesMessage();
		errorMessage.setSummary(summary);
		errorMessage.setDetail(detail);
		errorMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
		getCurrentInstance().addMessage(null, errorMessage);
	}

	/**
	 * 
	 * @param summary
	 * @param detail
	 */
	protected void addInfoMessage(final String summary, final String detail) {
		final FacesMessage infoMessage = new FacesMessage();
		infoMessage.setSummary(summary);
		infoMessage.setDetail(detail);
		infoMessage.setSeverity(FacesMessage.SEVERITY_INFO);
		getCurrentInstance().addMessage(null, infoMessage);
	}

	/**
	 * @param summary
	 * @param detail
	 */
	protected void addWarningMessage(final String summary, final String detail) {
		final FacesMessage warningMessage = new FacesMessage();
		warningMessage.setSummary(summary);
		warningMessage.setDetail(detail);
		warningMessage.setSeverity(FacesMessage.SEVERITY_WARN);
		getCurrentInstance().addMessage(null, warningMessage);
	}


	/**
	 * 
	 * @return
	 */
	protected boolean isPostback() {
		return getCurrentInstance().isPostback();
	}

	/**
	 * 
	 * @return
	 */
	protected String getSessionUsername() {
		return getCurrentInstance().getExternalContext().getRemoteUser();
	}

	/**
	 * 
	 * @return
	 */
	public String getRemoteUser() {
		return getSessionUsername();
	}



	/**
	 * 
	 * @return
	 */
	public HttpServletRequest getRequest() {
		return request;
	}

	/**
	 * 
	 * @param request
	 */
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * 
	 * @return
	 */
	public HttpSession getSession() {
		return session;
	}

	/**
	 * 
	 * @param session
	 */
	public void setSession(HttpSession session) {
		this.session = session;
	}


	public RequestContext getRequestContext() {
		return RequestContext.getCurrentInstance();
	}


}

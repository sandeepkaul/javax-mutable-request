/**
 * 
 */
package com.sandeepkaul.javax.mutable.request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpUpgradeHandler;
import javax.servlet.http.Part;

import org.junit.Assert;
import org.junit.Test;

import com.sandeepkaul.javax.mutalble.request.MutableHttpServletRequest;

/**
 * @author Sandeep Kaul (sandeep.1904@gmail.com)
 *
 */
public class TestMutableHttpServletRequest {


  private static final String HEADER_VALUE = "value";
  private static final String HEADER_NAME = "name";

  @Test
  public void testAddHeader() {

    MutableHttpServletRequest mutableHttpServletRequest = getMutableHttpServletRequest();
    mutableHttpServletRequest.addHeader(HEADER_NAME, HEADER_VALUE);
    String headerValue = mutableHttpServletRequest.getHeader(HEADER_NAME);
    Assert.assertEquals(HEADER_VALUE, headerValue);
  }

  @Test
  public void testGetHeader() {

    MutableHttpServletRequest mutableHttpServletRequest = getMutableHttpServletRequest();
    mutableHttpServletRequest.addHeader("name1", "value1");
    String headerValue = mutableHttpServletRequest.getHeader("name1");
    Assert.assertEquals("value1", headerValue);
  }


  @Test
  public void testRemoveCustomHeader() {

    MutableHttpServletRequest mutableHttpServletRequest = getMutableHttpServletRequest();
    mutableHttpServletRequest.addHeader(HEADER_NAME, HEADER_VALUE);
    String headerValue = mutableHttpServletRequest.getHeader(HEADER_NAME);
    Assert.assertEquals(HEADER_VALUE, headerValue);
    mutableHttpServletRequest.removeCustomHeader(HEADER_NAME);
    headerValue = mutableHttpServletRequest.getHeader(HEADER_NAME);
    Assert.assertNull(headerValue);
  }

  @Test
  public void testGetHeaderNames() {

    MutableHttpServletRequest mutableHttpServletRequest = getMutableHttpServletRequest();
    mutableHttpServletRequest.addHeader(HEADER_NAME, HEADER_VALUE);
    mutableHttpServletRequest.addHeader(HEADER_NAME+"1", HEADER_VALUE+"1");
    Enumeration<String> headerNames = mutableHttpServletRequest.getHeaderNames();
    boolean headerFound = false;
    while (headerNames.hasMoreElements()) {
      String headerName = (String) headerNames.nextElement();
      if(headerName.equals(HEADER_NAME)) {
        headerFound = true;
      }
    }
    Assert.assertTrue(headerFound);
    
    
    mutableHttpServletRequest.removeCustomHeader(HEADER_NAME);
    String headerValue = mutableHttpServletRequest.getHeader(HEADER_NAME);
    Assert.assertNull(headerValue);
    
    
    headerNames = mutableHttpServletRequest.getHeaderNames();
    headerFound = false;
    while (headerNames.hasMoreElements()) {
      String headerName = (String) headerNames.nextElement();
      if(headerName.equals(HEADER_NAME)) {
        headerFound = true;
      }
    }
    Assert.assertFalse(headerFound);
    
  }

  public MutableHttpServletRequest getMutableHttpServletRequest() {

    MutableHttpServletRequest mutableHttpServletRequest =
        new MutableHttpServletRequest(new HttpServletRequest() {

          @Override
          public AsyncContext startAsync(ServletRequest servletRequest,
              ServletResponse servletResponse) throws IllegalStateException {

            return null;
          }

          @Override
          public AsyncContext startAsync() throws IllegalStateException {

            return null;
          }

          @Override
          public void setCharacterEncoding(String env) throws UnsupportedEncodingException {


        }

          @Override
          public void setAttribute(String name, Object o) {


        }

          @Override
          public void removeAttribute(String name) {


        }

          @Override
          public boolean isSecure() {

            return false;
          }

          @Override
          public boolean isAsyncSupported() {

            return false;
          }

          @Override
          public boolean isAsyncStarted() {

            return false;
          }

          @Override
          public ServletContext getServletContext() {

            return null;
          }

          @Override
          public int getServerPort() {

            return 0;
          }

          @Override
          public String getServerName() {

            return null;
          }

          @Override
          public String getScheme() {

            return null;
          }

          @Override
          public RequestDispatcher getRequestDispatcher(String path) {

            return null;
          }

          @Override
          public int getRemotePort() {

            return 0;
          }

          @Override
          public String getRemoteHost() {

            return null;
          }

          @Override
          public String getRemoteAddr() {

            return null;
          }

          @Override
          public String getRealPath(String path) {

            return null;
          }

          @Override
          public BufferedReader getReader() throws IOException {

            return null;
          }

          @Override
          public String getProtocol() {

            return null;
          }

          @Override
          public String[] getParameterValues(String name) {

            return null;
          }

          @Override
          public Enumeration<String> getParameterNames() {

            return null;
          }

          @Override
          public Map<String, String[]> getParameterMap() {

            return null;
          }

          @Override
          public String getParameter(String name) {

            return null;
          }

          @Override
          public Enumeration<Locale> getLocales() {

            return null;
          }

          @Override
          public Locale getLocale() {

            return null;
          }

          @Override
          public int getLocalPort() {

            return 0;
          }

          @Override
          public String getLocalName() {

            return null;
          }

          @Override
          public String getLocalAddr() {

            return null;
          }

          @Override
          public ServletInputStream getInputStream() throws IOException {

            return null;
          }

          @Override
          public DispatcherType getDispatcherType() {

            return null;
          }

          @Override
          public String getContentType() {

            return null;
          }

          @Override
          public long getContentLengthLong() {

            return 0;
          }

          @Override
          public int getContentLength() {

            return 0;
          }

          @Override
          public String getCharacterEncoding() {

            return null;
          }

          @Override
          public Enumeration<String> getAttributeNames() {

            return null;
          }

          @Override
          public Object getAttribute(String name) {

            return null;
          }

          @Override
          public AsyncContext getAsyncContext() {

            return null;
          }

          @Override
          public <T extends HttpUpgradeHandler> T upgrade(Class<T> handlerClass)
              throws IOException, ServletException {

            return null;
          }

          @Override
          public void logout() throws ServletException {


        }

          @Override
          public void login(String username, String password) throws ServletException {


        }

          @Override
          public boolean isUserInRole(String role) {

            return false;
          }

          @Override
          public boolean isRequestedSessionIdValid() {

            return false;
          }

          @Override
          public boolean isRequestedSessionIdFromUrl() {

            return false;
          }

          @Override
          public boolean isRequestedSessionIdFromURL() {

            return false;
          }

          @Override
          public boolean isRequestedSessionIdFromCookie() {

            return false;
          }

          @Override
          public Principal getUserPrincipal() {

            return null;
          }

          @Override
          public HttpSession getSession(boolean create) {

            return null;
          }

          @Override
          public HttpSession getSession() {

            return null;
          }

          @Override
          public String getServletPath() {

            return null;
          }

          @Override
          public String getRequestedSessionId() {

            return null;
          }

          @Override
          public StringBuffer getRequestURL() {

            return null;
          }

          @Override
          public String getRequestURI() {

            return null;
          }

          @Override
          public String getRemoteUser() {

            return null;
          }

          @Override
          public String getQueryString() {

            return null;
          }

          @Override
          public String getPathTranslated() {

            return null;
          }

          @Override
          public String getPathInfo() {

            return null;
          }

          @Override
          public Collection<Part> getParts() throws IOException, ServletException {

            return null;
          }

          @Override
          public Part getPart(String name) throws IOException, ServletException {

            return null;
          }

          @Override
          public String getMethod() {

            return null;
          }

          @Override
          public int getIntHeader(String name) {

            return 0;
          }

          @Override
          public Enumeration<String> getHeaders(String name) {

            return null;
          }

          @Override
          public Enumeration<String> getHeaderNames() {

            Set<String> set = new HashSet<String>(); 
            set.add("H1");
            set.add("H2");
            @SuppressWarnings({"unchecked", "rawtypes"})
            Enumeration<String> enumeration = new Vector(set).elements();
            return enumeration;
          }

          @Override
          public String getHeader(String name) {

            return null;
          }

          @Override
          public long getDateHeader(String name) {

            return 0;
          }

          @Override
          public Cookie[] getCookies() {

            return null;
          }

          @Override
          public String getContextPath() {
            return null;
          }

          @Override
          public String getAuthType() {
            return null;
          }

          @Override
          public String changeSessionId() {
            return null;
          }

          @Override
          public boolean authenticate(HttpServletResponse response)
              throws IOException, ServletException {
            return false;
          }
        });

    return mutableHttpServletRequest;
  }
}

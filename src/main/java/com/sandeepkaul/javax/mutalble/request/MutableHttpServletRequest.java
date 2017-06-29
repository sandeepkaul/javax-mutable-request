/**
 * 
 */
package com.sandeepkaul.javax.mutalble.request;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * @author Sandeep Kaul (sandeep.1904@gmail.com)
 * 
 *         The use of this filter is to modify Request headers in filters or anywhere else. The
 *         current implementation of @HttpServletRequest does not allow to set headers. This is a
 *         wrapper around it to help you modify request headers
 * 
 *
 */
public class MutableHttpServletRequest extends HttpServletRequestWrapper {


  // This is used to store all the custom headers.
  private final Map<String, String> customHeaders;

  public MutableHttpServletRequest(HttpServletRequest request) {
    super(request);
    this.customHeaders = new HashMap<String, String>();
  }

  public void addHeader(String headerName, String headerValue) {
    this.customHeaders.put(headerName, headerValue);
  }

  public void removeCustomHeader(String headerName) {
    this.customHeaders.remove(headerName);
  }

  public String getHeader(String headerName) {
    // check the custom headers first
    String headerValue = customHeaders.get(headerName);

    if (headerValue != null) {
      return headerValue;
    }
    // else return from into the original wrapped object
    return ((HttpServletRequest) getRequest()).getHeader(headerName);
  }

  public Enumeration<String> getHeaderNames() {
    // create a set of the custom header names
    Set<String> set = new HashSet<String>(customHeaders.keySet());

    // now add the headers from the wrapped request object
    Enumeration<String> e = ((HttpServletRequest) getRequest()).getHeaderNames();
    while (e.hasMoreElements()) {
      // add the names of the request headers into the list
      String n = e.nextElement();
      set.add(n);
    }

    // create an enumeration from the set and return
    return Collections.enumeration(set);
  }
}

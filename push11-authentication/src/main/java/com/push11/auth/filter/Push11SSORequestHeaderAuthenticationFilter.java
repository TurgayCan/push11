package com.push11.auth.filter;

import org.springframework.security.web.authentication.preauth.RequestHeaderAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by turgaycan on 9/17/15.
 * <p>
 * Handles for SSO request headers to create Authorization ids.
 */
public class Push11SSORequestHeaderAuthenticationFilter extends RequestHeaderAuthenticationFilter {

    private boolean allowPreAuthenticatedPrincipals = true;

    public Push11SSORequestHeaderAuthenticationFilter() {
        super();
        //TODO Pull this value from a properties file (application.properties, or localstrings.properties)
        //NOTE SM_USER is the default, but you can change it like this (your company may use some other header)
        this.setPrincipalRequestHeader("SM_USER");

    }

    /**
     * This is called when a request is made, the returned object identifies the
     * user and will either be {@literal null} or a String. This method will throw an exception if
     * exceptionIfHeaderMissing is set to true (default) and the required header is missing.
     *
     * @param request {@link javax.servlet.http.HttpServletRequest}
     */
    @Override
    protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
        String userName = (String) (super.getPreAuthenticatedPrincipal(request));
        if (userName == null || userName.trim().equals("")) {
            return userName;
        }

        return userName;
    }

    public boolean isAllowPreAuthenticatedPrincipals() {
        return allowPreAuthenticatedPrincipals;
    }

}

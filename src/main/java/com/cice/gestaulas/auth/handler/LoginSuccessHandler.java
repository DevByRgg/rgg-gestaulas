package com.cice.gestaulas.auth.handler;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.support.SessionFlashMapManager;


@Component
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{	
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		SessionFlashMapManager flashMapManager = new SessionFlashMapManager();		
		FlashMap flashMap = new FlashMap();		
		String mensaje = String.format("Hola %s, has iniciado sesión con éxito!", authentication.getName());		
		flashMap.put("success", mensaje);
		
		flashMapManager.saveOutputFlashMap(flashMap, request, response);
		
		if(authentication != null) {
			logger.info(mensaje);
		}
		
		handle(request, response, authentication);
        clearAuthenticationAttributes(request);
		
		//super.onAuthenticationSuccess(request, response, authentication);
	}
	
	protected void handle(
	        HttpServletRequest request,
	        HttpServletResponse response, 
	        Authentication authentication
	) throws IOException {

	    String targetUrl = determineTargetUrl(authentication);

	    if (response.isCommitted()) {
	        logger.debug(
	                "Response has already been committed. Unable to redirect to "
	                        + targetUrl);
	        return;
	    }

	    redirectStrategy.sendRedirect(request, response, targetUrl);
	}
	
	protected String determineTargetUrl(final Authentication authentication) {

	    Map<String, String> roleTargetUrlMap = new HashMap<>();
	    roleTargetUrlMap.put("ROLE_USER", "/");
	    roleTargetUrlMap.put("ROLE_ADMIN", "/admin");

	    final Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
	    for (final GrantedAuthority grantedAuthority : authorities) {
	        String authorityName = grantedAuthority.getAuthority();
	        if(roleTargetUrlMap.containsKey(authorityName)) {
	            return roleTargetUrlMap.get(authorityName);
	        }
	    }

	    throw new IllegalStateException();
	}
	
}

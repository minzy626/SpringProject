package com.javalec.ex.UserService;

import org.apache.log4j.Logger;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.authority.mapping.NullAuthoritiesMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

public class CustomIPAddressAuthenticationProvider implements AuthenticationProvider {
	
	private static final Logger logger = Logger.getLogger(CustomIPAddressAuthenticationProvider.class);
    private GrantedAuthoritiesMapper authoritiesMapper = new NullAuthoritiesMapper();

	//접속한 사용자의 IP주소 검사.
		 @Override
		    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

				WebAuthenticationDetails wad = null;
			    String userIPAddress         = null;
			    boolean isAuthenticatedByIP  = false;
			
			    //사이트에 접속한 유저의 아이피를 얻어온다.
			    wad = (WebAuthenticationDetails) authentication.getDetails();
			    userIPAddress = wad.getRemoteAddress();
			
			
			    logger.debug("userIPAddress == " + userIPAddress);
			    System.out.println("userIPAddress == " + userIPAddress);
			    //사용자의 아이피와 데이터베이스에 들어있는 아이피를 비교한다.
			    //isAuthenticatedByIP =  someDataObject.hasIPAddress(userIPAddress);
			    isAuthenticatedByIP = true;
			
			
//			    // 아이피가 금지되어있다면
//			    if (isAuthenticatedByIP)
//			    {
//			
//			        logger.debug("");
//			        UserDetails user = null;
//			
//			
//			        UsernamePasswordAuthenticationToken result = null;
//			
//			        result = new UsernamePasswordAuthenticationToken("John Principal",
//			                                                          "PlaceholderPWE"); 
//			
//			        result.setDetails(authentication.getDetails());
//			
//			        return result;
//			    }
			
			
			    // 인증이 성공하지 않았으면 null을 리턴함으로써 다음 인증 제공자가 인증을 진행할수 있도록 한다. 
			    return null;

}

		@Override
		public boolean supports(Class<?> arg0) {
			// TODO Auto-generated method stub
			return false;
		}
}

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

	//������ ������� IP�ּ� �˻�.
		 @Override
		    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

				WebAuthenticationDetails wad = null;
			    String userIPAddress         = null;
			    boolean isAuthenticatedByIP  = false;
			
			    //����Ʈ�� ������ ������ �����Ǹ� ���´�.
			    wad = (WebAuthenticationDetails) authentication.getDetails();
			    userIPAddress = wad.getRemoteAddress();
			
			
			    logger.debug("userIPAddress == " + userIPAddress);
			    System.out.println("userIPAddress == " + userIPAddress);
			    //������� �����ǿ� �����ͺ��̽��� ����ִ� �����Ǹ� ���Ѵ�.
			    //isAuthenticatedByIP =  someDataObject.hasIPAddress(userIPAddress);
			    isAuthenticatedByIP = true;
			
			
//			    // �����ǰ� �����Ǿ��ִٸ�
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
			
			
			    // ������ �������� �ʾ����� null�� ���������ν� ���� ���� �����ڰ� ������ �����Ҽ� �ֵ��� �Ѵ�. 
			    return null;

}

		@Override
		public boolean supports(Class<?> arg0) {
			// TODO Auto-generated method stub
			return false;
		}
}

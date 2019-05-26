package io.uetunited.oneheed.controller;

import java.io.IOException;

import com.restfb.util.StringUtils;
import io.uetunited.oneheed.payload.AccessTokenPayload;
import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.uetunited.oneheed.common.RestFB;

@Controller
public class FBController {
	
	@Autowired
	private RestFB restFb;

	@PostMapping("/oauth2/login/facebook")
	public ResponseEntity loginFacebook(@RequestBody AccessTokenPayload payload) throws ClientProtocolException, IOException {
		if (StringUtils.isBlank(payload.getToken())) {
			return ResponseEntity.badRequest().build();
		}

		String accessToken = payload.getToken();
		
		com.restfb.types.User user = restFb.getUserInfo(accessToken);
//		UserDetails userDetail = restFb.buildUser(user);
//		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetail, null,
//				userDetail.getAuthorities());
//		authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//		SecurityContextHolder.getContext().setAuthentication(authentication);
		return ResponseEntity.ok(user);
	}

}

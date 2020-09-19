package toy.project.kando.auth.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import toy.project.kando.auth.model.Auth;

@ExtendWith(MockitoExtension.class)
public class JwtServiceImplTest {
	private JwtServiceImpl jwtService;

	@BeforeEach
	public void setUp() {
		jwtService = new JwtServiceImpl("secretKey", 30);
	}

	@Test
	@DisplayName("토큰 생성 테스트")
	public void createTokenTest() {
		//when
		String id = "id";

		//given
 		String createdToken = jwtService.createToken(id);

		//then
		assertTrue(StringUtils.isNotEmpty(createdToken));
	}

	@Test
	@DisplayName("토큰에서 데이터 추출 테스트")
	public void getAuthTest() {
		//when
		String token = jwtService.createToken("id");

		//given
		Auth auth = jwtService.getAuth(token);

		//then
		assertEquals(auth.getUserId(), "id");
		assertNotNull(auth.getExpiration());
	}
}

package su.spring.web.json.jackson;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//빈으로 REST 지원 컨트롤러 스캔을 구성하며 @ResponseBody 어노테이션을 설정하지 않아도 지원된다.
@RestController
public class JacksonJsonToMapController {
	private static final Logger logger = LoggerFactory.getLogger(JacksonJsonToMapController.class);

//매핑된 요청의 Accept 요청을 허용하며 GET 메서드에서 사용한다.
	@GetMapping(value = "/jsonStringMap", produces = "application/json")
	public void json_java(HttpServletResponse response) throws Exception {
// JSON 형태 문자열을 할당한다.
		String jsonStr = "{\"id\" : \"min\", \"password\" : \"1234\" , \"name\" : \"홍길동\"}"; // JSON을 읽고 쓰는 기능과 변환을 수행하기
																								// 위한 관련 기능을 제공한다.
		ObjectMapper objectMapper = new ObjectMapper(); // 참조하는 Map 제네릭 타입에 대한 정보를 익명 클래스로 반환한다.
		Map<String, Object> jsonMap = objectMapper.readValue(jsonStr, new TypeReference<Map<String, Object>>() {
		});
		logger.info("데이터 확인 - " + jsonMap);
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().println(jsonMap);
	}
}
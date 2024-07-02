package su.spring.web.json.jackson;

import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import su.spring.web.json.dto.JsonDTO;
import java.io.File;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.*;

//빈으로 REST 지원 컨트롤러 스캔을 구성하며 @ResponseBody 어노테이션을 설정하지 않아도 지원된다.
@RestController
public class JacksonJsonFileToJavaController {
	private static final Logger logger = LoggerFactory.getLogger(JacksonJsonFileToJavaController.class);

//매핑된 요청의 Accept 요청을 허용하며 GET 메서드에서 사용한다.
	@GetMapping(value = "/jsonFile", produces = "application/json")
	public void json_java(HttpServletResponse response) throws Exception {
//설정된 경로명 문자열을 경로명으로 변환하여 새 파일의 인스턴스를 선언한다.
		File file = new File("/Users/nohyeonsu/Library/data/data.json");
//JSON을 읽고 쓰는 기능과 변환을 수행하기 위한 관련 기능을 제공한다.
		ObjectMapper objectMapper = new ObjectMapper(); // 주어진 파일의 JSON 콘텐츠를 주어진 자바 타입으로 역직렬화한다.
		JsonDTO jsonDTO = objectMapper.readValue(file, JsonDTO.class);
		logger.info("데이터 확인 - " + jsonDTO);
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().println(jsonDTO);
	}
}

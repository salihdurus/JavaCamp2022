package kodlama.io.Devs.business.responses.programmingLanguages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdProgrammingLanguageResponse {
	private int id;
	private String name;
}

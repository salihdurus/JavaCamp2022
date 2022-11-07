package kodlama.io.Devs.business.requests.programmingLanguages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProgrammingLanguageRequest {
	private int id;
	private String newName;
}

package kodlama.io.Devs.business.requests.subTechnologies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateSubTechnologyRequest {
	String name;
	String programmingLanguageName;
}

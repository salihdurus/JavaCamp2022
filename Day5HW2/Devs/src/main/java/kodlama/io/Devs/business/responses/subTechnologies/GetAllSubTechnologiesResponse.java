package kodlama.io.Devs.business.responses.subTechnologies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllSubTechnologiesResponse {
	int id;
	String name;
	String programmingLanguageName;
}

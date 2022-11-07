package kodlama.io.Devs.business.responses.programmingLanguages;

import java.util.List;

import kodlama.io.Devs.business.responses.subTechnologies.GetSubTechnologyOnlyName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllProgrammingLanguagesWithSubTechnologiesResponse {
	int id;
	String name;
	List<GetSubTechnologyOnlyName> technologies;
}

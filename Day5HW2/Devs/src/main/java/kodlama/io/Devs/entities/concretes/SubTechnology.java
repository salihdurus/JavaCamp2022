package kodlama.io.Devs.entities.concretes;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "sub_technologies")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class SubTechnology {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,
			CascadeType.REFRESH}, fetch = FetchType.EAGER, targetEntity = ProgrammingLanguage.class)
	@JoinColumn(name = "language_id")
	private ProgrammingLanguage programmingLanguage;
}

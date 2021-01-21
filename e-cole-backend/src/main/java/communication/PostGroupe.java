package communication;

import java.util.List;

import org.poly.entities.Groupe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class PostGroupe {

	private List<affectsEnMa> affects ;
	private Groupe groupe ;
	
}


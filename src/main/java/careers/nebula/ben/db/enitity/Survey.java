/**
 * 
 */
package careers.nebula.ben.db.enitity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Ankit Verma
 *
 */
@Entity
@Table (name = "surveys")
public class Survey {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", columnDefinition = "serial")
	private Integer id;
}

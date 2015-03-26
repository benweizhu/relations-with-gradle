package me.zeph.relations.model.entity;

import javax.persistence.*;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Entity
@Table(name = "RELT_LOCUS")
public class LocusEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "RELT_LOCUS_GEN")
	@SequenceGenerator(name = "RELT_LOCUS_GEN")
	@Column(name = "ID")
	private long id;

	@Column(name = "NAME")
	private String name;

	@ManyToMany(mappedBy = "loci")
	private List<KitEntity> kits = newArrayList();

	public LocusEntity() {
	}

	public LocusEntity(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<KitEntity> getKits() {
		return kits;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		LocusEntity that = (LocusEntity) o;
		return (name != null ? !name.equals(that.name) : that.name != null) ? false : true;
	}

	@Override
	public int hashCode() {
		return name != null ? name.hashCode() : 0;
	}
}
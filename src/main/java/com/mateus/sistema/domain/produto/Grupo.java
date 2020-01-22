package com.mateus.sistema.domain.produto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity(name = "Grupo")
@Table(name ="grupo")
public class Grupo implements Serializable {
	@Version
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	
	private boolean messageReceived;
    private Integer messageCount = 0; 
	
	@OneToMany(mappedBy = "grupo")
	@JsonIgnore
	private List<Subgrupo> subGrupos = new ArrayList<Subgrupo>();
	
	public Grupo() {
	}

	public Grupo(Long id) {
		this.id = id;
	}
	
	public Grupo(Long id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public List<Subgrupo> getSubGrupos() {
		return subGrupos;
	}

	public void setSubGrupos(List<Subgrupo> subGrupos) {
		this.subGrupos = subGrupos;
	}
	
	public boolean isMessageReceived() {
        return messageReceived;
    }

    public void setMessageReceived(boolean messageReceived) {
        this.messageReceived = messageReceived;
    }

    public Integer getMessageCount() {
        return messageCount;
    }

    public void setMessageCount(Integer messageCount) {
        this.messageCount = messageCount;
    }
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo other = (Grupo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}

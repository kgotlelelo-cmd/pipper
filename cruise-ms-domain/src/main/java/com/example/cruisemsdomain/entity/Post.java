package com.example.cruisemsdomain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column(
            name = "body"
    )
    private String body;

    @Column(
            name = "likes"
    )
    private Long likes;

	  @ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "client_id", nullable = false)
		@JsonIgnore
    private Client client;

	  @Override
	  public boolean equals(Object obj) {
		  if (this == obj) return true;
		  if (obj == null) return false;
		  if (getClass() != obj.getClass()) return false;
		  Post other = (Post) obj;
		  if (body == null) {
			  if (other.body != null)
			  	return false;
	  	} else if (!body.equals(other.body))
			  return false;
		  return true;
	  }

	  @Override
	  public int hashCode() {
		  return getClass().hashCode();
	  }
}

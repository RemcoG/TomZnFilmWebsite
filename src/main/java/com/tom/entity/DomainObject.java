package com.tom.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.io.Serializable;
import java.util.UUID;

/**
 * Created by Tom on 3-9-2015.
 */
@MappedSuperclass
@Getter
@Setter
@ToString(includeFieldNames = true, of = { "id", "version"})
public abstract class DomainObject implements Serializable{
    @Id
    private UUID id;

    @Version
    @Setter(AccessLevel.NONE)
    private Long version;

    @Override
    public int hashCode() {
        if (id != null) {
            return id.hashCode();
        } else {
            return super.hashCode();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        // null is not an instance of anything, so check whether null is not necessary
        if (!(o instanceof DomainObject)) {
            return false;
        }

        DomainObject other = (DomainObject) o;

        // unsaved objects are never equal
        if (id == null || other.getId() == null) {
            return false;
        }

        return id.equals(other.getId());
    }
}

package com.oil.supplier.domain.vo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: guowenjuan
 * Date: 15-11-19
 * Time: 下午4:43
 * To change this template use File | Settings | File Templates.
 */
public abstract class VoBaseObject implements Serializable {

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public boolean equals(Object vo) {
        return EqualsBuilder.reflectionEquals(this, vo);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.koss.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author koss
 */
@Entity
@Table(name = "sessions", catalog = "userAuth", schema = "")
@NamedQueries({
    @NamedQuery(name = "Sessions.findAll", query = "SELECT s FROM Sessions s"),
    @NamedQuery(name = "Sessions.findById", query = "SELECT s FROM Sessions s WHERE s.id = :id"),
    @NamedQuery(name = "Sessions.findBySessionhash", query = "SELECT s FROM Sessions s WHERE s.sessionhash = :sessionhash"),
    @NamedQuery(name = "Sessions.findBySessiontime", query = "SELECT s FROM Sessions s WHERE s.sessiontime = :sessiontime"),
    @NamedQuery(name = "Sessions.findBySessionsCount", query = "SELECT s FROM Sessions s WHERE s.sessionsCount = :sessionsCount")})
public class Sessions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "sessionhash", nullable = false, length = 45)
    private String sessionhash;
    @Column(name = "sessiontime", nullable = false, length = 45)
    private String sessiontime;
    @Column(name = "sessionsCount", nullable = false, length = 45)
    private String sessionsCount;

    public Sessions() {
    }

    public Sessions(String sessionhash, String sessiontime, String sessionsCount) {
        this.sessionhash = sessionhash;
        this.sessiontime = sessiontime;
        this.sessionsCount = sessionsCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSessionhash() {
        return sessionhash;
    }

    public void setSessionhash(String sessionhash) {
        this.sessionhash = sessionhash;
    }

    public String getSessiontime() {
        return sessiontime;
    }

    public void setSessiontime(String sessiontime) {
        this.sessiontime = sessiontime;
    }

    public String getSessionsCount() {
        return sessionsCount;
    }

    public void setSessionsCount(String sessionsCount) {
        this.sessionsCount = sessionsCount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sessions)) {
            return false;
        }
        Sessions other = (Sessions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.com.koss.entity.Sessions[ id=" + id + " ]";
    }

}

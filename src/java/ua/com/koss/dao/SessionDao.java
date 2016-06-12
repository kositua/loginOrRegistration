/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.koss.dao;

import ua.com.koss.entity.Sessions;

/**
 *
 * @author koss
 */
public interface SessionDao {

    Sessions getByHashId(String hashid);

    void changeSessionCount(Sessions session);

    void changeSessionTime(Sessions session, String timesession);

    void addSession(String sessionhash, String sessiontime, String sessionsCount);
}

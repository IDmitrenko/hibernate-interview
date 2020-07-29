package ru.dias.hibernate.exception;

/**
 *
 * @author Dias
 */
public class CBaseDAOException extends Exception {
    public CBaseDAOException() { super(); }
    public CBaseDAOException(String p_msg) { super(p_msg); }
    public CBaseDAOException(String p_msg, Throwable p_cause) { super(p_msg, p_cause); }
    public CBaseDAOException(Throwable p_cause) { super(p_cause); }

}
